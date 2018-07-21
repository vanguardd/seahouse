package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @title 合同实体类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/19
 */
@Entity
@Table(name = "tb_contract")
@Getter@Setter
public class Contract extends BaseDomain {

    /**
     * 合同编号
     */
    @Id
    @GeneratedValue
    private Long contractId;

    /**
     * 合同书
     */
    private String contractUrl;

    /**
     * 签订时间
     */
    private Date SigningTime;

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

    /**
     * 合同状态
     */
    private String state;
}