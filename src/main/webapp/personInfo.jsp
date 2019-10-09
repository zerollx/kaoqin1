<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/9/5
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <title>Title</title>
    <script type="text/javascript" src="layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="jq/jquery-1.11.3.js"></script>
    <script src="js/xadmin.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">账号名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" autocomplete="off" class="layui-input" value="${username}" readonly="true">
        </div>

    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="text" name="password" autocomplete="off" class="layui-input" value="${password}">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">修改密码</label>
        <div class="layui-input-inline">
            <input type="text" name="updatePassword" autocomplete="off" class="layui-input">
        </div>
    </div>
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
                url: "/uppass",
                data: {
                    username:data.field.username,
                    updatePassword:data.field.updatePassword,
                },
                dataType: 'json',
                success: function (data) {
                    if(data.code==200){
                        xadmin.close()
                        location.href="login.jsp"
                    }else {
                        layer.msg("更修改密码失败");
                    }
                }
            })
            return false;
        });
    });


</script>
</body>
</html>
