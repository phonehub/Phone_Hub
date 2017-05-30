<%@ page language="java" import="java.util.*,cn.edu.zhku.phonehub.user.model.User" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人资料</title>

		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/infstyle.css" rel="stylesheet" type="text/css">
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>			
	</head>

	<body>
	 <%   if(request.getAttribute("user")==null){
	          
	            RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/user/ModifyCtrl?methods=select"); //
				rd.forward(request, response); ;
	           return ;
	       }
	       User user = (User)request.getAttribute("user");
	  //  User user =(User)session.getAttribute("user");
	    String type =null;
	  %>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<a  target="_top" class="h">欢迎你,<%=user.getUserName() %></a>
									
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage home">
								<div class="menu-hd"><a href="../index.jsp" target="_top" class="h">商城首页</a></div>
							</div>
							<div class="topMessage my-shangcheng">
								<div class="menu-hd MyShangcheng"><a href="/PhoneHub/user/information.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="/PhoneHub/cart/showcart.jsp" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
							</div>
							<div class="topMessage favorite">
						
						</ul>
					
						<!--悬浮搜索框-->

							</div>
  	                            <div class="nav white" >
							<div class="logoBig">
								<li><img  src="../Image/logo.jpg" width="200px" alt="" /></li>
							</div>

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form>
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="../index.jsp">首页</a></li>
                               
							</ul>
						   
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-info">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
						</div>
						<hr/>

						<!--头像 -->
						<div class="user-infoPic">

							<div class="filePic">
								<img class="am-circle am-img-thumbnail"  src="/PhoneHub/<%=user.getHeadImage() %> " alt="" />
							</div>

							<p class="am-form-help">头像</p>

							<div class="info-m">
								<div></div>
								<div class="vip">
                                  
								</div>
							</div>
						</div>

						<!--个人信息 -->
						<div class="info-main">
							<form class="am-form am-form-horizontal">

								<div class="am-form-group">
									<label for="user-name2" class="am-form-label">用户名</label>
									<div class="am-form-content">
								     <input type="text" id="user-name2" placeholder="nickname"  readonly="readonly" value="<%=user.getUserName()%>">
									</div>
								</div>

					     <form class="am-form am-form-horizontal">

								<div class="am-form-group">
									<label for="user-name2" class="am-form-label">钱包</label>
									<div class="am-form-content">
								     <input type="text" id="user-name2" placeholder="nickname"  readonly="readonly" value="<%=user.getWallet() %>">
									</div>
								</div>
								 <form class="am-form am-form-horizontal">

								<div class="am-form-group">
									<label for="user-name2" class="am-form-label">用户类别</label>
									<div class="am-form-content">
									<%if(user.getPower()==3)
									     type="普通用户";
									     else if(user.getPower()==2)
									     type="商家";
									     else
									     type="超级管理员";
									   
									 %>
								     <input type="text" id="user-name2" placeholder="nickname"  readonly="readonly" value="<%=type %>">
									
									</div>
								</div>
							

							</form>
						</div>

					</div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
						
						</p>
					</div>
					<div class="footer-bd">
						<p>
							<a href="#">关于恒望</a>
							<a href="#">合作伙伴</a>
							<a href="#">联系我们</a>
							<a href="#">网站地图</a>
						</p>
					</div>
				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person active">
						<a href="index.html"><i class="am-icon-user"></i>个人中心</a>
					</li>
					<li class="person">
						<p><i class="am-icon-newspaper-o"></i>个人资料</p>
						<ul>
							<li> <a href="information.jsp">个人信息</a></li>
							<li> <a href="password.jsp">修改帐号密码</a></li>
							<li> <a href="modify.jsp">修改支付密码</a></li>
							<li> <a href="address.jsp">地址管理</a></li>
							
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-balance-scale"></i>我的交易</p>
						<ul>
							<li><a href="order.html">订单管理</a></li>
							
						</ul>
					</li>
					<% 
					int power = -1;
		             Integer inter = (Integer) session.getAttribute("power");
		            power = inter.intValue();
		            if(power<3){
		            
					%>
					<li class="person">
						<p><i class="am-icon-balance-scale"></i>我的店铺</p>
						<ul>
							<li><a href="/PhoneHub/storeManage/myStore.jsp">店铺管理</a></li>
							
						</ul>
					</li>
					<%
					}
					else{
						
					 %>
					 <li class="person">
						<p><i class="am-icon-balance-scale"></i>我的店铺</p>
						<ul>
							<li><a href="/PhoneHub/storeManage/createStore.jsp" target="page">创建店铺</a></li>
							
						</ul>
					</li>
					
					<%
					}
					 %>
					
				</ul>

			</aside>
		</div>

	</body>

</html>