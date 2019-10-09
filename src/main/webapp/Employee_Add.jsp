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
        <label class="layui-form-label">员工编码</label>
        <div class="layui-input-inline">
            <input type="text" name="empCode" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="empName" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-upload">
        <label class="layui-form-label">用户头像</label>
        <button type="button" class="layui-btn layui-btn-normal" id="test8" name="file">选择文件</button>
        <button type="button" class="layui-btn" id="test10">开始上传</button>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-inline">
            <input type="hidden" id="headImg" name="headImg"  >
        </div>
    </div>

    <script>
        layui.use('upload', function(){
            var upload = layui.upload;
            var $ = layui.jquery;
            //执行实例
            upload.render({
                elem: '#test8'
                ,url: '/upload'
                ,auto: false
                //,multiple: true
                ,bindAction: '#test10'
                ,done: function(res){
                    console.log(res);
                    $('#headImg').val(res.data.src);
                }
            });
        });
    </script>
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
            <input type="text" name="empAge" autocomplete="off" class="layui-input" lay-verify="age" >
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">民族</label>
        <div class="layui-input-inline">
            <input type="text" name="empNation" autocomplete="off" class="layui-input" lay-verify="required" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">身份证</label>
        <div class="layui-input-inline">
            <input type="text" name="empCard" autocomplete="off" class="layui-input" lay-verify="identity" >
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">薪水</label>
        <div class="layui-input-inline">
            <input type="text" name="empSalary" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-inline">
            <input type="text" name="empPhone" id="empPhone" autocomplete="off" class="layui-input" maxlenth="11" lay-verify="phone">${empPhoneError}
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">紧急联系人</label>
        <div class="layui-input-inline">
            <input type="text" name="empEmergencyContact" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">紧急联系电话</label>
        <div class="layui-input-inline">
            <input type="text" name="empEmergencyPhone" autocomplete="off" class="layui-input" lay-verify="phone1">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">岗位</label>
        <div class="layui-input-block">
            <select name="sStation" id="sStation" lay-verify="required" >
                <c:forEach var="list" items="${list}" >
                    <%--<c:forEach var="all" items="${list.sName}" >--%>
                    <option value="${list.empPositionId}">${list.SName}</option>
                    <%--<option value="1">总经理</option>--%>
                    <%--<option value="2">会计</option>--%>
                    <%--<option value="3">前台</option>--%>
                    <%--<option value="4">后勤</option>--%>
                    <%--<option value="5">技术</option>--%>
                    <%--<option value="4">后勤</option>--%>
                    <%--</c:forEach>--%>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">个人描述</label>
        <div class="layui-input-block">
            <input type="text"style="height: 80px;width: 400px" name="empDescribe" autocomplete="off" class="layui-input" >
        </div>
    </div>


    <script type="text/javascript">
        layui.use(['form'], function () {
            var form = layui.form;
            //自定义验证规则
            form.verify({
                title: function (value, item) {
                    if (value.length < 5) {
                        return '标题至少得5个字符啊';
                    }
                }, fname: function (value) {
                    if (value.length < 4) {
                        return '请输入至少4位的用户名';
                    }
                }, contact: function (value) {
                    if (value.length < 4) {
                        return '内容请输入至少4个字符';
                    }
                }
                , phone: [/^1[3|7|8]\d{9}$/, '手机必须11位，只能是数字！']
                , email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']
                , identity:[/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/, '身份证格式不对']
                ,phone1: [/^1[3|7|8]\d{9}$/, '手机必须11位，只能是数字！']
                ,age:[/^(1[89]|[2-5]\d|60)$/,'年龄必须小等于60岁']
            });
        });
     </script>

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
            console.log(data.field);
            layer.msg(JSON.stringify(data.field));
            var val = $("#sStation").val();
            $.ajax({
                type: "post",
                url: "/empAdd",
                data: {
                    "empCode": data.field.empCode,
                    "empName": data.field.empName,
                    "headImg": data.field.headImg,
                    "empSex": data.field.empSex,
                    "empAge":data.field.empAge,
                    "empNation": data.field.empNation,
                    "empCard": data.field.empCard,
                    "empSalary": data.field.empSalary,
                    "empPhone": data.field.empPhone,
                    "empEmergencyContact": data.field.empEmergencyContact,
                    "empEmergencyPhone": data.field.empEmergencyPhone,
                    "sStation":val,
                    "empDescribe": data.field.empDescribe,
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
