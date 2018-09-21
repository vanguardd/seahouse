package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.request.SearchQuery;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.Room;
import com.team.seahouse.domain.vo.HouseDetailVo;
import com.team.seahouse.domain.vo.HouseListVo;
import com.team.seahouse.domain.vo.LandlordHouseListVo;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.IRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
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
    private IRoomService roomService;

    /**
     * 保存房间信息接口
     * @param room
     * @return
     */
    @PostMapping("/room/save")
    @ApiOperation(value = "保存房间信息接口", notes = "保存房间信息，并返回保存的房间信息Id")
    public Response saveRoom(@RequestBody Room room) {
        try {
            Room saveRoom = roomService.save(room);
            return new Response(CommonReturnCode.OK, saveRoom);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 发布出租房屋信息
     * @param house
     * @return
     */
    @PostMapping("/add")
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
     * @param roomId 房屋编号
     * @return
     */
    @GetMapping("/{roomId}")
    @ApiOperation(value = "查看房屋详情", notes = "查看房屋详情接口")
    public Response detail(@PathVariable("roomId") Long roomId) {
        try {
            //获得已经登录的用户编号
            Long userId = getUserId();
            HouseDetailVo house = houseService.findByRoomId(roomId, userId);
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
     * @param searchQuery 搜索查询封装的对象
     * @return
     */
    @GetMapping("/search")
    @ApiOperation(value = "搜索房屋接口", notes = "根据关键字模糊查询和筛选房屋信息接口")
    public Response search(SearchQuery searchQuery) {
        try {
            PageResult<HouseListVo> houseList = houseService.search(searchQuery);
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
    public Response findByType(@PathVariable("type") Integer type, PageQuery pageQuery) {
        try {
            if(type == null) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            PageResult<HouseListVo> houseList = houseService.findByType(type, pageQuery);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 根据用户信息推荐房屋信息接口
     * @param pageQuery
     * @return
     */
    @GetMapping("/recommend")
    @ApiOperation(value = "推荐房屋信息接口", notes = "根据用户信息推荐房屋信息接口")
    public Response recommend(PageQuery pageQuery) {

        try {
            //获得携带Token的用户信息
            UserInfoVo userInfo = getUserInfo();
            PageResult<HouseListVo> houseList = houseService.recommend(userInfo, pageQuery);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 根据房东用户编号查询房东房屋列表
     * @param pageQuery
     * @return
     */
    @GetMapping("/landlord/list")
    @ApiOperation(value = "查询房东房屋列表", notes = "根据房东用户编号查询房东房屋列表")
    public Response landlordHouseList(PageQuery pageQuery) {
        try {
            Long userId = getUserId();
            PageResult<LandlordHouseListVo> pageResult = houseService.findLandlordHouseList(userId, pageQuery);
            return new Response(CommonReturnCode.OK, pageResult);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @PutMapping("/unShelve/{roomId}")
    @ApiOperation(value = "下架房间", notes = "对房间进行下架操作")
    public Response unShelve(@PathVariable("roomId") Long roomId) {
        try {
            roomService.unShelve(roomId);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(HouseController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
