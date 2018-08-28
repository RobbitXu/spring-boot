package com.spring.thread;

/**
 * 多线程任务
 * Created by admin on 2018/8/22.
 */
public interface AsyncTaskService {
    /**
     * 异步任务
     * @param i
     */
    void executeAsyncTask(Integer i);

    /**
     * 异步任务
     * @param i
     */
    void executeAsyncTaskPlus(Integer i);
}
