package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.commons.utils.PagesUtils;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.domain.vo.Pages;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.ITrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @Title: 足迹模块接口
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/21
 */
@RestController
@RequestMapping("/track")
@Api(value = "足迹模块接口", description = "包含我的足迹，自动合并客户端访问足迹和后端记录")
public class TrackController extends BaseController {

    @Autowired
    private ITrackService trackService;

    /**
     * 查询我的足迹
     * @param pages
     * @return
     */
    @GetMapping("/myTrack")
    @ApiOperation(value = "查询我的足迹", notes = "根据用户编号查询足迹信息")
    public Response myTrack(@RequestBody Pages pages) {
        try {
            Long userId = getUserId();
            Pageable pageable = PagesUtils.createPageRequest(pages);
            Page<HouseVo> houseList = trackService.myTracks(userId, pageable);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            LoggerUtils.error(TrackController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 访问房屋信息详情时，添加浏览足迹
     * @param houseId
     * @param userId
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加足迹", notes = "访问房屋信息详情时，添加浏览足迹")
    public Response addTrack(Long houseId, Long userId) {
        try {
            trackService.add(userId, houseId);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 根据用户编号清空所有足迹信息
     * @param userId
     * @return
     */
    @DeleteMapping("/clear")
    @ApiOperation(value = "清空所有足迹信息", notes = "根据用户编号清空所有足迹信息")
    public Response clearTracks(Long userId) {
        try {
            trackService.clearTracks(userId);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
