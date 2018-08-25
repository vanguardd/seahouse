package com.team.seahouse.repository;

import com.team.seahouse.domain.House;
import com.team.seahouse.domain.vo.HouseDetailVo;
import com.team.seahouse.domain.vo.HouseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.method.P;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @title 房屋模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface HouseRepository extends JpaRepository<House, Long>, JpaSpecificationExecutor<HouseVo> {

    public String listSql = "select h.houseId, h.title, h.roomImage, h.rent, h.rentWay, h.housePattern," +
            "h.payWay, h.address, h.addressCoordinate, h.roomArea, h.exposition," +
            "h.houseKeeperId, h.landlordId, h.landlordName from House h, Collection c where h.houseId=c.houseId";

    public String detailSql = "select h.houseId as houseId, h.title as title, h.houseName as houseName, h.livingRoom as livingRoom, " +
            "h.livingRoomImages as livingRoomImages, h.bathRoom as bathRoom, h.bathRoomImages as bathRoomImages, " +
            "h.kitchen as kitchen, h.kitchenImages as kitchenImages, h.balcony as balcony, h.balconyImages as balconyImages, " +
            "h.propertyValue as propertyValue, h.propertyPayType as propertyPayType, h.waterValue as waterValue, h.waterPayType as waterPayType, " +
            "h.electricValue as electricValue, h.electricPayType as electricPayType, h.heatingValue as heatingValue, h.heatingPayType as heatingPayType, " +
            "h.customName as customName, h.customValue as customValue, h.customPayType as customPayType, h.floor as floor, " +
            "h.isHasElevator as isHasElevator, h.fixtures as fixtures, h.housePattern as housePattern, h.roomName as roomName, h.roomArea as roomArea, " +
            "h.roomFacilities as roomFacilities, h.roomImage as roomImage, h.roomImages as roomImages, h.exposition as exposition, " +
            "h.rent as rent, h.rentWay as rentWay, h.payWay as payWay, h.labels as labels, h.introduction as introduction, h.address as address, " +
            "h.addressCoordinate as addressCoordinate, h.firstAddress as firstAddress, h.plotName as plotName, h.greenArea as greenArea, " +
            "h.heatingWay as heatingWay, h.parking as parking, h.property as property, h.years as years, h.villageIntroduction as villageIntroduction, " +
            "h.rentRule as rentRule, h.exitRentRule as exitRentRule, h.type as type, h.landlordId as landlordId, h.landLardZhiMaScore as landLardZhiMaScore, " +
            "u.realName as landlordName, u.mobilePhone as landLardMobilePhone, u.createDate as landLardCreateDate " +
            "from House h, UserInfo u " +
            "where h.landlordId = u.userId";

    /**
     * 根据房屋编号查询房屋信息
     * @param houseId
     * @return
     */
    House findByHouseId(Long houseId);

    /**
     * 根据房屋编号查询出租房屋信息列表
     * @param houseIds
     * @param pageable
     * @return
     */
    Page<HouseVo> findByHouseIdIn(Set<Long> houseIds, Pageable pageable);

    /**
     * 根据用户编号查询收藏的房屋列表
     * @param userId
     * @param pageable
     * @return
     */
    @Query(listSql + " and c.userId=?1")
    Page<HouseVo> findCollectedHouseByUserId(Long userId, Pageable pageable);


    /**
     * 根据类型查询房屋信息
     * @param type
     * @param pageable
     * @return
     */
    Page<HouseVo> findHousesByType(Integer type, Pageable pageable);

    /**
     * 根据用户信息推荐房屋信息
     * @param zmCode
     * @param pageable
     * @return
     */
    @Query(value = "select h.* from tb_house h \n" +
            "\tleft join tb_user_info u \n" +
            "\ton h.landLord_id=u.user_id  \n" +
            "         where u.zmCode = ?1 ORDER BY ?#{#pageable}",
          countQuery = "select count(*) from tb_house h \n" +
                  "\tleft join tb_user_info u \n" +
                  "\ton h.landLord_id=u.user_id  \n" +
                  "         where u.zmCode = :zmcode",
          nativeQuery = true)
    Page<HouseVo> findByUserInfo(Integer zmCode, Pageable pageable);
}
