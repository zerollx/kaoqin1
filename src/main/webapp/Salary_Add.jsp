<%--
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
        <label class="layui-form-label">领薪人编码</label>
        <div class="layui-input-inline">
            <input type="text" name="peopleCode" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">领薪人</label>
        <div class="layui-input-block">
            <select name="salaryPeople" id="salaryPeople" lay-verify="required">
                <c:forEach var="allName" items="${allName}">
                    <option value="${allName}">${allName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">薪水</label>
        <div class="layui-input-inline">
            <input type="text" name="salary" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">领薪区间</label>
        <div class="layui-input-inline">
            <input type="text" name="start" autocomplete="off" class="layui-input" lay-verify="required"
                   placeholder="开始日期">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="text" name="end" autocomplete="off" class="layui-input" lay-verify="required"
                   placeholder="结束日期">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">工时</label>
        <div class="layui-input-inline">
            <input type="text" name="time" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="test9">计算薪资</button>
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
            var salaryPeople = $("#salaryPeople").val();
            // var val = $("#sType").val();
            // var val2 = $("#sSuper").val();

            $.ajax({
                type: "post",
                url: "/SalaryAdd",
                data: {
                    "peopleCode": data.field.peopleCode,
                    "salaryPeople": salaryPeople,
                    "salary": data.field.salary,
                    "start": data.field.start,
                    "end": data.field.end,
                    "time": data.field.time,
                },
                dataType: 'json',
                success: function (data) {
                    if (data.code == 200) {
                        xadmin.close();
                        // location.href='Employee_Add.jsp';
                        xadmin.father_reload()
                    } else {
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
