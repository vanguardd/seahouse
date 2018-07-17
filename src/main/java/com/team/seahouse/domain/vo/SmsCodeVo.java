package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @title 验证码视图对象
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/17
 */
@Getter@Setter
public class SmsCodeVo extends BaseDomain {
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

    @Override
    public String toString() {
        return "SmsCodeVo{" +
                "mobilePhone='" + mobilePhone + '\'' +
                ", validateCode='" + validateCode + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
