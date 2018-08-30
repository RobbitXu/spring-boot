package com.spring.dubbo.product.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.spring.dubbo.product.DubboServerService;

/**
 * Created by admin on 2018/8/30.
 */
@Service(version = "1.0.0")
public class DubboServerServiceImpl implements DubboServerService {
    @Override
    public void test() {

    }
}
