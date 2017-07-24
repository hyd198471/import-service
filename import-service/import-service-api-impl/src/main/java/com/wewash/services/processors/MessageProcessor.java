package com.wewash.services.processors;

import com.wewash.services.domain.mapper.MessageMapper;
import com.wewash.services.model.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class MessageProcessor<T> {

    @Autowired
    private MessageMapper messageMapper;

    abstract MessageType getMessageType();
    abstract Class<T> getMessageClass();



    T readMessage(String message) {
        return messageMapper.readValue(message, getMessageClass());
    }

}
