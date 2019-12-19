package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @title 用户信息实体类
 * @describe 包含用户详细信息
 * @author vanguard
 * @version 1.0
 * @date 18/7/13
 */
@Data
@Table(name = "tb_user_info")
public class UserInfo extends BaseDomain {

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
