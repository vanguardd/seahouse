package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @title 签约实体类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/19
 */
@Table(name = "tb_contract")
@Getter@Setter
public class Contract extends BaseDomain {

    /**
     * 合同书
     */
    private String contractUrl;

    /**
     * 签订时间
     */
    private Date signingTime;

    /**
     * 生效时间
     */
    private Date effectiveTime;

    /**
     * 甲方用户编号
     */
    private Long partyAId;

    /**
     * 乙方用户编号
     */
    private Long partyBId;

     /** 甲方签字状态（租客） */
    private Integer renterSignState;

     /** 乙方签字状态（房东） */
    private Integer landlordSignState;

    /** 租客签约时间 */
    private Date renterSignTime;

    /** 房东签约时间 */
    private Date landlordSignTime;
    /**
     * 合同状态
     */
    private Integer state;

    /**
     * 签约开始日期
     */
    private Date startDate;

    /**
     * 签约结束日期
     */
    private Date endDate;

    /**
     * 创建时间
     */
    private Date createTime;
}
