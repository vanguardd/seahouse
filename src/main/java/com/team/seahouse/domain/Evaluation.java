package com.team.seahouse.domain;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
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
}