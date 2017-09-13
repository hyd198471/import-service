package com.wewash.services.mapper.fixture;


import com.wewash.services.dto.fixture.Competition;
import com.wewash.services.dto.fixture.Event;
import com.wewash.services.dto.fixture.Region;
import com.wewash.services.dto.fixture.Sport;
import com.wewash.services.ebet.dto.event.GroupDTO;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    private GroupDTO convertImportGroupToEbetGroup(Sport sport, Region region, Competition competition) {
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

    GroupDTO convertImportGroupToEbetGroup(Event betgeniusEvent) {
        Competition competition = betgeniusEvent.getFixture().getCompetition();
        return convertImportGroupToEbetGroup(
                betgeniusEvent.getFixture().getSport(), competition.getRegion(), competition);
    }
}