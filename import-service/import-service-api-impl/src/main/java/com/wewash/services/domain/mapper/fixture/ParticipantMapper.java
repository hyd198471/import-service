package com.wewash.services.domain.mapper.fixture;

import com.wewash.services.domain.dto.fixture.Competitor;
import com.wewash.services.domain.dto.fixture.HomeAway;
import com.wewash.services.domain.ebet.dto.enums.Position;
import com.wewash.services.domain.ebet.dto.event.ParticipantDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.wewash.services.domain.dto.fixture.HomeAway.Away;
import static com.wewash.services.domain.dto.fixture.HomeAway.Home;
import static com.wewash.services.domain.ebet.dto.enums.Position.AWAY;
import static com.wewash.services.domain.ebet.dto.enums.Position.HOME;


@Component
public class ParticipantMapper {

    private static final int MAX_PARTICIPANTS = 2;
    private static final int FIRST_IN_LIST = 0;

    List<ParticipantDTO> convertBetgeniusCompetitorsToEbetParticipants(List<Competitor> competitors) {
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
            if (homeAway == Home) {
                return HOME;
            } else if (homeAway == Away) {
                return AWAY;
            }
        }
        return getPosition(index);
    }

    private Position getPosition(int index) {
        return index == FIRST_IN_LIST ? HOME : AWAY;
    }
}