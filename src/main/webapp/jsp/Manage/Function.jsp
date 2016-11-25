<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <base href="<%=basePath%>">
	  <title>北航知识图谱·ACT</title>
	  <script src="js/ex/d3.min.js"></script>
	  <script src="js/ex/jquery.js"></script>
	  <script src="js/Manage/Function.js"></script>
	  <link rel="stylesheet" type="text/css" href="css/ex/bootstrap.css">
	  <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body onload="init('<%=basePath%>')">
    <jsp:include page="../include/sidebar.jsp" />
    <div class="container-fluid" >
	<div class="row-fluid" >
    <div class="span3" style="width:20%;height:100%" ></div>
	<div class="span9" style="width:80%;height:100%;" >
	<div style="width:100%;height:100%;overflow-x:hidden;overflow-y:auto">
		<ul class="thumbnails" style="font-family:微软雅黑;margin-top:50px;margin-bottom:50px;font-size:18px">
			<li class="span11">
				<div class="thumbnail">
					<h3 style="color:darkred">属性聚合</h3>
					<div id="container0"></div>
				</div>
			</li>
			<li class="span11">
				<div class="thumbnail">
					<h3 style="color:darkblue">属性划类</h3>
					<div id="container1"></div>
				</div>
			</li>
			<li class="span11">
				<div class="thumbnail">
					<h3 style="color:darkgreen">类别体系</h3>
					<div id="container2"></div>
				</div>
			</li>
			<li class="span11">
				<div class="thumbnail">
					<h3 style="color:purple">实体融合</h3>
					<img style="margin-top:20px;" src="img/display/pic002.png" />
					<img src="img/display/pic003.png" />
				</div>
			</li>
		</ul>
	</div>
	</div>
	</div>
	</div>
  </body>
</html>