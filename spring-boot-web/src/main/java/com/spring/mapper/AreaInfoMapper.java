package com.spring.mapper;

import com.spring.bean.AreaInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据处理mapper
 * Created by admin on 2018/7/4.
 */
@Repository
public interface AreaInfoMapper {
    List<AreaInfo> queryAll();
    AreaInfo queryAreaInfoById(Integer id);
}
