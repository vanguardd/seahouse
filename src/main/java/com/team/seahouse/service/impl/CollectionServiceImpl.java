package com.team.seahouse.service.impl;

import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.commons.response.CommonReturnCode;
import com.team.seahouse.domain.Collection;
import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseVo;
import com.team.seahouse.repository.CollectionRepository;
import com.team.seahouse.repository.HouseRepository;
import com.team.seahouse.service.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private CollectionRepository collectionRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public void add(Collection collection) {
        //设置创建时间
        collection.setCreateTime(new Date());
        try {
            collectionRepository.save(collection);
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<HouseVo> getMyCollections(Long userId, Pageable pageable) {
        List<House> houseList = new ArrayList<>();
        try {
            Page<HouseVo> housePages = houseRepository.findCollectedHouseByUserId(userId, pageable);
            return housePages;
        } catch (Exception e) {
            throw new BusinessException(CommonReturnCode.BAD_REQUEST);
        }
    }
}
