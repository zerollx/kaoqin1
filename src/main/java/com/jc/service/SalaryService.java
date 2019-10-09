package com.jc.service;

import com.jc.entity.Salary;
import com.jc.entity.SalaryPageBean;

public interface SalaryService {

    public SalaryPageBean<Salary> listAll ( Integer currentPage, Integer pageSize, String username );

//    public boolean add ( RepairCard repairCard );

    public boolean add ( Salary salary );

    public boolean delete ( Integer id );

}
