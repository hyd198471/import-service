package com.wewash.services.domain.messageloggers;

import com.wewash.services.domain.dto.BaseMessage;
import com.wewash.services.domain.mapper.MessageMapper;
import com.wewash.services.model.IncomingMessage;
import com.wewash.services.model.MessageType;
import com.wewash.services.processors.ProcessorQueue;
import com.wewash.services.repository.MessageLogRepository;
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
    private MessageLogRepository messageLogRepository;

    @Autowired
    private ProcessorQueue processorQueue;

    public final void logMessage(String messageString) {
        IncomingMessage incomingMessage = generateMessageLog(messageString);
        T message = readMessage(messageString);

        incomingMessage.setBgHeaderTimestamp(Date.from(message.getHeader().getTimeStampUtc().toInstant()));

        long fixtureId = getFixtureId(message);
        incomingMessage.setFixtureId(fixtureId);

        LOGGER.info("Logging Fixture Id [{}] MessageType [{}]", fixtureId, getMessageType());

        messageLogRepository.saveAndFlush(incomingMessage);
        processorQueue.submit(fixtureId);


    }

    private IncomingMessage generateMessageLog(String message) {
        IncomingMessage incomingMessage = new IncomingMessage();
        incomingMessage.setIncomingMessage(message);
        incomingMessage.setIncomingMessageReceived(new Date());
        incomingMessage.setFixtureId(UNKNOWN_FIXTURE);
        incomingMessage.setMessageType(getMessageType());
        incomingMessage.setProcessed(false);
        return incomingMessage;
    }

    abstract protected long getFixtureId(T message);
    abstract Class<T> getMessageClass();
    abstract MessageType getMessageType();

    T readMessage(String message) { return messageMapper.readValue(message, getMessageClass());}
}
