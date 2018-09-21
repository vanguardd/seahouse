package com.team.seahouse.service;

import com.team.seahouse.domain.Room;

import java.util.List;

/**
 * @Title: 房屋业务接口
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/07
 */
public interface IRoomService {

    /**
     * 保存房间信息
     * @param room
     * @return
     */
    Room save(Room room);

    /**
     * 根据房间编号设置房间的房屋编号
     * @param houseId 更新值
     * @param roomIds 需要更新的房间信息的Id
     */
    void setHouseId(Long houseId, List<Long> roomIds);

    /**
     * 根据房东编号查询房间个数
     * @param userId
     * @return
     */
    int selectCountByLandlordId(Long userId);

    /**
     * 根据房间编号做下架操作
     * @param roomId
     */
    void unShelve(Long roomId);
}
