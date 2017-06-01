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

		<title>修改账户密码</title>

		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="../css/infstyle.css" rel="stylesheet" type="text/css">
		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/stepstyle.css" rel="stylesheet" type="text/css">		
        <script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>		
		  <script>
  function check() {
	var p1=document.getElementById("user-new-password");
	var p2=document.getElementById("user-confirm-password");
	var p3=document.getElementById("user-old-password");
     if (p1.value.length<6||p1.value.length>20) {
        alert("用户名不合规格,长度要在[6,20]");
        return false;
    } 
     if (p1.value!=p2.value) {
        alert("两次输入密码不一致！");
        return false;
    }
    if(p3.value==p1.value){
     alert("不能与原密码一致！");
        return false;
    }
    return true;
}
function formsubmit() {
	    if(!check())
		    return false;
	
		document.form.action = "/PhoneHub/user/ModifyCtrl";
		document.form.submit();
		alert("成功");
		}
		
  </script>	
	</head>

	<body>
	 <% String name =(String)session.getAttribute("userName");
	   
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
									<a  target="_top" class="h">欢迎你,<%=name %></a>
									
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
						</div>

						<div class="clear"></div>
						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<li><img src="../Image/logo.jpg" /></li>
							</div>
							<script>
								function search(){
									var searchInfo = document.getElementById("searchInput").value;
									alert("searchInfo="+searchInfo);
									var search_form = document.getElementById("search_form");
									search_form.action="../servlet/SearchProductCtrl?searchType=商品&searchInfo="+searchInfo;
									search_form.submit();
								}
							</script>
							
							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form id="search_form" action="" method="post">
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input onclick="search()" id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
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

					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改密码</strong> / <small>Password</small></div>
					</div>
					<hr/>
					<!--进度条-->
				
					<form class="am-form am-form-horizontal" enctype="multipart/form-data"  method="post" name="form">
					  
						<div class="am-form-group">
							<label for="user-old-password" class="am-form-label">原密码</label>
							<div class="am-form-content">
								<input type="password" id="user-old-password" placeholder="请输入原登录密码" name="oldpassWord">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-new-password" class="am-form-label">新密码</label>
							<div class="am-form-content">
								<input type="password" id="user-new-password" placeholder="由数字、字母组合" name="passWord">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">确认密码</label>
							<div class="am-form-content">
								<input type="password" id="user-confirm-password" placeholder="请再次输入上面的密码">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">上传头像</label>
							<div class="am-form-content">
								<input type="file" name="HeadImage" value="上传头像"><br>
							</div>
						</div>
						 
						<div class="info-btn">
							<div class="am-btn am-btn-danger" onclick="formsubmit()">保存修改</div>
						</div>

					</form>

				</div>


				<!--底部-->
					<div class="footer">
						<div>
							<p align="center">
								Copyright &copy; 2017.PhoneHub Technology.
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
							<li><a href="../servlet/ConsumerSeeOrderCtrl">订单管理</a></li>
							
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