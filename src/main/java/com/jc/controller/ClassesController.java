package com.jc.controller;

import com.jc.entity.Classes;
import com.jc.entity.ClassesPageBean;
import com.jc.service.ClassesService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @RequestMapping(value = "/ClassesFindAll")
    @ResponseBody
    public ResultMap findAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        ClassesPageBean<Classes> all = classesService.findAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
        return rs;
    }

    @RequestMapping(value = "ClassesAdd")
    @ResponseBody
    public ResultMap add ( String cCode, String cName, String cMorning, String cAfternoon ) {
        Classes classes = new Classes ( cCode, cName, cMorning, cAfternoon );
        boolean add = classesService.add ( classes );
        if ( add ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "ClassesDelete")
    @ResponseBody
    public ResultMap delete ( Integer id ) {
        boolean delete = classesService.delete ( id );
        if ( delete ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "ClassesFindById")
    public String findById ( Integer id, Model model ) {
        Classes byId = classesService.findById ( id );
        model.addAttribute ( "byId", byId );
        return "Classes_Update";
    }

    @RequestMapping(value = "ClassesUpdate")
    @ResponseBody
    public ResultMap update ( Integer id, String cCode, String cName, String cMorning, String cAfternoon ) {
        Classes classes = new Classes ( id, cCode, cName, cMorning, cAfternoon );
        boolean update = classesService.update ( classes );
        if ( update ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping(value = "ClassDeleteAll")
    @ResponseBody
    public ResultMap deleteAll ( @RequestParam("ids[]") Integer ids[] ) {
        boolean b = classesService.deleteAll ( ids );
        if ( b ) {
            return ResultMap.okCode ();
        }

        return ResultMap.failCode ();
    }

}
