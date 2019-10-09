package com.jc.controller;

import com.jc.entity.CheckAll;
import com.jc.entity.CheckReport;
import com.jc.entity.PunchCard;
import com.jc.entity.PunchCardPageBean;
import com.jc.service.CheckAllService;
import com.jc.service.CheckReportService;
import com.jc.service.PunchCardService;
import com.jc.util.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class PunchCardController {
    @Autowired
    private PunchCardService punchCardService;
    @Autowired
    private CheckReportService checkReportService;
    @Autowired
    private CheckAllService checkAllService;


    @RequestMapping(value = "punchListAll")
    @ResponseBody
    public ResultMap listAll ( @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, String username ) {
        PunchCardPageBean<PunchCard> all = punchCardService.listAll ( page, limit, username );
        ResultMap rs = new ResultMap ();
        rs.setMsg ( "" );
        rs.setCode ( 0 );
        rs.setCount ( all.getCountTotal () );
        rs.setData ( all.getList () );
//        model.addAttribute ( "all",all );
        return rs;
    }

    @RequestMapping(value = "/PunchAdd")
    @ResponseBody
    public ResultMap add ( String punchPeople, String punchDate, Integer punchRemarks ) {
        PunchCard punchCard = new PunchCard ( punchPeople, punchDate, punchRemarks );
        boolean add = punchCardService.add ( punchCard );
        int hours;
        int minutes;
        int second;
        Integer s;
        Integer s1;
        Integer s2;
        try {
            String my = punchDate;
            SimpleDateFormat f = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            Date parse = f.parse ( my );
            Calendar c = Calendar.getInstance ();
            c.setTime ( parse );
            hours = c.get ( Calendar.HOUR_OF_DAY );
            minutes = c.get ( Calendar.MINUTE );
            second = c.get ( Calendar.SECOND );
            System.out.println ( hours );
            System.out.println ( minutes );
            System.out.println ( second );
            s = punchRemarks;
            s1 = 1;
            s2 = 2;
            System.out.println ( s1 );
            if ( add ) {
                if ( s1.equals ( s ) ) {
                    if ( hours < 9 || (hours == 9 && minutes == 0 && second == 0) ) {
                        CheckReport checkReport = new CheckReport ( punchPeople, punchDate, 1,"A" );
                        checkReportService.mAdd ( checkReport );
                    } else if ( hours > 9 || hours == 9 && second > 0 ) {
                        CheckReport checkReport = new CheckReport ( punchPeople, punchDate, 2 ,"A");
                        checkReportService.mAdd ( checkReport );
                    }
                } else if ( s2.equals ( s ) ) {
                    if ( hours > 18 || (hours == 18 && minutes == 0 && second == 0) ) {
                        CheckReport checkReport = new CheckReport ( punchPeople, punchDate, 3,"B" );
                        checkReportService.mAdd ( checkReport );
                    } else if ( hours < 18 ) {
                        CheckReport checkReport = new CheckReport ( punchPeople, punchDate, 4,"B" );
                        checkReportService.mAdd ( checkReport );
                    }
                }
                return ResultMap.okCode ();
            }
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        return ResultMap.failCode ();
    }

//    @Scheduled(cron = "0/5 * * * * ? ") //当前是5秒执行一次
    public void testTask ( ) {

    }
}
