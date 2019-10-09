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
        <label class="layui-form-label">ID</label>
        <div class="layui-input-inline">
            <input type="text" name="id" autocomplete="off" class="layui-input" value="${byId.id}" readonly="true">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">请假人</label>
        <div class="layui-input-inline">
            <input type="text" name="leavePeople" autocomplete="off" class="layui-input" lay-verify="required"
                   value="${byId.leavePeople}" readonly="true">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">开始时间</label>
        <div class="layui-input-inline">
            <input type="text" name="start" autocomplete="off" class="layui-input"
                   value="${byId.start}" readonly="true" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">结束时间</label>
        <div class="layui-input-inline">
            <input type="text" name="end" autocomplete="off" class="layui-input"  readonly="true" value="${byId.end}" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">原因</label>
        <div class="layui-input-inline">
            <input style="height: 80px;width: 400px" type="text" name="reason" autocomplete="off" class="layui-input"
                   value="${byId.reason}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">审核</label>
        <div class="layui-input-block">
            <select name="sStation" id="status" lay-verify="required" >
                <option value=""></option>
                <option value="0">等待审核</option>
                <option value="1">审核通过</option>
                <option value="-1">审核未通过</option>
            </select>
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
            var status = $("#status").val();
            $.ajax({
                type: "post",
                url: "/LeaveUpdate",
                data: {
                    "id":data.field.id,
                    "status": status,
                },
                dataType: 'json',
                success: function (data) {
                    if (data.code == 200) {
                        xadmin.close();
                        // location.href='Employee_Add.jsp';
                        xadmin.father_reload()
                    } else {
                        layer.msg("审批失败")
                    }
                }
            })
            return false;
        });
    });
</script>
</body>
</html>
