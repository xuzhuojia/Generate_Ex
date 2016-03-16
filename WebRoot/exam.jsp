<!-- 响应登陆以及判断考试状态,以及显示通知 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="beans.*" %>
<%@ page import="db.dao.*" %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>老师用户———添加公告</title>
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
    
    
<script type="text/javascript">   
function check(form){
var r=confirm("是否确认添加公告？");
    if (r==true) {
        
        submitpaper(form);
    }
    
}
   
function submitpaper(form){
    var a = document.getElementById("ntitle");
    var c = document.getElementById("ncontent");
    if( a.value==0 | c.value==0 )
    {alert("请填写完全！");window.close(); return false;}
    else{
    alert("添加公告成功！");
    window.close();}
}    
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
						   <a class="navbar-brand" href="tea1.html">学生考试系统</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						 <ul class="nav navbar-nav">
							<li class="hvr-bounce-to-bottom active"><a href="Trequest.jsp">发布信息</a></li>
							<li class="hvr-bounce-to-bottom "><a href="manager_student.jsp">班级管理</a></li>
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
<div class="pages">
			<div class="headdings">
                <div class="about-text-info">
                   <div class="col-md-11">
                   <h4>最新公告</h4></div>
                        <div class="col-md-1"> 
                        </div>
                    </div>
                 <br><br>      
        <div class="col-md-12 well">
            <form action="servlet/SetNotice" method="post" class="form-horizontal" role="form" name="notice" onsubmit="return check('notice')"> 
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="ntitle" class="control-label">公告标题</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" name="ntitle" class="form-control" id="ntitle">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="time" class="control-label">发布的考试编号</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="ntime" name="eno" >
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="ncontent" class="ncontent">公告内容</label>
                </div>
                <div class="col-sm-10">
                    <textarea class="form-control" id="ncontent" style="height:120px" name="ncontent" ></textarea>
                </div>
              </div>
            <div class="col-md-3"></div>
            <div class="col-md-3"><input class="btn btn-primary btn-large " type="submit" value="确定"></div> 
            <div class="col-md-3"><input class="btn btn-primary btn-large " type="reset" value="重置"> </div>
            </form>
            </div>
              <div class="clearfix"> </div>
	
					<div class="clearfix"> </div>
					
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
