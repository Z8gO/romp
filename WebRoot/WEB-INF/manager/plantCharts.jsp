<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>PlantChart</title>

<script type="text/javascript" src="js/FusionCharts.js"></script>
</head>
<body style="text-align: center;">
	<div id="chartDiv"  ></div>
	<div style="text-align: right;width: 80%;text-decoration: none;"><a href="LoginSuccess">返回我的管理员首页</a></div>
	
		<script>
			var chart1=new FusionCharts(
		"<%=path%>/FusionCharts_Evaluation/Doughnut3D.swf",
					"chartDivID", "900", "600");     //创建对象，这里有三个参数
					//加载数据，设置数据文件
			chart1.setDataXML("${xmlstr}");    //直接加载动态的数据
				chart1.render("chartDiv");   //图片渲染的位置
		</script>
</body>
</html>
