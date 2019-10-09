package com.jc.service.Impl;
import com.jc.entity.RepairCard;
import com.jc.entity.RepairCardPageBean;
import com.jc.mapper.RepairCardMapper;
import com.jc.service.RepairCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairCardServiceImpl implements RepairCardService {
    @Autowired
    private RepairCardMapper mapper;
    @Override
    public RepairCardPageBean<RepairCard> listAll ( Integer currentPage, Integer pageSize, String username ) {
        RepairCardPageBean<RepairCard> RepairCardPageBean = new RepairCardPageBean ();
        //1.封装总条数
        RepairCardPageBean.setCountTotal ( mapper.getCount ( username ) );
        //2.封装当前页
        RepairCardPageBean.setCurrentPage ( currentPage );
        //3.封装实体集
        RepairCardPageBean.setList ( mapper.listAll ( (currentPage - 1) * pageSize, pageSize, username ) );
        return RepairCardPageBean;
    }

    @Override
    public boolean add ( RepairCard repairCard ) {
        return  mapper.add (repairCard );
    }
}
