package com.spring.config;

import com.spring.demo.FunctionDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2018/8/21.
 */
@Configuration
public class DemoConfig {

    /**
     * java配置创建bean
     * @return
     */
    @Bean
    public FunctionDemo functionDemo(){
        return  new FunctionDemo();
    }
}
