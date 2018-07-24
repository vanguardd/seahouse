package com.team.seahouse.controller;

import com.team.seahouse.commons.base.BaseController;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.response.Response;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.QueryVo;
import com.team.seahouse.repository.HouseRepository;
import com.team.seahouse.service.IHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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
            House house = houseService.findByHouseId(houseId);
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

    /**
     * 根据关键字模糊查询房屋信息接口
     * @param queryVo 搜索查询封装的对象
     * @param page 第几页
     * @param size 每页显示个数
     * @return
     */
    @GetMapping("/search")
    @ApiOperation(value = "搜索房屋接口", notes = "根据关键字模糊查询和筛选房屋信息接口")
    public Response search(@RequestBody QueryVo queryVo,
                                 @RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "15") Integer size) {
        //默认以价格从高到低排序
        Sort sort = new Sort(Sort.Direction.DESC, "price");
        //封装分页对象
        Pageable pageable = new PageRequest(page, size, sort);
        try {
            List<House> houseList = houseService.search(queryVo, pageable);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }

    /**
     * 根据类型查询方法信息接口
     * @param type
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/type/{type}")
    @ApiOperation(value = "根据类型查询房屋信息接口", notes = "根据类型查询房屋信息接口")
    public Response findByType(@PathVariable("type") Integer type,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "15") Integer size) {
        //默认以价格从高到低排序
        Sort sort = new Sort(Sort.Direction.DESC, "price");
        //封装分页对象
        Pageable pageable = new PageRequest(page, size, sort);
        try {
            List<House> houseList = houseService.findByType(type, pageable);
            return new Response(CommonReturnCode.OK, houseList);
        } catch (BusinessException e) {
            return new Response(e.getCode(), e.getMessage());
        }
    }
}
