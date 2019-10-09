package com.jc.controller;

import com.jc.entity.Station;
import com.jc.entity.StationPageBean;
import com.jc.service.StationService;
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
@SessionAttributes("list")
public class StationController {
    @Autowired
    private StationService stationService;

//    @RequestMapping(value = "/allStation")
//    public String findAllStation ( Model model ) {
//        ArrayList<String> allStation = stationService.findAllStation ();
//        model.addAttribute ( "allStation", allStation );
//        return "Employee_Add";
//    }


    @RequestMapping(value = "/pageAll")
    @ResponseBody
    public ResultMap listAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        StationPageBean<Station> alls = stationService.findAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( alls.getCountTotal () );
        rs.setData ( alls.getList () );
//        model.addAttribute ( "all",all );
        return rs;
    }

    @RequestMapping(value = "/allPositionId")
    public String findAllPositionId ( Model model ) {
        ArrayList<Station> list = stationService.list ();
        model.addAttribute ( "list", list );
        return "Employee_Add";
    }


    @RequestMapping(value = "StationAdd")
    @ResponseBody
    public ResultMap add ( String sCode, String sName, String sPart, String sSuper, String sType, String sDescribe, String empPositionId ) {
        Station station = new Station ( sCode, sName, sPart, sSuper, sType, sDescribe, empPositionId );
        boolean add = stationService.add ( station );
        if ( add ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

    @RequestMapping("StationDelete")
    @ResponseBody
    public ResultMap delete ( Integer id ) {
        boolean delete = stationService.delete ( id );
        if ( delete ) {
            return ResultMap.okCode ();
        }

        return ResultMap.failCode ();
    }

    @RequestMapping(value = "findById2")
    public String findById ( Integer id, Model model ) {
        Station byId = stationService.findById ( id );
        model.addAttribute ( "byId", byId );
        return "Station_Update";
    }
    @RequestMapping(value = "StationUpdate")
    @ResponseBody
    public ResultMap update( Integer id , String sCode , String sName, String sPart , String sSuper, String sType, String sDescribe ){
       Station station = new Station ( id,sCode,sName,sPart,sSuper,sType,sDescribe );
        boolean update = stationService.update ( station );
        if (update){
            return  ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

}
