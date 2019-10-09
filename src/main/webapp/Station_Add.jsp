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
        <label class="layui-form-label">岗位编码</label>
        <div class="layui-input-inline">
            <input type="text" name="sCode" autocomplete="off" class="layui-input"  lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">岗位名</label>
        <div class="layui-input-inline">
            <input type="text" name="sName" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">所在部门</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="text" name="sPart" autocomplete="off" class="layui-input" lay-verify="required">--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">所在部门</label>
        <div class="layui-input-block">
            <select name="sPart" id="sPart" lay-verify="required" >
                <c:forEach var="all" items="${all}" >
                    <option value="${all.departName}">${all.departName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">直接上级</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="text" name="sSuper" autocomplete="off" class="layui-input" >--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">直接上级</label>
        <div class="layui-input-block">
            <select name="sSuper" id="sSuper" lay-verify="required" >
                <c:forEach var="list" items="${all}" >
                    <option value="${list.departCode}">${list.departName}</option>
                </c:forEach>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">岗位类别</label>
        <div class="layui-input-block">
            <select name="sType" id="sType"  >
                <option value=" "></option>
                <option value="管理类">管理类</option>
                <option value="技术类">技术类</option>
                <option value="文职类">文职类</option>
            </select>
        </div>
    </div>

    <%--<div class="layui-form-item">--%>
        <%--<label class="layui-form-label">岗位类别</label>--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="text" name="sType" autocomplete="off" class="layui-input" lay-verify="required">--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">部门职责描述</label>
        <div class="layui-input-block">
            <input type="text"style="height: 80px;width: 400px" name="sDescribe" autocomplete="off" class="layui-input" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">岗位ID</label>
        <div class="layui-input-block">
            <input type="text" name="empPositionId" id="empPositionId" autocomplete="off" class="layui-input" placeholder="获取随机编码" >
        </div>
    </div>
 <%--唯一标识--%>
<script>
    var bm = getUuid();//编码
    $("#empPositionId").val(bm)
    function getUuid(){
        var len=16;//32长度
        var radix=16;//16进制
        var chars='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz./;@Daaxxcv'.split('');
        var
    uuid=[],i;radix=radix||chars.length;if(len){for(i=0;i<len;i++)uuid[i]=chars[0|Math.random()*radix];}else{var r;uuid[8]=uuid[13]=uuid[18]=uuid[23]='-';uuid[14]='4';for(i=0;i<36;i++){if(!uuid[i]){r=0|Math.random()*16;uuid[i]=chars[(i==19)?(r&0x3)|0x8:r];}}}
        return uuid.join('');
    }

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
            layer.msg(JSON.stringify(data.field));
            var val1 = $("#sPart").val();
            var val = $("#sType").val();
            var val2 = $("#sSuper").val();

            $.ajax({
                type: "post",
                url: "/StationAdd",
                data: {
                    "sCode": data.field.sCode,
                    "sName": data.field.sName,
                    "sPart": val1,
                    "sSuper": val2,
                    "sType": val,
                    "sDescribe": data.field.sDescribe,
                    "empPositionId":data.field.empPositionId,
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
