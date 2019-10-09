package com.jc.mapper;

import com.jc.entity.Login;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    /**
     * 根据账号名密码查询 登录
     */

    public Login findByUserNameAndPwd ( @Param("userName") String userName, @Param("password") String passWord, @Param("identity") String identity );
}
