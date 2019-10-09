package com.jc.controller;

import com.jc.entity.Leave;
import com.jc.entity.LeavePageBean;
import com.jc.service.LeaveService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "LeaveAll")
    @ResponseBody
    public ResultMap findAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        LeavePageBean<Leave> all = leaveService.findAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
        return rs;
    }

    @RequestMapping(value = "LeaveAdd")
    @ResponseBody
    public ResultMap add ( String leavePeople, String start, String end, String reason ) {
        Leave leave = new Leave ( leavePeople, start, end, reason );
        boolean add = leaveService.add ( leave );
        if ( add ) {
            return ResultMap.okCode ();
        }
        return ResultMap.okCode ();
    }

    @RequestMapping(value = "LeaveUpdate")
    @ResponseBody
    public ResultMap update ( Integer id,Integer status ) {
        Leave leave = new Leave ( id,status );
        boolean update = leaveService.update ( leave );
        if ( update ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "LeaveFindById")
    public String updateById ( Integer id, Model model ) {
        Leave byId = leaveService.findById ( id );
        model.addAttribute ( "byId", byId );
        return "Leave_update";
    }


}
