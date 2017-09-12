package com.wewash.services.processors;

import com.wewash.services.domain.ebet.dto.event.EventDTO;
import com.wewash.services.domain.mapper.fixture.MessageMapper;
import com.wewash.services.model.FixtureSnapshot;
import com.wewash.services.model.IncomingMessage;
import com.wewash.services.model.MessageProcessingLock;
import com.wewash.services.model.MessageType;
import com.wewash.services.queue.AsyncWorker;
import com.wewash.services.queue.QueueWrapper;
import com.wewash.services.repository.FixtureSnapshotRepository;
import com.wewash.services.repository.IncomingMessageRepository;
import com.wewash.services.repository.MessageProcessingLockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

@Component("processorWorker")
public class ProcessorWorker implements AsyncWorker<Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorWorker.class);

    private final List<MessageProcessor> messageProcessors;

    private final TransactionTemplate transactionTemplate;

    private final MessageProcessingLockRepository messageProcessingLockRepository;

    private final IncomingMessageRepository incomingMessageRepository;

    private final FixtureSnapshotRepository fixtureSnapshotRepository;

    private final MessageMapper messageMapper;

    private static final Set<MessageType> SKIP_PUBLISH_MESSAGE_TYPES = new HashSet<>();

    private final AtomicLong requestNumber = new AtomicLong(0);


    private final Map<MessageType, MessageProcessor> messageProcessorMap = new EnumMap<>(MessageType.class);

    static {
        SKIP_PUBLISH_MESSAGE_TYPES.add(MessageType.COVERAGE);
        SKIP_PUBLISH_MESSAGE_TYPES.add(MessageType.FOOTBALLMATCHSUMMARY);
    }


    /*
    We choose Date(946681200000) (2000-01-01) as the minimum date as no message will ever be smaller than this date.
    We don't choose Date(0) as it's an illegal date in MYSQL.

    This is the date we create on the snapshot when there isn't a snapshot to begin with,
    so that the logic that checks for old messages doesn't get triggered but has a non-null date
    to compare against.
     */
    private static final Date MINIMUM_DATE = new Date(946681200000L);

    @PostConstruct
    void init() {
        messageProcessors.forEach(messageProcessor
                -> messageProcessorMap.put(messageProcessor.getMessageType(), messageProcessor));
    }

    @Autowired
    public ProcessorWorker(List<MessageProcessor> messageProcessors,
                           TransactionTemplate transactionTemplate,
                           MessageProcessingLockRepository messageProcessingLockRepository,
                           IncomingMessageRepository incomingMessageRepository,
                           FixtureSnapshotRepository fixtureSnapshotRepository,
                           MessageMapper messageMapper) {
        this.messageProcessors = Collections.unmodifiableList(messageProcessors);
        this.transactionTemplate = transactionTemplate;
        this.messageProcessingLockRepository = messageProcessingLockRepository;
        this.incomingMessageRepository = incomingMessageRepository;
        this.fixtureSnapshotRepository = fixtureSnapshotRepository;
        this.messageMapper= messageMapper;

    }


    @Override
    @Async("processorThreadPool")
    public Future<Long> executeWorkAsync(Long fixtureId, QueueWrapper<Long> queue) {

        processMessagesTransactionally(fixtureId);


        return new AsyncResult<>(fixtureId);
    }

    private void processMessagesTransactionally(Long fixtureId) {

        transactionTemplate.execute(transactionStatus -> {
                    acquireMessagingLock(fixtureId);
                    try {
                        return processMessages(fixtureId);
                    } finally {
                        releaseMessageProcessingLock(fixtureId);
                    }
                }
        );


    }

    // table MessageProcessingLock is required because we have Pessimistic lock in messageLogger

    // and OPTIMISTIC lock in snapshot publisher. A Entity table is used for a lock
    private void acquireMessagingLock(Long fixtureId) {
        MessageProcessingLock entityLock = new MessageProcessingLock();
        entityLock.setId(fixtureId);
        //save and flush because of concurrency issue
        messageProcessingLockRepository.saveAndFlush(entityLock);
    }

    private boolean processMessages(Long fixtureId) {

        FixtureSnapshot fixtureSnapshot;
        EventDTO originalDto;
        EventDTO originalDtoForComparison;
        Optional<FixtureSnapshot> snapshotOptional
                = Optional.ofNullable(fixtureSnapshotRepository.findOne(fixtureId));
        if(snapshotOptional.isPresent()) {
            fixtureSnapshot = snapshotOptional.get();
            originalDto = messageMapper.readValue(snapshotOptional.get(), EventDTO.class);
            //We read AGAIN so that it cannot be modified in-memory
            originalDtoForComparison = messageMapper.readValue(snapshotOptional.get(), EventDTO.class);
        } else {
            fixtureSnapshot = new FixtureSnapshot();
            fixtureSnapshot.setId(fixtureId);
            fixtureSnapshot.setBgHeaderTimestamp(MINIMUM_DATE);

            originalDto = new EventDTO();
            originalDtoForComparison = new EventDTO();
        }


        List<IncomingMessage> unprocessedMessages =
                incomingMessageRepository.findByFixtureIdAndProcessedOrderByHeaderTimestamp(fixtureId, false);

        unprocessedMessages.sort(new FixtureFirstMessageLogComparator());
        long requestNum = requestNumber.incrementAndGet();

        return false;
    }


    private void releaseMessageProcessingLock(Long fixtureId) {
        messageProcessingLockRepository.delete(fixtureId);
    }
}
