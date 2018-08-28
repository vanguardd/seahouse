package com.team.seahouse.commons.support.page;

import com.alibaba.fastjson.JSON;
import com.team.seahouse.commons.base.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
public class PageQuery implements Serializable {

    protected static final long serialVersionUID = 1L;

    /**
     * 第几页
     */
    private Integer page = 1;

    /**
     * 每页显示几条内容
     */
    private Integer size = 10;

    /**
     * 排序字段
     */
    private String sortColumn = "create_time";

    /**
     * 排序方式
     */
    private String direction = "DESC";

    @Override
    public String toString() {
        return JSON.toJSONString(this, true);
    }



}
