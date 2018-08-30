package com.spring.repository;

import com.spring.bean.MysqlSequenceBo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2018/8/28.
 */
public interface MysqlSequenceRepository extends JpaRepository<MysqlSequenceBo,Integer> {

//    int createSequence(MysqlSequenceBo bo);

    @Modifying
    @Transactional
    @Query("update MysqlSequenceBo as mysqlSequenceBo set mysqlSequenceBo.seqValue = :newSequence where mysqlSequenceBo.seqName= :seqName and mysqlSequenceBo.seqValue= :oldValue ")
    int updSequence(@Param("newSequence") Long newSequence, @Param("seqName") String seqName, @Param("oldValue") Long oldValue);

//    int delSequence(@Param("seqName") String seqName);


    MysqlSequenceBo findBySeqName(@Param("seqName") String seqName);

//    List<MysqlSequenceBo> getAll();

}
