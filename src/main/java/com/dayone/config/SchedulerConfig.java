package com.dayone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler threadPoll = new ThreadPoolTaskScheduler();

        int n = Runtime.getRuntime().availableProcessors();
        threadPoll.setPoolSize(n);
        threadPoll.initialize();

        taskRegistrar.setTaskScheduler(threadPoll);
    }
}
