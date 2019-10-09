package com.jc.service.Impl;

import com.jc.entity.Classes;
import com.jc.entity.ClassesPageBean;
import com.jc.mapper.ClassesMapper;
import com.jc.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper mapper;
    @Override
    public ClassesPageBean<Classes> findAll ( Integer currentPage, Integer pageSize, String username ) {
        ClassesPageBean<Classes> classesPageBean = new ClassesPageBean ();
        //1.封装总条数
        classesPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        classesPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        classesPageBean.setList ( mapper.findAll ((currentPage - 1) * pageSize,pageSize, username ) );
        return classesPageBean;
    }

    @Override
    public boolean add ( Classes classes ) {
        return  mapper.Add ( classes );
    }

    @Override
    public boolean delete ( Integer id ) {
        return  mapper.delete ( id );
    }

    @Override
    public Classes findById ( Integer id ) {
        return  mapper.findById ( id );
    }

    @Override
    public boolean update ( Classes classes ) {
       return  mapper.update ( classes );
    }

    @Override
    public boolean deleteAll ( Integer[] ids ) {
        return  mapper.deleteAll ( ids );
    }
}
