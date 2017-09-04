package com.wewash.services.processors;

import com.wewash.services.infra.send.EventImportServiceSender;
import com.wewash.services.infra.send.InvalidMessageException;
import com.wewash.services.model.FixtureSnapshot;
import com.wewash.services.model.SnapshotPublishingLock;
import com.wewash.services.queue.AsyncWorker;
import com.wewash.services.queue.QueueWrapper;
import com.wewash.services.repository.FixtureSnapshotRepository;
import com.wewash.services.repository.SnapshotPublishingLockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.concurrent.Future;

@Component("snapshotPublisherWorker")
public class SnapshotPubilsherWorker implements AsyncWorker<Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnapshotPubilsherWorker.class);

    @Autowired
    private EventImportServiceSender eventImportServiceSender;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private SnapshotPublishingLockRepository snapshotPublishingLockRepository;

    @Autowired
    private FixtureSnapshotRepository fixtureSnapshotRepository;

    @Override
    @Async("snapshotPublisherThreadPool")
    public Future<Long> executeWorkAsync(Long fixtureId, QueueWrapper<Long> snapshotQueue) {
        publishSnapshotTransactionally(fixtureId);


        return null;
    }

    private void publishSnapshotTransactionally(Long fixtureId) {
        transactionTemplate.execute(transactionStatus -> {
                acquirePublishLock(fixtureId);
                publishSnapshot(fixtureId);
                releaseSnapshot(fixtureId);
                return null;
        });

    }

    private void acquirePublishLock(Long fixtureId) {
        LOGGER.debug("Acquiring Publishing lock for fixtureId [{}]", fixtureId);
        SnapshotPublishingLock entityLock = new SnapshotPublishingLock();
        entityLock.setId(fixtureId);
        snapshotPublishingLockRepository.saveAndFlush(entityLock);
        LOGGER.debug("Publishing Lock for fixtureId [{}] acquired", fixtureId);


    }

    private void publishSnapshot(Long fixtureId) {
        LOGGER.debug("About to publish snapshot [{}]", fixtureId);
        FixtureSnapshot fixtureSnapshot = fixtureSnapshotRepository.findOne(fixtureId);
        if(!fixtureSnapshot.getPublished()) {
            try {
                eventImportServiceSender.sendEvent(fixtureSnapshot.getSnapshotJson());
                fixtureSnapshot.setPublishedAt(new Date());
                fixtureSnapshot.setPublished(true);
            } catch (InvalidMessageException e) {
                LOGGER.error("Latest Snapshot for [{}] rejected", fixtureId, e);
                fixtureSnapshot.setValid(false);
            }
            fixtureSnapshotRepository.saveAndFlush(fixtureSnapshot);
        } else {
            LOGGER.debug("Snapshot for [{}] not published as already published", fixtureId);
        }


    }

    private void releaseSnapshot(Long fixtureId) {
        LOGGER.debug("Releasing Publishing Lock for fixtureId [{}]", fixtureId);
        snapshotPublishingLockRepository.delete(fixtureId);
    }


}
