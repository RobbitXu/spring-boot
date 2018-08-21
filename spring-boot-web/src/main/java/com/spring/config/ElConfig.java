package com.spring.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;


/**
 * Created by admin on 2018/8/21.
 */
@Configuration
@PropertySource("classpath:file/test.properties")
@ComponentScan("com.spring.demo")
public class ElConfig {

    /**
     * 常量
     */
    @Value("hello")
    private String normal;

    /**
     * 注入其他属性
     */
    @Value("#{functionDemo.another}")
    private String another;

    /**
     * 获取主机名
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 随机数
     */
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    @Value("classpath:file/test.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource urlResource;

    @Value("${test.username}")
    private String username;

    @Autowired
    Environment environment;

    /**
     * 读取properties文件使用
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try{
            System.out.println(normal);
            System.out.println(another);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(username);
            System.out.println(IOUtils.toString(urlResource.getInputStream()));
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(environment.getProperty("test.password"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
