package com.jc.service.Impl;

import com.jc.mapper.DepartmentMapper;
import com.jc.entity.Department;
import com.jc.entity.DepartmentPageBean;
import com.jc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper mapper;
    @Override
    public DepartmentPageBean<Department> listAll ( Integer currentPage, Integer pageSize, String username ) {
      DepartmentPageBean<Department> DepartmentPageBean = new DepartmentPageBean ();
        //1.封装总条数
        DepartmentPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        DepartmentPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        DepartmentPageBean.setList ( mapper.listAll  ( (currentPage - 1) * pageSize, pageSize, username ) );
        return DepartmentPageBean;
    }

    @Override
    public boolean add ( Department department ) {
        return mapper.add ( department );
    }

    @Override
    public boolean delete ( Integer id ) {
        return  mapper.delete ( id );
    }

    @Override
    public boolean deleteAll ( Integer[] ids ) {
        return mapper.deleteAll ( ids );
    }

    @Override
    public Department findById ( Integer id ) {
        return  mapper.findById ( id );
    }

    @Override
    public boolean update ( Department department ) {
        return mapper.update ( department );
    }

    @Override
    public ArrayList<Department> findAll () {
        return mapper.findAll ();
    }
}
