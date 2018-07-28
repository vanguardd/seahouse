package com.team.seahouse.domain.vo;

import com.team.seahouse.domain.UserInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Title: 用户信息视图对象
 * @Description: 包含用户信息和芝麻信用分
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/24
 */
public interface UserInfoVo {

    /**
     * 用户编号
     */
    Long getUserId();

    /**
     * 昵称
     */
    String getUserName();

    /**
     * 手机号
     */
    String getMobilePhone();

    /**
     * 邮箱
     */
    String getEmail();

    /**
     * 性别
     */
    Integer getSex();

    /**
     * 出生年月
     * @return
     */
    Date getBornDate();

    /**
     * 真实姓名
     */
    String getRealName();

    /**
     * 头像
     */
    String getAvatar();

    /**
     * 公司地址
     */
    String getCompanyAddress();

    /**
     * 芝麻信用分
     */
    Integer getZmScore();
}
