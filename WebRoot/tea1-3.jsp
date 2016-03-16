<!-- 响应登陆以及判断考试状态,以及显示通知 -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="beans.*" %>
<%@ page language="java" import="db.dao.*" %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>老师用户———删除公告</title>
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
    
    
<!-- <script type="text/javascript">   
function check(form){
var r=confirm("是否确认删除公告？");
    if (r==true) {
        
        submitpaper(form);
    }
    else{
    return false;
    window.close();
    }
}
   
function submitpaper(form){
    
    alert("删除公告成功！");
    
 //   window.close();
    $(form).submit();
}
</script> -->    
<script type="text/javascript">  
function check(form){
var r=confirm("是否确认删除公告？");
    if (r==true) {
        
        submitpaper(form);
    }else{
        return false;
    }
    
}
   
function submitpaper(form){
    
    alert("删除公告成功！");
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
	<div class="headdings">
                <div class="about-text-info">
                   <div class="col-md-11">
                   <h4>您发布的(试卷)公告</h4></div>
                    </div>
                 <br><br>      
        <div class="about-text-info noticeshow">
            <div class="clearfix"> </div>
            <form action="servlet/DelNotice" method="post" class="form-horizontal" role="form" name="dnotice" onsubmit="return check('dnotice')">
              <div class="panel panel-default">
    
      <%
      		List<Notice> notices=new ArrayList<Notice>();
      		List<Notice> notices2=new ArrayList<Notice>();
      		NoticeDao noticeDao=new NoticeDao();
      		notices=noticeDao.query();
      		
      		System.out.println(request.getParameter("submit"));
      		for(Notice notice : notices){
      			if(notice.getEno()!=null){
      				notices2.add(notice);
      				System.out.println(notices2.size());
      			}
      		}
      		if("1".equals(request.getParameter("submit"))){
      		
      			for(Notice notice : notices){
       %>
                     <div class="panel-heading">
      				<h4 class="panel-title">
        			<a data-toggle="collapse" data-parent="#accordion" 
          				href="#collapseOne">
          				<%=notice.getNtitle() %>
        			</a></h4></div>
        <%} }
        else{
                for(Notice notice2:notices2){
        %>
                     <div class="panel-heading">
      				<h4 class="panel-title">
        			<a data-toggle="collapse" data-parent="#accordion" 
          				href="#collapseOne">
          				<%=notice2.getNtitle() %>
        			</a>	</h4></div>
      <% }}%>
      
  </div> 
            <div class="col-md-2"></div>
            <div class="col-md-6">
            <div class="form-group">
            <select class="form-control input-lg"  name="selected">
          <%if("1".equals(request.getParameter("submit"))){
      		
      			for(int i=0;i<notices.size();i++){
       %>
                     
         			<option value="<%=notices.get(i).getTno()%>"><%=notices.get(i).getNtitle() %></option>
         			
        <%} }
        else{
                for(int i=0;i<notices2.size();i++){
        %>
         			<option value="<%=notices2.get(i).getTno()%>"><%=notices2.get(i).getNtitle() %></option>
         			
      <% }}%>
        </select>
          </div>
                </div> 
            <div class="col-md-2"><input class="btn btn-primary btn-large " type="submit"  value="删除此公告">
                </div>
                <div class="clearfix"> </div>
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