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
	
		<title>订单管理</title>

		<link href="./AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="./css/personal.css" rel="stylesheet" type="text/css">
		<link href="./css/orstyle.css" rel="stylesheet" type="text/css">

		<script src="./AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="./AmazeUI-2.4.2/assets/js/amazeui.js"></script>
	

 	
	<script type="text/javascript">
		function pay(oid){
			var get=prompt("请输入密码");
			if(get!=null){
				//alert("已获得"+get);
				alert("获得"+oid);
				request.getSession().setAttribute("userPassword",get);
				self.location="./servlet/PayOrderCtrl?orderId="+oid;
			}
			else{
				alert("失败");
			}
		}
	</script>

  </head>
  
  <body>
    <%
    	//request.getSession().setAttribute("userPassword","0");
  		ArrayList<StoreSeeOrder> consumerSeeOrderList = (ArrayList<StoreSeeOrder>)request.getAttribute("consumerSeeOrderList");
  		if(consumerSeeOrderList==null){
  			%>
  				<script>window.alert('<%="获取订单失败"%>');</script>
  			<% 
  		}
  		PageBean pageBean = (PageBean)request.getAttribute("pageBean");
  		if(pageBean==null){
  			%>
  				<script>window.alert('<%="获取pageBean失败"%>');</script>
  			<% 
  		}
  		String result_msg = (String)request.getAttribute("result_msg");
  		if(result_msg!=null){
  			%>
  				<script>window.alert('<%=result_msg%>');</script>
  			<% 
  		}
  		//out.write("订单完成----consumerSeeOrderList="+consumerSeeOrderList.toString());
  	 	//out.write("订单----consumerSeeOrderList.size()="+consumerSeeOrderList.size());
  	 	//int orderId = showOrder.getOrderId();
  	 	//request.getSession().setAttribute("orderId",orderId);
  		%>
  	 	
  	 	
  	 	<%
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
								<div class="menu-hd"><a id="mc-menu-hd" href="./servlet/ShowShopcartCtrl" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
							</div>
						</ul>
						</div>

   						<!--悬浮搜索框-->

						<div class="nav white">
							<div class="logoBig">
								<li><img src="./Image/logo.jpg" /></li>
							</div>
							<script>
								function search(){
									var searchInfo = document.getElementById("searchInput").value;
									alert("searchInfo="+searchInfo);
									var search_form = document.getElementById("search_form");
									search_form.action="./servlet/SearchProductCtrl?searchType=商品&searchInfo="+searchInfo;
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
						<li class="index"><a href="#">首页</a></li>
					</ul>
				</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-order">
   
   					<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#tab1">所有订单</a></li>
								<!-- 
								<li><a href="#tab2">待付款</a></li>
								<li><a href="#tab3">待发货</a></li>
								<li><a href="#tab4">待收货</a></li>
								<li><a href="#tab5">待评价</a></li>
								 -->
								
							</ul>
   
							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
								<%
							   		int current_orderId;
							   		int front_orderId = 0;
							   		int next_orderId = 0;
							   		
							   		if(consumerSeeOrderList!=null)
										for(int i=0;i<consumerSeeOrderList.size();i++){
											current_orderId = consumerSeeOrderList.get(i).getOrderId(); 
								%>
										<div class="order-list">
											
											<!--交易成功-->
											<div class="order-status5">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;"><%=consumerSeeOrderList.get(i).getOrderId() %></a></div>
													<span>创建时间：<a href="javascript:;"><%=consumerSeeOrderList.get(i).getCreateTime() %></a></span>
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint">
																		<img src="/PhoneHub/Image/<%=consumerSeeOrderList.get(i).getImage1()%>" width="80ps" height="80ps" class="itempic J_ItemImg">
																	</a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<a href="#">
																			<p><%=consumerSeeOrderList.get(i).getProductName() %></p>
																			<br>
																			<p class="info-little">颜色：<%=consumerSeeOrderList.get(i).getColor() %> </p>
																		</a>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	<%=consumerSeeOrderList.get(i).getColor() %>
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span><%=consumerSeeOrderList.get(i).getNum() %>
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>

													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：<%=consumerSeeOrderList.get(i).getAmount() %>
																<p>包邮</p>
															</div>
														</li>
														<div class="move-right">
														<%
										   				String status = null;
												  	 	int status_ = consumerSeeOrderList.get(i).getStatus();
												  	 	//备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
												  	 	if(status_==1){
												  	 		status= "未付款";
												  	 	}
												  	 	else if(status_==2){
												  	 		status = "已付款未发货";
												  	 	}
												  	 	else if(status_==3){
												  	 		status = "已付款已发货";
												  	 	}
												  	 	else if(status_==4){
												  	 		status = "已收货";
												  	 	}
										   			 %>
													 <script>
													 	function pay(orderId){
													 		var pay_bt = document.getElementById("pay_bt");
													 		window.location.href="./servlet/PayOrderCtrl?orderId="+orderId;
													 	}
													 	function get(orderId){
													 		var get_bt = document.getElementById("get_bt");
													 		window.location.href="./servlet/GetProductCtrl?orderId="+orderId;
													 	}
													 </script>
															<li class="td td-status">
																<div class="item-status">
																	<p class="order-info"><a href=""><%=status %></a></p>
																	<p class="order-info"><a href="">订单详情</a></p>
																</div>
															</li>
															<li class="td td-change">
															<%
																if(status.equals("未付款")){  //pay(<=consumerSeeOrderList.get(i).getOrderId()>)
																	%>
																	<input value="付款" type="button" id="pay_bt" class="am-btn am-btn-danger anniu" onclick="pay(<%=consumerSeeOrderList.get(i).getOrderId()%>)" >
																	<%
																}
																else{
																	%>
																	<input value="付款" disabled="disabled" type="button" id="pay_bt" class="am-btn am-btn-danger anniu">
																	<%
																}
																if(status.equals("已付款已发货")){ 
																	%>
																	<input value="收货" type="button" id="get_bt" class="am-btn am-btn-danger anniu" onclick="get(<%=consumerSeeOrderList.get(i).getOrderId()%>)">
																	<%
																}
																else{
																	%>
																	<input value="收货" disabled="disabled" type="button" id="get_bt" class="am-btn am-btn-danger anniu" >
																	<%
																}
															 %>
															</li>
														</div>
													</div>
												</div>
											</div>
										</div>
									  <%
										}
										%>
									</div>
									<br>
									<br>
									<table  border="8" align="right">
										<tr>
											<td>每页<%=pageBean.getPageSize() %>行</td>
											<td>共<%=pageBean.getTotalRows() %>行</td>
											<td>页数<%=pageBean.getCurPage() %>/<%=pageBean.getTotalPages() %></td>
										</tr> 	
										<tr>
											<td><a href = "./servlet/ConsumerSeeOrderCtrl?page=<%=1%>">首页</a></td>
											<td><a href = "./servlet/ConsumerSeeOrderCtrl?page=<%=pageBean.getCurPage()+1%>">下一页</a></td>
											<td><a href = "./servlet/ConsumerSeeOrderCtrl?page=<%=pageBean.getCurPage()-1%>">上一页</a></td>
											<td><a href = "./servlet/ConsumerSeeOrderCtrl?page=<%=pageBean.getTotalPages()%> ">尾页</a></td>
										</tr>	 
									</table>
								</div>
							</div>

						</div>
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
			<aside class="menu">
				<ul>
					<li class="person active">
						<a href=""><i class="am-icon-user"></i>个人中心</a>
					</li>
					<li class="person">
						<p><i class="am-icon-newspaper-o"></i>个人资料</p>
						<ul>
							<li> <a href="./user/information.jsp">个人信息</a></li>
							<li> <a href="./user/password.jsp">修改帐号密码</a></li>
							<li> <a href="./user/modify.jsp">修改支付密码</a></li>
							<li> <a href="./user/address.jsp">地址管理</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-balance-scale"></i>我的交易</p>
						<ul>
							<li><a href="./servlet/ConsumerSeeOrderCtrl">订单管理</a></li>
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
