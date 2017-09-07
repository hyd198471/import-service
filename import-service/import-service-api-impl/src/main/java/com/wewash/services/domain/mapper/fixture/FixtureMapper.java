package com.wewash.services.domain.mapper.fixture;

import com.wewash.services.domain.dto.fixture.Competitor;
import com.wewash.services.domain.dto.fixture.Event;
import com.wewash.services.domain.ebet.dto.common.MessageHeaderDTO;
import com.wewash.services.domain.ebet.dto.event.EventDTO;
import com.wewash.services.domain.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

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

    public EventDTO convertBetgeniusEventToEbetEvent(final Event betgeniusEvent, EventDTO eventDTO) {
        MessageHeaderDTO messageCommonDTO = new MessageHeaderDTO();
        messageCommonDTO.setMessageTime(convertToDate(betgeniusEvent.getHeader().getTimeStampUtc()));
        messageCommonDTO.setProvider(providerMapper.getProvider());

        eventDTO.setId(betgeniusEvent.getFixture().getId());
        eventDTO.setMessageHeader(messageCommonDTO);
        eventDTO.setSport(sportMapper.getSport(betgeniusEvent.getFixture().getSport().getId()));
        List<Competitor> competitors = betgeniusEvent.getFixture().getCompetitors();
        eventDTO.setParticipants(participantMapper.convertBetgeniusCompetitorsToEbetParticipants(competitors));
        eventDTO.setStartsAt(convertToDate(betgeniusEvent.getFixture().getStartTimeUtc()));
        eventDTO.setGroup(groupMapper.convertBetgeniusGroupToEbetGroup(betgeniusEvent));

        return eventDTO;
    }

    private Date convertToDate(OffsetDateTime startTime) {
        return Date.from(startTime.toInstant());
    }
}
