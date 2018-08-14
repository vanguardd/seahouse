package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @title 用户实体类
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/12
 */

@Entity
@Table(name = "tb_user")
@Getter@Setter
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
    @NotNull(message = "手机号不能为空")
    private String mobilePhone;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 最近一次修改或重置密码的时间
     */
    private Date lastPasswordResetDate;

    /**
     * 用户状态
     */
    private Integer state;

}
