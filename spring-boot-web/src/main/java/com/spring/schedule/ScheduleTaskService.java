package com.spring.schedule;

/**
 * 定时任务
 * Created by admin on 2018/8/22.
 */
public interface ScheduleTaskService {
    /**
     * 当前时间
     */
    void reportCurrentTime();

    void reportCurrentTimeForFixedRate ();

    /**
     * 制定时间
     */
    void fixTimeExecution();
}
