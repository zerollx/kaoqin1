<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/10/7
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>欢迎${username}</h1>
 <div class="layui-input-inline">
  <h2> 现在是北京时间</h2>  <input type="text" name="punchDate" autocomplete="off" class="layui-input" lay-verify="required"
            value="<%=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(Calendar.getInstance().getTime())%>">
 </div>


 <h2>这个是会动的时间</h2><h2 id="clock" onload="realSysTime()"> </h2>
 <script language="javascript">
     function realSysTime(clock){
         var now=new Date(); //创建Date对象
         var year=now.getFullYear(); //获取年份
         var month=now.getMonth(); //获取月份
         var date=now.getDate(); //获取日期
         var day=now.getDay(); //获取星期
         var hour=now.getHours(); //获取小时
         var minu=now.getMinutes(); //获取分钟
         var sec=now.getSeconds(); //获取秒钟
         month=month+1;
         var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
         var week=arr_week[day]; //获取中文的星期
         var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间
         clock.innerHTML=time; //显示系统时间
     }
     window.onload=function(){
         window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间
     }
 </script>
</body>
</html>
