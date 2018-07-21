package com.team.seahouse.service;

import com.team.seahouse.domain.House;

/**
 * @title 房屋业务接口
 * @describe 房屋业务接口
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface IHouseService {

    /**
     * 发布出租房屋信息
     * @param house
     */
    void publish(House house);

    /**
     * 更新出租房屋信息
     * @param house
     */
    void update(House house);

}
