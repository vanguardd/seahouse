package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Title: 房东房屋列表对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/14
 */
@Getter@Setter
public class LandlordHouseListVo extends BaseDomain {

    /**
     * 房东名称
     */
    private String houseName;

    private String fixtures;

    private String city;

    private String region;

    private Integer auditState;

    private List<RoomVo> rooms;
}

/**
 * 房间对象(一对多)
 */
@Getter@Setter
class RoomVo extends BaseDomain {
    private String roomName;

    private String roomImage;

    private String roomArea;

    private BigDecimal rent;

    private String rentWay;

    private Integer state;
}
