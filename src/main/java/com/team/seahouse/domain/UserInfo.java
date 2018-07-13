package com.team.seahouse.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @title 用户信息实体类
 * @describe 包含用户详细信息
 * @author vanguard
 * @version 1.0
 * @date 18/7/13
 */
@Table(name = "tb_user_info")
@Entity
@Getter@Setter
public class UserInfo {
    /**
     * 用户基本信息编号
     */
    @Id
    @GeneratedValue
    private Long userInfoId;
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 昵称
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生年月
     */
    private Date bornDate;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 用户状态
     */
    private String state;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;
}
