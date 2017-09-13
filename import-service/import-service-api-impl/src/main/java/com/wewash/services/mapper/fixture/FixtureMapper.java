package com.wewash.services.mapper.fixture;

import com.wewash.services.dto.fixture.Competitor;
import com.wewash.services.dto.fixture.Event;
import com.wewash.services.ebet.dto.common.MessageHeaderDTO;
import com.wewash.services.ebet.dto.event.EventDTO;
import com.wewash.services.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Component
public class FixtureMapper {
    private ProviderMapper providerMapper;

    private GroupMapper groupMapper;

    private SportMapper sportMapper;

    private ParticipantMapper participantMapper;

    @Autowired
    public FixtureMapper(ProviderMapper providerMapper, GroupMapper groupMapper,
                         SportMapper sportMapper, ParticipantMapper participantMapper) {
        this.providerMapper = providerMapper;
        this.groupMapper = groupMapper;
        this.sportMapper = sportMapper;
        this.participantMapper = participantMapper;
    }

    public EventDTO convertImportEventToEbetEvent(final Event importEvent, EventDTO eventDTO) {
        MessageHeaderDTO messageCommonDTO = new MessageHeaderDTO();
        messageCommonDTO.setMessageTime(convertToDate(importEvent.getHeader().getTimeStampUtc()));
        messageCommonDTO.setProvider(providerMapper.getProvider());

        eventDTO.setId(importEvent.getFixture().getId());
        eventDTO.setMessageHeader(messageCommonDTO);
        eventDTO.setSport(sportMapper.getSport(importEvent.getFixture().getSport().getId()));
        List<Competitor> competitors = importEvent.getFixture().getCompetitors();
        eventDTO.setParticipants(participantMapper.convertImportCompetitorsToEbetParticipants(competitors));
        eventDTO.setStartsAt(convertToDate(importEvent.getFixture().getStartTimeUtc()));
        eventDTO.setGroup(groupMapper.convertImportGroupToEbetGroup(importEvent));

        return eventDTO;
    }

    private Date convertToDate(OffsetDateTime startTime) {
        return Date.from(startTime.toInstant());
    }
}
