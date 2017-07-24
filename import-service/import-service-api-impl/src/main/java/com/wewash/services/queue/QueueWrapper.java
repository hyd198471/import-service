package com.wewash.services.queue;

import java.util.concurrent.Future;

public interface QueueWrapper<E> {
    Future<E> submit(E e);

    void complete(E e);

    void rejectAndRetry(E e);
}
