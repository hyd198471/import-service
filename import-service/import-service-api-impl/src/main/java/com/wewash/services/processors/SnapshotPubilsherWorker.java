package com.wewash.services.processors;

import com.wewash.services.queue.AsyncWorker;
import com.wewash.services.queue.QueueWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.Future;

@Component("snapshotPublisherWorker")
public class SnapshotPubilsherWorker implements AsyncWorker<Long> {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    @Async("snapshotPublisherThreadPool")
    public Future<Long> executeWorkAsync(Long fixtureId, QueueWrapper<Long> snapshotQueue) {

        return null;
    }
}
