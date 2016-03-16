<!-- 响应教务员登录，教师管理，学生管理-->
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
<title>管理员用户</title>
<base href="<%=basePath%>">
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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
</head>
  <body>
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
						   <a class="navbar-brand" href="javascript:window.location.href='Drequest.jsp'">学生考试系统</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							<li class="hvr-bounce-to-bottom active"><a href="javascript:window.location.href='Drequest.jsp'">登录信息</a></li>
							<li class="hvr-bounce-to-bottom "><a href="manager_student.jsp">学生管理</a></li>
							<li class="hvr-bounce-to-bottom"><a href="manager_teacher.jsp">教师管理</a></li>
                            <li class="hvr-bounce-to-bottom"><a href="javascript:window.location.href='D_Personal_Info.jsp'">个人信息</a></li>
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
					<h4>登录成功</h4>
					<% request.setCharacterEncoding("utf-8"); %>
    	<%
    			Teacher teacher=new Teacher();
    			teacher=((Teacher)request.getSession().getAttribute("teacher"));
    	 %>
					<h5>欢迎您！<%=teacher.getTname()%></h5>
					<h5>管理员号 ：<%=teacher.getTno() %></h5>
                    <h5>管理权限：所有</h5>
				</div>
			<!-- 	<div class="col-md-8 about-text-info well"> -->
<!--                 <div class="stunotice"> -->
                <img alt="" src="images/jiaowu.jpg" style="width:650px;height:235px;margin-left:30px;">          

<div class="clearfix"> </div>
			<!-- </div> -->
  </div>  
			<div class="headdings">
		<div class="headdings">
					<div class="clearfix"> </div>
					</div>
			 </div>
    </div>
    </div>
<!-- footer -->

	<div class="footer-bottom">
		<div class="container">
			<p>信六小组出品 | <a href="" target="_blank" title="关于我们">关于我们</a></p>
		</div>
	</div>
            </div>
<!-- //footer -->
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
  </body>
</html>
