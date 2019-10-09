package com.jc.service;

import com.jc.entity.CheckAll;
import com.jc.entity.CheckAllPageBean;

public interface CheckAllService {

    public CheckAllPageBean<CheckAll> listAll ( Integer currentPage, Integer pageSize, String username );


    public boolean Add ( CheckAll CheckAll );

}
