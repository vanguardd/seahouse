package com.team.seahouse.domain.vo;

import com.alibaba.fastjson.JSON;
import com.team.seahouse.commons.base.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Title: 封装的分页对象
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/26
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class Pages extends BaseDomain {

    /**
     * 第几页
     */
    private int page;

    /**
     * 每页显示几条内容
     */
    private int size;

    /**
     * 排序字段
     */
    private String sortColumn;

    /**
     * 排序方式
     */
    private String direction;

    @Override
    public String toString() {
        return JSON.toJSONString(this, true);
    }

}
