package com.lzb.model;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/8/28.
 */
public class page implements Serializable {

    private static final long serialVersionUID = 771391397688870234L;

    private int pageSize; // 每页显示记录数

    private int pageNumber; // 当前页

    private String sortName; // 排序字段

    private String sortOrder; // asc/desc

    private int offset;

    private long total;

    public page() {
        this.pageSize = 0;
        this.pageNumber = 0;
        this.offset = -1;
        this.total = 0;
    }

    public page(int page, int rows) {
        setPageSize(rows);
        setPageNumber(page);
        this.offset = -1;
        this.total = 0;
    }

    public void setPageSize(int rows) {
        this.pageSize = rows;
        this.offset = this.pageSize * (this.pageNumber - 1);
    }

    public int getPageSize() {return pageSize < 0 ? 0 : pageSize;}

    public void setPageNumber(int page) {
        this.pageNumber = page;
    }

    public int getPageNumber() {
        return pageNumber < 0 ? 0 : pageNumber;
    }

    public int getOffset() {
        return offset < 0 ? 0 : offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public long getTotal() {
        return total < 0 ? 0 : total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

}
