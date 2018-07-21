package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @title 用户试图对象
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Getter@Setter
public class UserVo extends BaseDomain {

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 昵称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生年月
     */
    private Date bornDate;

    /**
     * 公司地址
     */
    private String companyAddress;
}