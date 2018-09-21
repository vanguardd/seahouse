package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.domain.Device;
import com.team.seahouse.mapper.DeviceMapper;
import com.team.seahouse.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author: 你看起来很好吃
 * @Version: 1.0
 * @Date: 2018/09/18
 */
@Service
public class DeviceServiceImpl implements IDeviceService{

    @Autowired
    private DeviceMapper deviceMapper;

    public void updateDevice (Device device) {
        try{
            deviceMapper.updateDevice(device);
        }catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    public void insertDevice (Device device) {
        try{
            deviceMapper.insert(device);
        }catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }
}
