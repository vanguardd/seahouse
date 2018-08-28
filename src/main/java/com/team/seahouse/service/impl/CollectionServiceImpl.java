package com.team.seahouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.Collections;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.mapper.CollectionMapper;
import com.team.seahouse.mapper.HouseMapper;
import com.team.seahouse.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Title: 收藏业务接口实现类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/21
 */
@Service
public class CollectionServiceImpl implements ICollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public void add(Collections collections) {
        //设置创建时间
        collections.setCreateTime(new Date());
        try {
            collectionMapper.insert(collections);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public PageResult<HouseVo> getMyCollections(Long userId, PageQuery page) {
        try {
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序条件
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<HouseVo> houseList = houseMapper.findCollectedHouseByUserId(userId);
            PageResult<HouseVo> result = new PageResult<>(houseList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
    }
}
