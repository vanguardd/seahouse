package com.team.seahouse.commons.enums;

/**
 * @Title: 订单状态常量枚举类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public enum OrderStatusEnum {

    SUBMIT_ORDERS(1, "订单提交"),
    SIGN_TO_COMPLETE(2, "签字完成"),
    PAY_TO_COMPLETE(3, "支付完成"),
    EVALUATE_TO_COMPLETE(4, "评价完成"),

    AUTOMATICALLY_CANCEL_THE_ORDER(11, "自动取消订单"),
    MANUALLY_CANCEL_THE_ORDER(12, "手动取消订单");

    private Integer status;

    private String stateInfo;

    private OrderStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static OrderStatusEnum stateOf(int index) {
        for (OrderStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus() == index) {
                return statusEnum;
            }
        }
        return null;
    }
}
