<!-- 响应教师登陆、管理试卷、管理班级、管理题库、评分、发布通知 -->
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
    
    <title>老师用户———发布信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
    	<% request.setCharacterEncoding("utf-8"); %>
    	<%
    			Teacher teacher=new Teacher();
    			teacher=((Teacher)request.getSession().getAttribute("teacher"));
    	 %>
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
						   <a class="navbar-brand" href="Trequest.jsp">学生考试系统</a>
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
								<li><a href="index1.jsp">退出登录</a></li>
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
					<h5><%=teacher.getTname()%>老师</h5>
					<p>您的教师号是 <%=teacher.getTno()%></p>
                    <p>您的所教班级是 <%=teacher.getTclass()%></p>
				</div>
				<div class="col-md-8 about-text-info well">
		<%
        NoticeDao noticeDao=new NoticeDao();
        List<Notice> notices=noticeDao.query();
        Date mdate=new Date(notices.get(0).getNtime().getTime());
        Notice n=notices.get(0);
        for(Notice notice: notices){      
            Date date=new  Date(notice.getNtime().getTime()) ;
            if(date.getTime()>mdate.getTime()){
            	mdate=date;
            	n=notice;
            }
         }
         String title=n.getNtitle();
         String content=n.getNcontent();
         request.getSession().setAttribute("content", content);
     %>
                <h4>最新公告</h4>
                <div class="stunotice">
<h3><%=title %></h3>

<p><%=content %></p>            
<p class="col-md-3"><a class="btn btn-primary btn-large " onclick="window.open('tea1-1.jsp')">更多公告 &raquo;</a></p>
<p class="col-md-3"><a class="btn btn-primary btn-large " onclick="window.open('set_notice.jsp')">添加公告 &raquo;</a></p>
<p class="col-md-3"><a class="btn btn-primary btn-large " onclick="window.open('tea1-3.jsp?submit=<%=1%>')">删除公告 &raquo;</a></p>                    
</div>
<div class="clearfix"> </div>
			</div>
  </div>  
			<div class="headdings">
                    <div class="col-md-6 about-text-info">
                        <div class="clearfix"> </div>
                <h4>试卷库</h4>
                 <br> 
                 <div class="list-group list-group-alternate"> 
                 <%
                       ExamDao examDao=new ExamDao();
                       List<Exam> exams=examDao.query();
                       for(Exam exam:exams){
                       		String eno=exam.getEno();%>
                       		<a href="servlet/StartExamServlet?eno=<%=eno %>" class="list-group-item">试卷<%=eno %></a>
                  <%     }
                  %>
                 <br></div>
                 <div class="row">
                 <form action="servlet/ExamServlet" method="post">
                 <div class="col-md-8">
                 <input type="text" class="form-control" name="eno" placeholder="请输入新建的试卷名称">
                     </div>
                     <div class="col-md-2"><input type="submit" class="btn btn-primary btn-large " name="submit" value="新建" /></div>
                     </form>
                     <br>
                     <form action="servlet/DelExam" method="post">
                     <div class="col-md-8">
                    <input type="text" class="form-control"  name="eno" placeholder="请输入删除的试卷名称" >
                     </div>
                     <div class="col-md-2"><input type="submit" class="btn btn-primary btn-large " name="submit" value="删除"/></div>
                     </form>
                        </div>
              <div class="clearfix"> </div>
			</div>
        <div class="col-md-6 about-text-info">
                        <div class="clearfix"> </div>
                <h4>已发布的试卷</h4>
                 <br>
                <div class="list-group list-group-alternate"> 
                <%
                		ExamDao examDao2=new ExamDao();
                       List<Exam> exams2=examDao.query();
                       List<String> enos=new ArrayList<String>();
                       notices=noticeDao.query();
                       for(Notice notice:notices){
                       		if(notice.getEno()!=null){
                       			enos.add(notice.getEno());
                       		}
                       }
                       for(Exam exam:exams2){
                       		String eno=exam.getEno();
                       		if(enos.contains(eno)){
                %>
                				<a href="servlet/StartExamServlet?eno=<%=eno %>" class="list-group-item">试卷<%=eno %></a>
                
                <%}} %>
                 <br>
                </div>
                 <div class="row">
                 <form action="Trequest.jsp">
                     <div class="col-md-2"><input type="submit" class="btn btn-primary btn-large " name="submit" value="添加试卷公告"  onclick="window.open('exam.jsp')"/></div>
                     </form >
                     <br>
                     <form action="Trequest.jsp">
                     <div class="col-md-2"><input type="submit" class="btn btn-primary btn-large " name="submit" value="删除试卷公告" onclick="window.open('tea1-3.jsp')"/></div>
                     </form>
                     
                   
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
	<a href="servlet/ExamServlet">新建试卷</a>
	<a href="exam.jsp">发布试卷</a>
	<a href="servlet/SetNotice">发布公告</a>
	<a href="servlet/SetScore">试卷评分</a>
	<a href="manager_student.jsp">班级信息</a>
	<a href="manager_questions.jsp">题库管理</a>
 
</html>
