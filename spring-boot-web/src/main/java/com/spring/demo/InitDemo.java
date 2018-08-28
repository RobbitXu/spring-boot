package com.spring.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by admin on 2018/8/21.
 */
public class InitDemo {

    public void init(){
        System.out.println("init");
    }

    public InitDemo(){
        System.out.println("construct");
    }


    public void destory(){
        System.out.println("destory");
    }

    @PostConstruct
    public void initPostConstruct(){
        System.out.println("initPostConstruct");
    }

    @PreDestroy
    public void destoryPreDestroy(){
        System.out.println("destoryPreDestroy");
    }
}
