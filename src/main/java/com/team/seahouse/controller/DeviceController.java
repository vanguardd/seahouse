package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.domain.Device;
import com.team.seahouse.service.IDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author: 你看起来很好吃
 * @Version: 1.0
 * @Date: 2018/09/17
 */
@RestController
@RequestMapping("/device")
@Api(value="设备业务", description = "新增设备信息、查询设备信息")
public class DeviceController extends BaseController{


    @Autowired
    private IDeviceService deviceService;

    /**
     * 新增设备信息
     * @param device
     * @return
     */
    @PostMapping("/insert")
    @ApiOperation(value="新增设备信息", notes = "新增一条设备信息")
    public void insert (@RequestBody Device device) {
        long userId = getUserId();
        device.setUserId(userId);
        device.setCreateTime(new Date());
        try{
            deviceService.insertDevice(device);
        }catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    /**
     * 更新设备信息
     * @param device
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value="更新设备信息", notes="根据查询结果选择，新增或者更新设备信息")
    public void update (@RequestBody Device device) {
        try{
            long userId = getUserId();
            device.setUserId(userId);
            device.setCreateTime(new Date());
            deviceService.updateDevice(device);
        }catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }
}
