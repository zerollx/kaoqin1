package com.jc.service;

import com.jc.entity.PunchCard;
import com.jc.entity.PunchCardPageBean;

public interface PunchCardService {
    public PunchCardPageBean<PunchCard> listAll ( Integer currentPage, Integer pageSize, String username );

    public boolean add( PunchCard punchCard );
}
