package com.jc.controller;

import com.jc.entity.CheckReport;
import com.jc.entity.CheckReportPageBean;
import com.jc.service.CheckReportService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckReportController {
    @Autowired
    private CheckReportService checkReportService;

    @RequestMapping(value = "checkAll")
    @ResponseBody
    public ResultMap listAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        CheckReportPageBean<CheckReport> all = checkReportService.listAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
//        model.addAttribute ( "all",all );
        return rs;
    }


}
