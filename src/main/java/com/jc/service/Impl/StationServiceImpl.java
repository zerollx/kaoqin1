package com.jc.service.Impl;

import com.jc.entity.Station;
import com.jc.entity.StationPageBean;
import com.jc.mapper.StationMapper;
import com.jc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationMapper mapper;

    @Override
    public ArrayList<String> findAllStation () {
        return mapper.findAllStation ();
    }

    @Override
    public StationPageBean<Station> findAll ( Integer currentPage, Integer pageSize, String username ) {
        StationPageBean<Station> StationPageBean = new StationPageBean ();
        //1.封装总条数
        StationPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        StationPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        StationPageBean.setList ( mapper.listAll ( (currentPage - 1) * pageSize, pageSize, username ) );
        return StationPageBean;
    }

    @Override
    public ArrayList<Station> list () {
        return mapper.findAll ();
    }

    @Override
    public boolean add ( Station station ) {
        return mapper.add ( station );
    }

    @Override
    public boolean delete ( Integer id ) {
        return mapper.delete ( id );
    }


    @Override
    public boolean update ( Station station ) {
        return mapper.update ( station );
    }

    @Override
    public Station findById ( Integer id ) {
        return mapper.findById ( id );
    }


//    @Override
//    public ArrayList<String> findAllPositionId () {
//        return mapper.findAllPositionId ();
//    }
}
