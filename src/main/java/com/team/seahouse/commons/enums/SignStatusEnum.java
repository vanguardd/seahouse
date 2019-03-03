package com.team.seahouse.commons.enums;

/**
 * @Title: 签约状态
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/21
 */
public enum SignStatusEnum {
    NO_SIGN(0, "未签约"),
    SIGNED(1, "已签约");

    private Integer status;

    private String stateInfo;

    private SignStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SignStatusEnum stateOf(int index) {
        for (SignStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
