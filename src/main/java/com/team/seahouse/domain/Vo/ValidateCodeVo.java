package com.team.seahouse.domain.Vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author vanguard
 * @version 1.0
 * @title
 * @describe
 * @date 2018/07/16
 */
@Getter@Setter
public class ValidateCodeVo extends BaseDomain {
    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 验证码
     */
    private String validateCode;

    /**
     * 发送时间
     */
    private Date sendTime;
}
