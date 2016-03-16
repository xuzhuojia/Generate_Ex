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
    
<title>学生考试系统登录</title>
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
	<div class="banner-body logn">
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
						   <a class="navbar-brand" href="index.html">学生考试系统</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						
						  <div class="sign-in">
							<ul>
								<li><a href="login.html">请登录</a></li>
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
<!-- login-page -->
	<div class="login">
		<div class="login-grids">
            <div class="col-md-3"></div>
			<div class="col-md-6 log">
					 <h3 >登录</h3>
					 <p>欢迎您的登录，本考试系统支持学生、老师、管理员三种权限。</p>
					 <p>密码初始值为123456，如果忘记密码，请与管理员联系。</p>
					 <form action="servlet/InfoServlet" method="post">
						 <h5>账户名：</h5>	
						 <input type="text" value="" name="sno"><!-- 老师也用sno -->
						 <h5>密码：</h5>
						 <input type="password" name="spw"/><!-- 老师也用spw -->
                         <div class="control-group">
                         <div class="col-md-3">
                         <label class="radio" for="plogin">
                         <input type="radio" value="A" name="plogin">
                             学生</label></div>
                         <div class="col-md-3">
                         <label class="radio" for="plogin">
                         <input type="radio" value="A" name="plogin">
                         老师
                             </label></div>
                         <div class="col-md-3">
                         <label class="radio" name="plogin">
                         <input type="radio" value="A" name="plogin">
                         管理员</label>
                         </div></div>
						 <input type="submit" value="登录">
					 </form>
					
			</div>
			</div>
			
		</div>
	</div>
<!-- //login-page -->
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
