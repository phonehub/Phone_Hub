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
    
    <title>My JSP 'ShowOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
  		ShowOrder showOrder = (ShowOrder)request.getAttribute("showOrder");
  	 	//out.write("界面----showOrder="+showOrder.toString());
  	 	ArrayList<OrderProductInfo> productInfo = showOrder.getProductInfo();
  	 	
  	 	//传输参数
  	 	int orderId = showOrder.getOrderId(); 
  	 	int userId = showOrder.getUserId();
  	 	String userPassword = "111";
  	 	
  	 	request.getSession().setAttribute("orderId",orderId);
  	 	request.getSession().setAttribute("userId",userId);
  	 	request.getSession().setAttribute("userPassword",userPassword);
  	 	
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
  <form action="./servlet/PayOrderCtrl">
   
   
   
   <table border="1" align="left">
   		<tr>
   			<td ><p align="left">订单详情</p></td>
   		</tr>
   </table>
   <br>
   <br>
   <table border="1" align="left">
   		<tr>
   			<td ><p align="left">状态：<%=status_ %></p></td>
   		</tr>
   </table>
   <br>
   <br>
   	<table border="1" align="left">
			<tr>
				<td>收货人</td>
				<td><%=showOrder.getName() %></td>
				<td>电话</td>
				<td><%=showOrder.getPhone() %></td>
			</tr>
	</table>
	<br>
	<br>
	<table border="1" align="left">
			<tr>
				<td>收货地址</td>
				<td><%=showOrder.getProvince() %></td>
				<td><%=showOrder.getCity() %></td>
				<td><%=showOrder.getDetailAddress() %></td>
			</tr> 
	</table >
	<br> 
    <br>
   	<table border="1" align="center">
   		<tr>
   			<td colspan="8"><p align="left">店铺：<%=showOrder.getStoreName() %></p></td>
   		</tr>
   	
   		<tr> 
			<td>图片</td>
			<td>商品名称</td>
			<td>颜色</td>
			<td>内存</td>
			<td>网络类型</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
		</tr>
		<%
			for(int i=0;i<productInfo.size();i++){
				%>
				<tr>
					
					<th><input type="image" value="<%=productInfo.get(i).getImage1()%>"></th>
					<th><%=productInfo.get(i).getProductName() %></th>
					<th><%=productInfo.get(i).getColor() %></th>
					<th><%=productInfo.get(i).getRam() %></th>
					<th><%=productInfo.get(i).getNetworkType() %></th>
					<th><%=productInfo.get(i).getCost() %></th>
					<th><%=productInfo.get(i).getNum() %></th>
					<th><%=productInfo.get(i).getCost()*productInfo.get(i).getNum() %></th>
				</tr>
				<% 
			}
		 %>
		 <tr>
		 	<td colspan="8" align="right">应付金额：<%=showOrder.getAmount() %></td>
		 </tr>
		 <tr>
		 	<td colspan="8" align="left">订单编号：<%=showOrder.getOrderId() %></td>
		 </tr>
		 <tr>
		 	<td colspan="8" align="left">创建时间：<%=showOrder.getCreateTime() %></td>
		 </tr>
		 
   		<tr>
   			<td colspan="8" align="center"><input type="submit" value="立刻付钱"></td>
   		</tr>
   	</table>
   
   
   
  	
  </form>
  </body>
</html>
