package com.wewash.services.processors;

import com.wewash.services.model.MessageType;
import com.wewash.services.queue.AsyncWorker;
import com.wewash.services.queue.QueueWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Component("processorWorker")
public class ProcessorWorker implements AsyncWorker<Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorWorker.class);

    @Autowired
    private List<MessageProcessor> messageProcessors;

    @Autowired
    private TransactionTemplate transactionTemplate;


    private final Map<MessageType, MessageProcessor> messageProcessorMap = new EnumMap<>(MessageType.class);


    @PostConstruct
    void init() {
        messageProcessors.forEach(messageProcessor
                -> messageProcessorMap.put(messageProcessor.getMessageType(),messageProcessor));
    }

    @Override
    @Async("processorThreadPool")
    public Future<Long> executeWorkAsync(Long fixtureId, QueueWrapper<Long> queue) {
        return new AsyncResult<>(fixtureId);
    }



}
