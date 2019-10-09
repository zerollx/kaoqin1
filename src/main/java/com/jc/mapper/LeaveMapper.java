package com.jc.mapper;
import com.jc.entity.Leave;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface LeaveMapper {

    public ArrayList<Leave> findAll ( @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("username") String username );

    public Integer getCount ( @Param("username") String username );

    public boolean add ( Leave leave );

    public boolean update ( Leave leave );
    public Leave findById ( Integer id );


}
