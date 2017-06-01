<%@ page language="java" 
import="java.util.*" 
import="cn.edu.zhku.phonehub.product.model.*"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  		<base href="<%=basePath%>">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>搜索商品页面</title>

		<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="./AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="./basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="./css/seastyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="./basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="./js/script.js"></script>
	


  </head>
  
  <body>
  	<%
		ArrayList<SearchProductInfo> productList = (ArrayList<SearchProductInfo>)request.getAttribute("productList");
		Product productDetail = (Product)request.getAttribute("productDetail");
	 %>
  
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
					<div class="menu-hd"><a href="./index.jsp" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="./servlet/ConsumerSeeOrderCtrl" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
<!-- 测试用 -->
	<%
		request.getSession().setAttribute("userId",3);
	 %>
					<div class="menu-hd"><a id="mc-menu-hd" href="./servlet/ShowShopcartCtrl" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
			</ul>
			</div>

			<!--悬浮搜索框-->
			<div class="nav white">
				<div class="logo"><img src="./images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="./images/logobig.png" /></li>
				</div>

				<div>
					<form name="searchProduct" action="./servlet/SearchProductCtrl">
						<table align="center" border="1">
							<tr>
								<td>
									<div style="block-size:40px;">
										<select class="am-form-content address"  name="searchType">
											<option value="品牌">
												品牌
											</option>
											<option value="商品" selected>
												商品
											</option>
											<option value="店铺">
												店铺
											</option>
										</select>
									</div>
								</td>
								<td>
									<div>
										<input type="text" name="searchInfo" placeholder="搜索" value="">
										<!-- 
										<div class="am-form am-form-horizontal">
											<input type="text"  name="searchInfo" id="user-old-password" placeholder="输入查询信息" name="oldpassWord">
										</div>
										 -->
									</div>
									</td>
								<td>	
									<div>
										<input type="submit" value="查找">
									</div>
								</td>
							</tr>
						</table>
					</form>
					
					<!-- 
					<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn"  value="搜索" index="1" type="submit">
					</form>
					 -->
					
				</div>
			</div>

			<div class="clear"></div>
			<b class="line"></b>
           <div class="search">
			<div class="search-list">
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">搜索结果</span></div>
			</div>
					<div class="am-g am-g-fixed">
						<div class="am-u-sm-12 am-u-md-12">
	                  	<div class="theme-popover">														
							
							<div class="clear"></div>
                        </div>
							<div class="search-content">
								<div class="sort">
									<li class="first"><a title="综合" href="./servlet/SearchProductCtrl?searchType=<%="所有"%>&searchInfo=<%="无"%>">综合排序</a></li>
									<!--  <li><a title="销量">销量降序</a></li> -->
									<li><a title="价格" href="./servlet/SearchProductCtrl?searchType=<%="价格降序"%>&searchInfo=<%="无" %>">价格降序</a></li>
									<li><a title="价格" href="./servlet/SearchProductCtrl?searchType=<%="价格升序"%>&searchInfo=<%="无" %>">价格升序</a></li>
								</div>
								<div class="clear"></div> 

								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
									
									<script>
										function detail(productId){
											alert("productId="+productId);
											window.location.href="./servlet/ShowProductDetailCtrl?productId="+productId;
										}
									</script>
									<%
										if(productList!=null){
											for(int i=0;i<productList.size();i++){
									 %>
									
									<li>
										<div class="i-pic limit" >
											<img src="/PhoneHub/Image/<%=productList.get(i).getImage1()%>" onclick="detail(<%=productList.get(i).getProductId()%>)"/>											
											<p class="title fl">【<%=productList.get(i).getStoreName()%>】<%=productList.get(i).getProductName() %></p>
											<p class="price fl">
												<b>¥</b>
												<strong><%=productList.get(i).getPrice() %></strong>
											</p>
											<p class="number fl">
												销量<span>0</span>
											</p>
										</div>
									</li>
								
									<%
											}
									}
								 	%>
								 
								 <%
								 	if(productDetail!=null){
								  %>

								 
								<%
									}
								 %>								 
								 
								 
								</ul>
							</div>
							<div class="search-side">

								<div class="side-title">
									
								</div>

							</div>
							<div class="clear"></div>
							<!--分页 -->
						<!--  
							<ul class="am-pagination am-pagination-right">
								<li class="am-disabled"><a href="#">&laquo;</a></li>
								<li class="am-active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						-->
						</div>
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

			</div>

		<!--引导 -->
		<div class="navCir">
			<li><a href="home2.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>

		

  </body>
</html>
