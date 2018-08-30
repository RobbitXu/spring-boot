package com.spring.mapper;

import com.spring.bean.MysqlSequenceBo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2018/8/28.
 */
@Repository
public interface MysqlSequenceDAO {
    /**
     *
     */
    int createSequence(MysqlSequenceBo bo);

    int updSequence(@Param("newSequence") Long newSequence,@Param("seqName") String seqName, @Param("oldValue") Long oldValue);

    int delSequence(@Param("seqName") String seqName);

    MysqlSequenceBo getSequence(@Param("name") String seqName);

    List<MysqlSequenceBo> getAll();

}
