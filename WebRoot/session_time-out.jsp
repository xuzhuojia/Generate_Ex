<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会话超时</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    登录超时，等待重新登陆！<br>
    系统在 <span id="timeout">3.000</span> 秒后 将自动跳转到 
    <a href="index.jsp">考试管理系统登录首页</a>
    <%response.setHeader("refresh", "3;url=\"../index.jsp\""); %>
  </body>
</html>
