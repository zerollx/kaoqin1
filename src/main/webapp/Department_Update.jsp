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
            <input type="text" name="id" autocomplete="off" class="layui-input" value="${byId.id}" readonly="true">
        </div>
    </div>

    <%--<div style="margin-left: 300px">--%>
    <div class="layui-form-item">
        <label class="layui-form-label">部门编号</label>
        <div class="layui-input-inline">
            <input type="text" name="departCode" autocomplete="off" class="layui-input" value="${byId.departCode}" readonly="true">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">部门名</label>
        <div class="layui-input-inline">
            <input type="text" name="departName" value="${byId.departName} " autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">负责人</label>
        <div class="layui-input-inline">
            <input type="text" name="departLeading" autocomplete="off" class="layui-input" value="${byId.departLeading}" >
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">部门职责</label>
        <div class="layui-input-block">
            <input type="text"style="height: 80px;width: 400px" name="empDuty" autocomplete="off" class="layui-input" value="${byId.departDuty}">
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">上级部门</label>
        <div class="layui-input-block">
            <input type="text"style="height: 80px;width: 400px" name="departSuperDepart" autocomplete="off" class="layui-input" value="${byId.departSuperDepart}">
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
            $.ajax({
                type: "post",
                url: "/departUpdate",
                data: {
                   "id" :data.field.id,
                    "departCode": data.field.departCode,
                    "departName":data.field.departName,
                    "departLeading": data.field.departLeading,
                    "empDuty": data.field.empDuty,
                    "departSuperDepart": data.field.departSuperDepart,
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
