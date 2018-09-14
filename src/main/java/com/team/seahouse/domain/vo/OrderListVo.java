package com.team.seahouse.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.commons.enums.OrderStatusEnum;
import com.team.seahouse.commons.enums.OrderTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: 订单列表对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/13
 */
@Getter@Setter
public class OrderListVo extends BaseDomain {
    /**
     * 订单编号
     * 系统生成
     */
    private String orderNumber;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 租客签字状态 1-签字;0-未签字
     */
    @Column(name = "renter_sign_state")
    private Integer renterSignState;

    /**
     * 房东编号
     */
    @Column(name = "landLord_id")
    private Long landlordId;

    /**
     * 房东签字状态 1-签字;0-未签字
     */
    @Column(name = "landLord_sign_state")
    private Integer landlordSignState;

    /**
     * 房屋编号
     */
    @Column(name = "house_id")
    private Long houseId;

    /**
     * 合同编号
     */
    @Column(name = "contract_id")
    private Long contractId;

    /**
     * 订单状态
     */
    private Integer state;

    /**
     * 状态值
     */
    private String stateVal;

    private String landlordAvatar;

    private String landlordName;

    private String tenantAvatar;

    private String tenantName;

    @JsonIgnore
    private String houseName;

    @JsonIgnore
    private String roomName;

    private String title;

    private String roomImage;

    private String fixtures;

    private Double roomArea;

    private BigDecimal rent;

    public String getTitle() {
        return houseName + " " + roomName;
    }

    public void setState(Integer state) {
        this.state = state;
        this.stateVal = OrderStatusEnum.stateOf(state).getStateInfo();
    }

}
