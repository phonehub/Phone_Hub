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
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	
	<title>付款结果页面</title>
	
	<link rel="stylesheet"  type="text/css" href="./AmazeUI-2.4.2/assets/css/amazeui.css"/>
	<link href="./AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
	<link href="./basic/css/demo.css" rel="stylesheet" type="text/css" />
	
	<link href="./css/sustyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="./basic/js/jquery-1.7.min.js"></script>

  </head>
  
  <body>
  <%
  		ShowOrder showOrder = (ShowOrder)request.getAttribute("showOrder");
  	 	//out.write("订单完成----showOrder="+showOrder.toString());
  	 	ArrayList<OrderProductInfo> productInfo = showOrder.getProductInfo();
  	 	
  	 	int orderId = showOrder.getOrderId();
  	 	request.getSession().setAttribute("orderId",orderId);
  	 	int userId = showOrder.getUserId();
  	 	request.getSession().setAttribute("userId",userId);
  	 	
  	 	String status = showOrder.getStatus();
  	 	String status_ = null;
  	 	//备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
  	 	if(status.equals("1")){
  	 	 	status_= "未付款";
  	 	}
  	 	else if(status.equals("2")){
  	 		status_ = "已付款未发货";
  	 	}
  	 	else if(status.equals("3")){
  	 		status_ = "已付款已发货";
  	 	}
  	 	else if(status.equals("4")){
  	 		status_ = "已收货";
  	 	}
  	 	
   %>
   <!--顶部导航条 -->
	<div class="am-container header">
	  <ul class="message-l">
	    <div class="topMessage">
	     <div class="menu-hd">
	       <a href="#" target="_top" class="h">亲，请登录</a>
	       <a href="#" target="_top">免费注册</a>
	     </div></div>
	  </ul>
	  <ul class="message-r">
	    <div class="topMessage home"><div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div></div>
	    <div class="topMessage my-shangcheng"><div class="menu-hd MyShangcheng"><a href="./servlet/ConsumerSeeOrderCtrl" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div></div>
	    <div class="topMessage mini-cart"><div class="menu-hd"><a id="mc-menu-hd" href="./servlet/ShowShopcartCtrl" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div></div>
	  </ul>
	</div>
	
   	<!--悬浮搜索框-->
	<div class="nav white">
		<div class="logo"><img src="./images/logo.png" /></div>
	    <div class="logoBig">
	      <li><img src="../images/logobig.png" /></li>
	    </div>
	<script>
		function search(){									
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
	
	<div class="take-delivery">
	 <div class="status">
	   <h2>您已成功付款</h2>
	   <div class="successInfo">
	     <ul>
	       <li>付款金额<em><%=showOrder.getAmount() %></em></li>
	       <div class="user-info">
	       	 <p>订单编号：<%=showOrder.getOrderId() %></p>
	         <p>收货人：<%=showOrder.getName() %></p>
	         <p>联系电话：<%=showOrder.getPhone() %></p>
	         <p>收货地址：
	         			<%=showOrder.getProvince() %>
	         			<%=showOrder.getCity() %>
	         			<%=showOrder.getDetailAddress() %></p>
	       </div>请认真核对您的收货信息，如有错误请联系客服 </ul>
	     <div class="option">
	       <span class="info">您可以</span>
	        <a href="./servlet/ConsumerSeeOrderCtrl" class="J_MakePoint">查看<span>所有订单</span></a>
	     </div>
	    </div>
	  </div>
	</div>
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
					<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a
						href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
						- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
						target="_blank">网页模板</a>
					</em>
				</p>
			</div>
		</div>

  </body>
</html>
