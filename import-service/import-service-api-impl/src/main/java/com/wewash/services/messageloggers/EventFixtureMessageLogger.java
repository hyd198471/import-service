package com.wewash.services.messageloggers;

import com.wewash.services.dto.fixture.Event;
import org.springframework.stereotype.Service;

import com.wewash.services.model.MessageType;

@Service
public class EventFixtureMessageLogger extends MessageLogger<Event> {

    @Override
    protected long getFixtureId(Event event) {
        return event.getFixture().getId();
    }

    @Override
    Class<Event> getMessageClass() {
        return Event.class;
    }

    @Override
    MessageType getMessageType() {
        return MessageType.FIXTURE;
    }

}
