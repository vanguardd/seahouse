package com.team.seahouse.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @title 用户对象
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bornDate;

    /**
     * 公司地址
     */
    private String companyAddress;
}
