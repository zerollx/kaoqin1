package com.jc.mapper;


import com.jc.entity.PunchCard;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface PunchMapper {
    public ArrayList<PunchCard> listAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public boolean add ( PunchCard punchCard );
}
