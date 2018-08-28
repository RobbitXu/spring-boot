package com.spring.service.impl;

import com.spring.bean.AreaInfo;
import com.spring.repository.AreaInfoRepository;
import com.spring.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/7/4.
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaInfoRepository areaInfoRepository;

    @Override
    public List<AreaInfo> queryAreaInfoByLevel(Integer levelType) {
        List<AreaInfo>  areaInfoList = areaInfoRepository.findAreaInfoByLevelType(levelType);

        return areaInfoList;
    }

    @Override
    public AreaInfo queryAreaInfoById(Integer id) {

        AreaInfo areaInfo = areaInfoRepository.findById(id).get();
        return areaInfo;

    }

    @Override
    public Boolean updateAreaInfo(String areaCode,String areaName) {

        areaInfoRepository.updateAreaInfo(areaCode,areaName);
        return true;
    }

    @Override
    public List<AreaInfo> queryAreaInfoByAreaCode(String areaCode) {
        return areaInfoRepository.queryByAreaCode(areaCode);
    }
}
