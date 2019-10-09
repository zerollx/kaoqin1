package com.jc.service.Impl;

import com.jc.entity.CheckReport;
import com.jc.entity.CheckReportPageBean;
import com.jc.mapper.CheckReportMapper;
import com.jc.service.CheckReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckReportServiceImpl implements CheckReportService {
    @Autowired
    private CheckReportMapper mapper;

    @Override
    public CheckReportPageBean<CheckReport> listAll ( Integer currentPage, Integer pageSize, String username ) {
        CheckReportPageBean<CheckReport> CheckReportPageBean = new CheckReportPageBean ();
        //1.封装总条数
        CheckReportPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        CheckReportPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        CheckReportPageBean.setList ( mapper.listAll ( (currentPage - 1) * pageSize, pageSize, username ) );
        return CheckReportPageBean;
    }

    @Override
    public boolean mAdd ( CheckReport checkReport ) {
        return mapper.mAdd ( checkReport );
    }

//    @Override
//    public boolean aAdd ( CheckReport checkReport ) {
//        return mapper.aAdd ( checkReport );
//    }
//
//    @Override
//    public CheckReport findByIds ( String name, Integer situation ) {
//        return mapper.findByIds ( name, situation );
//    }
}
