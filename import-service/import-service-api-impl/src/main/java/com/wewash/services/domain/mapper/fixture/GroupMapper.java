package com.wewash.services.domain.mapper.fixture;


import com.wewash.services.domain.dto.fixture.Competition;
import com.wewash.services.domain.dto.fixture.Event;
import com.wewash.services.domain.dto.fixture.Region;
import com.wewash.services.domain.dto.fixture.Sport;
import com.wewash.services.domain.ebet.dto.event.GroupDTO;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    private GroupDTO convertBetgeniusGroupToEbetGroup(Sport sport, Region region, Competition competition) {
        GroupDTO groupSportDTO = new GroupDTO();
        groupSportDTO.setId(sport.getId());
        groupSportDTO.setName(sport.getName());

        GroupDTO groupRegionDTO = new GroupDTO();
        groupRegionDTO.setId(region.getId());
        groupRegionDTO.setName(region.getName());

        GroupDTO groupCompetitionDTO = new GroupDTO();
        groupCompetitionDTO.setId(competition.getId());
        groupCompetitionDTO.setName(competition.getName());

        groupCompetitionDTO.setParent(groupRegionDTO);
        groupRegionDTO.setParent(groupSportDTO);
        return groupCompetitionDTO;
    }

    GroupDTO convertBetgeniusGroupToEbetGroup(Event betgeniusEvent) {
        Competition competition = betgeniusEvent.getFixture().getCompetition();
        return convertBetgeniusGroupToEbetGroup(
                betgeniusEvent.getFixture().getSport(), competition.getRegion(), competition);
    }
}