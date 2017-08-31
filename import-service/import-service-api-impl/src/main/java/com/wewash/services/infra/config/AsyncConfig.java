package com.wewash.services.infra.config;

import com.wewash.services.infra.ThreadPoolTaskExecutorFactory;
import com.wewash.services.queue.AsyncWorker;
import com.wewash.services.queue.DedupingQueue;
import com.wewash.services.queue.QueueWrapper;
import com.wewash.services.queue.SimpleQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
@Profile("!BDD_TEST")
public class AsyncConfig {

    @Value("${service.betgenius.processorThreadPool.maxPoolSize:10}")
    private int processorThreadPoolMaxPoolSize;

    @Value("${service.betgenius.snapshotPublisherThreadPool.maxPoolSize:10}")
    private int snapshotPublisherThreadPoolMaxPoolSize;

    private final ThreadPoolTaskExecutorFactory executorFactory = new ThreadPoolTaskExecutorFactory();

    @Bean(name = "snapshotPublisherThreadPool", destroyMethod = "shutdown")
    public Executor snapshotPublisherExecutor() {
        return executorFactory.createNewExecutorWithPoolSize(snapshotPublisherThreadPoolMaxPoolSize);
    }

    @Bean(name = "processorThreadPool", destroyMethod = "shutdown")
    public Executor processorExecutor() {
        return executorFactory.createNewExecutorWithPoolSize(processorThreadPoolMaxPoolSize);
    }

    @Bean
    public QueueWrapper<Long> snapshotPublisherQueue(@Qualifier("snapshotPublisherWorker")
                                                             AsyncWorker<Long> asyncWorker) {
        return new DedupingQueue<>(asyncWorker);

    }

    @Bean
    public QueueWrapper<Long> processorQueue(@Qualifier("processorWorker")
                                                         AsyncWorker<Long> asyncWorker) {
        return new SimpleQueue<>(asyncWorker);
    }

}
