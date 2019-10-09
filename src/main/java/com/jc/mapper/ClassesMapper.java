package com.jc.mapper;

import com.jc.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ClassesMapper {


    public ArrayList<Classes> findAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public boolean Add ( Classes classes );

    public boolean delete ( Integer id );

    public Classes findById ( Integer id );

    public boolean update( Classes classes );

    public  boolean deleteAll ( Integer ids[] );
}
