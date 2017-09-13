package com.wewash.services.processors;

import com.google.common.collect.Sets;
import com.wewash.services.dto.fixture.Event;
import com.wewash.services.ebet.dto.event.EventDTO;
import com.wewash.services.mapper.fixture.FixtureMapper;
import com.wewash.services.mapper.MessageMapper;
import com.wewash.services.mapper.fixture.SportMapper;
import com.wewash.services.model.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EventFixtureMessageProcessor extends MessageProcessor<Event> {

    private static final Set<Integer> SUPPORTED_SPORTS = Sets.newHashSet(SportMapper.BG_FOOTBALL);

    @Autowired
    private FixtureMapper fixtureMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    MessageType getMessageType() {
        return MessageType.FIXTURE;
    }

    @Override
    Class<Event> getMessageClass() {
        return Event.class;
    }

    @Override
    protected EventDTO update(Event event, EventDTO eventDTO) {
        validateSportSupported(event);
        eventDTO = fixtureMapper.convertImportEventToEbetEvent(event, eventDTO);
        return eventDTO;
    }


    private void validateSportSupported(Event event) {
        if(SUPPORTED_SPORTS.contains(event.getFixture().getSport().getId())) {
            String errorMessage = String.format("Unsupported sport [%s] with Id: [%s]",
                    event.getFixture().getSport().getName(), event.getFixture().getSport().getId());
            throw new UnsupportedFeatureException(errorMessage);
        }

    }
}
