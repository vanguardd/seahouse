package com.team.seahouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.team.seahouse.commons.enums.AuditStatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.support.page.PageQuery;
import com.team.seahouse.commons.support.page.PageResult;
import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseDetailVo;
import com.team.seahouse.domain.vo.HouseListVo;
import com.team.seahouse.commons.request.SearchQuery;
import com.team.seahouse.domain.vo.LandlordHouseListVo;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.mapper.HouseMapper;
import com.team.seahouse.mapper.UserInfoMapper;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.IRoomService;
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

    @Autowired
    private IRoomService roomService;

    @Override
    public void publish(House house) {

        //根据房东用户编号查询房东信息
        UserInfoVo landLoadInfo = userInfoMapper.findUserInfoByUserId(house.getLandlordId());

        //设置房东姓名
        house.setLandlordName(landLoadInfo.getRealName());
        //设置房东芝麻信用分
        house.setLandLardZhiMaScore(landLoadInfo.getZmScore());
        //设置审核状态默认为未审核
        house.setAuditState(AuditStatusEnum.UN_AUDIT.getStatus());
        //设置创建时间
        house.setCreateTime(new Date());
        //设置更新时间
        house.setUpdateTime(new Date());

        try {
            //保存房屋信息
            houseMapper.insert(house);
            //保存房屋信息完成后，设置之前添加的房间信息的房屋编号
            String ids = house.getRoomIds();
            if(StringUtils.isNotBlank(ids)) {
                Long houseId = house.getId();
                List<Long> roomIds = StringUtils.stringToArray(ids);
                roomService.setHouseId(houseId, roomIds);
            }
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(House house) {
        //设置更新时间
        house.setUpdateTime(new Date());
        try {
            houseMapper.updateByPrimaryKey(house);
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

    @Override
    public HouseDetailVo findByRoomId(Long roomId, Long userId) {
        HouseDetailVo house = null;
        if(userId != null) {
            house = houseMapper.findByRoomIdLogin(roomId, userId);
            //已经登录，添加浏览记录
            trackService.add(userId, roomId);
        } else {
            house = houseMapper.findByRoomId(roomId);
        }
        if(house == null) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
        return house;

    }

    @Override
    public PageResult<HouseListVo> search(SearchQuery searchQuery) {
        try {
            PageHelper.startPage(searchQuery.getPage(), searchQuery.getSize());
            PageHelper.orderBy(searchQuery.getSortColumn() + " " + searchQuery.getDirection());

            List<HouseListVo> houseList = houseMapper.search(searchQuery);
            PageResult<HouseListVo> result = new PageResult<>(houseList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public PageResult<HouseListVo> findByType(Integer type, PageQuery page) {

        try {
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序条件
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<HouseListVo> houseList = houseMapper.findHousesByType(type);
            PageResult<HouseListVo> result = new PageResult<>(houseList);
            return result;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public PageResult<HouseListVo> recommend(UserInfoVo userInfo, PageQuery page) {

        try {
            //设置分页信息
            PageHelper.startPage(page.getPage(), page.getSize());
            //设置排序条件
            PageHelper.orderBy(page.getSortColumn() + " " + page.getDirection());
            List<HouseListVo> houseList = houseMapper.findByUserInfo(userInfo);
            PageResult<HouseListVo> result = new PageResult<>(houseList);
            return result;
        } catch (BusinessException e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public int selectCountByLandlordId(Long userId) {
        House house = new House();
        house.setLandlordId(userId);
        house.setAuditState(AuditStatusEnum.AUDIT_PASS.getStatus());
        int count = houseMapper.selectCount(house);
        return count;
    }

    @Override
    public PageResult<LandlordHouseListVo> findLandlordHouseList(Long userId, PageQuery pageQuery) {
        try {
            //设置分页信息
            PageHelper.startPage(pageQuery.getPage(), pageQuery.getSize());
            //设置排序条件
            PageHelper.orderBy(pageQuery.getSortColumn() + " " + pageQuery.getDirection());
            List<LandlordHouseListVo> houseListVos = houseMapper.findLandlordHouseListByUserId(userId);
            PageResult<LandlordHouseListVo> result = new PageResult<>(houseListVos);
            return result;
        } catch (BusinessException e) {
            throw new BusinessException(e);
        }
    }
}
