package com.team.seahouse.commons.support.page;

import com.github.pagehelper.PageInfo;
import com.team.seahouse.commons.base.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/08/27
 */
@Getter@Setter
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    protected static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 第几页
     */
    private int page;

    /**
     * 每页显示几条内容
     */
    private int size;

    /**
     * 当前分页的内容
     */
    private List<T> content;

    public PageResult(PageInfo<T> pageInfo) {
        this.content = pageInfo.getList();
        this.total = pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
        this.page = pageInfo.getPageNum();
        this.size = pageInfo.getPageSize();
    }

    public PageResult(List<T> list) {
        this(new PageInfo<>(list));
    }

}
