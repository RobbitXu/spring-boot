package com.spring.config.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by admin on 2018/8/22.
 */
@Configuration
@ComponentScan("com.spring.schedule")
@EnableScheduling
public class ScheduleTaskConfig {
}
