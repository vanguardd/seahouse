package com.team.seahouse.repository;

import com.team.seahouse.domain.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.method.P;

import java.math.BigDecimal;
import java.util.List;

/**
 * @title 房屋模块
 * @describe
 * @author vanguard
 * @version 1.0
 * @date 18/7/18
 */
public interface HouseRepository extends JpaRepository<House, Long>, JpaSpecificationExecutor<House> {

    public String collectSql = "select h.houseId, h.title, h.roomImages, h.firstAddress, h.rent, h.rentWay, h.housePattern," +
            "h.payWay, h.address, h.addressCoordinate, h.tags, h.disposition, h.roomArea, h.exposition, h.introduce," +
            "h.houseKeeperId, h.landlordId, h.landlordName from House h, Collection c where h.houseId=c.houseId";

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
    Page<House> findByHouseIdIn(List<Long> houseIds, Pageable pageable);

    /**
     * 根据用户编号查询收藏的房屋列表
     * @param userId
     * @param pageable
     * @return
     */
    @Query(collectSql + " and c.userId=?1")
    Page<House> findCollectedHouseByUserId(Long userId, Pageable pageable);


    /**
     * 根据类型查询房屋信息
     * @param type
     * @param pageable
     * @return
     */
    Page<House> findHousesByType(Integer type, Pageable pageable);

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
    Page<House> findByUserInfo(Integer zmCode, Pageable pageable);
}
