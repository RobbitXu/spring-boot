package com.spring.config.event;

import com.spring.listener.DemoListener;
import com.spring.publisher.DemoPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2018/8/21.
 */
@Configuration
public class EventConfig {

    @Bean
    public DemoPublisher demoPublisher(ApplicationContext context){
        DemoPublisher demoPublisher = new DemoPublisher();
        demoPublisher.setContext(context);
        return demoPublisher;
    }

    @Bean
    public DemoListener demoListener(){
        return new DemoListener();
    }
}
