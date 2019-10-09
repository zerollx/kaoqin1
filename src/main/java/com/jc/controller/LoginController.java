package com.jc.controller;

import com.jc.entity.Login;
import com.jc.service.LoginService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
    @Autowired
    private LoginService loginservice;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap login ( String username, String password, String identity, Model model ) {
        Login login = loginservice.findByUserNameAndPwd ( username, password, identity );
        if ( login != null ) {
            model.addAttribute ( "username",username );
            model.addAttribute ( "password",password );
            model.addAttribute ( "identity",identity );
            return ResultMap.okCode ();
        } else {
            return ResultMap.failCode ();
        }
    }
}
