package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.domain.House;
import com.team.seahouse.repository.HouseRepository;
import com.team.seahouse.service.IHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title 房屋模块接口
 * @describe 房屋模块接口
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@RestController
@RequestMapping("/house")
@Api(value = "房屋模块接口", description = "房屋模块接口")
public class HouseController extends BaseController {

    @Autowired
    private IHouseService houseService;

    @Autowired
    private HouseRepository houseRepository;

    /**
     * 发布出租房屋信息
     * @param house
     * @return
     */
    @PostMapping("/create")
    @ApiOperation(value = "发布出租房屋信息接口", notes = "发布出租房屋信息接口")
    public Response publish(@RequestBody House house) {
        try {
            houseService.publish(house);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
        return new Response(CommonReturnCode.OK);
    }

    /**
     * 查看房屋详情
     * @param houseId
     * @return
     */
    @GetMapping("/{houseId}")
    @ApiOperation(value = "查看房屋详情", notes = "查看房屋详情接口")
    public Response detail(@PathVariable("houseId") Long houseId) {
        try {
            House house = houseRepository.findByHouseId(houseId);
            return new Response(CommonReturnCode.OK, house);
        } catch (Exception e) {
            return new Response(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 修改出租房屋信息
     * @param house
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改出租房屋信息接口", notes = "修改出租房屋信息接口")
    public Response update(@RequestBody House house) {
        try {
            houseService.update(house);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
        return new Response(CommonReturnCode.OK);
    }
}
