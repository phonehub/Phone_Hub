<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>

		<script src="../js/jquery.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>

		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="../css/common.css" />
		<link rel="stylesheet" type="text/css" href="../css/slide.css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="../css/flat-ui.min.css" />
		<link rel="stylesheet" type="text/css"
			href="../css/jquery.nouislider.css">

		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
			type="text/css" />
		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
			type="text/css" />

		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="../css/hmstyle.css" rel="stylesheet" type="text/css" />
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		
		<script type="text/javascript" src="../js/jquery-1.11.1.js"></script> 
	</head>
	<script type="text/javascript">
	window.onload=function(){
			var power = <%=session.getAttribute("power")%>;
			if(power==3||power==2){
				document.getElementById("superadmin").style.visibility="hidden";
				document.getElementById("superstore").style.visibility="hidden";
				document.getElementById("apply").style.visibility="hidden";
			}
	}
	</script>
	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">小主，欢迎回来</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="../index.jsp" target="_top" class="h">商城首页</a>
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
		<!-- 左部导航条 -->
		<div class="leftMeun" id="leftMeun">
			<div id="logoDiv">
				<p id="logoP">
					<span>MyStore</span>
				</p>
			</div>
			<div class="meun-item meun-item-active" >
				后台管理
			</div>
			<div class="meun-title">
				店铺管理
			</div>
			<div class="meun-item" >
				<a href="storeDetail.jsp" target="page">店铺信息</a>
			</div>
			<div class="meun-item" >
				<a href="xxxxxx.jsp" target="page">店铺订单</a>
			</div>
			<div class="meun-item" >
				<a href="saleAccount.jsp" target="page">商品销量</a>
			</div>
			<div class="meun-title">
				商品管理
			</div>
			<div class="meun-item">
				<a href="productList.jsp" target="page">商品列表</a>
			</div>
			<div class="meun-item">
				<a href="addProduct.jsp" target="page">添加商品</a>
			</div>
			<div class="meun-title" id="superadmin">
				超级管理
			</div>
			<div class="meun-item" id="superstore">
				<a href="storeList.jsp" target="page">店铺列表</a>
			</div>
		</div>
		<div>
			<iframe name="page" id="page" width="1150px" height="690px"
				style="border: 1px solid black; position: absolute; top: 35px; left: 200px;">

			</iframe>
		</div>


	</body>
</html>