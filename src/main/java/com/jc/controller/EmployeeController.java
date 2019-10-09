package com.jc.controller;

import com.jc.entity.Employee;
import com.jc.entity.EmployeePageBean;
import com.jc.service.EmployeeService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes("all")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "findAll")
    @ResponseBody
    public ResultMap findAll ( Model model, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
//        ResultVo rv = new ResultVo ();
        ArrayList<Integer> ids = employeeService.findIds ();
        EmployeePageBean<Employee> all = employeeService.findAll ( ids, page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
        model.addAttribute ( "all", all );
        return rs;
    }


    @RequestMapping(value = "listAllById")
    public String listByIdAll ( Integer id, Model model ) {
        Employee employees = employeeService.listByIdAll ( id );
        model.addAttribute ( "employees", employees );
        return "Employee_information";
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap add ( String empCode, String empName, String headImg, String empSex, Integer empAge, String empNation, String empCard, Double empSalary, String empPhone, String empEmergencyContact, String empEmergencyPhone, String sStation, String empDescribe ) {
        Employee emp = new Employee ( empCode, empName, empSex, empAge, empNation, empCard, empSalary, empPhone, empEmergencyContact, empEmergencyPhone, empDescribe, sStation, headImg );
        boolean add = employeeService.employeeAdd ( emp );
        if ( add ) {
            ResultMap.okCode ();
        } else {
            ResultMap.failCode ();
        }

        return ResultMap.okCode ();
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResultMap delete ( Integer id ) {
        boolean flag = employeeService.EmployeeDelete ( id );
        if ( flag ) {
            ResultMap.okCode ();
        } else {
            ResultMap.failCode ();
        }
        return ResultMap.okCode ();
    }


    @RequestMapping(value = "deleteAll")
    @ResponseBody
    public ResultMap deleteAll ( @RequestParam("ids[]") Integer ids[] ) {
        boolean b = employeeService.deleteAll ( ids );
        if ( b ) {
            ResultMap.okCode ();
        } else {
            ResultMap.failCode ();
        }
        return ResultMap.okCode ();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public ResultMap update ( Integer id, String empName, String empSex, Integer empAge, String empNation, String empCard, Double empSalary, String empPhone, String empEmergencyContact, String empEmergencyPhone, String sStation, String empDescribe ) {
        Employee employee = new Employee ( id, empName, empSex, empAge, empNation, empCard, empSalary, empPhone, empEmergencyContact, empEmergencyPhone, sStation, empDescribe );
        boolean flag = employeeService.update ( employee );
        if ( flag ) {
            ResultMap.okCode ();
        } else {
            ResultMap.failCode ();
        }
        return ResultMap.okCode ();
    }

    /**
     * 修改用
     */
    @RequestMapping(value = "updateById")
    public String updateById ( Integer id, Model model ) {
        Employee employee = employeeService.findById ( id );
        model.addAttribute ( "employee", employee );
        return "Employee_Update";
    }


    @RequestMapping(value = "/allName")
    public String findAllPositionId ( Model model ) {
        ArrayList<String> allName = employeeService.allName ();
        model.addAttribute ( "allName", allName );
        return "Salary_Add";
    }

}