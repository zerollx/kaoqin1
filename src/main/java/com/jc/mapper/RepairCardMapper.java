package com.jc.mapper;


import com.jc.entity.RepairCard;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface RepairCardMapper {
    public ArrayList<RepairCard> listAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public boolean add ( RepairCard repairCard );

}
