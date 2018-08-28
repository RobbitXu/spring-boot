package com.spring.bean;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by admin on 2018/8/28.
 */
@Data
public class SequenceRange {

    private final long       min;
    private final long       max;
    /**  */
    private final AtomicLong value;
    /** 是否超限 */
    private volatile boolean over = false;

    /**
     * 构造.
     *
     * @param min
     * @param max
     */
    public SequenceRange(long min, long max) {
        this.min = min;
        this.max = max;
        this.value = new AtomicLong(min);
    }

    /**
     * <p>Gets and increment</p>
     *
     * @return
     */
    public long getAndIncrement() {
        long currentValue = value.getAndIncrement();
        if (currentValue > max) {
            over = true;
            return -1;
        }

        return currentValue;
    }
}
