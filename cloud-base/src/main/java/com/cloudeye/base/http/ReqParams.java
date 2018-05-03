package com.cloudeye.base.http;

import java.util.List;

/**
 * Created by hp on 2017/10/31.
 */
public class ReqParams<T> {

    private int pageNum;
    private int pageSize=10;
    private T data;
    private List<String> headerEn;
    /**
     * 登录用户ID
     */
    private Integer empId;
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getHeaderEn() {
        return headerEn;
    }

    public void setHeaderEn(List<String> headerEn) {
        this.headerEn = headerEn;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
