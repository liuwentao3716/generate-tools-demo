package com.test.tools.utils;

import java.util.List;

/**
 * 前端需要的分页信息
 *
 * @author Administrator
 */
public class PageList<T> {

    /**
     * 总记录数
     */
    private long total;

    /**
     * 数据
     */
    private List<T> data;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
