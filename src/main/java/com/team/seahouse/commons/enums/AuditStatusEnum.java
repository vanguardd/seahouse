package com.team.seahouse.commons.enums;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public enum AuditStatusEnum {
    /** 审核状态 */
    UN_AUDIT(0, "未审核"),

    AUDIT_PASS(1, "审核通过"),

    AUDIT_FAIL(2, "审核未通过");

    private Integer status;

    private String stateInfo;

    private AuditStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AuditStatusEnum stateOf(int index) {
        for (AuditStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
