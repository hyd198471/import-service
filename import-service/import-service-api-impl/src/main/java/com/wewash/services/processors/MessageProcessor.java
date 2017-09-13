package com.wewash.services.processors;

import com.wewash.services.ebet.dto.event.EventDTO;
import com.wewash.services.mapper.MessageMapper;
import com.wewash.services.exception.EventNotFoundException;
import com.wewash.services.model.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class MessageProcessor<T> {

    @Autowired
    private MessageMapper messageMapper;

    abstract MessageType getMessageType();
    abstract Class<T> getMessageClass();

    final EventDTO consumeMessageAndReturnEventDTO(Long fixtureId, String message, EventDTO eventDTO) {
        validate(eventDTO, fixtureId);
        T messageType = readMessage(message);
        return update(messageType, eventDTO);
    }

    protected abstract EventDTO update(T message, EventDTO eventDTO);


    protected void validate(EventDTO eventDTO, Long fixtureId) {
        if(eventDTO == null) {
            throw new EventNotFoundException(String.format("Event with unknown FixtureId [%s]", fixtureId));
        }
    }

    T readMessage(String message) {
        return messageMapper.readValue(message, getMessageClass());
    }

}
