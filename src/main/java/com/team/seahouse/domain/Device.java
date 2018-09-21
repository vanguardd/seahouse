package com.team.seahouse.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @title 设备模块
 * @describe
 * @author henmeiwei
 * @version 1.0
 * @date 16/7/18
 */
@Getter@Setter
@Table(name = "tb_device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 设备唯一标识
     */
    @Column(name = "client_id")
    private String clientId;

    /**
     * 设备型号
     */
    private String model;

    /**
     * 生产厂家
     */
    private String vendor;

    /**
     * 设备出厂标识
     */
    private String uuid;

    /**
     * 分辨率宽
     */
    @Column(name = "screen_width")
    private String screenWidth;

    /**
     * 分辨率高
     */
    @Column(name = "screen_height")
    private String screenHeight;

    /**
     * 操作系统名称
     */
    @Column(name = "os_name")
    private String osName;

    /**
     * 操作系统版本
     */
    @Column(name = "os_version")
    private String osVersion;

    /**
     * 系统语言
     */
    @Column(name = "os_language")
    private String osLanguage;

    /**
     * 操作系统厂商
     */
    @Column(name = "os_vendor")
    private String osVendor;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态
     */
    private String state;


}