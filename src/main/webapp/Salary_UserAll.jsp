<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/9/2
  Time: 10:51
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
    <link rel="stylesheet" href="css/xadmin.css">
    <script src="jq/jquery-1.11.3.js"></script>
</head>
<body>
<div style="margin-left: 100px ; margin-top: 10px">
    <button class="layui-btn layui-btn-danger" id="but-removeBatch"><i class="layui-icon">&#xe640;</i> 批量删除</button>
</div>
<table class="layui-hide" id="demo" lay-filter="test"></table>
<script type="text/html" id="barDemo">
    <%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看详情</a>--%>
    <%--<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<div class="demoTable">
    请输入部门名：
    <div class="layui-inline">
        <input class="layui-input" name="username" id="username" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>


<div class="layui-tab layui-tab-brief" lay-filter="demo">
    <ul class="layui-tab-title">
        <li>日期</li>
        <li></li>
        <li>上传</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item">
            <div id="laydateDemo"></div>
        </div>
        <div class="layui-tab-item">
            <div id="pageDemo"></div>
        </div>
        <div class="layui-tab-item">
            <div class="layui-upload-drag" id="uploadDemo">
                <i class="layui-icon"></i>
                <p>点击上传，或将文件拖拽到此处</p>
            </div>
        </div>
        <div class="layui-tab-item">
            <div id="sliderDemo" style="margin: 50px 20px;"></div>
        </div>
    </div>
</div>

<script>

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider', 'util'], function () {
        var laydate = layui.laydate //日期
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider //滑块
            , util = layui.util
            , $ = layui.jquery;

        //批量删除
        $("#but-removeBatch").click(function () {
            var array = table.checkStatus('demo').data;
            if (array.length == 0) {
                layer.msg("请选择要删除的记录");
            } else {
                var ids = [];
                for (var i in array) {
                    ids.push(array[i].id);
                }

                $.ajax({
                    type: 'post',
                    url: '/ClassDeleteAll',
                    data: {
                        "ids[]": ids
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.code == 200) {
                            layer.msg("操作成功", {
                                icon: 6
                            });
                            table.reload('demo', {})
                        } else {
                            layer.msg("操作失败", {
                                icon: 5
                            });
                        }
                    }
                })
                // $.post('/deleteAll',{"ids[]":ids},'json',function () {
                //     if (flag){
                //        layer.msg("操作成功",{
                //            icon:6
                //         });
                //        table.reload()
                //     } else {
                //         layer.msg("操作失败",{
                //             icon:5
                //         });
                //     }
                // })
            }
        })
        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , height: 420
            , url: '/SalaryListAll' //数据接口
            , title: '操作记录表'
            , page: true //开启分页
            , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            , totalRow: false //开启合计行
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left', width: 80}
                , {field: 'id', title: 'ID', width: 100, sort: true, fixed: 'left'}
                , {field: 'peopleCode', title: '领薪人编码', width: 120, sort: true, totalRow: true}
                , {field: 'salaryPeople', title: '领薪人姓名', width: 150, sort: true}
                , {field: 'salary', title: '薪水', width: 160, sort: true}
                , {field: 'start', title: '计算开始日期', width: 160, sort: true}
                , {field: 'end', title: '计算结束日期', width: 160, sort: true}
                , {fixed: 'right', width: 330, align: 'center', toolbar: '#barDemo',}
            ]]
        });
        //批量删除
        var $ = layui.$, active = {
            reload: function () {
                var username = $('#username').val();
                //执行重载
                table.reload('demo', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        username: username,
                    }
                }, 'data');
            },
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.msg('添加');
                    xadmin.open("添加页面", "/allName", 1000, 650);
                    break;
                case 'update':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {
                        // layer.open({
                        //     title: '删除信息'
                        //     ,type: 1
                        //     ,closeBtn: false
                        //     ,area: '300px;'
                        //     ,shade: 0.8
                        //     ,id: 'LAY_layuipro'
                        //     ,btn: ['保存', '取消']
                        //     ,content: '是否删除'
                        //     ,success: function(layero){
                        //         var btn = layero.find('.layui-layer-btn');
                        //         btn.find('.layui-layer-btn0').click(function () {
                        //             $.ajax({
                        //                 //几个参数需要注意一下
                        //                 type: "post",//方法类型
                        //                 url: "/deleteAll",//url
                        //                 data:{"id":ids},
                        //                 dataType:"json",
                        //                 async:false,
                        //                 traditional: true,
                        //                 success: function (data) {
                        //                     console.log(data);//打印服务端返回的数据(调试用)
                        //                     if (200==data.code ) {
                        //                         alert("修改失败");
                        //                     }else{
                        //                         window.location.replace("Employee_UserAll.jsp");
                        //                     };
                        //                 },
                        //                 error : function() {
                        //                     alert("请稍后重试！");
                        //
                        //                         }
                        //             })
                        //         })
                        //     }
                        // });
                    }
                    break;
            }
            ;
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                layer.msg('查看操作');
                xadmin.open('查看信息', 'listAllById?id=' + obj.data.id, 1100, 650)

            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    layer.msg('删除' + data.id);
                    $.ajax({
                        type: 'post',
                        url: 'SalaryDelete',
                        data: {
                            id: obj.data.id,
                        },
                        dataType: 'json',
                        success: function (data) {
                            if (data.code == 200) {
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.msg("删除成功")
                            } else {
                                layer.msg("删除失败")
                            }
                        }
                    })
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if (layEvent === 'edit') {
                layer.msg('修改' + data.id);
                xadmin.open('修改界面', 'ClassesFindById?id=' + obj.data.id, 1200, 660)
            }
        });

        //执行一个轮播实例
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , height: 200
            , arrow: 'none' //不显示箭头
            , anim: 'fade' //切换动画方式
        });

        //将日期直接嵌套在指定容器中
        var dateIns = laydate.render({
            elem: '#laydateDemo'
            , position: 'static'
            , calendar: true //是否开启公历重要节日
            , mark: { //标记重要日子
                '0-09-23': '生日'
                , '2018-08-28': '新版'
                , '2018-10-08': '神秘'
            }
            , done: function (value, date, endDate) {
                if (date.year == 2017 && date.month == 11 && date.date == 30) {
                    dateIns.hint('一不小心就月底了呢');
                }
            }
            , change: function (value, date, endDate) {
                layer.msg(value)
            }
        });

        //分页
        // laypage.render({
        //     elem: 'pageDemo' //分页容器的id
        //     ,count: 100 //总页数
        //     ,skin: '#1E9FFF' //自定义选中色值
        //     //,skip: true //开启跳页
        //     ,jump: function(obj, first){
        //         if(!first){
        //             layer.msg('第'+ obj.curr +'页', {offset: 'b'});
        //         }
        //     }
        // });

        //上传
        upload.render({
            elem: '#uploadDemo'
            , url: '' //上传接口
            , done: function (res) {
                console.log(res)
            }
        });

        slider.render({
            elem: '#sliderDemo'
            , input: true //输入框
        });

        //底部信息
        var footerTpl = lay('#footer')[0].innerHTML;
        lay('#footer').html(layui.laytpl(footerTpl).render({}))
            .removeClass('layui-hide');
    });


    //时间
    //处理时间戳

</script>
</body>
</html>
