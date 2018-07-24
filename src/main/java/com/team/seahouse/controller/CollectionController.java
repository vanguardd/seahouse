package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.commons.utils.LoggerUtils;
import com.team.seahouse.domain.Collection;
import com.team.seahouse.domain.House;
import com.team.seahouse.repository.CollectionRepository;
import com.team.seahouse.service.ICollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    private CollectionRepository collectionRepository;

    @Autowired
    private ICollectionService collectionService;

    @PostMapping("/add")
    @ApiOperation(value = "收藏出租房屋接口", notes = "收藏出租房屋信息接口")
    public Response add(Collection collection) {
        try {
            collectionService.add(collection);
            return new Response(CommonReturnCode.OK);
        } catch (BusinessException e) {
            LoggerUtils.error(CollectionController.class, e.getMessage());
            return new Response(e.getCode(), e.getMessage());
        }
    }

    @DeleteMapping("remove/{collectionId}")
    @ApiOperation(value = "取消收藏接口", notes = "取消收藏出租信息接口")
    public Response remove(@PathVariable Long houseId) {
        try {
            collectionRepository.deleteCollectionByHouseId(houseId);
            return new Response(CommonReturnCode.SUCCESS);
        } catch (Exception e) {
            LoggerUtils.error(CollectionController.class, CommonReturnCode.FAILED.getMessage());
            return new Response(CommonReturnCode.FAILED);
        }
    }

    @GetMapping("/my/{userId}")
    @ApiOperation(value = "查看我的收藏接口", notes = "根据用户编号查看收藏的出租房屋信息列表")
    public Response getMyCollections(@PathVariable("userId") Long userId,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "15") Integer size) {
        //以创建时间降序排序
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        //封装分页对象
        Pageable pageable = new PageRequest(page, size, sort);
        try {
            List<House> houseList = collectionService.getMyCollections(userId, pageable);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

}
