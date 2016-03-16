<!-- 响应登陆以及判断考试状态,以及显示通知 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="beans.*" %>
<%@ page import="db.dao.*" %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试公告显示</title>
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
  <%
        NoticeDao noticeDao=new NoticeDao();
        List<Notice> notices=noticeDao.query();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(Notice notice: notices){       
            String title=notice.getNtitle();
            String content=notice.getNcontent();
            request.getSession().setAttribute("content", content);
            String date=sdf.format(new Date(notice.getNtime().getTime()));
            String eno=notice.getEno();
            System.out.println(eno);
            if(eno!=null){
   %>
   			<p><a href="servlet/StartExamServlet?eno=<%=eno%>"><%=title%></a>&nbsp;&nbsp;&nbsp;<span><%=date %></span></p>
   <%}else{%>
   			 <p><a href="show_content.jsp?title=<%=title%>"><%=title%></a>&nbsp;&nbsp;&nbsp;<span><%=date%></span></p>
   		<% }
   		}
   		%> 
  </body>
</html>
