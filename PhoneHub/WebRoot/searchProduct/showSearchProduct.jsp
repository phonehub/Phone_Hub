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

	<title>商品详细信息页面</title>

	<link href="./AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
	<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="./basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link type="text/css" href="./css/optstyle.css" rel="stylesheet" />
	<link type="text/css" href="./css/style.css" rel="stylesheet" />

	<script type="text/javascript" src="./basic/js/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="./basic/js/quick_links.js"></script>

	<script type="text/javascript" src="./AmazeUI-2.4.2/assets/js/amazeui.js"></script>
	<script type="text/javascript" src="./js/jquery.imagezoom.min.js"></script>
	<script type="text/javascript" src="./js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="./js/list.js"></script>

  </head>
  
  <body>
  	 <%
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
				<div class="logo"><img src="./images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="./images/logobig.png" /></li>
				</div>
				<div class="search-bar pr">
					<form id="searchform" method="post">
						<input id="searchInput"  type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit"  onclick="search()">
						<script>
							function search(){
								var productName = document.getElementById("searchInput").value;
								alert("name="+productName);
								document.getElementById("searchform").action="./servlet/SearchProductCtrl?searchType=商品&searchInfo="+productName;
								document.getElementById("searchform").submit();
							}
						</script>
					</form>
				</div>
			</div>

			<div class="clear"></div>
            <b class="line"></b>
  	 
  	 <div class="listMain">

		<!--分类-->
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">商品详情</span></div>
			</div>

		  	 <script type="text/javascript">
					$(function() {});
					$(window).load(function() {
						$('.flexslider').flexslider({
							animation: "slide",
							start: function(slider) {
								$('body').removeClass('loading');
							}
						});
					});
				</script>
		  	 
		  	 <div class="scoll">
					<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<img src="./images/01.jpg" title="pic" />
								</li>
								<li>
									<img src="./images/02.jpg" />
								</li>
								<li>
									<img src="./images/03.jpg" />
								</li>
							</ul>
						</div>
					</section>
				</div>
		  	 <!--放大镜-->

				<div class="item-inform">
					<div class="clearfixLeft" id="clearcontent">

						<div class="box">
							<script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>

							<div class="tb-booth tb-pic tb-s310">
								<a href="./images/01.jpg"><img src="./images/01_mid.jpg" alt="细节展示放大镜特效" rel="./images/01.jpg" class="jqzoom" /></a>
							</div>
							<ul class="tb-thumb" id="thumblist">
								<li class="tb-selected">
									<div class="tb-pic tb-s40">
										<a ><img src="./images/01_small.jpg" mid="./images/01_mid.jpg" big="./images/01.jpg"></a>
									</div>
								</li>
								<li>
									<div class="tb-pic tb-s40">
										<a><img src="./images/02_small.jpg" mid="./images/02_mid.jpg" big="./images/02.jpg"></a>
									</div>
								</li>
								<li>
									<div class="tb-pic tb-s40">
										<a><img src="./images/03_small.jpg" mid="./images/03_mid.jpg" big="./images/03.jpg"></a>
									</div>
								</li>
							</ul>
						</div>

						<div class="clear"></div>
					</div>
		  	 		
		  	 		<div class="clearfixRight">

						<!--规格属性-->
						<!--名称-->
						<div class="tb-detail-hd">
							<h1>【<%=productDetail.getProductName()%>】</h1>
						</div>
						<div class="tb-detail-list">
							<!--价格-->
							<div class="tb-detail-price">
								<li class="price iteminfo_price">
									<dt>售价</dt>
									<dd><em>¥</em><b class="sys_item_price"><%=productDetail.getPrice() %></b>  </dd>                                 
								</li>
								<div class="clear"></div>
							</div>
		  	 		<!--销量-->
							<ul class="tm-ind-panel">
							<!-- 
								<li class="tm-ind-item tm-ind-sellCount canClick">
									<div class="tm-indcon"><span class="tm-label">月销量</span><span class="tm-count">1015</span></div>
								</li>
								<li class="tm-ind-item tm-ind-sumCount canClick">
									<div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count">6015</span></div>
								</li>
								<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
									<div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count">640</span></div>
								</li>
							 -->
								

							</ul>
							<div class="clear"></div>
		  	 		
		  	 		<!--各种规格-->
							<dl class="iteminfo_parameter sys_item_specpara">
								<dt class="theme-login"><div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div></dt>
								<dd>
									<!--操作页面-->
									<script type="text/javascript">
										function addormin(what){
											buy_num = document.getElementById("text_box").value;
											if(what==1){
												document.getElementById("text_box").value = buy_num -1;
											}
											else if(what==2){
												var ad=parseInt(buy_num)+parseInt(1);
												document.getElementById("text_box").value = ad;
											}
										}
									</script>
									<div class="theme-popover-mask"></div>

									<div class="theme-popover">
										<div class="theme-span"></div>
										<div class="theme-poptit">
											<a href="javascript:;" title="关闭" class="close">×</a>
										</div>
										<div class="theme-popbod dform">
											<form class="theme-signin" name="loginform" action="" method="post">

												<div class="theme-signin-left">

													<div class="theme-options">
														<div class="cart-title">颜色</div>
														<ul>
															<li class="sku-line selected"><%=productDetail.getColor() %><i></i></li>
														</ul>
													</div>
													<br>
													<div class="theme-options">
														<div class="cart-title">数量</div>
														<ul>
															<input id="min" class="am-btn am-btn-default" name="" type="button" value="-" onclick="" />
															<input id="text_box" name="" type="text" value="1" style="width:30px;" />
															<input id="add" class="am-btn am-btn-default" name="" type="button" value="+" onclick="" />
															<span id="Stock" class="tb-hidden">库存<span class="stock"><%=productDetail.getNum() %></span>件</span>
														</ul>
													</div>
													<div class="clear"></div>
												</div>
											</form>
										</div>
									</div>

								</dd>
							</dl>
							<div class="clear"></div>
						<br>
		  	 			<div class="pay">
							<li>
								<div class="clearfix tb-btn tb-btn-buy theme-login">
									<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="#">立即购买</a>
								</div>
							</li>
							<li>
								<div class="clearfix tb-btn tb-btn-basket theme-login">
									<a id="LikBasket" title="加入购物车" href="#"><i></i>加入购物车</a>
								</div>
							</li>
						</div>
		  	 			
					</div>
					<div class="clear"></div>
				</div>
  	 		<!-- introduce-->
				
				
				<div class="introduce">
  	 				<div class="introduceMain">
						<div class="am-tabs" data-am-tabs>
							<br>
							<br>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
										<span class="index-needs-dt-txt">宝贝详情</span></a>
								</li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" >
									<div class="J_Brand" >
										<div class="attr-list-hd tm-clear">
											<h4>产品参数：</h4></div>
										<div class="clear"></div>
										<ul id="J_AttrUL">
											<li title="" >产品名称:&nbsp;<%=productDetail.getProductName() %></li>
										</ul>
										<ul id="J_AttrUL" >
											<li title="">产品描述:&nbsp;<%=productDetail.getDescription() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">CPU型号:&nbsp;<%=productDetail.getCpu() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">运行内存:&nbsp;<%=productDetail.getRam() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">手机品牌:&nbsp;<%=productDetail.getBrand() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">屏幕大小:&nbsp;<%=productDetail.getScreenSize() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">体积:&nbsp;<%=productDetail.getSize() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">网络类型:&nbsp;<%=productDetail.getNetworkType() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">颜色:&nbsp;<%=productDetail.getColor() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">操作系统:&nbsp;<%=productDetail.getSystem() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">内存:&nbsp;<%=productDetail.getMemory() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">电池容量:&nbsp;<%=productDetail.getBattery()%></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">前置摄像头:&nbsp;<%=productDetail.getFrontCanmera()%></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">后置摄像头:&nbsp;<%=productDetail.getBehindCamera() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">核心数:&nbsp;<%=productDetail.getCoreNum() %></li>
										</ul>
										<ul id="J_AttrUL">
											<li title="">重量:&nbsp;<%=productDetail.getWeight() %></li>
										</ul>
										<div class="clear"></div>
									</div>

									<div class="details">
										<div class="attr-list-hd after-market-hd">
											<h4>商品细节</h4>
										</div>
										<div class="twlistNews">
											<img src="./images/tw1.jpg" />
											<img src="./images/tw2.jpg" />
											<img src="./images/tw3.jpg" />
										</div>
									</div>
									<div class="clear"></div>

								</div>

					<div class="clear"></div>
						<div class="footer">
							<div class="footer-hd">
								<p>
									<a href="#">恒望科技</a>
									<b>|</b>
									<a href="#">商城首页</a>
									<b>|</b>
									<a href="#">支付宝</a>
									<b>|</b>
									<a href="#">物流</a>
								</p>
							</div>
							<div class="footer-bd">
								<p>
									<a href="#">关于恒望</a>
									<a href="#">合作伙伴</a>
									<a href="#">联系我们</a>
									<a href="#">网站地图</a>
									<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
  	 			<!--菜单 -->
			<div class=tip>
				<div id="sidebar">
					<div id="wrap">
						<div id="prof" class="item">
							<a href="#">
								<span class="setting"></span>
							</a>
							<div class="ibar_login_box status_login">
								<div class="avatar_box">
									<p class="avatar_imgbox"><img src="./images/no-img_mid_.jpg" /></p>
									<ul class="user_info">
										<li>用户名：sl1903</li>
										<li>级&nbsp;别：普通会员</li>
									</ul>
								</div>
								<div class="login_btnbox">
									<a href="#" class="login_order">我的订单</a>
								</div>
								<i class="icon_arrow_white"></i>
							</div>

						</div>
						<div id="shopCart" class="item">
							<a href="./servlet/ShowShopcartCtrl">
								<span class="message"></span>
							</a>
							<p>
								购物车
							</p>
							<p class="cart_num">0</p>
						</div>
						<div id="asset" class="item">
							<a href="#">
								<span class="view"></span>
							</a>
							<div class="mp_tooltip">
								我的资产
								<i class="icon_arrow_right_black"></i>
							</div>
						</div>

						<!--回到顶部 -->
						<div id="quick_links_pop" class="quick_links_pop hide"></div>

					</div>

				</div>
				<div id="prof-content" class="nav-content">
					<div class="nav-con-close">
						<i class="am-icon-angle-right am-icon-fw"></i>
					</div>
					<div>
						我
					</div>
				</div>
				<div id="shopCart-content" class="nav-content">
					<div class="nav-con-close">
						<i class="am-icon-angle-right am-icon-fw"></i>
					</div>
					<div>
						购物车
					</div>
				</div>
			</div>
  </body>
</html>
