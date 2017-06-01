<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'modifyresult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  
		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="../css/infstyle.css" rel="stylesheet" type="text/css">
		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/stepstyle.css" rel="stylesheet" type="text/css">		
        <script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
        <script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>		
  </head>
  
  <body>
  <!--头 -->
     <% 
     String msg = "  ";
     if(request.getAttribute("MSG")!=null)
      msg = (String)request.getAttribute("MSG");
     String name = (String)session.getAttribute("userName");
      %>
   		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<a  target="_top" class="h">欢迎,<%=name %></a>
									
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
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改结果</strong> / <small>result</small></div>
					</div>
					<hr/>
					<!--进度条-->
				
					
					  
						<div class="am-form-group">
							<label for="user-old-password" class="am-form-label"></label>
						     
							<div class="am-form-content" align="center">
							  <h3><%=msg %></h3>
							  <a href="information.jsp" > 返回</a>
							</div>
						</div>
						<div class="am-form-group">
						
		
							</div>
						</div>
	
  
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">确认密码</label>
							
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
