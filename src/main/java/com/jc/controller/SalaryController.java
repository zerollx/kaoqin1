package com.jc.controller;


import com.jc.entity.Salary;
import com.jc.entity.SalaryPageBean;
import com.jc.service.SalaryService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "SalaryListAll")
    @ResponseBody
    public ResultMap listAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        SalaryPageBean<Salary> all = salaryService.listAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
//        model.addAttribute ( "all",all );
        return rs;
    }

    @RequestMapping(value = "SalaryAdd")
    @ResponseBody
    public ResultMap add (String peopleCode ,String salaryPeople,Double salary,String start,String end,Integer time){
        Double d ;
        d = (salary*time)/270;
        Salary  sal = new Salary (peopleCode,salaryPeople,d, start, end);
        boolean add = salaryService.add ( sal );
        if ( add ){
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "SalaryDelete")
    @ResponseBody
    public ResultMap delete (Integer id){
        boolean delete = salaryService.delete ( id );
        if ( delete ){
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

}
