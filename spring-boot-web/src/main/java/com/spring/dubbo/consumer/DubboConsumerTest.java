package com.spring.dubbo.consumer;

import com.spring.dubbo.product.DubboServerService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/8/30.
 */
@Component
public class DubboConsumerTest {
    @Reference
    DubboServerService dubboServerService;
}
