package com.cjlabs.api;

import com.cjlabs.boot.runner.ApplicationContextRunnerWrapper;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Job Delay Scheduler 主启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JobDelaySchedulerApplication {

    public static void main(String[] args) {
        ApplicationContextRunnerWrapper.run(JobDelaySchedulerApplication.class, args);
    }
}