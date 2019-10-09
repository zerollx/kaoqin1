package com.jc.service;

import com.jc.entity.CheckAll;
import com.jc.entity.CheckReport;
import com.jc.entity.CheckReportPageBean;

public interface CheckReportService {

    public CheckReportPageBean<CheckReport> listAll ( Integer currentPage, Integer pageSize, String username );

    public boolean mAdd ( CheckReport checkReport );

//    public boolean aAdd ( CheckReport checkReport );
//
//    public CheckReport findByIds( String name , Integer situation);

}
