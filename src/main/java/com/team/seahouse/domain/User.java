package com.team.seahouse.domain;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

/**
 * @Title: 用户实体类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/8/26
 */
@Data
@Table(name = "tb_user")
public class User extends BaseDomain {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobilePhone;

    private String password;

    private String email;

    private Date lastPasswordResetDate;

    /**
     * 用户 状态
     */
    private Integer state;
}