package com.jc.service.Impl;

import com.jc.entity.Leave;
import com.jc.entity.LeavePageBean;
import com.jc.mapper.LeaveMapper;
import com.jc.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper mapper;

    @Override
    public LeavePageBean<Leave> findAll ( Integer currentPage, Integer pageSize, String username ) {
        LeavePageBean<Leave> LeavePageBean = new LeavePageBean ();
        //1.封装总条数
        LeavePageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        LeavePageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        LeavePageBean.setList ( mapper.findAll ( (currentPage - 1) * pageSize, pageSize, username ) );
        return LeavePageBean;
    }

    @Override
    public boolean add ( Leave leave ) {
        return mapper.add ( leave );
    }


    @Override
    public boolean update ( Leave leave ) {
        return mapper.update ( leave );
    }

    @Override
    public Leave findById ( Integer id ) {
        return mapper.findById ( id );
    }
}
