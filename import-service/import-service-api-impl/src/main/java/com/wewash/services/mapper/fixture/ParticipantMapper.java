package com.wewash.services.mapper.fixture;

import com.wewash.services.dto.fixture.Competitor;
import com.wewash.services.dto.fixture.HomeAway;
import com.wewash.services.ebet.dto.enums.Position;
import com.wewash.services.ebet.dto.event.ParticipantDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ParticipantMapper {

    private static final int MAX_PARTICIPANTS = 2;
    private static final int FIRST_IN_LIST = 0;

    List<ParticipantDTO> convertImportCompetitorsToEbetParticipants(List<Competitor> competitors) {
        List<ParticipantDTO> participants = new ArrayList<>(MAX_PARTICIPANTS);
        for (int i = 0; i < competitors.size(); i++) {
            Competitor competitor = competitors.get(i);
            ParticipantDTO participantDTO = new ParticipantDTO();
            participantDTO.setId(competitor.getId());
            participantDTO.setName(competitor.getName());
            participantDTO.setPosition(getPosition(competitor.getHomeAway(), i));
            participants.add(participantDTO);
        }

        return participants;
    }

    private Position getPosition(HomeAway homeAway, int index) {
        if (homeAway !=null){
            if (homeAway == HomeAway.Home) {
                return Position.HOME;
            } else if (homeAway == HomeAway.Away) {
                return Position.AWAY;
            }
        }
        return getPosition(index);
    }

    private Position getPosition(int index) {
        return index == FIRST_IN_LIST ? Position.HOME : Position.AWAY;
    }
}