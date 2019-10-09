package com.jc.service.Impl;

import com.jc.mapper.EmployeeMapper;
import com.jc.entity.Employee;
import com.jc.entity.EmployeePageBean;
import com.jc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;

    /**
     * 分页查询全部
     */

    @Override
    public EmployeePageBean<Employee> findAll ( ArrayList<Integer> ids, Integer currentPage, Integer pageSize, String username ) {
        EmployeePageBean<Employee> EmployeePageBean = new EmployeePageBean ();
        //1.封装总条数
        EmployeePageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        EmployeePageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        EmployeePageBean.setList ( mapper.findAll ( ids, (currentPage - 1) * pageSize, pageSize, username ) );
        return EmployeePageBean;
    }

    @Override
    public ArrayList<Integer> findIds () {
        ArrayList<Integer> ids = new ArrayList<> ();
        return ids;
    }

    @Override
    public Integer getCount ( String username ) {
        return mapper.getCount ( username );
    }

    @Override
    public Employee listByIdAll ( Integer id ) {
        return mapper.listByIdAll ( id );
    }

    @Override
    public boolean employeeAdd ( Employee employee ) {
        return mapper.employeeAdd ( employee );
    }

    @Override
    public boolean EmployeeDelete ( Integer id ) {
        return mapper.employeeDelete ( id );
    }

    @Override
    public boolean deleteAll ( Integer ids[] ) {

        return mapper.deleteAll ( ids );
    }

    @Override
    public boolean update ( Employee employee ) {
        return mapper.update ( employee );
    }
    @Override
    public Employee findById ( Integer id ) {
        return mapper.findById ( id );
    }
    @Override
    public ArrayList<String> allName () {
        return mapper.allName ();
    }
}
