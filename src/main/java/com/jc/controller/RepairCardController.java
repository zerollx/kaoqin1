package com.jc.controller;


import com.jc.entity.RepairCard;
import com.jc.entity.RepairCardPageBean;
import com.jc.service.RepairCardService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RepairCardController {
    @Autowired
    private RepairCardService repairCardService;

    @RequestMapping(value = "RepairListAll")
    @ResponseBody
    public ResultMap listAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        RepairCardPageBean<RepairCard> all = repairCardService.listAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
//        model.addAttribute ( "all",all );
        return rs;
    }

    @RequestMapping(value = "/RepairAdd")
    @ResponseBody
    public ResultMap add ( String RepairPeople, String RepairDate, String RepairReason ) {
        RepairCard repairCard = new RepairCard ( RepairPeople, RepairDate, RepairReason );
        boolean add = repairCardService.add ( repairCard );
        if ( add ) {
            return ResultMap.okCode ();
        }
        return ResultMap.failCode ();
    }

}
