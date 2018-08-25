package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.StatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.commons.utils.StringUtils;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseDetailVo;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.domain.vo.QueryVo;
import com.team.seahouse.domain.vo.UserInfoVo;
import com.team.seahouse.repository.HouseRepository;
import com.team.seahouse.repository.UserInfoRepository;
import com.team.seahouse.repository.UserRepository;
import com.team.seahouse.service.IHouseService;
import com.team.seahouse.service.IRedisService;
import com.team.seahouse.service.IUserService;
import org.hibernate.Metamodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
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

        //设置标题
        house.setTitle(house.getHouseName() + " " + house.getRoomName());

        //根据房东用户编号查询房东信息
        UserInfoVo landLoadInfo = userInfoRepository.findUserInfoByUserId(house.getLandlordId());

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
        House house = houseRepository.findByHouseId(houseId);
        if(house == null) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
        return house;

    }

    @Override
    public Page<HouseVo> search(QueryVo queryVo, Pageable pageable) {

        try {
            Page<HouseVo> housePage = houseRepository.findAll( (Specification<HouseVo>) (root, criteriaQuery, cb) -> {

                List<Predicate> list = new ArrayList<>();

                //添加关键字搜索
                if(StringUtils.isNotBlank(queryVo.getKeyWord())) {
                    list.add(cb.like(root.get("address").as(String.class), "%" + queryVo.getKeyWord() + "%"));
                }

                //添加价格区间筛选
                if(queryVo.getMinPrice() != null && queryVo.getMaxPrice() != null) {
                    if(queryVo.getMaxPrice().equals(0)) {
                        list.add(cb.gt(root.get("minPrice").as(BigDecimal.class), queryVo.getMinPrice()));
                    }
                    list.add(cb.between(root.get("rent").as(BigDecimal.class), queryVo.getMinPrice(), queryVo.getMaxPrice()));
                }

                //添加房屋类型筛选
                if(queryVo.getType() != null) {
                    list.add(cb.equal(root.get("type").as(Integer.class), queryVo.getType()));
                }

                //添加房屋标签筛选
                if(StringUtils.isNotBlank(queryVo.getLabel())) {
                    String[] tags = queryVo.getLabel().split(";");
                    for(String tag : tags) {
                        list.add(cb.like(root.get("labels").as(String.class), tag));
                    }
                }

                //添加房屋朝向筛选
                if(StringUtils.isNotBlank(queryVo.getExposition())) {
                    list.add(cb.equal(root.get("exposition").as(String.class), queryVo.getExposition()));
                }

                //添加房屋状态为已审核
                list.add(cb.equal(root.get("state").as(Integer.class), StatusEnum.AUDIT_PASS.getStatus()));

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }, pageable);
            return housePage;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<HouseVo> findByType(Integer type, Pageable pageable) {

        List<HouseVo> houseList = null;
        try {
            Page<HouseVo> housePage = houseRepository.findHousesByType(type, pageable);
            return housePage;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<HouseVo> recommend(UserInfoVo userInfo, Pageable pageable) {
        //获得用户的芝麻信用分
        Integer zmCode = userInfo.getZmScore();
        //获得用户的公司地址
        String companyAddress = userInfo.getCompanyAddress();
        //获得用户的性别
        Integer sex = userInfo.getSex();
        //获得用户的出生年月
        Date bornDate = userInfo.getBornDate();
        try {
            Page<HouseVo> housePage = houseRepository.findByUserInfo(zmCode, pageable);
            return housePage;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }
}
