<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/8/31
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<meta charset="UTF-8">
<title>后台登录-考勤管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
      content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
<meta http-equiv="Cache-Control" content="no-siteapp"/>
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="jq/jquery-1.11.3.js"></script>
<![endif]-->
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">考勤管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form">
        <input name="username" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" id="password" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">

        <div class="layui-form-item">
            <label class="layui-form-label">请选择身份</label>
            <div class="layui-input-block">
                <input type="radio" name="identity" value="管理员" title="管理员">
                <input type="radio" name="identity" value="员工" title="员工" checked>
            </div>
        </div>
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
        <%--<a href="Check.jsp" class="layui-input-block" style="width:100%;" type="submit">点击注册</a>--%>
    </form>
</div>
<script>
    $(function () {
        layui.use('form', function () {
            var form = layui.form;
            // layer.msg('玩命卖萌中', function(){
            //   //关闭后的操作
            //   });
            //监听提交
            form.on('submit(login)', function (data) {
                // alert(888)
                layer.msg(JSON.stringify(data.field), function () {
                    // location.href='index.jsp'
                    $.ajax({
                        type: 'post',
                        url: '/login',
                        data: {
                            "username": data.field.username,
                            "password": data.field.password,
                            "identity": data.field.identity,
                        },
                        dataType: 'json',
                        success: function (data) {
                            if (data.code == 200) {
                                location.href = "index.jsp"
                            } else {
                                layer.msg("登录失败,请正确填写个人信息")
                            }
                        }
                    })
                });
                return false;
            });
        });
    })
</script>

<!-- 底部结束 -->
</body>
</html>
