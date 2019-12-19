package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @title 实名认证实体
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Data
@Table(name = "tb_identity_auth")
public class IdentityAuth extends BaseDomain {

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
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 审核时间
     */
    private Date auditTime;
}
