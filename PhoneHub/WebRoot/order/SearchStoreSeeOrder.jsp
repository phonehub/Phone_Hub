<%@page import="org.w3c.dom.Document"%>
<%@page import="cn.edu.zhku.phonehub.order.dao.StoreSeeOrderDao"%>
<%@ page language="java" import="java.util.*"
	import="cn.edu.zhku.phonehub.order.model.*"
	import="java.util.ArrayList" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>店铺订单管理</title>

		<link href="./AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
			type="text/css">
		<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
			type="text/css">

		<link href="./css/personal.css" rel="stylesheet" type="text/css">
		<link href="./css/orstyle.css" rel="stylesheet" type="text/css">

		<script src="./AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="./AmazeUI-2.4.2/assets/js/amazeui.js"></script>


	</head>
	<script type="text/javascript">
  	 		function onHref(index,orderId){
  	 			//alert("fjadsklfha");
  	 			//alert("index="+index);
  	 			//alert("message="+message);
  	 			alert("orderId="+orderId);
  	 			var id_name;
  	 			var id_phone;
  	 			var id_province;
  	 			var id_city;
  	 			var id_detailAddress;
  	 			var id_amount;
  	 			var id_message;
  	 			
  	 			id_name = document.getElementById("id_name"+index+orderId).value;
//  	 			alert("id_name="+id_name);
  	 			
	  	 		id_phone = document.getElementById("id_phone"+index+orderId).value;
//	  	 		alert("id_phone="+id_phone);
	  	 		
	  	 		id_province = document.getElementById("id_province"+index+orderId).value;
//	  	 		alert("id_province="+id_province);
	  	 		
	  	 		id_city = document.getElementById("id_city"+index+orderId).value;
//	  	 		alert("id_city="+id_city);
	  	 		
	  	 		id_detailAddress = document.getElementById("id_detailAddress"+index+orderId).value;
//	  	 		alert("id_detailAddress="+index+id_detailAddress);
	  	 		
	  	 		id_amount = document.getElementById("id_amount"+index+orderId).value;
//	  	 		alert("id_amount="+id_amount);
	  	 		
	  	 		id_message = document.getElementById("id_message"+index+orderId).value;
//	  	 		alert("id_message="+id_message);
	  	 		
//  	 			alert("orderId="+orderId+"id_name="+id_name+"///"+"id_phone"+id_phone+"///"+"id_province"+id_province+"///"+"id_city"+id_city+"///"+"id_detailAddress"+id_detailAddress+"///"+"id_amount"+id_amount+"///"+"id_message"+id_message);
  	 			
  	 			$.ajax({  
					type:"get",//请求方式  
					url:"./servlet/ModifyOrderCtrl?sendOrder_orderId="+orderId+"&province="+id_province+"&city="+id_city+"&detailAddress="+id_detailAddress+"&phone="+id_phone+"&name="+id_name+"&amount="+id_amount+"&message="+id_message,//发送请求地址  
					timeout:30000,//超时时间：30秒  
					//  dataType:"json",//设置返回数据的格式  
					//请求成功后的回调函数 data为json格式  
					success:function(){  
						alert("订单编号"+orderId+"修改成功");
						},  
						//请求出错的处理  
						error:function(){  
						alert("请求出错");  
					}
				}); 
  	 			
  	 			//window.location.href="./servlet/ModifyOrderCtrl?orderId="+orderId+"&province="+id_province+"&city="+id_city+"&detailAddress="+id_detailAddress+"&phone="+id_phone+"&name="+id_name+"&amount="+id_amount+"&message="+id_message;
			}  	 					 	
  	 </script>
  	 
  	 
  	 

	<%
		//ArrayList<StoreSeeOrderDao> storeSeeOrderList = (ArrayList<StoreSeeOrderDao>)request.getAttribute("storeSeeOrderList");
		//if(storeSeeOrderList != null){
		//	out.write(storeSeeOrderList.toString()); 
		//}
		//  	 	request.getSession().setAttribute("storeSeeOrder_select",10);
		//  	 	request.getSession().setAttribute("storeSeeOrder_orderId",28);
		//  	 	request.getSession().setAttribute("storeSeeOrder_userId",3);
		//  	 	request.getSession().setAttribute("storeSeeOrder_orderTime","05-17");
		ArrayList<StoreSeeOrder> storeSeeOrderList;
		String sendOrder_msg = (String) request
				.getAttribute("sendOrder_msg");
		if (sendOrder_msg != null) {
	%>
	<script>window.alert('<%=sendOrder_msg%>');</script>
	<%
		}
	%>
	<script type="text/javascript">
										function loadInfo(){  
								             $.ajax({  
								               type:"get",//请求方式  
								               url:"./servlet/StoreSeeOrderCtrl?select=3",//发送请求地址  
								               timeout:30000,//超时时间：30秒  
								               async:false,
								               dataType:"jason",//设置返回数据的格式  
								               //请求成功后的回调函数 data为json格式  
								               success:function(data){  
								                  alert("获得的data="+data);
								                  //$("#name").attr("value",data.name);//填充内容 
								                  //storeSeeOrderList = (ArrayList<StoreSeeOrder>) request.getAttribute("storeSeeOrderList");
								              },  
								              //请求出错的处理  
								              error:function(){  
								                        alert("请求出错");  
								              }  
								           });  
								          }
								       </script>
	<body>

		<!--头 -->
		<header>
		<article>
		<div class="mt-logo">
			<!--悬浮搜索框-->
			<div class="nav white">
				<table align="center">
					<tr>
						<td>
							<form action="./servlet/StoreSeeOrderCtrl?select=0">
								<select size="1" name="index">
									<option value="orderId">
										订单编号
									</option>
									<option value="orderTime">
										支付时间
									</option>
									<option value="userId">
										用户编号
									</option>
								</select>
								<input type="text" name="data">
								<input type="submit" value="查找">
							</form>
						</td>
					</tr>
				</table>
			</div>
			<div class="clear"></div>
		</div>
		</article>
		</header>
		<div>
			<b class="line"></b>
		</div>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
					<div class="user-order">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf">
								<strong class="am-text-danger am-text-lg">订单管理</strong> /
								<small>Order</small>
							</div>
						</div>
						<hr />

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
									<!-- <a href="#tab1">所有订单</a>  -->
									<script type="text/javascript">
								 		function up(){
								 			window.location.href="./servlet/StoreSeeOrderCtrl?select=2";
								 		}
								 	</script>
									<a onclick="up()">所有订单</a>
								</li>
								<li>
									<a href="#tab2">待付款</a>
								</li>
								<li>
									<a href="#tab3">已付款</a>
								</li>
								<li>
									<a href="#tab4">待发货</a>
								</li>
								<li>
									<a href="#tab5">已发货</a>
								</li>
							</ul>
							<div class="am-tabs-bd">
								<!-- tab1所有订单 -->
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<%
										storeSeeOrderList = (ArrayList<StoreSeeOrder>) request
												.getAttribute("storeSeeOrderList");
										if (storeSeeOrderList != null) {
											for (int i = 0; i < storeSeeOrderList.size(); i++) {
												//备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
												String status_ = null;
												int sta = storeSeeOrderList.get(i).getStatus();
												if (sta == 1) {
													status_ = "未付款";
												} else if (sta == 2) {
													status_ = "已付款未发货";
												} else if (sta == 3) {
													status_ = "已付款已发货";
												} else if (sta == 4) {
													status_ = "已收货";
												}
									%>

									<div class="order-main">
										<div class="order-list">

											<div class="order-status2">
												<div class="order-title">
													<div class="dd-num">
														订单编号：<%=storeSeeOrderList.get(i).getOrderId()%></div>
														<p id="status<%=storeSeeOrderList.get(i).getOrderId() %>"><span>状态：<%=status_%> </span></p>
												</div>
												<div class="order-title">
													<div class="dd-num">
														收货人：
														<input
															id="id_name1<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getName()%>>
													</div>
													<div class="dd-num">
														电话：
														<input
															id="id_phone1<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getPhone()%>>
													</div>
													<span>地址：<input
															id="id_province1<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getProvince()%>>
														<input
															id="id_city1<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getCity()%>> <input
															id="id_detailAddress1<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getDetailAddress()%>>
													</span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														备注：
														<input
															id="id_message1<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getMessage()%>>
													</div>
												</div>
												<div class="order-top">
													<div class="th th-item">
														<td class="td-inner">
															商品
														</td>
													</div>
													<div class="th th-price">
														<td class="td-inner">
															单价
														</td>
													</div>
													<div class="th th-number">
														<td class="td-inner">
															数量
														</td>
													</div>
													<div class="th th-operation">
														<td class="td-inner">
															商品操作
														</td>
													</div>
													<div class="th th-amount">
														<td class="td-inner">
															合计
														</td>
													</div>
													<!-- 
													<div class="th th-status">
														<td class="td-inner">
															交易状态
														</td>
													</div>
													 -->
													<div class="th th-status">
														<td class="td-inner">
															交易操作
														</td>
													</div>
													<div class="th th-change">
														<td class="td-inner">
															交易操作
														</td>
													</div>
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint"> <!-- 商品图片 --> <img
																			src="/PhoneHub/Image/<%=storeSeeOrderList.get(i).getImage1()%>"
																			class="itempic J_ItemImg"> </a> 
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<p><%=storeSeeOrderList.get(i).getProductName()%></p>
																		<p class="info-little">
																			颜色：<%=storeSeeOrderList.get(i).getColor()%>
																			<br />
																			内存：<%=storeSeeOrderList.get(i).getRam()%>
																			<br />
																			网络类型：<%=storeSeeOrderList.get(i).getNetworkType()%></p>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	<%=storeSeeOrderList.get(i).getCost()%>
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span><%=storeSeeOrderList.get(i).getNum()%>
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">

																</div>
															</li>
														</ul>

														<div class="order-right">
															<li class="td td-amount">
																<div class="item-amount">
																	<input
																		id="id_amount1<%=storeSeeOrderList.get(i).getOrderId()%>"
																		style="width: 60px" type="text"
																		value=<%=storeSeeOrderList.get(i).getAmount()%>>

																</div>
															</li>
												<script type="text/javascript">
													function send(orderId){
														$.ajax({  
															type:"get",//请求方式  
															url:"./servlet/SendOrderCtrl?sendOrder_orderId="+orderId,//发送请求地址  
															timeout:30000,//超时时间：30秒  
															//  dataType:"json",//设置返回数据的格式  
															//请求成功后的回调函数 data为json格式  
															success:function(){  
																//改变button的显示效果
																var send_list = document.getElementsByName("send_bt"+orderId);
																for(var i=0; i<send_list.length; i++){
																	var objTemp = send_list[i];
																	objTemp.disabled="true";
																}
																//改变显示订单状态（只能改变一个）
																document.getElementById("status"+orderId).innerHTML="状态：已付款已发货";
																//send_bt.disabled="true";
																alert("订单编号"+orderId+"发货成功");
															},  
															//请求出错的处理  
															error:function(){  
															alert("请求出错");  
															}
														}); 
													}
												</script>
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<!-- <p class="Mystatus"><%=status_%></p> -->
																		<!-- <div class="am-btn am-btn-danger anniu"> -->
																		<div class="move-right">
																			<%
																				if (status_.equals("已付款未发货")) {
																			%>
																			<!-- 
																			<a  id="send_bt<%=storeSeeOrderList.get(i).getOrderId() %>"
																				onclick="send(<%=storeSeeOrderList.get(i).getOrderId() %>)">
																				href="./servlet/SendOrderCtrl?sendOrder_orderId=<%=storeSeeOrderList.get(i).getOrderId()%>">
																				发货 </a>
																			-->
																				<input value="发货" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu" onclick="send(<%=storeSeeOrderList.get(i).getOrderId()%>)" >
																			<%
																				} else {
																			%>
																			<!-- <a id="send_id<%=storeSeeOrderList.get(i).getOrderId() %>" style="cursor: default;"> 发货 </a> -->
																				<input value="发货" disabled="disabled" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu">
																			<%
																				}
																			%>
																		</div>
																	</div>
																</li>
																<li class="td td-change">
																	<div class="am-btn am-btn-danger anniu"
																		onclick="onHref(1,<%=storeSeeOrderList.get(i).getOrderId()%>)">
																		修改
																	</div>
																</li>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<br>
									<br>
									<br>
									<%
										}
										}
									%>
								</div>
								<!-- tab1 -->

								<!-- tab2未付款 -->
								<div class="am-tab-panel am-fade" id="tab2">
									<script type="text/javascript">
										function select3(){
											window.location.href="./servlet/StoreSeeOrderCtrl?select=3";
										}
									</script>
									<%
										storeSeeOrderList = (ArrayList<StoreSeeOrder>) request
												.getAttribute("storeSeeOrderList");
										if (storeSeeOrderList != null) {
											for (int i = 0; i < storeSeeOrderList.size(); i++) {
												//备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
												String status_ = null;
												int sta = storeSeeOrderList.get(i).getStatus();
												if (sta == 1) {
													status_ = "未付款";
												} else if (sta == 2) {
													status_ = "已付款未发货";
												} else if (sta == 3) {
													status_ = "已付款已发货";
												} else if (sta == 4) {
													status_ = "已收货";
												}
												if (sta == 1) {
									%>

									<div class="order-main">
										<div class="order-list">

											<div class="order-status2">
												<div class="order-title">
													<div class="dd-num">
														订单编号：<%=storeSeeOrderList.get(i).getOrderId()%></div>
													<span> 状态：<%=status_%> </span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														收货人：
														<input
															id="id_name2<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getName()%>>
													</div>
													<div class="dd-num">
														电话：
														<input
															id="id_phone2<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getPhone()%>>
													</div>
													<span> 地址：<input
															id="id_province2<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getProvince()%>>
														<input
															id="id_city2<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getCity()%>> <input
															id="id_detailAddress2<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getDetailAddress()%>>
													</span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														备注：
														<input
															id="id_message2<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getMessage()%>>
													</div>
												</div>
												<div class="order-top">
													<div class="th th-item">
														<td class="td-inner">
															商品
														</td>
													</div>
													<div class="th th-price">
														<td class="td-inner">
															单价
														</td>
													</div>
													<div class="th th-number">
														<td class="td-inner">
															数量
														</td>
													</div>
													<div class="th th-operation">
														<td class="td-inner">
															商品操作
														</td>
													</div>
													<div class="th th-amount">
														<td class="td-inner">
															合计
														</td>
													</div>
													<!-- 
													<div class="th th-status">
														<td class="td-inner">
															交易状态
														</td>
													</div>
													 -->
													<div class="th th-status">
														<td class="td-inner">
															交易操作
														</td>
													</div>
													<div class="th th-change">
														<td class="td-inner">
															交易操作
														</td>
													</div>
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint"> <!-- 商品图片 --> <img
																			src="/PhoneHub/Image/<%=storeSeeOrderList.get(i).getImage1()%>"
																			class="itempic J_ItemImg"> </a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<p><%=storeSeeOrderList.get(i).getProductName()%></p>
																		<p class="info-little">
																			颜色：<%=storeSeeOrderList.get(i).getColor()%>
																			<br />
																			内存：<%=storeSeeOrderList.get(i).getRam()%>
																			<br />
																			网络类型：<%=storeSeeOrderList.get(i).getNetworkType()%></p>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	<%=storeSeeOrderList.get(i).getCost()%>
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span><%=storeSeeOrderList.get(i).getNum()%>
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">

																</div>
															</li>
														</ul>

														<div class="order-right">
															<li class="td td-amount">
																<div class="item-amount">
																	<input
																		id="id_amount2<%=storeSeeOrderList.get(i).getOrderId()%>"
																		style="width: 60px" type="text"
																		value=<%=storeSeeOrderList.get(i).getAmount()%>>
																</div>
															</li>
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<!-- <p class="Mystatus"><%=status_%></p> -->
																		<div class="move-right">
																			<%
																				if (status_.equals("已付款未发货")) {
																			%>
																				<input value="发货" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu" onclick="send(<%=storeSeeOrderList.get(i).getOrderId()%>)" >
																			<%
																				} else {
																			%>
																				<input value="发货" disabled="disabled" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu">
																			<%
																				}
																			%>
																		</div>
																	</div>
																</li>
																<li class="td td-change">
																	<div class="am-btn am-btn-danger anniu"
																		onclick="onHref(2,<%=storeSeeOrderList.get(i).getOrderId()%>)">
																		修改
																	</div>
																</li>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<br>
									<br>
									<br>
									<%
										}
											}
										}
									%>
								</div>
								<!-- tab2-->

								<!-- tab3已付款 -->
								<div class="am-tab-panel am-fade" id="tab3">
									<%
										storeSeeOrderList = (ArrayList<StoreSeeOrder>) request
												.getAttribute("storeSeeOrderList");
										if (storeSeeOrderList != null) {
											for (int i = 0; i < storeSeeOrderList.size(); i++) {
												//备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
												String status_ = null;
												int sta = storeSeeOrderList.get(i).getStatus();
												if (sta == 1) {
													status_ = "未付款";
												} else if (sta == 2) {
													status_ = "已付款未发货";
												} else if (sta == 3) {
													status_ = "已付款已发货";
												} else if (sta == 4) {
													status_ = "已收货";
												}
												if (sta == 3) {
									%>

									<div class="order-main">
										<div class="order-list">

											<div class="order-status2">
												<div class="order-title">
													<div class="dd-num">
														订单编号：<%=storeSeeOrderList.get(i).getOrderId()%></div>
													<span> 状态：<%=status_%> </span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														收货人：
														<input
															id="id_name3<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getName()%>>
													</div>
													<div class="dd-num">
														电话：
														<input
															id="id_phone3<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getPhone()%>>
													</div>
													<span> 地址：<input
															id="id_province3<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getProvince()%>>
														<input
															id="id_city3<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getCity()%>> <input
															id="id_detailAddress3<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getDetailAddress()%>>
													</span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														备注：
														<input
															id="id_message3<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getMessage()%>>
													</div>
												</div>
												<div class="order-top">
													<div class="th th-item">
														<td class="td-inner">
															商品
														</td>
													</div>
													<div class="th th-price">
														<td class="td-inner">
															单价
														</td>
													</div>
													<div class="th th-number">
														<td class="td-inner">
															数量
														</td>
													</div>
													<div class="th th-operation">
														<td class="td-inner">
															商品操作
														</td>
													</div>
													<div class="th th-amount">
														<td class="td-inner">
															合计
														</td>
													</div>
													<!-- 
													<div class="th th-status">
														<td class="td-inner">
															交易状态
														</td>
													</div>
													 -->
													<div class="th th-status">
														<td class="td-inner">
															交易操作
														</td>
													</div>
													<div class="th th-change">
														<td class="td-inner">
															交易操作
														</td>
													</div>
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint"> <!-- 商品图片 --> <img
																			src="/PhoneHub/Image/<%=storeSeeOrderList.get(i).getImage1()%>"
																			class="itempic J_ItemImg"> </a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<p><%=storeSeeOrderList.get(i).getProductName()%></p>
																		<p class="info-little">
																			颜色：<%=storeSeeOrderList.get(i).getColor()%>
																			<br />
																			内存：<%=storeSeeOrderList.get(i).getRam()%>
																			<br />
																			网络类型：<%=storeSeeOrderList.get(i).getNetworkType()%></p>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	<%=storeSeeOrderList.get(i).getCost()%>
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span><%=storeSeeOrderList.get(i).getNum()%>
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">

																</div>
															</li>
														</ul>

														<div class="order-right">
															<li class="td td-amount">
																<div class="item-amount">
																	<input
																		id="id_amount3<%=storeSeeOrderList.get(i).getOrderId()%>"
																		style="width: 60px" type="text"
																		value=<%=storeSeeOrderList.get(i).getAmount()%>>
																</div>
															</li>
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<!-- <p class="Mystatus"><%=status_%></p> -->
																		<div class="move-right">
																			<%
																				if (status_.equals("已付款未发货")) {
																			%>
																				<input value="发货" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu" onclick="send(<%=storeSeeOrderList.get(i).getOrderId()%>)" >
																			<%
																				} else {
																			%>
																				<input value="发货" disabled="disabled" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu">
																			<%
																				}
																			%>
																		</div>
																	</div>
																</li>
																<li class="td td-change">
																	<div class="am-btn am-btn-danger anniu"
																		onclick="onHref(3,<%=storeSeeOrderList.get(i).getOrderId()%>)">
																		修改
																	</div>
																</li>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<br>
									<br>
									<br>
									<%
										}
											}
										}
									%>
								</div>
								<!-- tab3-->


								<!-- tab4未发货 -->
								<div class="am-tab-panel am-fade" id="tab4">
									<%
										storeSeeOrderList = (ArrayList<StoreSeeOrder>) request
												.getAttribute("storeSeeOrderList");
										if (storeSeeOrderList != null) {
											for (int i = 0; i < storeSeeOrderList.size(); i++) {
												//备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
												String status_ = null;
												int sta = storeSeeOrderList.get(i).getStatus();
												if (sta == 1) {
													status_ = "未付款";
												} else if (sta == 2) {
													status_ = "已付款未发货";
												} else if (sta == 3) {
													status_ = "已付款已发货";
												} else if (sta == 4) {
													status_ = "已收货";
												}
												if (sta == 2) {
									%>

									<div class="order-main">
										<div class="order-list">

											<div class="order-status2">
												<div class="order-title">
													<div class="dd-num">
														订单编号：<%=storeSeeOrderList.get(i).getOrderId()%></div>
													<span> 状态：<%=status_%> </span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														收货人：
														<input
															id="id_name4<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getName()%>>
													</div>
													<div class="dd-num">
														电话：
														<input
															id="id_phone4<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getPhone()%>>
													</div>
													<span> 地址：<input
															id="id_province4<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getProvince()%>>
														<input
															id="id_city4<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getCity()%>> <input
															id="id_detailAddress4<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getDetailAddress()%>>
													</span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														备注：
														<input
															id="id_message4<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getMessage()%>>
													</div>
												</div>
												<div class="order-top">
													<div class="th th-item">
														<td class="td-inner">
															商品
														</td>
													</div>
													<div class="th th-price">
														<td class="td-inner">
															单价
														</td>
													</div>
													<div class="th th-number">
														<td class="td-inner">
															数量
														</td>
													</div>
													<div class="th th-operation">
														<td class="td-inner">
															商品操作
														</td>
													</div>
													<div class="th th-amount">
														<td class="td-inner">
															合计
														</td>
													</div>
													<!-- 
													<div class="th th-status">
														<td class="td-inner">
															交易状态
														</td>
													</div>
													 -->
													<div class="th th-status">
														<td class="td-inner">
															交易操作
														</td>
													</div>
													<div class="th th-change">
														<td class="td-inner">
															交易操作
														</td>
													</div>
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint"> <!-- 商品图片 --> <img
																			src="/PhoneHub/Image/<%=storeSeeOrderList.get(i).getImage1()%>"
																			class="itempic J_ItemImg"> </a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<p><%=storeSeeOrderList.get(i).getProductName()%></p>
																		<p class="info-little">
																			颜色：<%=storeSeeOrderList.get(i).getColor()%>
																			<br />
																			内存：<%=storeSeeOrderList.get(i).getRam()%>
																			<br />
																			网络类型：<%=storeSeeOrderList.get(i).getNetworkType()%></p>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	<%=storeSeeOrderList.get(i).getCost()%>
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span><%=storeSeeOrderList.get(i).getNum()%>
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">

																</div>
															</li>
														</ul>

														<div class="order-right">
															<li class="td td-amount">
																<div class="item-amount">
																	<input
																		id="id_amount4<%=storeSeeOrderList.get(i).getOrderId()%>"
																		style="width: 60px" type="text"
																		value=<%=storeSeeOrderList.get(i).getAmount()%>>
																</div>
															</li>
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<!-- <p class="Mystatus"><%=status_%></p> -->
																		<div class="move-right">
																			<%
																				if (status_.equals("已付款未发货")) {
																			%>
																				<input value="发货" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu" onclick="send(<%=storeSeeOrderList.get(i).getOrderId()%>)" >
																			<%
																				} else {
																			%>
																				<input value="发货" disabled="disabled" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu">
																			<%
																				}
																			%>
																		</div>
																	</div>
																</li>
																<li class="td td-change">
																	<div class="am-btn am-btn-danger anniu"
																		onclick="onHref(4,<%=storeSeeOrderList.get(i).getOrderId()%>)">
																		修改
																	</div>
																</li>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<br>
									<br>
									<br>
									<%
										}
											}
										}
									%>
								</div>
								<!-- tab4-->

								<!-- tab5已发货 -->
								<div class="am-tab-panel am-fade" id="tab5">
									<%
										storeSeeOrderList = (ArrayList<StoreSeeOrder>) request
												.getAttribute("storeSeeOrderList");
										if (storeSeeOrderList != null) {
											for (int i = 0; i < storeSeeOrderList.size(); i++) {
												//备注：订单状态（1未付款，2已付款未发货，3已付款已发货、4已收货）
												String status_ = null;
												int sta = storeSeeOrderList.get(i).getStatus();
												if (sta == 1) {
													status_ = "未付款";
												} else if (sta == 2) {
													status_ = "已付款未发货";
												} else if (sta == 3) {
													status_ = "已付款已发货";
												} else if (sta == 4) {
													status_ = "已收货";
												}
												if (sta == 3) {
									%>

									<div class="order-main">
										<div class="order-list">

											<div class="order-status2">
												<div class="order-title">
													<div class="dd-num">
														订单编号：<%=storeSeeOrderList.get(i).getOrderId()%></div>
													<span> 状态：<%=status_%> </span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														收货人：
														<input
															id="id_name5<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getName()%>>
													</div>
													<div class="dd-num">
														电话：
														<input
															id="id_phone5<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 100px" type="text"
															value=<%=storeSeeOrderList.get(i).getPhone()%>>
													</div>
													<span> 地址：<input
															id="id_province5<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getProvince()%>>
														<input
															id="id_city5<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 50px" type="text"
															value=<%=storeSeeOrderList.get(i).getCity()%>> <input
															id="id_detailAddress5<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getDetailAddress()%>>
													</span>
												</div>
												<div class="order-title">
													<div class="dd-num">
														备注：
														<input
															id="id_message5<%=storeSeeOrderList.get(i).getOrderId()%>"
															style="height: 20px; width: 200px" type="text"
															value=<%=storeSeeOrderList.get(i).getMessage()%>>
													</div>
												</div>
												<div class="order-top">
													<div class="th th-item">
														<td class="td-inner">
															商品
														</td>
													</div>
													<div class="th th-price">
														<td class="td-inner">
															单价
														</td>
													</div>
													<div class="th th-number">
														<td class="td-inner">
															数量
														</td>
													</div>
													<div class="th th-operation">
														<td class="td-inner">
															商品操作
														</td>
													</div>
													<div class="th th-amount">
														<td class="td-inner">
															合计
														</td>
													</div>
													<div class="th th-status">
														<td class="td-inner">
															交易状态
														</td>
													</div>
													<div class="th th-change">
														<td class="td-inner">
															交易操作
														</td>
													</div>
												</div>
												<div class="order-content">
													<div class="order-left">
														<ul class="item-list">
															<li class="td td-item">
																<div class="item-pic">
																	<a href="#" class="J_MakePoint"> <!-- 商品图片 --> <img
																			src="/PhoneHub/Image/<%=storeSeeOrderList.get(i).getImage1()%>"
																			class="itempic J_ItemImg"> </a>
																</div>
																<div class="item-info">
																	<div class="item-basic-info">
																		<p><%=storeSeeOrderList.get(i).getProductName()%></p>
																		<p class="info-little">
																			颜色：<%=storeSeeOrderList.get(i).getColor()%>
																			<br />
																			内存：<%=storeSeeOrderList.get(i).getRam()%>
																			<br />
																			网络类型：<%=storeSeeOrderList.get(i).getNetworkType()%></p>
																	</div>
																</div>
															</li>
															<li class="td td-price">
																<div class="item-price">
																	<%=storeSeeOrderList.get(i).getCost()%>
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span><%=storeSeeOrderList.get(i).getNum()%>
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">

																</div>
															</li>
														</ul>

														<div class="order-right">
															<li class="td td-amount">
																<div class="item-amount">
																	<input
																		id="id_amount5<%=storeSeeOrderList.get(i).getOrderId()%>"
																		style="width: 60px" type="text"
																		value=<%=storeSeeOrderList.get(i).getAmount()%>>
																</div>
															</li>
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<!-- <p class="Mystatus"><%=status_%></p> -->
																		<div class="move-right">
																			<%
																				if (status_.equals("已付款未发货")) {
																			%>
																				<input value="发货" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu" onclick="send(<%=storeSeeOrderList.get(i).getOrderId()%>)" >
																			<%
																				} else {
																			%>
																				<input value="发货" disabled="disabled" type="button" name="send_bt<%=storeSeeOrderList.get(i).getOrderId()%>" class="am-btn am-btn-danger anniu">
																			<%
																				}
																			%>
																		</div>
																	</div>
																</li>
																<li class="td td-change">
																	<div class="am-btn am-btn-danger anniu"
																		onclick="onHref(5,<%=storeSeeOrderList.get(i).getOrderId()%>)">
																		修改
																	</div>
																</li>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<br>
									<br>
									<br>
									<%
										}
											}
										}
									%>
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>
	</body>
</html>
