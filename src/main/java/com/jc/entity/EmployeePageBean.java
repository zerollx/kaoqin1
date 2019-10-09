package com.jc.entity;

import java.util.ArrayList;

public class EmployeePageBean<T> {
    private Integer pageSize;
    private Integer pageCount;
    private Integer countTotal;
    private Integer currentPage;
    private String empName;
    private ArrayList<T> list;

    public String getUserName () {
        return empName;
    }

    public void setUserName ( String userName ) {
        this.empName = userName;
    }

    public Integer getPageSize () {
        return pageSize;
    }

    public void setPageSize ( Integer pageSize ) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount () {
        return pageCount;
    }

    public void setPageCount ( Integer pageCount ) {
        this.pageCount = pageCount;
    }

    public Integer getCountTotal () {
        return countTotal;
    }

    public void setCountTotal ( Integer countTotal ) {
        this.countTotal = countTotal;
    }

    public Integer getCurrentPage () {
        return currentPage;
    }

    public void setCurrentPage ( Integer currentPage ) {
        this.currentPage = currentPage;
    }

    public ArrayList<T> getList () {
        return list;
    }

    public void setList ( ArrayList<T> list ) {
        this.list = list;
    }

    public EmployeePageBean ( Integer pageSize, Integer pageCount, Integer countTotal, Integer currentPage, ArrayList<T> list ) {
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.countTotal = countTotal;
        this.currentPage = currentPage;
        this.list = list;
    }

    public EmployeePageBean () {
    }

}
