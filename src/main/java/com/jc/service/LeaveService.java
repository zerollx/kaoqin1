package com.jc.service;


import com.jc.entity.Leave;
import com.jc.entity.LeavePageBean;

public interface LeaveService {

    public LeavePageBean<Leave> findAll ( Integer currentPage, Integer pageSize, String username );
    public boolean add( Leave leave );

    public boolean update ( Leave leave );
    public Leave findById ( Integer id );

}
