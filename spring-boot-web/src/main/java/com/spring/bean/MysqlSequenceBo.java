package com.spring.bean;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/8/28.
 */
@Data
@Entity
@Table(name="t_pub_sequence")
public class MysqlSequenceBo implements Serializable {

    /**
     * seq名
     */
    @Id
    private String seqName;
    /**
     * 当前值
     */
    private Long seqValue;
    /**
     * 最小值
     */
    private Long minValue;
    /**
     * 最大值
     */
    private Long maxValue;
    /**
     * 每次取值的数量
     */
    private Long step;
    /**  */
    private Date tmCreate;
    /**  */
    private Date tmSmp;

    /**
     * 一些简单的校验。如当前值必须在最大最小值之间。step值不能大于max与min的差
     * @return
     */
    public boolean validate(){
        if (StringUtils.isEmpty(seqName) || minValue < 0 || maxValue <= 0 || step <= 0 || minValue >= maxValue || maxValue - minValue <= step ||seqValue < minValue || seqValue > maxValue ) {
            return false;
        }
        return true;
    }
}
