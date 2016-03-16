<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>试题管理</title>
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
	<%request.setCharacterEncoding("utf-8");%>
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
						   <a class="navbar-brand" href="manager_questions.jsp">学生考试系统</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							<li class="hvr-bounce-to-bottom"><a href="Trequest.jsp">发布信息</a></li>
							<li class="hvr-bounce-to-bottom"><a href="manager_student1.jsp">班级管理</a></li>
							<li class="hvr-bounce-to-bottom   active"><a href="manager_questions.jsp">题库管理</a></li>
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
<!-- pages -->
			<div class="pages">
				<div class="headdings">
                    <div class="about-text-info">
                            <div class="col-md-12 well">
            <form class="form-horizontal" role="form" action="servlet/ManageQue" method="post" >
              <div class="form-group">
                <div class="col-sm-2">
                  <label  class="control-label">查看所有试题</label>
                </div>
                <div class="col-sm-10">
                  <!-- <a class="btn btn-primary btn-large " >点击查看所有试题</a> -->
                  
                  <input type="submit" name="submit" value="查看所有试题" class="btn btn-primary btn-large "/>
                  
                </div>
              </div>
              </form>
              <form class="form-horizontal" role="form" action="servlet/ManageQue" method="post" >
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">增加试题</label>
                </div>
                <div class="col-sm-3">
                   <div class="form-group">
                <!--  <select class="form-control">
                 <option value="">填空题</option>
                 <option value="">简答题</option>
                </select> -->
                <input type="text" name="qtype" value="输入试题类型" class="form-control"/>
               
   </div>
                </div>
                <div class="col-sm-3">
                  <!-- <input type="text" class="form-control" placeholder="试题题目"> -->
                   <input type="text" name="qcontent" value="输入题目" class="form-control"/>
                  
                </div>
                <div class="col-sm-3">
                  <!-- <input type="text" class="form-control" placeholder="试题标准答案"> -->
                  <input type="text" name="qanswer" value="输入题目的标准答案" class="form-control">
                </div>
                  <div class="col-sm-1">
                  <!--  <a class="btn btn-primary btn-large " >确定</a> -->
                   <input  type="submit" name="submit" value="增加题目" class="btn btn-primary btn-large "  />
                </div>
              </div>
              </form>
              <form class="form-horizontal" role="form" action="servlet/ManageQue" method="post" >
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="ncontent" class="ncontent">删除试题</label>
                </div>
                <div class="col-sm-9">
                <!--  <input type="text" class="form-control" placeholder="题号">    -->
                 <input type="text" name="qno"  value="题号" class="form-control"/>
                </div>
                <div class="col-sm-1">
                 <!-- <a class="btn btn-primary btn-large " >确定</a>   -->
                 <input  type="submit" name="submit" value="删除"  class="btn btn-primary btn-large " />
                </div>
              </div>
            
            </form>
            </div>
                    </div>
                    </div>
           <div class="clearfix"> </div>  
        <div class="about-text-info well">
  
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
  </body>
</html>
