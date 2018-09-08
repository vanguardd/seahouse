package com.team.seahouse.commons.enums;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public enum TimeRangeEnum {

    /** 预约看房时间段 */
    ALL_DAY(1, "", "全天"),
    MORNING(2, "", "上午(9:00-12:00)"),
    AFTERNOON(3, "", "下午(12:00-6:00)"),
    EVENING(4, "", "晚上(6:00-10:00)");

    private Integer type;

    private String typeValue;

    private String typeInfo;

    TimeRangeEnum(Integer type, String typeValue, String typeInfo) {
        this.type = type;
        this.typeValue = typeValue;
        this.typeInfo = typeInfo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
    }
}
