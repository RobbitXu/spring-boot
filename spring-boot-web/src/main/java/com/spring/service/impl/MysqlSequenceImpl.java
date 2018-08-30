package com.spring.service.impl;

import com.spring.factory.MysqlSequenceFactory;
import com.spring.service.MysqlSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by admin on 2018/8/28.
 */
@Service
public class MysqlSequenceImpl implements MysqlSequence {
    @Autowired
    private MysqlSequenceFactory mysqlSequenceFactory;

    @Override
    public String nextVal(String seqName) {
        return Objects.toString(mysqlSequenceFactory.getNextVal(seqName));
    }
}
