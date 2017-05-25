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
    
    <title>My JSP 'consumerSeeOrder.jsp' starting page</title>
    
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
  	 	//out.write("订单完成----showOrder="+showOrder.toString());
  	 	ArrayList<OrderProductInfo> productInfo = showOrder.getProductInfo();
  	 	
  	 	int orderId = showOrder.getOrderId();
  	 	request.getSession().setAttribute("orderId",orderId);
  	 	
  	 	
   %>
   <table border="1" align="left">
   		<tr>
   			<td ><p align="left">所有订单-按创建时间降序</p></td>
   		</tr>
   </table> 
   <br>
   <br>
   <table border="1">
   		<tr>
   			<td>图片</td>
   			<td>商品名称</td>
			<td>颜色</td>
			<td>内存</td>
			<td>网络类型</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
			<td>店铺</td>
			<td>发货时间</td>
			<!--  
			<td>创建时间</td>
			<td>付款时间</td>
			<td>收货时间</td> 
			-->
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
					<th><%=showOrder.getStoreName() %></th>
					<th><%=showOrder.getSendTime()%></th>
					
					<!-- 
					<th><%=showOrder.getCreateTime()%></th>
					<th><%=showOrder.getOrderTime() %></th>
					<th><%=showOrder.getGetTime()%></th>
					-->
				</tr>
				<% 
			}
		 %>
		 <tr>
		 	<td colspan="10" align="right">
   					<form action="">
   						<input type="submit" value="返回首页">
   					</form>
   				</td>
		 </tr>
		 
   </table>
   
   
   
   <br>
   <br>
   
   
   
  </body>
</html>
