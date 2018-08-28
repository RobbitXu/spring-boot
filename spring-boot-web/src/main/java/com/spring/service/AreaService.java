package com.spring.service;

import com.spring.bean.AreaInfo;

import java.util.List;

/**
 * Created by admin on 2018/7/4.
 */
public interface AreaService {

    /**
     * 根据等级查询
     * @param levelType
     * @return
     */
    List<AreaInfo> queryAreaInfoByLevel(Integer levelType);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    AreaInfo queryAreaInfoById(Integer id);


    /**
     * 更新数据
     * @return
     */
    Boolean updateAreaInfo(String areaCode,String areaName);


    /**
     * 根据code查询
     * @param areaCode
     * @return
     */
    List<AreaInfo> queryAreaInfoByAreaCode(String areaCode);

}
