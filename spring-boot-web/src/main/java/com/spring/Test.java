package com.spring;

import com.spring.config.ElConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by admin on 2018/8/21.
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig config = context.getBean(ElConfig.class);
        config.outputResource();
        context.close();

    }
}
