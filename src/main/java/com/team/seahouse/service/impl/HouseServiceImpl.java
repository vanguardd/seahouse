package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.StatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.UserInfo;
import com.team.seahouse.domain.vo.QueryVo;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.repository.HouseRepository;
import com.team.seahouse.repository.UserInfoRepository;
import com.team.seahouse.repository.UserRepository;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    private HouseRepository houseRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void publish(House house) {
        //根据房东用户编号查询房东信息
        UserInfoVo landLoadInfo = userInfoRepository.findUserInfoByUserId(house.getLandlordId());

        //设置房东姓名
        house.setLandlordName(landLoadInfo.getRealName());
        //设置房东芝麻信用分
        house.setLandLoardZhiMaScore(landLoadInfo.getZmScore());
        //设置审核状态默认为未审核
        house.setState(StatusEnum.UN_AUDIT.getStatus());
        //设置创建时间
        house.setCreateTime(new Date());
        //设置更新时间
        house.setUpdateTime(new Date());
        try {
            houseRepository.save(house);
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
            houseRepository.save(house);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public House findByHouseId(Long houseId) {
        try {
            House house = houseRepository.findByHouseId(houseId);
            return house;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }

    }

    @Override
    public List<House> search(QueryVo queryVo, Pageable pageable) {

        List<House> houseList = null;
        try {
            Page<House> housePage = houseRepository.findAll(new Specification<House>() {
                @Override
                public Predicate toPredicate(Root<House> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    List<Predicate> list = new ArrayList<>();

                    //添加关键字搜索
                    if(StringUtils.isNotBlank(queryVo.getKeyWord())) {
                        list.add(cb.like(root.get("title").as(String.class), "%" + queryVo.getKeyWord() + "%"));
                        list.add(cb.like(root.get("firstAddress").as(String.class), "%" + queryVo.getKeyWord() + "%"));
                    }

                    //添加价格区间筛选
                    if(queryVo.getMinPrice() != null && queryVo.getMaxPrice() != null) {
                        list.add(cb.between(root.get("price").as(BigDecimal.class), queryVo.getMinPrice(), queryVo.getMaxPrice()));
                    }

                    //添加房屋类型筛选
                    if(queryVo.getType() != null) {
                        list.add(cb.equal(root.get("type").as(Integer.class), queryVo.getType()));
                    }

                    //添加房屋标签筛选
                    if(StringUtils.isNotBlank(queryVo.getTags())) {
                        String[] tags = queryVo.getTags().split(";");
                        for(String tag : tags) {
                            list.add(cb.like(root.get("tags").as(String.class), tag));
                        }
                    }

                    //添加房屋朝向筛选
                    if(StringUtils.isNotBlank(queryVo.getExposition())) {
                        list.add(cb.equal(root.get("exposition").as(String.class), queryVo.getExposition()));
                    }

                    //添加房屋状态为已审核
                    list.add(cb.equal(root.get("state").as(Integer.class), StatusEnum.AUDIT_PASS));

                    Predicate[] p = new Predicate[list.size()];
                    return cb.and(list.toArray(p));

                }
            }, pageable);

            //遍历获取的Page对象，将数据添加到List集合中
            for(House house : housePage) {
                houseList.add(house);
            }
            return houseList;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<House> findByType(Integer type, Pageable pageable) {

        List<House> houseList = null;
        try {
            Page<House> housePage = houseRepository.findHousesByType(type, pageable);
            for(House house : housePage) {
                houseList.add(house);
            }
            return houseList;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }
}
