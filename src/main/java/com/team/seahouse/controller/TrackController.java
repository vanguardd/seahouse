package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.domain.vo.HouseListVo;
import com.team.seahouse.mapper.HouseMapper;
import com.team.seahouse.service.ITrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: 足迹模块接口
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/21
 */
@Slf4j
@RestController
@RequestMapping("/track")
@Api(value = "足迹模块接口", description = "包含我的足迹，自动合并客户端访问足迹和后端记录")
public class TrackController extends BaseController {

    @Autowired
    private ITrackService trackService;

    /**
     * 查询我的足迹
     * @param page
     * @return
     */
    @GetMapping("/myTrack")
    @ApiOperation(value = "查询我的足迹", notes = "根据用户编号查询足迹信息")
    public Response myTrack(PageQuery page) {
        try {
            Long userId = getUserId();
            PageResult<HouseListVo> houseList = trackService.myTracks(userId, page);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 添加客户端保存的足迹记录
     * @param houseIds
     * @return
     */
    @PostMapping("/addList")
    @ApiOperation(value = "添加足迹", notes = "访问房屋信息详情时，添加浏览足迹")
    public Response addTrack(@RequestParam("houseIds") String houseIds) {

        try {
            if(!StringUtils.isNotBlank(houseIds)) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            Long userId = getUserId();
            List<Long> houseIdList = StringUtils.stringToArray(houseIds);
            trackService.addList(userId, houseIdList);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        } 
    }

    /**
     * 根据用户编号清空所有足迹信息
     * @return
     */
    @DeleteMapping("/clear")
    @ApiOperation(value = "清空所有足迹信息", notes = "根据用户编号清空所有足迹信息")
    public Response clearTracks() {
        try {
            Long userId = getUserId();
            trackService.clearTracks(userId);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 删除足迹
     * @param houseIds
     * @return
     */
    @DeleteMapping("/deleteTracks")
    @ApiOperation(value = "删除足迹", notes = "删除单个或多个足迹")
    public Response deleteTracks(String houseIds) {
        try {
            if(!StringUtils.isNotBlank(houseIds)) {
                throw new BusinessException(CommonReturnCode.BAD_REQUEST);
            }
            Long userId = getUserId();
            List<Long> houseIdList = StringUtils.stringToArray(houseIds);
            trackService.deleteTracks(userId, houseIdList);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            log.error(e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
