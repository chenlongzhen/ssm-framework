<%--
  Created by IntelliJ IDEA.
  User: clz
  Date: 2020/4/12
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>柱状图演示</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
</head>

<body>
<a href="index.jsp">首页</a><br>
<a href="echarts/line.jsp">折线图演示</a><br>
<a href="echarts/pie.jsp">饼图演示</a><br>
<div id = "main" style="width: 600px;height: 400px;"></div>
<script type="text/javascript">
    var myecharts = echarts.init(document.getElementById('main'));
    var option = {
        backgroundColor:'#CC22FF',
        title:{
            text:'产品销量展示'
        },
        tooltip:{},
        legend:{
            data:['销量']
        },
        xAxis:{
            data:[]
        },
        yAxis:{},
        series:[{
            name:'销量',
            type:'bar',
            data:[]
        }]
    };
    myecharts.setOption(option);
    myecharts.showLoading();
    var names = [];
    var nums = [];
    $.ajax({
        url:'ProductServlet',
        type:'post',
        async:'true',
        data:{},
        dataType:'json',
        success:function(data){
            for(var i = 0 ; i < data.length ; i++){
                names.push(data[i].name);
                nums.push(data[i].num);
            }
            myecharts.hideLoading();
            myecharts.setOption({
                xAxis:{
                    data:names
                },
                series:[{
                    name:'销量',
                    data:nums
                }]
            });
        },
        error:function(){
            alert("图表数据加载失败");
            myecharts.hideLoading();
        }
    });
</script>
</body>
</html>
