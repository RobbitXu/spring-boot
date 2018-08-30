package com.spring.service.impl;

import com.spring.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/8/30.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate ;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void test(Object o) {

        //set value
        stringRedisTemplate.opsForValue().set("com:spring:test", "111");

        //get value
        String testValue = stringRedisTemplate.opsForValue().get("com:spring:test");
    }
}
