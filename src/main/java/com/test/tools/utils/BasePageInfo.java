package com.test.tools.utils;

import java.io.Serializable;

/**
 * 前端分页所传的参数信息
 *
 * @author Administrator
 */
public class BasePageInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 每页条数
     */
    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BasePageInfo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
