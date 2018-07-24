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

    public String collectSql = "select h.houseId, h.title, h.images, h.firstAddress, h.price, h.rentWay, h.housePattern," +
            "h.payWay, h.address, h.addressCoordinate, h.tags, h.disposition, h.area, h.exposition, h.introduce," +
            "h.houseKeeperId, h.landlordId, h.landlordName from House h, Collection c where h.houseId=c.houseId";

    public String baseSql = "select h.houseId, h.title, h.images, h.firstAddress, h.price, h.rentWay, h.housePattern, payWay," +
            "h.address, h.addressCoordinate, h.tags, h.disposition, h.area, h.exposition, h.introduce, h.landlordId, h.landlordName" +
            "from House h, User u where h.landlordId=u.userId and h.state='1'";
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
     * 根据关键字模糊搜索房屋信息
     * @param keyword
     * @param pageable
     * @return
     */
    @Query(baseSql + " and h.firstAddress like ?1 and h.title like ?1")
    Page<House> searchByKeyWord(String keyword, Pageable pageable);

    /**
     * 根据关键字和价格区间搜索房屋信息
     * @param keyWord 关键字
     * @param minPrice 最低价格
     * @param maxPrice 最高价格
     * @param pageable
     * @return
     */
    @Query(baseSql + " and h.firstAddress like ?1 and h.title like ?1 and h.price between ?2 and ?3")
    Page<House> searchByKeyWordAndPriceBetween(String keyWord, BigDecimal minPrice, BigDecimal maxPrice,
                                               Pageable pageable);

    /**
     * 根据关键字、价格区间和房屋类型所搜房屋信息
     * @param keyWord
     * @param minPrice
     * @param maxPrice
     * @param type
     * @param pageable
     * @return
     */
    @Query(baseSql + " and h.firstAddress like ?1 and h.title like ?1 and type=?4 and h.price between ?2 and ?3")
    Page<House> searchByKeyWordAndPriceBetweenAndType(String keyWord, BigDecimal minPrice,
                                                      BigDecimal maxPrice, Integer type, Pageable pageable);



    /**
     * 根据类型查询房屋信息
     * @param type
     * @param pageable
     * @return
     */
    Page<House> findHousesByType(Integer type, Pageable pageable);
}
