package com.wewash.services.queue;

import java.util.concurrent.Future;

public interface AsyncWorker<E> {
    Future<E> executeWorkAsync(E e, QueueWrapper<E> queue);

}
