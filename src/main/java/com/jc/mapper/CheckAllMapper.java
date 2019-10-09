package com.jc.mapper;

import com.jc.entity.CheckAll;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface CheckAllMapper {
    public ArrayList<CheckAll> listAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );


    public boolean checkAdd ( CheckAll checkAll );

}
