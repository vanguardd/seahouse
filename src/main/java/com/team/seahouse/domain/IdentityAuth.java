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
 * @title 实名认证实体
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Entity
@Table(name = "tb_identity_auth")
@Getter@Setter
public class IdentityAuth extends BaseDomain {
    /**
     * 认证编号
     */
    @Id
    @GeneratedValue
    private Long authId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件类型
     */
    private String idType;

    /**
     * 证件号码
     */
    private String idNumber;

    /**
     * 证件照片1
     */
    private String image1;

    /**
     * 证件照片2
     */
    private String image2;

    /**
     * 证件照片3
     */
    private String image3;

    /**
     * 审核备注
     */
    private String remark;

    /**
     * 审核状态
     */
    private String state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 审核时间
     */
    private Date auditTime;
}
