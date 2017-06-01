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

		<!-- Mobile specific metas
============================================ -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- Google web fonts
============================================ -->
		<link
			href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,700|Raleway:300,300i,400,700"
			rel="stylesheet">

		<!-- Favicon
============================================ -->
		<link rel="shortcut icon" type="image/x-icon" href="Image/index/favicon.png">

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

		<!-- modernizr js
============================================ -->
		<script src="js/modernizr.js"></script>

	</head>

	<body>

		<header id="header-section" class="navbar-fixed-top">
		<nav class="navbar navbar-default">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- logo -->
				<a class="navbar-brand" href="index.html">
					<div class="logo">
						<span>PhoneHub</span>
					</div> </a>

			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<!-- menu list -->
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="" class="smoothScroll">商城首页</a>
					</li>
					<li>
						<a href="../PhoneHub/user/register.html" class="smoothScroll">注册</a>
					</li>
					<li>
						<a href="../PhoneHub/user/login.html" class="smoothScroll hidden-sm">登录</a>
					</li>
					<li>
						<a href="./cart/showcart.jsp" class="smoothScroll">购物车</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
		</nav>
		</header>
		<!-- / END HEADER SECTION --> 
<script>
	function keyup_submit(e) {
		var event = arguments.callee.caller.arguments[0] || window.event;
		if(event.keyCode == 13){
			document.getElementById("search_bt").click();
		}
	}
</script>

<script type="text/javascript">
	function search_onclick(){
		var searchInfo = document.getElementById("email").value;
		alert("searchInfo="+searchInfo);
		window.location.href="./servlet/SearchProductCtrl?searchType=商品&searchInfo="+searchInfo;
	}
</script>
		<!-- START BANNER SECTION -->
		<section id="banner-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-5 col-sm-5">
					<div class="banner-mobile">
						<img src="Image/banner-mobile2.png" alt="banner-mobile"
							class="img-responsive" />
					</div>
				</div>
				<div class="col-lg-5 col-sm-7">
					<div class="banner-cont">
						<h1>
							Welcome to PhoneHub
						</h1>
						<p>
							我们----专注手机两星期
						</p>
						</br>
						<input type="text" id="email" placeholder="商品名称"
							onkeydown=keyup_submit(); />
						<input type="button" id="search_bt" onclick="search_onclick()">
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
							<p>
								Copyright &copy; 2017.Company name All rights reserved.
								<a target="_blank" href="">什么玩意</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- / END FOTTER SECTION -->


		<!-- JS -->

		<!-- jquery js -->
		<script src="js/jquery-3.1.1.js"></script>
		<!-- bootstrap js -->
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<!-- easing js -->
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
		<!-- mousescroll js -->
		<script type="text/javascript" src="js/mousescroll.js"></script>
		<!-- smoothscroll js -->
		<script type="text/javascript" src="js/smoothscroll.js"></script>
		<!-- owl carousel js -->
		<script type="text/javascript" src="js/owl.carousel.min.js"></script>
		<!-- wow js -->
		<script src="js/wow.min.js"></script>
		<!-- simple overlay video js -->
		<script src="js/simple-overlay.js"></script>
		<script>
	new WOW().init();
</script>
		<!-- Main js -->
		<script type="text/javascript" src="js/main.js"></script>

	</body>
</html>
