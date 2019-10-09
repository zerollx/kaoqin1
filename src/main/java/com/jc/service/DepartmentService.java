package com.jc.service;

import com.jc.entity.Department;
import com.jc.entity.DepartmentPageBean;

import java.util.ArrayList;


public interface DepartmentService {

    public DepartmentPageBean<Department> listAll ( Integer currentPage, Integer pageSize, String username );

    public boolean add ( Department department );

    public boolean delete ( Integer id );

    public boolean deleteAll ( Integer ids[] );

    public Department findById ( Integer id );

    public boolean update( Department department );

    public ArrayList<Department> findAll ();
}
