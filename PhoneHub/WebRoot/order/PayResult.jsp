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
    
    <title>My JSP 'PayResult.jsp' starting page</title>
    
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
  	 	out.write("订单完成----showOrder="+showOrder.toString());
  	 	
  	 	int orderId = showOrder.getOrderId();
  	 	request.getSession().setAttribute("orderId",orderId);
  	 	
   %>
   <br>
   <form action="./servlet/GetProductCtrl">
   
   	<input type="submit" value="收货">
   
   </form>
  
  
  </body>
</html>