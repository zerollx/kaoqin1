package com.jc.service;

import com.jc.entity.Login;


public interface LoginService {
    public Login findByUserNameAndPwd ( String userName, String passWord, String identity );
}
