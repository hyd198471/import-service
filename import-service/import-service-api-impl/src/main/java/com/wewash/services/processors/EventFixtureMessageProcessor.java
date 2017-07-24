package com.wewash.services.processors;

import com.wewash.services.domain.dto.fixture.Event;
import com.wewash.services.model.MessageType;
import org.springframework.stereotype.Service;

@Service
public class EventFixtureMessageProcessor extends MessageProcessor <Event> {
    @Override
    MessageType getMessageType() {
        return MessageType.FIXTURE;
    }

    @Override
    Class<Event> getMessageClass() {
        return Event.class;
    }
}
