package com.jc.service.Impl;

import com.jc.entity.Login;
import com.jc.mapper.LoginMapper;
import com.jc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper mapper;
    @Override
    public Login findByUserNameAndPwd ( String userName, String passWord, String identity ) {
        return mapper.findByUserNameAndPwd ( userName, passWord, identity );
    }
}
