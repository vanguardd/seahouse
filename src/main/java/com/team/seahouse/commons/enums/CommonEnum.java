package com.team.seahouse.commons.enums;

import com.team.seahouse.commons.response.CommonReturnCode;

/**
 * 通用常量枚举
 */
public enum  CommonEnum {

    /**
     * 发送短信验证码的类型
     */
    LOGIN_TYPE(1, "登录"),
    REGISTER_TYPE(2, "注册"),

    /**
     * 出租房屋类型
     */
    ALL_TYPE(1, "整租"),
    SHARE_TYPE(2, "合租");


    private Integer type;

    private String typeInfo;

    private CommonEnum(Integer type, String typeInfo) {
        this.type = type;
        this.typeInfo = typeInfo;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }
}
