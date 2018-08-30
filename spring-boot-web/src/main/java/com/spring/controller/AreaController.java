package com.spring.controller;

import com.spring.bean.AreaInfo;
import com.spring.controller.base.BaseController;
import com.spring.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 地区编码controller
 * Created by admin on 2018/7/4.
 */
@Slf4j
@RestController
@RequestMapping("/area")
public class AreaController extends BaseController {

    @Autowired
    AreaService areaService;


    /**
     * 根据等级查询地区编码
     * @param level
     * @return
     */
    @RequestMapping(value = "/queryAreaInfoByLevel")
    public List<AreaInfo> queryAreaInfoByLevel(@RequestParam("level") Integer level){
        return areaService.queryAreaInfoByLevel(level);
    }

    @RequestMapping(value = "/queryAreaInfoById")
//    @Cacheable(value="com.spring.area")
    public AreaInfo queryAreaInfoById(@RequestParam("id") Integer id){
        return  areaService.queryAreaInfoById(id);
    }

    @RequestMapping(value = "/updateAreaInfo")
    public Boolean  updateAreaInfo(@RequestParam("areaCode") String areaCode,@RequestParam("areaName") String areaName){
        return areaService.updateAreaInfo(areaCode,areaName);
    }

    @RequestMapping(value = "/queryAreaInfoByAreaCode")
    public List<AreaInfo> queryAreaInfoByAreaCode(@RequestParam("areaCode") String areaCode){
        return areaService.queryAreaInfoByAreaCode(areaCode);
    }

}
