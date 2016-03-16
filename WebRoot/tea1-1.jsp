<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8"%>
<%@ page import="beans.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="db.dao.*" %>
<%@ page import="servlet.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>老师用户——最新公告</title>
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
</head>
	
<body>
<!-- banner-body -->
	<div class="banner-body page">
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
						   <a class="navbar-brand" href="tea1.html">学生考试系统</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="hvr-bounce-to-bottom active"><a href="Trequest.jsp">发布信息</a></li>
							<li class="hvr-bounce-to-bottom "><a href="manager_student1.jsp">班级管理</a></li>
							<li class="hvr-bounce-to-bottom"><a href="manager_questions.jsp">题库管理</a></li>
                            <li class="hvr-bounce-to-bottom"><a href="servlet/SetScore">评分管理</a></li>
                            <li class="hvr-bounce-to-bottom"><a href="tea5.jsp">个人信息</a></li>
						  </ul>
						  <div class="sign-in">
							<ul>
                            <li><a href="index.html">退出登录</a></li>
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
<!-- pages -->
			<div class="pages">
				<div class="headdings">
					<div class="about-text-info">
                   <div class="col-md-11">
                   <h4>所有公告</h4></div>
                    </div>
                    <div class="clearfix"> </div>
                    <div class="about-text-info noticeshow">
					<div class="panel-group" id="accordion">
  
    
      <%
        NoticeDao noticeDao=new NoticeDao();
        List<Notice> notices=noticeDao.query();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String content=null;
        String date=null;
        int i=0;
        for(Notice notice: notices){       
            String title=notice.getNtitle();
            content=notice.getNcontent();
            String tno=notice.getTno();
            date=sdf.format(new Date(notice.getNtime().getTime()));
            String eno=notice.getEno();
            System.out.println(eno);   
            
            if(eno!=null){
            
   %>
   <div class="panel panel-default">
   	 <div class="panel-heading">
      <h4 class="panel-title">
      <a href="servlet/StartExamServlet?eno=<%=eno%>&title=<%=title %>"  data-toggle="collapse" data-parent="#accordion" ><%=title%>&nbsp;&nbsp;&nbsp;<%=date%></a></h4></div>
      <div class="panel-title" style="text-align: center;"><p style="font-size:20px;"><%=content %></p></div>
    </div>  
    
    <%}else{%>  
    <div class="panel panel-default">
   	 <div class="panel-heading">
      <h4 class="panel-title">
      <a href="show_content.jsp?tno=<%=tno%>" data-toggle="collapse" data-parent="#accordion" ><%=title%>&nbsp;&nbsp;&nbsp;<%=date%></a></h4></div>
      <div class="panel-title" style="text-align: center;"><p style="font-size:20px;"><%=content %></p></div>
    </div>  
   <%
   		}
   		i++;
   	}%>
    
</div>	
          <div class="clearfix"> </div>         
					</div>
        
				</div>
			</div>
<!-- //pages -->
		</div>
	</div>
<!-- footer -->

	<div class="footer-bottom">
		<div class="container">
			<p>信六小组出品 | <a href="#" target="_blank" title="关于我们">关于我们</a></p>
		</div>
	</div>
<!-- //footer -->
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
<!-- //for bootstrap working -->
</body>
</html>
