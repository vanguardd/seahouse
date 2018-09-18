package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.Device;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Title: 设备信息模块
 * @Description:
 * @Author: 你看起来很好吃
 * @Version: 1.0
 * @Date: 2018/9/17
 */
public interface DeviceMapper extends BaseMapper<Device> {

    /**
     * 更新设备信息
     * @param userId
     * @return
     */
    @Update("UPDATE TB_DEVICE SET CLIENT_ID=#{device.clientId}, MODEL=#{device.model}, VENDOR=#{device.vendor}, UUID=#{device.uuid}," +
            "SCREEN_WIDTH=#{device.screenWidth}, SCREEN_HEIGHT=#{device.screenHeight}, OS_NAME=#{device.osName}, OS_VENDOR=#{device.osVendor}," +
            "OS_VERSION=#{device.osVersion}, OS_LANGUAGE=#{device.osLanguage}  WHERE user_id=#{device.userId}")
    int updateDevice(Device device);
}