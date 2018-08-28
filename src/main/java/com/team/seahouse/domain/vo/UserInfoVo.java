package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.domain.UserInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Title: 用户信息视图对象
 * @Description: 包含用户信息和芝麻信用分
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/24
 */
@Getter@Setter
public class UserInfoVo extends BaseDomain {

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
    @NotNull(message = "手机号不能为空")
    private String mobilePhone;

    /**
     * 邮箱
     */
    @Email
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
     * 芝麻信用分
     */
    private Integer zmScore;
}
