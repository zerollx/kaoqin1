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
        <label class="layui-form-label">部门编码</label>
        <div class="layui-input-inline">
            <input type="text" name="departCode" autocomplete="off" class="layui-input"  lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">部门名</label>
        <div class="layui-input-inline">
            <input type="text" name="departName" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">负责人</label>
        <div class="layui-input-inline">
            <input type="text" name="departLeading" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">部门职责</label>
        <div class="layui-input-block">
            <input type="text"style="height: 80px;width: 400px" name="departDuty" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">上级部门</label>
        <div class="layui-input-block">
            <select name="sStation" id="departSuperDepart"  >
                <%--<c:forEach var="allStation" items="${allStation}" >--%>
                    <%--<option value="${allStation}" >${allStation}</option>--%>
                    <option value=" "></option>
                    <option value="总裁室">总裁室</option>
                    <option value="财务部">财务部</option>
                    <option value="人力资源部">人力资源部</option>
                    <option value="市场部">市场部</option>
                    <option value="研发部">研发部</option>
                    <option value="后勤部">后勤部</option>
                <%--</c:forEach>--%>
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
            var val = $("#departSuperDepart").val();
            $.ajax({
                type: "post",
                url: "/add",
                data: {
                    "departCode": data.field.departCode,
                    "departName": data.field.departName,
                    "departLeading": data.field.departLeading,
                    "departDuty": data.field.departDuty,
                    "departSuperDepart":val,
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
