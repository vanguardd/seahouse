package com.team.seahouse.commons.enums;

/**
 * @Title: 预约看房状态常量枚举类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public enum ReservationStatusEnum {

    UNCONFIRMED(0, "待确认"),
    CONFIRMED_COMPLETE(1, "已确认"),
    COMPLETE(3, "已完成");


    private Integer status;

    private String stateInfo;

    private ReservationStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ReservationStatusEnum stateOf(int index) {
        for (ReservationStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
