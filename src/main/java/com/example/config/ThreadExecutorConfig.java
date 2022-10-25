package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadExecutorConfig {

    @Bean(name = "demoTaskExecutor")
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(15);
        executor.setMaxPoolSize(40);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(120);
        executor.setThreadNamePrefix("demoTaskExecutorThread");
        executor.initialize();
        return executor;
    } 
}
