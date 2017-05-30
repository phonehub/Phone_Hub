<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>PhoneHub</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
			type="text/css" />
		<link href="./AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
			type="text/css" />

		<link href="./basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="./css/hmstyle.css" rel="stylesheet" type="text/css" />
		<script src="./AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="./AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		
		
		<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,700|Raleway:300,300i,400,700" rel="stylesheet">

<!-- Favicon
============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

<!-- CSS  -->
<!-- Bootstrap CSS
============================================ -->
<link rel="stylesheet" href="cssindex/bootstrap.min.css">

<!-- font-awesome CSS
============================================ -->
<link rel="stylesheet" href="cssindex/font-awesome.min.css">

<!-- owl.carousel CSS
============================================ -->
<link rel="stylesheet" href="cssindex/owl.carousel.css">
<link rel="stylesheet" href="cssindex/owl.theme.css">

<!-- simple-overlay CSS
============================================ -->
<link rel="stylesheet" href="cssindex/simple-overlay.css">
		
<!-- main CSS
============================================ -->		
<link rel="stylesheet" href="cssindex/style.css">

<!-- responsive CSS
============================================ -->		
<link rel="stylesheet" href="cssindex/responsive.css">


	</head>

	<body>
		<header id="header-section" class="navbar-fixed-top">
	<nav class="navbar navbar-default">
	  <div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<!-- logo -->
			<a class="navbar-brand" href="index.html">
				<div class="logo">
					<span>DOTAPPS</span>
				</div>
			</a>

		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

			<!-- menu list -->
		  <ul class="nav navbar-nav navbar-right">
			<li><a href="#screenshots-section" class="smoothScroll">商城首页</a></li>
			<li><a href="#pricing-section" class="smoothScroll">注册</a></li>
			<li><a href="#testimonial-section" class="smoothScroll hidden-sm">登录</a></li>                
			<li><a href="#subscribe-section" class="smoothScroll">购物车</a></li>
		  </ul>
		</div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
</header>
<!-- / END HEADER SECTION -->
<script>
 function keyup_submit(e){ 
	var evt = window.event || e; 
	if (evt.keyCode == 13){
		alert("success");
    }
  }
</script>
<!-- START BANNER SECTION -->
<section id="banner-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-5 col-sm-5">
				<div class="banner-mobile">
					<img src="Image/banner-mobile2.png" alt="banner-mobile" class="img-responsive" />
				</div>
			</div>
			<div class="col-lg-5 col-sm-7">
				<div class="banner-cont">
					<h1>Welcome to PhoneHub</h1>
					<p>我们----专注手机两星期</p>
					</br>
					<form>
						<input type="text" id="email" placeholder="Write your email here"  onkeydown=keyup_submit(); />
					</form>
				</div>
			</div>
			<div class="col-lg-2 col-sm-0"></div>
		</div>
	</div>
</section>

<!-- START FOOTER SECTION -->
<div id="footer-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="footer-cont">
					<p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://www.moke8.com/html/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
				</div>
			</div>
		</div>
	</div>
</div>
	</body>
</html>
