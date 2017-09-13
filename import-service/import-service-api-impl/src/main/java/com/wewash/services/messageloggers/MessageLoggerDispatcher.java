package com.wewash.services.messageloggers;

import java.io.IOException;
import java.util.*;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.wewash.services.exception.BadImportMessageException;
import com.wewash.services.exception.PoisonMessageException;
import com.wewash.services.model.MessageType;
import com.wewash.services.model.PoisonAuditLog;
import com.wewash.services.repository.PoisonAuditLogRepository;

@Service
public class MessageLoggerDispatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageLoggerDispatcher.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private CounterService counterService;

    @Autowired
    private List<MessageLogger> messageLoggers;

    @Autowired
    private PoisonAuditLogRepository poisonAuditLogRepository;

    private Map<MessageType, MessageLogger> messageLoggerMap = new EnumMap<>(MessageType.class);

    @PostConstruct
    public void init() {
        for (MessageLogger messageLogger : messageLoggers) {
            messageLoggerMap.put(messageLogger.getMessageType(), messageLogger);
        }
    }

    public void process(String incomingMessage) {
        MessageType messageType;
        try {
            messageType = extractMessageType(incomingMessage);
            if (messageLoggerMap.containsKey(messageType)) {
                messageLoggerMap.get(messageType).logMessage(incomingMessage);
            }
        } catch (PoisonMessageException | BadImportMessageException e) {
            generatePoisonAuditLog(incomingMessage, e);
            counterService.increment("messages.poison");
            throw e;
        }

    }

    private MessageType extractMessageType(String incomingMessage) {
        final JsonNode root;
        try {
            root = MAPPER.readTree(incomingMessage);
        } catch (IOException e) {
            throw new PoisonMessageException(e.getMessage(), e);
        }

        Iterator<String> fieldNames = root.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            if (!"header".equalsIgnoreCase(fieldName)) {
                return MessageType.valueOf(fieldName.toUpperCase(Locale.ENGLISH));
            }
        }
        throw new BadImportMessageException("Cannot determine type of import message: " + incomingMessage);
    }

    private void generatePoisonAuditLog(String incomingMessage, RuntimeException e) {
        PoisonAuditLog poisonAuditLog = new PoisonAuditLog();
        poisonAuditLog.setExceptionMessage(Throwables.getStackTraceAsString(e));
        poisonAuditLog.setIncomingMessage(incomingMessage);
        poisonAuditLog.setIncomingMessageReceived(new Date());
        poisonAuditLogRepository.saveAndFlush(poisonAuditLog);
    }

}
