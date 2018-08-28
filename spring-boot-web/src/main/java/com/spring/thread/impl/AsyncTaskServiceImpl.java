package com.spring.thread.impl;

import com.spring.thread.AsyncTaskService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/8/22.
 */
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {

    @Async
    @Override
    public void executeAsyncTask(Integer i) {
        System.out.println(String.format("execute async task:%s",i));
    }

    @Async
    @Override
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println(String.format("execute async task  plus : %s " ,i));

    }
}
