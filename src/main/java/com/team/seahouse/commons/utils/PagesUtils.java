package com.team.seahouse.commons.utils;

import com.team.seahouse.domain.vo.Pages;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @Title:
 * @Description:
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 2018/07/26
 */
public class PagesUtils {

    /**
     * 分页大小
     */
    private final static Integer SIZE = 15;

    /**
     * 默认页数 0开头
     */
    private final static Integer PAGE = 0;

    /**
     * 默认排序字段
     */
    private final static String SORT = "createTime";

    /**
     * 创建Pageable对象
     * @param pages
     * @return
     */
    public static Pageable createPageRequest(Pages pages) {
        return PageRequest.of(pages.getPage() <= 0 ? PAGE : pages.getPage(),
                pages.getSize() <= 0 ? SIZE:pages.getSize(),
                new Sort(StringUtils.isNotBlank(pages.getDirection()) && pages.getDirection().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                        StringUtils.isBlank(pages.getSortColumn()) ? SORT: pages.getSortColumn()));
    }



}
