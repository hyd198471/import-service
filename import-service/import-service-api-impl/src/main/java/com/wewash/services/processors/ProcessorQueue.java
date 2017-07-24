package com.wewash.services.processors;

import com.wewash.services.queue.AsyncWorker;
import com.wewash.services.queue.SimpleQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProcessorQueue extends SimpleQueue<Long>{

    @Autowired
    public ProcessorQueue(@Qualifier("processorWorker") AsyncWorker<Long> asyncWorker) {
        super(asyncWorker);
    }
}
