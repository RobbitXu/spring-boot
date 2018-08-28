package com.spring.service.impl;

import com.spring.service.MysqlSequence;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/8/28.
 */
@Service
public class MysqlSequenceImpl implements MysqlSequence {
    @Autowired
    private MysqlSequenceFactory mysqlSequenceFactory;

    @Override
    public String nextVal(String seqName) {
        return null;
    }
}
