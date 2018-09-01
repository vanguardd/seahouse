package com.team.seahouse.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_evaluation")
public class Evaluation {
    /**
     * 评价编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 评价人
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 评价人昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 房屋编号
     */
    @Column(name = "house_id")
    private Integer houseId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取评价编号
     *
     * @return id - 评价编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评价编号
     *
     * @param id 评价编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取评价内容
     *
     * @return content - 评价内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评价内容
     *
     * @param content 评价内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取评价人
     *
     * @return user_id - 评价人
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置评价人
     *
     * @param userId 评价人
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取评价人昵称
     *
     * @return user_name - 评价人昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置评价人昵称
     *
     * @param userName 评价人昵称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取房屋编号
     *
     * @return house_id - 房屋编号
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * 设置房屋编号
     *
     * @param houseId 房屋编号
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}