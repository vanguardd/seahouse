package com.team.seahouse.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @Title: 房东信息视图对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/09
 */
@Getter@Setter
public class LandlordFunction {

    /**
     * 房屋个数
     */
    private Integer houseCount;

    /**
     * 房间个数
     */
    private Integer roomCount;

    /**
     * 预约个数
     */
    private Integer reservationCount;

    /**
     * 房客个数
     */
    private Integer tenantCount;

    /**
     * 订单个数
     */
    private Integer orderCount;
}
