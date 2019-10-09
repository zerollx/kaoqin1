package com.jc.mapper;

import com.jc.entity.CheckAll;
import com.jc.entity.CheckReport;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface CheckReportMapper {
    public ArrayList<CheckReport> listAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public boolean mAdd ( CheckReport checkReport );

}
