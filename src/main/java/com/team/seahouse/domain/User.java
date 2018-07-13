package com.team.seahouse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @title 用户实体类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */
@Getter@Setter
@Entity
@Table(name = "tb_user")
public class User extends BaseDomain {

    @Id
    @GeneratedValue
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
     * 密码
     */
    private String password;

    /**
     * 最近一次修改或重置密码的时间
     */
    private Date lastPasswordResetDate;


}
