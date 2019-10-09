package com.jc.mapper;

import com.jc.entity.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface SalaryMapper {
    public ArrayList<Salary> listAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public boolean add ( Salary salary );

    public boolean delete ( Integer id );
}
