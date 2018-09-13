package com.team.seahouse.commons.enums;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/13
 */
public enum ContractStatusEnum {

    NO_SIGN(0, "未签约"),
    SIGNED(1, "已签约");

    private Integer status;

    private String stateInfo;

    private ContractStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ContractStatusEnum stateOf(int index) {
        for (ContractStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
