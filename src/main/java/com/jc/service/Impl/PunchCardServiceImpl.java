package com.jc.service.Impl;

import com.jc.entity.PunchCard;
import com.jc.entity.PunchCardPageBean;
import com.jc.mapper.PunchMapper;
import com.jc.service.PunchCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunchCardServiceImpl implements PunchCardService {

    @Autowired
    private PunchMapper mapper;

    @Override
    public PunchCardPageBean<PunchCard> listAll ( Integer currentPage, Integer pageSize, String username ) {

        PunchCardPageBean<PunchCard> PunchCardPageBean = new PunchCardPageBean ();
        //1.封装总条数
        PunchCardPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        PunchCardPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        PunchCardPageBean.setList ( mapper.listAll ( (currentPage - 1) * pageSize, pageSize, username ) );
        return PunchCardPageBean;
    }

    @Override
    public boolean add ( PunchCard punchCard ) {
        return mapper.add ( punchCard );
    }

}
