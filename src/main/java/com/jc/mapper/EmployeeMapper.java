package com.jc.mapper;

import com.jc.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface EmployeeMapper {
    /**
     * 查询全部
     */
    public ArrayList<Employee> findAll ( @Param("ids") ArrayList<Integer> ids, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    /**
     * 查询全部ID
     */
    public ArrayList<Integer> findIds ();

    /**
     * 查询总条数
     *
     * @return
     */
    public Integer getCount ( @Param("username") String username );

    /**
     * 查询全部信息
     */
    public Employee listByIdAll ( Integer id );

    /**
     * 添加
     */

    public boolean employeeAdd ( Employee employee );

    /**
     * 删除
     */
    public boolean employeeDelete ( Integer id );

    /**
     * 多删除
     */

    public  boolean deleteAll ( Integer ids[] );

    /**
     * 修改
     */
    public boolean update ( Employee employee );

    public Employee findById ( Integer id );

    /**
     * 查询全部
     */

    public ArrayList<String> allName ();
}
