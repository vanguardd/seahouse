package com.team.seahouse.commons.enums;

/**
 * @Title: 类型常量枚举类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/9/7
 */
public enum TypeEnum {

    /**
     * 发送短信验证码的类型
     */
    LOGIN_TYPE(1, "登录"),
    REGISTER_TYPE(2, "注册"),

    /**
     * 出租房屋类型
     */
    ALL_TYPE(1, "整租"),
    SHARE_TYPE(2, "合租"),
    APARTMENT_TYPE(3, "公寓");

    private Integer type;

    private String typeInfo;

    private TypeEnum(Integer type, String typeInfo) {
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
