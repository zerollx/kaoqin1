package com.jc.service.Impl;

import com.jc.entity.Salary;
import com.jc.entity.SalaryPageBean;
import com.jc.mapper.SalaryMapper;
import com.jc.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper mapper;

    @Override
    public SalaryPageBean<Salary> listAll ( Integer currentPage, Integer pageSize, String username ) {
        SalaryPageBean<Salary> SalaryPageBean = new SalaryPageBean ();
        //1.封装总条数
        SalaryPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        SalaryPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        SalaryPageBean.setList ( mapper.listAll ( (currentPage - 1) * pageSize, pageSize, username ) );
        return SalaryPageBean;
    }

    @Override
    public boolean add ( Salary salary ) {
        return mapper.add ( salary );
    }

    @Override
    public boolean delete ( Integer id ) {
        return mapper.delete ( id );
    }
}
