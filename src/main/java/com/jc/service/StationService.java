package com.jc.service;

import com.jc.entity.Station;
import com.jc.entity.StationPageBean;

import java.util.ArrayList;

public interface StationService {
    public ArrayList<String> findAllStation ();

    public StationPageBean<Station> findAll ( Integer currentPage, Integer pageSize, String username );

    public ArrayList<Station> list ();

    //    public ArrayList<String> findAllPositionId();
    public boolean add ( Station station );

    public boolean delete ( Integer id );

    public boolean update( Station station );
    public Station findById ( Integer id );


}
