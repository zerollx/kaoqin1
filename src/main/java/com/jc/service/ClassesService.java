package com.jc.service;

import com.jc.entity.Classes;
import com.jc.entity.ClassesPageBean;

public interface ClassesService {

    public ClassesPageBean<Classes> findAll ( Integer currentPage, Integer pageSize, String username );

    public boolean add ( Classes classes );

    public boolean delete ( Integer id );

    public Classes findById ( Integer id );
    public boolean update ( Classes classes );

    public boolean deleteAll ( Integer ids[] );

}
