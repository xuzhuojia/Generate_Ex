<!-- 响应教师登陆、管理试卷、管理班级、管理题库、评分、发布通知 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="beans.*" %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试管理系统</title>
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
    <br>
    	<% request.setCharacterEncoding("utf-8"); %>
	<h1>登陆成功</h1>
	<h2>欢迎您<%=((Teacher)request.getAttribute("teacher")).getTname()%>
	</h2>
	<br>
	您的号码<%=((Teacher)request.getAttribute("teacher")).getTno()%><br>
	和班级是<%=((Teacher)request.getAttribute("teacher")).getTclass()%>

  </body>
</html>
