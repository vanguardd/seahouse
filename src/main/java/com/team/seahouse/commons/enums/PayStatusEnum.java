package com.team.seahouse.commons.enums;

/**
 * @Title: 支付状态
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/21
 */
public enum PayStatusEnum {

    NO_PAY(0, "未支付"),
    PAYED(1, "已支付");

    private Integer status;

    private String stateInfo;

    private PayStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static PayStatusEnum stateOf(int index) {
        for (PayStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
