package com.spring.publisher;

import com.spring.event.DemoEvent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/8/21.
 */
public class DemoPublisher {


    ApplicationContext context;

    public void pushMessage(String msg){
        context.publishEvent(new DemoEvent(this,msg));
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
