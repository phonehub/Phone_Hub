<%@ page language="java" 
import="java.util.*" 
import="cn.edu.zhku.phonehub.order.model.ShowPreviewOrder"
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

		<title>预览订单页面</title>

		<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />

		<link href="./basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="./css/cartstyle.css" rel="stylesheet" type="text/css" />

		<link href="./css/jsstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="./js/address.js"></script>
  </head>

  <body>
   <%
  	ArrayList<ShowPreviewOrder> showPreviewOrder = (ArrayList<ShowPreviewOrder>)request.getAttribute("showPreviewOrder");
  	session.setAttribute("previewOrder",showPreviewOrder); //再将预览的商品信息传给CommitOrderCtrl
	String name = null;
	String phone = null;
	String province = null;
	String city = null;
	String detailAddress = null;
	float sum_price = 0;
	if(showPreviewOrder==null){
		%>
		<script>window.alert('<%="预览订单失败"%>');</script>
		<%
	}
	else{ 
		name = showPreviewOrder.get(0).getUserName();
		phone = showPreviewOrder.get(0).getPhone();
		province = showPreviewOrder.get(0).getProvince();
		city = showPreviewOrder.get(0).getCity();
		detailAddress = showPreviewOrder.get(0).getDetailAddress();
	}
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
				<div class="logo"><img src="./Image/logo.png" /></div>
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
						<h3>确认收货地址 </h3>
						<div class="clear"></div>
						<ul>
							<div class="per-border"></div>
							<li class="user-addresslist defaultAddr">

								<div class="address-left">
									<div class="user DefaultAddr">
										<span class="buy-address-detail">   
                   						<span class="buy-user">姓名：<input onchange="" type="text" id="take_name" value=<%=name %>></span>
										
										</span>
									</div>
									<div class="user DefalutAddr">
										<span class="buy-address-detail">  
										<span class="buy-phone">电话：<input type="text" id="take_phone" value=<%=phone %>></span>
										</span>
									</div>
									
									<div class="default-address DefaultAddr">
										<span class="buy-line-title buy-line-title-type">收货地址：</span><br>
										<span class="buy--address-detail">
								   		<span class="province"><input type="text" id="take_province" value=<%=province %>></span>
										<span class="city"><input type="text" id="take_city" value=<%=city %>></span>
										<span class="street"><input type="text" id="take_detailAddress" value=<%=detailAddress %>></span>
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
  					<!--物流 -->
					<div class="logistics">
						<h3>选择物流方式</h3>
						<ul class="op_express_delivery_hot">
							<li data-value="yuantong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -468px"></i>圆通<span></span></li>
							<li data-value="shentong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -1008px"></i>申通<span></span></li>
							<li data-value="yunda" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -576px"></i>韵达<span></span></li>
							<li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right" style="background-position:0px -324px"></i>中通<span></span></li>
							<li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--支付方式
					<div class="logistics">
						<h3>选择支付方式</h3>
						<ul class="pay-list">
							<li class="pay card"><img src="./images/wangyin.jpg" />银联<span></span></li>
							<li class="pay qq"><img src="./images/weizhifu.jpg" />微信<span></span></li>
							<li class="pay taobao"><img src="./images/zhifubao.jpg" />支付宝<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>
  					-->
  				<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
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
  						if(showPreviewOrder!=null){
							for(int i=0;i<showPreviewOrder.size();i++){
								sum_price +=showPreviewOrder.get(i).getPrice()*showPreviewOrder.get(i).getNum();
					%>
  						
  						<tr class="item-list">
								<div class="bundle  bundle-last">

									<div class="bundle-main">
										<ul class="item-content clearfix">
											<div class="pay-phone">
												<li class="td td-item">
													<div class="item-pic">
														<a href="#" class="J_MakePoint">
															<img src="/PhoneHub/Image/<%=showPreviewOrder.get(0).getImage1()%>" width="80px" height="80px"  class="itempic J_ItemImg"></a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a href="./servlet/SearchProductCtrl?searchType=商品&searchInfo=<%=showPreviewOrder.get(i).getProductName() %>" class="item-title J_MakePoint" data-point="tbcart.8.11"><%=showPreviewOrder.get(i).getProductName() %></a>
														</div>
													</div>
												</li>
												<li class="td td-info">
													<div class="item-props">
														<span class="sku-line">颜色：<%=showPreviewOrder.get(i).getColor() %></span>
														<br>
														<span class="sku-line">内存：<%=showPreviewOrder.get(i).getRam() %></span>
														<br>
														<span class="sku-line">网络：<%=showPreviewOrder.get(i).getNetworkType() %></span>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price price-promo-promo">
														<div class="price-content">
															<em class="J_Price price-now"><%=showPreviewOrder.get(i).getPrice() %></em>
														</div>
													</div>
												</li>
											</div>
											<li class="td td-amount">
												<div class="amount-wrapper ">
													<div class="item-amount ">
														<span class="phone-title">购买数量</span>
														<div class="item-props">
															<span class="sku-line"><%=showPreviewOrder.get(i).getNum() %></span>
															<!--<input class="text_box" name="" type="text" value=<%=showPreviewOrder.get(i).getNum() %> style="width:30px;" />  -->
														</div>
													</div>
												</div>
											</li>
											<li class="td td-sum">
												<div class="td-inner">
													<em tabindex="0" class="J_ItemSum number"><%=showPreviewOrder.get(i).getPrice()*showPreviewOrder.get(i).getNum() %></em>
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
  				<div class="pay-total">
						<!--留言-->
							<div class="order-extra">
								<div class="order-user-info">
									<div id="holyshit257" class="memo">
										<label>买家留言：</label>
										<input type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
										<div class="msg hidden J-msg">
											<p class="error">最多输入500个字符</p>
										</div>
									</div>
								</div>
							</div>
  					<div class="clear"></div>
				</div>
				
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
									<script type="text/javascript">
										function submit(){
											var name = document.getElementById("take_name").value;
											var phone = document.getElementById("take_phone").value;
											var province = document.getElementById("take_province").value;
											var city = document.getElementById("take_city").value;
											var detailAddress = document.getElementById("take_detailAddress").value;
											alert(name+phone+province+city+detailAddress);
											window.location.href="./servlet/CommitOrderCtrl?name="+name+"&phone="+phone+"&province="+province+"&city="+city+"&detailAddress="+detailAddress;
										}		
									
									</script>
									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">		<!-- href="./servlet/CommitOrderCtrl" -->
											<a id="J_Go" onclick="submit()"  class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
										</div>
										<div class="go-btn-wrap">
											<a id="J_Go" href="./servlet/ShowShopcartCtrl" class="btn-go" tabindex="0" title="点击此按钮，提交订单">返回</a>
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
