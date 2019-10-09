package com.jc.service;

import com.jc.entity.RepairCard;
import com.jc.entity.RepairCardPageBean;

public interface RepairCardService {
    public RepairCardPageBean<RepairCard> listAll ( Integer currentPage, Integer pageSize, String username );

    public boolean add ( RepairCard repairCard );
}
