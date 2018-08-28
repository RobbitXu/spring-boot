package com.spring.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Created by admin on 2018/8/21.
 */
public class DemoEvent extends ApplicationEvent {

    private String msg ;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
