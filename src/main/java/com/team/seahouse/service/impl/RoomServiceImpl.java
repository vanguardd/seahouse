package com.team.seahouse.service.impl;

import com.team.seahouse.commons.enums.RoomStatusEnum;
import com.team.seahouse.commons.exception.BusinessException;
import com.team.seahouse.domain.Room;
import com.team.seahouse.mapper.RoomMapper;
import com.team.seahouse.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Title: 房间业务实现类
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room save(Room room) {
        room.setState(RoomStatusEnum.NORMAL.getStatus());
        room.setCreateTime(new Date());
        room.setUpdateTime(new Date());
        try {
            roomMapper.insert(room);
        } catch (BusinessException e) {
            throw new BusinessException(e);
        }
        return room;
    }

    @Override
    public void setHouseId(Long houseId, List<Long> roomIds) {
        for(Long roomId: roomIds) {
            roomMapper.setHouseId(houseId, roomId);
        }
    }

    @Override
    public int selectCountByLandlordId(Long userId) {
        int roomCount = roomMapper.selectCountByLandlordId(userId).intValue();
        return roomCount;
    }

    @Override
    public void unShelve(Long roomId) {
        Room room = new Room();
        room.setId(roomId);
        room.setState(RoomStatusEnum.OFF_SHELVE.getStatus());
        try {
            roomMapper.updateByPrimaryKeySelective(room);
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }
}
