package com.wewash.services.processors;

import com.wewash.services.domain.ebet.dto.event.EventDTO;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.stereotype.Service;

@Service
public class MaterialEventComparator {
    public boolean hasMaterialUpdate(EventDTO originalDto, EventDTO updatedDto) {
        if(oneSideisNull(originalDto, updatedDto)) {
            return bothSideAreNull(originalDto, updatedDto);
        }

        EqualsBuilder equalsBuilder = new EqualsBuilder()
                .append(originalDto.getId(), updatedDto.getId())
                .append(originalDto.isLive(), updatedDto.isLive())
                .append(originalDto.getSport(), updatedDto.getSport())
                .append(originalDto.getStartsAt(), updatedDto.getStartsAt())
                .append(originalDto.getParticipants(), updatedDto.getParticipants())
                .append(originalDto.getGroup(), updatedDto.getGroup())
                .append(originalDto.getConfigs(), updatedDto.getConfigs())
                .append(originalDto.getBetMarkets(), updatedDto.getBetMarkets())
                .append(originalDto.getSections(), updatedDto.getSections())
                .append(originalDto.getCurrentSection(), updatedDto.getCurrentSection());

        if(oneSideisNull(originalDto.getMessageHeader(), updatedDto.getMessageHeader())) {
            if(!bothSideAreNull(originalDto.getMessageHeader(), updatedDto.getMessageHeader())) {
                //If both sides aren't null, then there's a difference.
                return true;
            }
        } else {
            //This means that neither side is null
            //do not care about messageheader messageTime
            equalsBuilder.append(
                    originalDto.getMessageHeader().getProvider(),
                    updatedDto.getMessageHeader().getProvider()
            );
        }
        return !equalsBuilder.isEquals();

    }

    private boolean oneSideisNull(Object object1, Object object2) {
        return object1 == null || object2 == null;
    }


    private boolean bothSideAreNull(Object object1, Object object2) {
        return object1 == null && object2 == null;
    }

}
