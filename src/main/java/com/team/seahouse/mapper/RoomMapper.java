package com.team.seahouse.mapper;

import com.team.seahouse.commons.base.BaseMapper;
import com.team.seahouse.domain.Room;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Title: 房间模块
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/9/7
 */
public interface RoomMapper extends BaseMapper<Room> {

    /**
     * 设置房屋编号
     * @param houseId
     * @param roomId
     */
    @Select("UPDATE tb_room SET house_id=#{houseId} WHERE id=#{roomId}")
    void setHouseId(@Param("houseId") Long houseId, @Param("roomId") Long roomId);

    /**
     * 根据房东编号查询房间个数
     * @param userId
     * @return
     */
    Long selectCountByLandlordId(Long userId);
}