package com.spring;

import com.spring.config.event.EventConfig;
import com.spring.config.schedule.ScheduleTaskConfig;
import com.spring.config.thread.TaskExecutorConfig;
import com.spring.publisher.DemoPublisher;
import com.spring.schedule.ScheduleTaskService;
import com.spring.thread.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by admin on 2018/8/21.
 */
public class Test {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(ElConfig.class);
        //El config
//        ElConfig config = context.getBean(ElConfig.class);
//        config.outputResource();

        //init config
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(InitConfig.class);
//        InitConfig config = context.getBean(InitConfig.class);

        // event
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(EventConfig.class);
//        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
//        demoPublisher.pushMessage("Hello World!");

        //thread
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
//        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
//
//        for(int i =0 ;i< 10;i++){
//            asyncTaskService.executeAsyncTask(i);
//            asyncTaskService.executeAsyncTaskPlus(i);
//        }

        //schedule
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ScheduleTaskConfig.class);

//        context.close();

    }
}
