package com.spring.schedule.impl;

import com.spring.schedule.ScheduleTaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/8/22.
 */
@Component
public class ScheduleTaskServiceImpl  {

    private static final SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    /**
     * fixedDelay 从上一次方法执行完开始算
     * fixedRate 从上一次方法执行时开始算，如果上一次方法阻塞住了，下一次也是不会执行，但是在阻塞这段时间内累计应该执行的次数，当不再阻塞时，一下子把这些全部执行掉，而后再按照固定速率继续执行
     * cron表达式可以定制化执行任务
     */

//    @Scheduled(fixedDelay = 5*1000)
    public void reportCurrentTime() {
        try {
            Thread.sleep(8 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("fixedDelay current time : %s",sf.format(new Date()) ));

    }

//    @Scheduled(fixedRate = 5*1000)
    public void reportCurrentTimeForFixedRate() {
        try {
            Thread.sleep(8 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("fixedRate current time : %s",sf.format(new Date()) ));
    }


//    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecution() {
        System.out.println(String.format("fix time : %s" ,sf.format(new Date())));
    }
}
