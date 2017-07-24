package com.wewash.services.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 This is not really a queue - it simply leverages the async functionality from spring, which submits to a
 ThreadPoolExecutor (which has it's own queue). The only difference here is that it only submits to that
 ThreadPoolExecutor in case it hasn't submitted it yet. It also has a 'complete' method which allows
 workers to call back and remove from the 'working' list a given ID. That means that as long as a worker is working on
 the item with a given ID, we don't schedule the work.
 */
public class DedupingQueue<E> implements QueueWrapper<E>{
    private static final Logger LOGGER = LoggerFactory.getLogger(DedupingQueue.class);

    private final AsyncWorker<E> asyncWorker;

    private final Map<E, Future<E>> itemsBeingWorkedOn = new HashMap<>();
    public DedupingQueue(AsyncWorker<E> asyncWorker) {
        this.asyncWorker = asyncWorker;
    }

    @Override
    public Future<E> submit(E e) {
        synchronized (itemsBeingWorkedOn) {
            if(!itemsBeingWorkedOn.containsKey(e)) {
                itemsBeingWorkedOn.put(e, asyncWorker.executeWorkAsync(e,this));
            } else {
                LOGGER.debug("Rejected [{}] as it's already being worked on", e);
            }
        }
        return itemsBeingWorkedOn.get(e);
    }

    @Override
    public void complete(E e) {
        synchronized (itemsBeingWorkedOn) {
            LOGGER.debug("Completed [{}]", e);
            itemsBeingWorkedOn.remove(e);
        }

    }

    @Override
    public void rejectAndRetry(E e) {
        itemsBeingWorkedOn.put(e, asyncWorker.executeWorkAsync(e, this));
    }
}
