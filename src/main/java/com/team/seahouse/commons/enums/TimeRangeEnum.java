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
    ALL_DAY(1, "全天(9:00-22:00)"),
    MORNING(2, "上午(9:00-12:00)"),
    AFTERNOON(3, "下午(12:00-18:00)"),
    EVENING(4, "晚上(6:00-22:00)");


    private Integer status;

    private String stateInfo;

    private TimeRangeEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static TimeRangeEnum stateOf(int index) {
        for (TimeRangeEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
