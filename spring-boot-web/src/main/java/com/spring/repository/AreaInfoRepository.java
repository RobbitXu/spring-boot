package com.spring.repository;

import com.spring.bean.AreaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2018/7/6.
 */
public interface AreaInfoRepository extends JpaRepository<AreaInfo,Integer> {
    AreaInfo findAreaInfoByAreaCode(String areaCode);

    List<AreaInfo> findAreaInfoByLevelType(Integer levelType);

    List<AreaInfo> findAreaInfoByParentCode(String parentCode);

    List<AreaInfo> findAreaInfoByAreaCodeIn(List<String> areaInfo);


    @Modifying
    @Transactional
    @Query("update AreaInfo as areaInfo set areaInfo.areaName = :areaName where areaInfo.areaCode = :areaCode")
    Integer updateAreaInfo(@Param("areaCode") String areaCode, @Param("areaName") String areaName);


    @Query(value = "select areaInfo.areaCode, areaInfo.parentCode,areaInfo.areaName,areaInfo.levelType from AreaInfo as areaInfo where areaInfo.areaCode = :areaCode")
    List<AreaInfo> queryByAreaCode(@Param("areaCode") String areaCode);


}
