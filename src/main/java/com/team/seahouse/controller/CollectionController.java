package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.Collections;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.mapper.CollectionMapper;
import com.team.seahouse.service.ICollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: 收藏模块接口
 * @Description: 收藏模块接口
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/21
 */
@RestController
@RequestMapping("/collection")
@Api(value = "收藏模块接口", description = "收藏模块接口")
public class CollectionController extends BaseController {
    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private ICollectionService collectionService;

    @PostMapping("/add")
    @ApiOperation(value = "收藏出租房屋接口", notes = "收藏出租房屋信息接口")
    public Response add(@RequestBody Collections collections) {

        try {
            Long userId = getUserId();
            collections.setUserId(userId);
            collectionService.add(collections);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(CollectionController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @DeleteMapping("remove/{houseId}")
    @ApiOperation(value = "取消收藏接口", notes = "取消收藏出租信息接口")
    public Response remove(@PathVariable("houseId") Long houseId) {
        try {
            collectionMapper.deleteCollectionByHouseId(houseId);
            return new Response(CommonReturnCode.SUCCESS);
        } catch (Exception e) {
            LoggerUtils.error(CollectionController.class, CommonReturnCode.FAILED.getMessage());
            return new Response(CommonReturnCode.FAILED);
        }
    }

    @GetMapping("/myCollection")
    @ApiOperation(value = "查看我的收藏接口", notes = "根据用户编号查看收藏的出租房屋信息列表")
    public Response getMyCollections(@RequestBody PageQuery pageQuery) {
        Long userId = getUserId();
        try {
            PageResult<HouseVo> houseList = collectionService.getMyCollections(userId, pageQuery);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

}
