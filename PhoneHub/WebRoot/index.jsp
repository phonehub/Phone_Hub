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


	</head>

	<body>
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">亲，请登录</a>
						<a href="#" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="/PhoneHub/user/information.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="/PhoneHub/cart/showcart.jsp" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h">0</strong> </a>
					</div>
				</div>
			</ul>
		</div>

		<!--悬浮搜索框-->

		<div class="nav white">
			<div class="logo">
				<img src="./Image/logo.png" />
			</div>
			<div class="logoBig">
				<li>
					<img src="./Image/logo.png" height="90" width="200" />
				</li>
			</div>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form>
				<select size="1" name="searchType">
							<option value="品牌">
								品牌
							</option>
							<option value="商品" selected>
								商品
							</option>
							<option value="店铺">
								店铺
							</option>
					<select>
					<td>
						<input id="searchInput" name="index_none_header_sysc" type="text"
							placeholder="搜索"  style="width:50px" autocomplete="off">
							
					</td>
					<td>
						<input id="ai-topsearch" class="submit am-btn" value="搜索"
							index="1" type="submit">
					</td>
					
				</form>
			</div>
		</div>

		<div class="bannerTwo">
			<!--轮播 -->
			<div class="am-slider am-slider-default scoll" data-am-flexslider
				id="demo-slider-0">
				<ul class="am-slides">

					<li class="banner2">
						<a><img src="./Image/index/hongmiNote4x.jpg" weigth="300px"
								height="720px" /> </a>
					</li>
					<li class="banner3">
						<a><img src="./Image/index/xiaomi5c.jpg" weigth="300px"
								height="720px" /> </a>
					</li>
					<li class="banner4">
						<a><img src="./Image/index/meilan5s.jpg" weigth="300px"
								height="720px" /> </a>
					</li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<!-- 网页底部 -->
		>
		<div class="footer ">

			<div class="footer-bd ">
				<p>
					<a href="# ">PhoneHub</a>
					<a href="# ">合作伙伴</a>
					<a href="# ">联系我们</a>
					<a href="# ">网站地图</a>
					<em>©2017 PhoneHub Corporation. All rights reserved</em>
				</p>
			</div>
		</div>
	</body>
</html>
