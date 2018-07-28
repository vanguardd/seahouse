package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.commons.utils.PagesUtils;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.vo.Pages;
import com.team.seahouse.domain.vo.QueryVo;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.repository.HouseRepository;
import com.team.seahouse.service.IHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
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
            House house = houseService.findByHouseId(houseId);
            return new Response(CommonReturnCode.OK, house);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
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
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 根据关键字模糊查询房屋信息接口
     * @param queryVo 搜索查询封装的对象
     * @return
     */
    @GetMapping("/search")
    @ApiOperation(value = "搜索房屋接口", notes = "根据关键字模糊查询和筛选房屋信息接口")
    public Response search(@RequestBody QueryVo queryVo, Pages pages) {
        //创建Pageable对象
        Pageable pageable = PagesUtils.createPageRequest(pages);
        try {
            Page<House> houseList = houseService.search(queryVo, pageable);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 根据类型查询房屋信息接口
     * @param type
     * @return
     */
    @GetMapping("/type/{type}")
    @ApiOperation(value = "根据类型查询房屋信息接口", notes = "根据类型查询房屋信息接口")
    public Response findByType(@PathVariable("type") Integer type,
                               @RequestBody Pages pages) {
        //创建Pageable对象
        Pageable pageable = PagesUtils.createPageRequest(pages);
        try {
            Page<House> houseList = houseService.findByType(type, pageable);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 根据用户信息推荐房屋信息接口
     * @param pages
     * @return
     */
    @GetMapping("/recommend")
    @ApiOperation(value = "推荐房屋信息接口", notes = "根据用户信息推荐房屋信息接口")
    public Response recommend(@RequestBody Pages pages) {
        //创建Pageable对象
        Pageable pageable = PagesUtils.createPageRequest(pages);
        //获得携带Token的用户信息
        UserInfoVo userInfo = getUserInfo();
        try {
            Page<House> houseList = houseService.recommend(userInfo, pageable);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
