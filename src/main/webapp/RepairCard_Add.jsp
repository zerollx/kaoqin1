<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/9/4
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="jq/jquery-1.11.3.js"></script>
    <script src="js/xadmin.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">打卡人</label>
        <div class="layui-input-inline">
            <input type="text" name="RepairPeople" autocomplete="off" class="layui-input"  lay-verify="required" value="${username}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">打卡日期</label>
        <div class="layui-input-inline">
            <input type="text" name="RepairDate" autocomplete="off" class="layui-input"  lay-verify="required" value="<%=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(Calendar.getInstance().getTime())%>">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-inline">
            <input style="height: 80px;width: 400px" type="text" name="RepairReason" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="test9">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
 </form>

 <script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;
        var $ = layui.jquery;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            // var val1 = $("#sPart").val();
            // var val = $("#sType").val();
            // var val2 = $("#sSuper").val();
            $.ajax({
                type: "post",
                url: "/RepairAdd",
                data: {
                    "RepairPeople": data.field.RepairPeople,
                    "RepairDate": data.field.RepairDate,
                    "RepairReason": data.field.RepairReason,
                },
                dataType: 'json',
                success: function (data) {
                    if(data.code==200){
                       xadmin.close();
                       // location.href='Employee_Add.jsp';
                        xadmin.father_reload()
                    }else {
                        layer.msg("添加失败")
                    }
                }
            })
            return false;
        });
    });
</script>
</body>
</html>
