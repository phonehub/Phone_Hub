<%@ page language="java" 
import="java.util.*" 
import="cn.edu.zhku.phonehub.order.model.*"
import="java.util.ArrayList"

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
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>结算页面</title>

		<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="./basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="./css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="./css/jsstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="./js/address.js"></script>

  </head>
  
  <body>
  	<%
  		ShowOrder showOrder = (ShowOrder)request.getAttribute("showOrder");
  	 	//out.write("界面----showOrder="+showOrder.toString());
  	 	ArrayList<OrderProductInfo> productInfo = showOrder.getProductInfo();
  	 	
  	 	String name = null;
		String phone = null;
		String province = null;
		String city = null;
		String detailAddress = null;
		float sum_price = 0;
		if(showOrder==null){
			%>
			<script>window.alert('<%="获取订单失败"%>');</script>
			<% 
		}
		else{ 
			name = showOrder.getName();
			phone = showOrder.getPhone();
			province = showOrder.getProvince();
			city = showOrder.getCity();
			detailAddress = showOrder.getDetailAddress();
		}
  	 	//传输参数
  	 	int orderId = showOrder.getOrderId(); 
  	 	int userId = showOrder.getUserId();
  	 	String userPassword = "111";
  	 	
  	 	request.getSession().setAttribute("orderId",orderId);
  	 	request.getSession().setAttribute("userId",userId);
  	 	request.getSession().setAttribute("userPassword",userPassword);
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
					<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="./servlet/ConsumerSeeOrderCtrl" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="./servlet/ShowShopcartCtrl" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
			</ul>
			</div>
  	<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="./images/logobig.png" /></li>
				</div>

<script>
	function search() {
		var searchInfo = document.getElementById("searchInput").value;
		alert("searchInfo=" + searchInfo);
		var search_form = document.getElementById("search_form");
		search_form.action = "./servlet/SearchProductCtrl?searchType=商品&searchInfo="
				+ searchInfo;
		search_form.submit();
	}
</script>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form id="search_form" action="" method="post">
					<input id="searchInput" name="index_none_header_sysc" type="text"
						placeholder="搜索" autocomplete="off">
					<input onclick="search()" id="ai-topsearch" class="submit am-btn"
						value="搜索" index="1" type="submit">
				</form>
			</div>
		</div>

			<div class="clear"></div>
			
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<h3>收货地址 </h3>
						<div class="clear"></div>
						<ul>
							<div class="per-border"></div>
							<li class="user-addresslist defaultAddr">

								<div class="address-left">
									<div class="user DefaultAddr">
										<span class="buy-address-detail">   
                   						<span class="buy-user">姓名：<%=name %></span>
										
										</span>
									</div>
									<div class="user DefalutAddr">
										<span class="buy-address-detail">  
										<span class="buy-phone">电话：<%=phone %></span>
										</span>
									</div>
									
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span><br>
										<span class="buy--address-detail">
								   		<span class="province"><%=province %></span>
										<span class="city"><%=city %></span>
										<span class="street"><%=detailAddress %></span>
										</span>
									</div>
								</div>
								<div class="address-right">
									<a href="./person/address.html">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>
							</li>
						</ul>
						<div class="clear"></div>
					</div>
  
  				<!--支付方式-->
					<div class="logistics">
						<h3>选择支付方式</h3>
						<ul class="pay-list">
							<li class="pay card"><img src="./images/wangyin.jpg" />银联<span></span></li>
							<li class="pay qq"><img src="./images/weizhifu.jpg" />微信<span></span></li>
							<li class="pay taobao"><img src="./images/zhifubao.jpg" />支付宝<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>
  				<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>订单编号：<%=showOrder.getOrderId() %></h3>
							<h3>订单状态：未付款</h3>
							<h3>创建时间：<%=showOrder.getCreateTime() %></h3>
							<div class="cart-table-th">
								<div class="wp">
									<div class="th th-item">
										<div class="td-inner">商品信息</div>
									</div>
									<div class="th th-price">
										<div class="td-inner">单价</div>
									</div>
									<div class="th th-amount">
										<div class="td-inner">数量</div>
									</div>
									<div class="th th-sum">
										<div class="td-inner">金额</div>
									</div>
									<div class="th th-oplist">
										<div class="td-inner">配送方式</div>
									</div>
								</div>
							</div>
							<div class="clear"></div>
  					<%
  						if(productInfo!=null){
							for(int i=0;i<productInfo.size();i++){
								sum_price +=productInfo.get(i).getCost()*productInfo.get(i).getNum();
					%>
  						<tr class="item-list">
								<div class="bundle  bundle-last">

									<div class="bundle-main">
										<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
															<img src="./images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11"><%=productInfo.get(i).getProductName() %></a>
														</div>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														<span class="sku-line">颜色：<%=productInfo.get(i).getColor() %></span>
														<br>
														<span class="sku-line">内存：<%=productInfo.get(i).getRam() %></span>
														<br>
														<span class="sku-line">网络：<%=productInfo.get(i).getNetworkType() %></span>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<em class="J_Price price-now"><%=productInfo.get(i).getCost() %></em>
														</div>
													</div>
												</li>
											</div>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="item-props">
															<span class="sku-line"><%=productInfo.get(i).getNum() %></span>
															<!--<input class="text_box" name="" type="text" value=<%=productInfo.get(i).getNum() %> style="width:30px;" />  -->
														</div>
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number"><%=productInfo.get(i).getCost()*productInfo.get(i).getNum() %></em>
												</div>
											</li>
											<li class="td td-oplist">
												<div class="td-inner">
													<span class="phone-title">配送方式</span>
													<div class="pay-logis">
														<b class="sys_item_freprice">包邮</b>
													</div>
												</div>
											</li>

										</ul>
										<div class="clear"></div>
									</div>
							</tr>
							<div class="clear"></div>
							</div>
					<%
							}
						}
					%> 
					<!--信息 -->
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee"><%=sum_price %></em>
											</span>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
											<a id="J_Go" href="./servlet/PayOrderCtrl?orderId=<%=showOrder.getOrderId() %>" class="btn-go" tabindex="0" title="点击此按钮，提交订单">立刻付钱</a>
										</div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>
					<div class="clear"></div>
				</div>
			</div>
  </body>
</html>
