package com.team.seahouse.commons.enums;

/**
 * @Title: 订单状态常量枚举类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public enum OrderStatusEnum {

    SUBMIT_ORDERS(1, "待签约"),
    SIGN_TO_COMPLETE(2, "待付款"),
    PAY_TO_COMPLETE(3, "待入住"),
    CHECK_IN(4, "待评价"),
    EVALUATE_TO_COMPLETE(10, "订单完成"),

    EXIT_RENT(5, "申请退租中"),
    EXIT_RENT_SUCC(6, "申请退租成功"),
    EXIT_RENT_FAIL(7, "申请退租失败"),
    FINISHED(8, "订单终止"),

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
