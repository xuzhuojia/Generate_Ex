<!-- 学生查看自己各科考试的成绩列表 -->
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
    <title>学生用户——成绩查询</title>
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
						   <a class="navbar-brand" href="stu1.html">学生考试系统</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							<li class="hvr-bounce-to-bottom"><a href="javascript:window.location.href='Srequest.jsp'">在线测试</a></li>
							<li class="hvr-bounce-to-bottom  active"><a href="javascript:window.location.href='SScoreQuery.jsp'">成绩查询</a></li>
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
<!-- pages -->
			<div class="pages">
				<div class="headdings">
					<div class="col-md-12 about-text-info">
				<% request.setCharacterEncoding("utf-8"); %>
    	    <%  			
    	    SE se=new SE();
    	    se=((SE)request.getSession().getAttribute("se"));
    	  %>
    	  
    	   <table class="table">
							<thead>
								<tr>
									<th width="60%">测试标题</th>
									<th width="25%"></th>
                                    <th width="25%">详细结果</th>
								</tr>
							</thead>
							<tbody>
						  
						    <%
        NoticeDao noticeDao=new NoticeDao();
        List<Notice> notices=noticeDao.query();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        int i=0;
        for(Notice notice: notices){       
            String title=notice.getNtitle();
            String content=notice.getNcontent();
            request.getSession().setAttribute("content", content);
            String date=sdf.format(new Date(notice.getNtime().getTime()));
            String eno=notice.getEno();
            System.out.println(eno);
            i++;
            if(eno!=null){
   %>
   			<tr>
   					<td><%=title %></td>
				    <td></td> 
                    <td><a href="servlet/GetScore?eno=<%=eno%>">查看分数和答案</a></td>
			</tr>
   			
   			
   <%}
   		}
   		%> 
							</tbody>
						  </table>                    
					</div>
				    <div class="headdings">
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
			<p>信六小组出品 | <a href="http://www.cssmoban.com/" target="_blank" title="关于我们">关于我们</a></p>
		</div>
	</div>
<!-- //footer -->
<!-- for bootstrap working -->
		<script src="js/bootstrap.js"> </script>
<!-- //for bootstrap working -->
  </body>
</html>
