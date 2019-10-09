package com.jc.mapper;

import com.jc.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface DepartmentMapper {

    public ArrayList<Department> listAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public boolean add ( Department department );

    public boolean delete ( Integer id );

    public boolean deleteAll ( Integer ids[] );

    public Department findById ( Integer id );

    public boolean update( Department department );

    public ArrayList<Department> findAll ();


}
