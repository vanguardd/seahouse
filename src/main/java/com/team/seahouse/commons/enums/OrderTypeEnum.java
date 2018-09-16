package com.team.seahouse.commons.enums;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public enum OrderTypeEnum {
    ALL_VALID(0, "1,2,3,4,9", "全部有效订单"),
    TO_BE_PAID(1, "1", "未签字"),
    WAIT_FOR_RECEIVING(2, "1,2", "待支付"),
    CLOSE(3, "1,2,3,9", "待评价"),
    ALL_ORDER(4,"1,2,3,4,9,11,12","全部订单");

    private Integer type;

    private String typeValue;

    private String typeInfo;

    private OrderTypeEnum(Integer type, String typeValue, String typeInfo) {
        this.type = type;
        this.typeValue = typeValue;
        this.typeInfo = typeInfo;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public static OrderTypeEnum typeOf(Integer index) {
        for (OrderTypeEnum statusEnum : values()) {
            if (statusEnum.getType().equals(index)) {
                return statusEnum;
            }
        }
        return ALL_VALID;
    }
}
