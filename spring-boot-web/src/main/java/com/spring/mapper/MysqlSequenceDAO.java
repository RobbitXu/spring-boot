package com.spring.mapper;

import com.spring.bean.MysqlSequenceBo;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by admin on 2018/8/28.
 */
public interface MysqlSequenceDAO {
    /**
     *
     */
    int createSequence(MysqlSequenceBo bo);

    int updSequence(@Param("seqName") String seqName, @Param("oldValue") long oldValue, @Param("newValue") long newValue);

    int delSequence(@Param("seqName") String seqName);

    MysqlSequenceBo getSequence(@Param("seqName") String seqName);

    List<MysqlSequenceBo> getAll();

}
