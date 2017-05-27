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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<div>
			<ul>
				<img alt="" src="Image/logo.jpg" height="50" weight="50" />
				<a href="首页">PhoneHub</a>
				<span>|</span>
				<a href="个人资料界面">我的</a>
				<span>|</span>
				<a href="购物车地址">购物车</a>
				<span>|</span>
			</ul>
		</div>
		<div>
			<div>
				热门型号
			</div>
			<div>
				<ul>
					<li>
						<a href="xxx.jsp">
						<img alt="" src="Image/logo.jpg" />
						<span><span>魅蓝 E2</span><span class="">6 期免息</span><em>￥1299 起</em></span>
						</a>
					</li>
					<li>
						<a href="xxx.jsp">
						<img alt="" src="Image/logo.jpg" />
						<span><span>魅蓝 E2</span><span class="">6 期免息</span><em>￥1299 起</em></span>
						</a>
					</li>
					<li>
						<a href="xxx.jsp">
						<img alt="" src="Image/logo.jpg" />
						<span><span>魅蓝 E2</span><span class="">6 期免息</span><em>￥1299 起</em></span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div>
		<ul>
		<li>了解我们</li>
		<li>联系我们<Li>
		</ul>
		<ul>
		<li>©2017 PhoneHub Corporation. All rights reserved<li>
		</ul>
		</div>
		
	</body>
</html>
