package com.team.seahouse.commons.enums;

/**
 * @Title: 房间状态常量枚举类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public enum RoomStatusEnum {

    NORMAL(1, "正常"),

    RENTED(2, "已租"),

    OFF_SHELVE(0, "下架");

    private Integer status;

    private String stateInfo;

    private RoomStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static RoomStatusEnum stateOf(int index) {
        for (RoomStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }

}
