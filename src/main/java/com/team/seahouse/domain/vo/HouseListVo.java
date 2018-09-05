package com.team.seahouse.domain.vo;

import com.team.seahouse.commons.base.BaseDomain;
import com.team.seahouse.domain.House;
import com.team.seahouse.mapper.typehandler.StringArrayTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Title: 列表房屋对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/24
 */
@Getter@Setter
public class HouseListVo extends BaseDomain {

    /**
     * 详情首页照片和列表照片
     */
    private String roomImage;

    /**
     * 标题
     */
    private String title;

    /**
     * 装修程度
     */
    private String fixtures;

    /**
     * 房屋面积
     */
    private Double roomArea;

    /**
     * 租金
     */
    private BigDecimal rent;

    /**
     * 租住方式
     */
    private String rentWay;

    /**
     * 标签
     */
    private String labels;

    /**
     * 地址
     */
    private String address;

    /**
     * 地址坐标
     */
    private String addressCoordinate;

    public String[] getLabels() {
        if(labels != null && !labels.equals("")) {
            return labels.split(",");
        }
        return null;
    }

    public String[] getAddressCoordinate() {
        if(addressCoordinate != null && !addressCoordinate.equals("")) {
            return addressCoordinate.split(",");
        }
        return null;
    }
}
