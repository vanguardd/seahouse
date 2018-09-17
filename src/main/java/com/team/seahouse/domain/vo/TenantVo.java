package com.team.seahouse.domain.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Title: 房客视图层对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/09/17
 */
@Getter@Setter
public class TenantVo {
    private String houseId;

    private String houseName;

    private List<Tenant> tenants;

}

@Getter@Setter
class Tenant {

    private Long roomId;

    private String avatar;

    private String realName;

    private String roomName;

    private Integer sex;

    private String mobilePhone;

    private Date signTime;

    private String payDate;
}
