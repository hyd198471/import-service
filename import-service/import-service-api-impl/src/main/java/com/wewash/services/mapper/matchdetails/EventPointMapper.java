package com.wewash.services.mapper.matchdetails;

import com.wewash.services.dto.matchdetails.Goal;
import com.wewash.services.dto.matchdetails.MatchAction;
import com.wewash.services.dto.matchdetails.MatchActions;
import com.wewash.services.ebet.dto.event.ParticipantDTO;
import com.wewash.services.ebet.dto.matchstate.EventPointDTO;
import com.wewash.services.ebet.dto.matchstate.football.FootballEventPointDTO;
import com.wewash.services.ebet.dto.matchstate.football.FootballEventPointDTO.EventPointType;
import com.wewash.services.ebet.dto.matchstate.football.FootballScoreEventPointDTO;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.wewash.services.ebet.dto.matchstate.football.FootballEventPointDTO.EventPointType.CORNER;
import static com.wewash.services.ebet.dto.matchstate.football.FootballEventPointDTO.EventPointType.RED_CARD;
import static com.wewash.services.ebet.dto.matchstate.football.FootballEventPointDTO.EventPointType.YELLOW_CARD;
import static com.wewash.services.ebet.dto.matchstate.football.FootballScoreEventPointDTO.TYPE_IDENTIFIER;

public class EventPointMapper {

    private  final Map<String, Integer> eventPointTypeDelayMap = new HashMap<>();

    List<EventPointDTO> convertImportMatchActionToEbetEventPoints(MatchActions matchActions,
                                                                  String currentPhase,
                                                                  Date currentPhaseStartTime,
                                                                  List<ParticipantDTO> participants) {
        List<EventPointDTO> eventPoints = new ArrayList<>();

        matchActions.getGoals().getGoals().stream()
                .filter(goal -> currentPhase.equalsIgnoreCase(goal.getPhase()) && goal.isIsConfirmed())
                .forEach(goal -> eventPoints.add(createEventPointFromGoal(goal, currentPhaseStartTime, participants)));

        eventPoints.addAll(createEventPointFromMatchActions(matchActions.getYellowCards().getMatchActions(),
                YELLOW_CARD,
                currentPhase,
                currentPhaseStartTime,
                participants));

        eventPoints.addAll(createEventPointFromMatchActions(matchActions.getSecondYellowCards().getMatchActions(),
                RED_CARD,
                currentPhase,
                currentPhaseStartTime,
                participants));

        eventPoints.addAll(createEventPointFromMatchActions(matchActions.getStraightRedCards().getMatchActions(),
                RED_CARD,
                currentPhase,
                currentPhaseStartTime,
                participants));

        eventPoints.addAll(
                createEventPointFromMatchActions(
                        matchActions.getCorners().getMatchActions(), CORNER, currentPhase, currentPhaseStartTime,
                        participants)
        );

        eventPoints.sort(Comparator.comparing(EventPointDTO::getOccurredAt));
        return eventPoints;
    }

    @Value("${service.im.goalDelayMs:4000}")
    private int goalDelayMs;

    @Value("${service.betgenius.yellowcardDelayMs:0}")
    private int yellowcardDelayMs;


    @Value("${service.betgenius.redcardDelayMs:0}")
    private int redcardDelayMs;

    @Value("${service.betgenius.cornerDelayMs:0}")
    private int cornerDelayMs;

    @PostConstruct
    void init() {
        eventPointTypeDelayMap.put(TYPE_IDENTIFIER, goalDelayMs);
        eventPointTypeDelayMap.put(YELLOW_CARD.name(), yellowcardDelayMs);
        eventPointTypeDelayMap.put(RED_CARD.name(), redcardDelayMs);
        eventPointTypeDelayMap.put(CORNER.name(), cornerDelayMs);
    }

    private FootballScoreEventPointDTO createEventPointFromGoal(Goal goal,
                                                                Date currentPhaseStartTime,
                                                                List<ParticipantDTO> participants) {
        FootballScoreEventPointDTO footballScoreEventPointDTO = new FootballScoreEventPointDTO();
        footballScoreEventPointDTO.setIsPenalty(goal.isWasScoredFromPenalty());
        footballScoreEventPointDTO.setPlayerId(goal.getScoredByPlayerId());

        return addCommonEventPointFields(footballScoreEventPointDTO,
                                        goal.getTeam(),
                                        goal.getTimeElapsedInPhase(),
                                        goal.getTimeStampUtc(),
                                        currentPhaseStartTime,
                                        participants,
                                        TYPE_IDENTIFIER);
    }

    private List<EventPointDTO> createEventPointFromMatchActions(
            List<MatchAction> matchActions, EventPointType eventPointType,
            String currentPhase, Date currentPhaseStartTime, List<ParticipantDTO> participants) {

        return matchActions.stream()
                .filter(matchAction -> currentPhase.equalsIgnoreCase(matchAction.getPhase()) && matchAction.isIsConfirmed())
                .map(matchAction -> createCommonEventPointMatchAction(matchAction, currentPhaseStartTime, eventPointType, participants))
                .collect(Collectors.toList());

    }

    private FootballEventPointDTO createCommonEventPointMatchAction(MatchAction matchAction,
                                                                    Date currentPhaseStartTime,
                                                                    EventPointType eventPointType,
                                                                    List<ParticipantDTO> participants) {
        FootballEventPointDTO dto = new FootballEventPointDTO();
        dto.setType(eventPointType);
        dto.setPlayerId(matchAction.getPlayerId());
        return addCommonEventPointFields(dto,
                                        matchAction.getTeam(),
                                        matchAction.getTimeElapsedInPhase(),
                                        matchAction.getTimeStampUtc(),
                                        currentPhaseStartTime,
                                        participants,
                                        eventPointType.name());

    }

    private <T extends EventPointDTO> T addCommonEventPointFields(
            T eventPoint,
            String team,
            String elapsedTimeInPhase,
            OffsetDateTime actionTimeStamp,
            Date currentPhaseDateTime,
            List<ParticipantDTO> participantDTOS,
            String type) {
        eventPoint.setParticipantId(fetchParticipantId(participantDTOS, team));
        long elapseTimeInMillis = parseElapsedTime(elapsedTimeInPhase);
        eventPoint.setGameClockElapsedInSection(elapseTimeInMillis);
        long eventPointDelay = eventPointTypeDelayMap.get(type);
        Date occuredAt;
        if(actionTimeStamp == null) {
            occuredAt = new Date(currentPhaseDateTime.getTime() + elapseTimeInMillis + eventPointDelay);
        } else {
            occuredAt = Date.from(actionTimeStamp.plus(eventPointDelay, ChronoUnit.MILLIS).toInstant());
        }

        eventPoint.setOccurredAt(occuredAt);
        return eventPoint;

    }
    private long fetchParticipantId(List<ParticipantDTO> participants, String position) {
        for (ParticipantDTO participant : participants) {
            if (participant.getPosition().name().equalsIgnoreCase(position)) {
                return participant.getId();
            }
        }
        return 0;
    }

    private long parseElapsedTime(String elapsedTimeInPhase) {
        String[] dateParts = elapsedTimeInPhase.split(":");
        long hours = Long.parseLong(dateParts[0]);
        long minutes = Long.parseLong(dateParts[1]);

        String[] secondParts = dateParts[2].split("\\.");
        long seconds;
        long milliseconds = 0;
        if (secondParts.length > 1) {
            seconds = Long.parseLong(secondParts[0]);
            String milliSecondsAsString = secondParts[1];
            milliseconds =  (long)(Double.parseDouble(milliSecondsAsString) *
                    Math.pow(10, 3 - milliSecondsAsString.length()));
        } else {
            seconds = Long.parseLong(dateParts[2]);
        }

        return TimeUnit.HOURS.toMillis(hours) +
                TimeUnit.MINUTES.toMillis(minutes) +
                TimeUnit.SECONDS.toMillis(seconds) + milliseconds;
    }


}
