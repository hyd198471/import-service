package com.wewash.services.infra;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadPoolTaskExecutorFactory {

    public ThreadPoolTaskExecutor createNewExecutorWithPoolSize(int poolSize) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(poolSize);
        executor.setCorePoolSize(poolSize);
        executor.setAllowCoreThreadTimeOut(true);
        executor.initialize();
        return executor;
    }

}
