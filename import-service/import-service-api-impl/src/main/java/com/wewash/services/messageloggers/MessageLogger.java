package com.wewash.services.messageloggers;

import com.wewash.services.dto.BaseMessage;
import com.wewash.services.mapper.MessageMapper;
import com.wewash.services.model.IncomingMessage;
import com.wewash.services.model.MessageType;
import com.wewash.services.queue.QueueWrapper;
import com.wewash.services.repository.IncomingMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public abstract class MessageLogger<T extends BaseMessage> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageLogger.class);

    private static final Long UNKNOWN_FIXTURE = -1L;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private IncomingMessageRepository incomingMessageRepository;

    @Autowired
    private QueueWrapper<Long> processorQueue;

    final void logMessage(String messageString) {
        IncomingMessage incomingMessage = generateMessageLog(messageString);
        T message = readMessage(messageString);

        incomingMessage.setHeaderTimestamp(Date.from(message.getHeader().getTimeStampUtc().toInstant()));

        long fixtureId = getFixtureId(message);
        incomingMessage.setFixtureId(fixtureId);

        LOGGER.info("Logging Fixture Id [{}] MessageType [{}]", fixtureId, getMessageType());

        incomingMessageRepository.saveAndFlush(incomingMessage);
        processorQueue.submit(fixtureId);


    }

    private IncomingMessage generateMessageLog(String message) {
        IncomingMessage incomingMessage = new IncomingMessage();
        incomingMessage.setIncomingMessageJson(message);
        incomingMessage.setIncomingMessageReceived(new Date());
        incomingMessage.setFixtureId(UNKNOWN_FIXTURE);
        incomingMessage.setMessageType(getMessageType());
        incomingMessage.setProcessed(false);
        return incomingMessage;
    }

    protected abstract long getFixtureId(T message);
    abstract Class<T> getMessageClass();
    abstract MessageType getMessageType();

    private T readMessage(String message) { return messageMapper.readValue(message, getMessageClass());}
}
