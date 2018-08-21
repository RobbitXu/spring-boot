package com.spring.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/8/21.
 */
@Data
@Service
public class FunctionDemo {

    @Value("another")
    private String another;
}
