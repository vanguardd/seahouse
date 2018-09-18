package com.team.seahouse.service;

import com.team.seahouse.domain.Device;

/**
 * @Title:
 * @Description:
 * @Author: 你看起来很好吃
 * @Version: 1.0
 * @Date: 2018/09/18
 */
public interface IDeviceService {

    /**
     * @Title: 更新设备信息
     * @Description: 更新设备信息
     * @Author: 你看起来很好吃
     * @Version: 1.0
     * @Date: 2018/9/18
     */
    void updateDevice (Device device);

    /**
     * @Title: 新增一套设备信息
     * @Description:
     * @Author: 你看起来很好吃
     * @Version: 1.0
     * @Date: 2018/9/18
     */
    void insertDevice (Device device);
}
