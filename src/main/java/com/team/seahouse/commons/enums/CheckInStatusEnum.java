package com.team.seahouse.commons.enums;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/21
 */
public enum CheckInStatusEnum {
    NO_CHECK_IN(0, "未入住"),
    CHECKED_IN(1, "已入住");

    private Integer status;

    private String stateInfo;

    private CheckInStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static CheckInStatusEnum stateOf(int index) {
        for (CheckInStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
