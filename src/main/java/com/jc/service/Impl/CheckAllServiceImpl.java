package com.jc.service.Impl;

import com.jc.entity.CheckAll;
import com.jc.entity.CheckAllPageBean;
import com.jc.mapper.CheckAllMapper;
import com.jc.service.CheckAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckAllServiceImpl implements CheckAllService {
    @Autowired
    private CheckAllMapper mapper;

    @Override
    public CheckAllPageBean<CheckAll> listAll ( Integer currentPage, Integer pageSize, String username ) {
        CheckAllPageBean<CheckAll> CheckAllPageBean = new CheckAllPageBean ();
        //1.封装总条数
        CheckAllPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        CheckAllPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        CheckAllPageBean.setList ( mapper.listAll ( (currentPage - 1) * pageSize, pageSize, username ) );
        return CheckAllPageBean;
    }


    @Override
    public boolean Add ( CheckAll CheckAll ) {
        return mapper.checkAdd (CheckAll  );
    }


}
