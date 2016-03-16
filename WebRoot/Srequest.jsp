<!-- 响应学生登陆以及判断考试状态,以及显示通知 -->
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="beans.*" %>
<%@ page import="db.dao.*" %>
<%@ page import="servlet.*" %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生用户———在线测试</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Quickly Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- tip -->

  </head>
  
  <body>
<!-- banner-body -->
    
	<div class="banner-body">
		<div class="container">
<!-- header -->
			<div class="header">
				<div class="header-nav">
					<nav class="navbar navbar-default">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
						  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						  </button>
						   <a class="navbar-brand" href="javascript:window.location.href='Srequest.jsp'">学生考试系统</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							<li class="hvr-bounce-to-bottom active"><a href="javascript:window.location.href='Srequest.jsp'">在线测试</a></li>
							<li class="hvr-bounce-to-bottom "><a href="javascript:window.location.href='SScoreQuery.jsp'">成绩查询</a></li>
							<li class="hvr-bounce-to-bottom"><a href="javascript:window.location.href='S_Personal_Info.jsp'">个人信息</a></li>
						  </ul>
						  <div class="sign-in">
							<ul>
								<li><a href="javascript:window.location.href='index1.jsp'">退出登录</a></li>
							</ul>
							</div>
						</div><!-- /.navbar-collapse -->
					</nav>
				</div>
	
			<!-- search-scripts -->
			<script src="js/classie.js"></script>
			<script src="js/uisearch.js"></script>
				<script>
					new UISearch( document.getElementById( 'sb-search' ) );
				</script>
			<!-- //search-scripts -->
			</div>
<!-- //header -->
<div class="pages">
            <br>
			<div class="headdings">
				<div class="col-md-4 about-text-info login-sucess">
				<% request.setCharacterEncoding("utf-8"); %>
    	<%
    			Student student=new Student();
    			student=((Student)request.getSession().getAttribute("student"));
    			
    	 %>
					<h4>登录成功</h4>
					<h5>欢迎您！<%=student.getSname()%></h5>
					<p>您的学号是 <%=student.getSno()%></p>
                    <p>您的班级是 <%=student.getSclass()%></p>
				</div>
				<div class="col-md-8 about-text-info well">
                <h4>最新公告</h4>
                <div contenteditable="true" class="stunotice">
<h3>13级信息安全期中考试通知</h3>

<p>同学们好！请于2016年5月10日（第二周星期四）下午三点进行在线期中考试，本次考试将会记入平时成绩，请同学相互告知，谢谢！董老师</p>

<p><a class="btn btn-primary btn-large " href="javascript:window.location.href='Srequest.jsp'">查看更多 &raquo;</a></p>
</div>
<div class="clearfix"> </div>
			</div>
  </div>  
			<div class="headdings">
                    <div class="col-md-12 about-text-info">
                        <div class="clearfix"> </div>
                <h4>待做测试</h4>
                 <br>      
                 <div class="list-group list-group-alternate"> 
                 <%
        NoticeDao noticeDao=new NoticeDao();
        List<Notice> notices=noticeDao.query();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        int i=0;
        for(Notice notice: notices){       
            String title=notice.getNtitle();
            String content=notice.getNcontent();
            String tno=notice.getTno();
            String date=sdf.format(new Date(notice.getNtime().getTime()));
            String eno=notice.getEno();
            System.out.println(eno);
            i++;
            if(eno!=null){
   %>
   			<a href="servlet/StartExamServlet?eno=<%=eno%>&title=<%=title %>" class="list-group-item" ><%=title%>&nbsp;&nbsp;&nbsp;<%=date %></a>
   <%}else{%>
   			<a href="show_content.jsp?tno=<%=tno%>" class="list-group-item" ><%=title%>&nbsp;&nbsp;&nbsp;<%=date%></a>
   		<% }
   		}
   		%> 
						</div>
              <div class="clearfix"> </div>
			</div>
       
					
					
					<div class="headdings">
					<div class="clearfix"> </div>
					</div>
			 </div>
    </div>
    </div>
<!-- footer -->

	<div class="footer-bottom">
		<div class="container">
			<p>信六小组出品 | <a href="#" target="_blank" title="关于我们">关于我们</a></p>
		</div>
	</div>
            </div>
<!-- //footer -->
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
<!-- //for bootstrap working -->
  </body>
</html>
