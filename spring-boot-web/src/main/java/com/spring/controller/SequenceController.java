package com.spring.controller;

import com.spring.controller.base.BaseController;
import com.spring.service.MysqlSequence;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by admin on 2018/8/28.
 */
@RestController
@RequestMapping("/sequence")
@Slf4j
public class SequenceController extends BaseController {

    private static final String  SEQ_NAME = "T_SEQ_TEST";


    @Autowired
    MysqlSequence  mysqlSequence ;


    @RequestMapping("/queryNextVal")
    public String queryNextVal(){
        Thread thread = new Thread(new Test("Thread1",mysqlSequence));
        Thread thread2 = new Thread(new Test("Thread2",mysqlSequence));
        Thread thread3 = new Thread(new Test("Thread3",mysqlSequence));
        Thread thread4 = new Thread(new Test("Thread4",mysqlSequence));
        Thread thread5 = new Thread(new Test("Thread5",mysqlSequence));
        Thread thread6 = new Thread(new Test("Thread6",mysqlSequence));
        Thread thread7 = new Thread(new Test("Thread7",mysqlSequence));
        Thread thread8 = new Thread(new Test("Thread8",mysqlSequence));
        Thread thread9 = new Thread(new Test("Thread9",mysqlSequence));
        Thread thread10 = new Thread(new Test("Thread10",mysqlSequence));

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        return null;
    }

    class Test implements Runnable{

        private String name;
        private MysqlSequence mysqlSequence;
        public Test(String name,MysqlSequence mysqlSequence){
            this.name = name;
            this.mysqlSequence = mysqlSequence;
        }

        @Override
        public void run() {
            for(int i =0 ;i< 1000;i++){
                String sequence = mysqlSequence.nextVal(SEQ_NAME);
                log.info(name + "," + sequence);
                System.out.println(name + "," + sequence);
            }
        }
    }


    private String leftPadding(String seq,int len){
        String res  ="";
        String str ="";
        if(seq.length()<len){
            for(int i=0;i<len-seq.length();i++){
                str +="0";
            }
        }
        res  =str+seq;
        return res;

    }
}
