package com.spring.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 地区编码表
 * Created by admin on 2018/7/4.
 */
@Data
@Entity
@Table(name="t_area_info")
public class AreaInfo implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    /**
     * 地区编码
     */
    private String areaCode;
    /**
     * 父级地区编码
     */
    private String parentCode;
    /**
     * 地区编码名称
     */
    private String areaName;
    /**
     * 区域等级 0:国家 1:省 2:市 3:县区
     */
    private Integer levelType;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 更新日期
     */
    private Date updateTime;
    /**
     * 是否有效
     */
    @Column(name="is_delete")
    private Boolean delete;
}
