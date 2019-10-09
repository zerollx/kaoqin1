package com.jc.mapper;

import com.jc.entity.Station;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface StationMapper {
    /**
     * 查询全部职位
     */
    public ArrayList<String> findAllStation ();

    /*  查询全部emp_position_id
     */
//    public   ArrayList<String> findAllPositionId();
    /**
     * 查询全部
     */
    public ArrayList<Station> listAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public ArrayList<Station> findAll ();

    public boolean  add( Station station );

    public  boolean delete ( Integer id );

    public boolean update( Station station );
    public Station findById ( Integer id );
}
