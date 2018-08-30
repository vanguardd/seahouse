package com.team.seahouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.seahouse.commons.enums.StatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseDetailVo;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.commons.request.SearchQuery;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.mapper.HouseMapper;
import com.team.seahouse.mapper.UserInfoMapper;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @title 房屋模块业务实现
 * @describe 房屋模块业务实现
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private ITrackService trackService;

    @Override
    public void publish(House house) {

        //设置标题
        house.setTitle(house.getHouseName() + " " + house.getRoomName());

        //根据房东用户编号查询房东信息
        UserInfoVo landLoadInfo = userInfoMapper.findUserInfoByUserId(house.getLandlordId());

        //设置房东姓名
        house.setLandlordName(landLoadInfo.getRealName());
        //设置房东芝麻信用分
        house.setLandLardZhiMaScore(landLoadInfo.getZmScore());
        //设置审核状态默认为未审核
        house.setState(StatusEnum.UN_AUDIT.getStatus());
        //设置创建时间
        house.setCreateTime(new Date());
        //设置更新时间
        house.setUpdateTime(new Date());

        try {
            houseMapper.insert(house);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(House house) {
        //设置更新时间
        house.setUpdateTime(new Date());
        try {
            houseMapper.updateByPrimaryKey(house);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public HouseDetailVo findByHouseId(Long houseId, Long userId) {
        HouseDetailVo house = houseMapper.findByHouseId(houseId);
        if(house == null) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
        //用户编号不为空，代表已经登录，添加浏览记录
        if(userId != null) {
            trackService.add(userId, houseId);
        }
        return house;

    }

    @Override
    public PageResult<HouseVo> search(SearchQuery searchQuery) {

        try {
            PageHelper.startPage(searchQuery.getPage(), searchQuery.getSize());
            PageHelper.orderBy(searchQuery.getSortColumn() + " " + searchQuery.getDirection());

            List<HouseVo> houseList = houseMapper.search(searchQuery);
            PageResult<HouseVo> result = new PageResult<>(houseList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public PageResult<HouseVo> findByType(Integer type, PageQuery page) {

        try {
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序条件
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<HouseVo> houseList = houseMapper.findHousesByType(type);
            PageResult<HouseVo> result = new PageResult<>(houseList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public PageResult<HouseVo> recommend(UserInfoVo userInfo, PageQuery page) {

        try {
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序条件
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<HouseVo> houseList = houseMapper.findByUserInfo(userInfo);
            PageResult<HouseVo> result = new PageResult<>(houseList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }
}
