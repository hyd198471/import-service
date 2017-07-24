package com.wewash.services.queue;

import java.util.concurrent.Future;

/**
 This is not really a queue - it simply leverages the async functionality from spring, which submits to a
 ThreadPoolExecutor (which has it's own queue). The difference here is simply that on 'reject and retry' we
 just submit the same work to the ThreadPoolExecutor.
 */
public class SimpleQueue<E> implements QueueWrapper<E> {
    private final AsyncWorker<E> asyncWorker;

    public SimpleQueue(AsyncWorker<E> asyncWorker) {
        this.asyncWorker = asyncWorker;
    }

    @Override
    public Future<E> submit(E e) {
        return asyncWorker.executeWorkAsync(e, this);
    }

    @Override
    public void complete(E e) {
        //nothing to do :)
    }

    @Override
    public void rejectAndRetry(E e) {
        asyncWorker.executeWorkAsync(e, this);
    }
}
