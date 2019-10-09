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
        <label class="layui-form-label">岗位编号</label>
        <div class="layui-input-inline">
            <input type="text" name="sCode" autocomplete="off" class="layui-input" value="${byId.SCode}"
                   readonly="true">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">岗位名称</label>
        <div class="layui-input-inline">
            <input type="text" name="sName" value="${byId.SName} " autocomplete="off" class="layui-input"
                   readonly="true">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">所在部门</label>
        <div class="layui-input-inline">
            <input type="text" name="sPart" autocomplete="off" class="layui-input" value="${byId.SPart}"
                   lay-verify="required">
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">直接上级</label>
        <div class="layui-input-block">
            <input type="text" name="sSuper" autocomplete="off" class="layui-input" value="${byId.SSuper}"
                   lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">岗位类别</label>
        <div class="layui-input-block">
            <select name="sType" id="sType" lay-verify="required">
                <option value=" "></option>
                <option value="管理类">管理类</option>
                <option value="技术类">技术类</option>
                <option value="文职类">文职类</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">岗位职责描述</label>
        <div class="layui-input-block">
            <input type="text" style="height: 80px;width: 400px" name="sDescribe" autocomplete="off" class="layui-input"
                   value="${byId.SDescribe}" vlay-verify="required">
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
            var sType = $("#sType").val();
            $.ajax({
                type: "post",
                url: "/StationUpdate",
                data: {
                    "id": data.field.id,
                    "sCode": data.field.sCode,
                    "sName": data.field.sName,
                    "sPart": data.field.sPart,
                    "sSuper": data.field.sSuper,
                    "sType": sType,
                    "sDescribe": data.field.sDescribe,
                },
                dataType: 'json',
                success: function (data) {
                    if (data.code == 200) {
                        xadmin.close()
                        xadmin.father_reload()
                    } else {
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
