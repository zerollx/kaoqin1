<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/9/2
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <input type="text" name="id" autocomplete="off" class="layui-input" value="${employee.id}" readonly="true">
        </div>
    </div>

    <%--<div style="margin-left: 300px">--%>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="empName" autocomplete="off" class="layui-input" value="${employee.empName}">
        </div>
    </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="empSex"  value="男" title="男">
                <input type="radio" name="empSex"  value="女" title="女" checked>
            </div>
        </div>

    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-inline">
            <input type="text" name="empAge" value="${employee.empAge} " autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">民族</label>
        <div class="layui-input-inline">
            <input type="text" name="empNation" autocomplete="off" class="layui-input" value="${employee.empNation}" >
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">身份证</label>
        <div class="layui-input-inline">
            <input type="text" name="empCard" required autocomplete="off" class="layui-input"
                   value="${employee.empCard}" >
        </div>
    </div>

        <div class="layui-form-item">
            <label class="layui-form-label">薪资</label>
            <div class="layui-input-inline">
                <input type="text" name="empSalary" required autocomplete="off" class="layui-input"
                       value="${employee.empSalary}" >
            </div>
        </div>


    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="empPhone" autocomplete="off" class="layui-input" value="${employee.empPhone}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">紧急联系人</label>
        <div class="layui-input-inline">
            <input type="text" name="empEmergencyContact" autocomplete="off" class="layui-input" value="${employee.empEmergencyContact}" >
        </div>
    </div>

        <div class="layui-form-item">
            <label class="layui-form-label">紧急电话</label>
            <div class="layui-input-inline">
                <input type="text" name="empEmergencyPhone" autocomplete="off" class="layui-input" value="${employee.empEmergencyPhone}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">岗位</label>
            <div class="layui-input-block">
                <select name="sStation" id="sStation" lay-verify="required" >
                    <%--<c:forEach var="allStation" items="${allStation}" >--%>
                    <%--<option value="${allStation}" >${allStation}</option>--%>
                    <option value="1">总经理</option>
                    <option value="2">会计</option>
                    <option value="3">前台</option>
                    <option value="4">后勤</option>
                    <%--</c:forEach>--%>
                </select>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">个人描述</label>
            <div class="layui-input-block">
                <input type="text"style="height: 80px;width: 400px" name="empDescribe" autocomplete="off" class="layui-input" value="${employee.empDescribe}">
            </div>
        </div>
    </div>
    <%--<div class="layui-form-item"  style="margin-left:50px ; margin-top: -570px; float: left" >--%>
        <%--<label class="layui-form-label"></label>--%>
        <%--<div class="layui-input-inline"  style="display: inline">--%>
            <%--<img  name="headImg" src="${employees.empImg} " width="150px" height="200px">--%>
        <%--</div>--%>
    <%--</div>--%>
<div class="layui-form-item">
    <div class="layui-input-block">
        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
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
            var val = $("#sStation").val();
            $.ajax({
                type: "post",
                url: "/update",
                data: {
                   "id" :data.field.id,
                    "empName": data.field.empName,
                    "empSex":data.field.empSex,
                    "empAge": data.field.empAge,
                    "empNation": data.field.empNation,
                    "empCard": data.field.empCard,
                    "empSalary":data.field.empSalary,
                    "empPhone": data.field.empPhone,
                    "empEmergencyContact": data.field.empEmergencyContact,
                    "empEmergencyPhone":data.field.empEmergencyPhone,
                    "sStation": val,
                    "empDescribe": data.field.empDescribe,
                },
                dataType: 'json',
                success: function (data) {
                    if(data.code==200){
                        xadmin.close()
                        xadmin.father_reload()
                    }else {
                        layer.msg("更新失败")
                    }
                }
            })
            return false;
        });
    });

</script>
</body>
</html>
