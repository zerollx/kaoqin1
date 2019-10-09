package com.jc.controller;

import com.jc.entity.Department;
import com.jc.entity.DepartmentPageBean;
import com.jc.service.DepartmentService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@Controller
@SessionAttributes("all")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "listAll")
    @ResponseBody
    public ResultMap listAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        DepartmentPageBean<Department> all = departmentService.listAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
//        model.addAttribute ( "all",all );
        return rs;
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public ResultMap add ( String departCode, String departName, String departLeading, String departDuty, String departSuperDepart ) {
        Department department = new Department ( departCode, departName, departLeading, departDuty, departSuperDepart );
        boolean add = departmentService.add ( department );
        if ( add ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "departDelete")
    @ResponseBody
    public ResultMap delete ( Integer id ) {
        boolean delete = departmentService.delete ( id );
        if ( delete ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "departmentDeleteAll")
    @ResponseBody
    public ResultMap deleteAll ( @RequestParam("ids[]") Integer ids[] ) {
        boolean b = departmentService.deleteAll ( ids );
        if ( b ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "findById")
    public String findById ( Model model, Integer id ) {
        Department byId = departmentService.findById ( id );
        model.addAttribute ( "byId", byId );
        return "Department_Update";
    }

    @RequestMapping(value = "departUpdate")
    @ResponseBody
    public ResultMap update ( Integer id, String departCode, String departName, String departLeading, String empDuty, String departSuperDepart ) {
        Department department = new Department ( id, departCode, departName, departLeading, empDuty, departSuperDepart );
        boolean update = departmentService.update ( department );
        if ( update ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }


    @RequestMapping(value = "DepartmentFindAll")
    public String findAll ( Model model ) {
        ArrayList<Department> all = departmentService.findAll ();
        model.addAttribute ( "all", all );
        return "Station_Add";
    }

}
