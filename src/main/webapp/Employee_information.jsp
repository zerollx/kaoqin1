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
    <div style="margin-left: 300px">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="empName" autocomplete="off" class="layui-input" value="${employees.empName}"readonly="true">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-inline">
            <input type="text" name="empSex" autocomplete="off" class="layui-input" value="${employees.empSex}"readonly="true">
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-inline">
            <input type="text" name="empAge" value="${employees.empAge} " autocomplete="off" class="layui-input"readonly="true">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">民族</label>
        <div class="layui-input-inline">
            <input type="text" name="empNation" autocomplete="off" class="layui-input" value="${employees.empNation}" readonly="true">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">身份证</label>
        <div class="layui-input-inline">
            <input type="text" name="empIdentity" required autocomplete="off" class="layui-input"
                   value="${employees.empCard}" readonly="true">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="empPhone" autocomplete="off" class="layui-input" value="${employees.empPhone}"value="readonly" readonly>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">紧急联系人</label>
        <div class="layui-input-inline">
            <input type="text" name="empEmergencyContact" autocomplete="off" class="layui-input" value="${employees.empEmergencyContact}" value="readonly" readonly>
        </div>
    </div>

        <div class="layui-form-item">
            <label class="layui-form-label">紧急电话</label>
            <div class="layui-input-inline">
                <input type="text" name="empEmergencyContactPhone" autocomplete="off" class="layui-input" value="${employees.empEmergencyPhone}"value="readonly" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">职称</label>
            <div class="layui-input-inline">
                <input type="text" name="sName" autocomplete="off" class="layui-input" value="${employees.station.SName}"value="readonly" readonly>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">个人描述</label>
            <div class="layui-input-block">
                <input type="text"style="height: 80px;width: 400px" name="empDescribe" autocomplete="off" class="layui-input" value="${employees.empDescribe}"value="readonly" readonly>
            </div>
        </div>
    </div>
    <div class="layui-form-item"  style="margin-left:50px ; margin-top: -570px; float: left" >
        <label class="layui-form-label"></label>
        <div class="layui-input-inline"  style="display: inline">
            <img  name="headImg" src="${employees.empImg} " width="150px" height="200px">
        </div>
    </div>
</form>

<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

</body>
</html>
