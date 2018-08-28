package com.spring.config.init;

import com.spring.demo.InitDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2018/8/21.
 */
@Configuration
public class InitConfig {

    @Bean(initMethod = "init" ,destroyMethod = "destory")
    public InitDemo initDemo (){
        return new InitDemo();
    }

//    @Bean
//    public InitDemo initDemo(){
//        return new InitDemo();
//    }
}
