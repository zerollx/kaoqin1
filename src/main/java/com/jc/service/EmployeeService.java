package com.jc.service;

import com.jc.entity.Employee;
import com.jc.entity.EmployeePageBean;

import java.util.ArrayList;

public interface EmployeeService {

    /**
     * 查询全部
     */
    public EmployeePageBean<Employee> findAll ( ArrayList<Integer> ids, Integer currentPage, Integer pageSize, String username );

    /**
     * 查询全部ID
     */

    public ArrayList<Integer> findIds ();

    /**
     * 查询全部条数
     */

    public Integer getCount ( String username );

    /**
     * 根据Id查询信息，显示全部
     */

    public Employee listByIdAll ( Integer id );

    /**
     * 添加
     */
    public boolean employeeAdd ( Employee employee );

    /**
     * 删除
     */
    public boolean EmployeeDelete ( Integer id );

    /**
     * 多删除
     */
    public  boolean deleteAll ( Integer ids[] );

    /**
     * 修改
     */
    public boolean update( Employee employee );
    public Employee findById ( Integer id );

    /**
     * 查询全部name
     */
    public  ArrayList<String>  allName ();
}
