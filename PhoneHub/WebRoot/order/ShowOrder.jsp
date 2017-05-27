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
  	 	out.write("界面----showOrder="+showOrder.toString());
  	 	
  	 	//传输参数
  	 	int orderId = showOrder.getOrderId();
  	 	int userId = 3;
  	 	String userPassword = "111";
  	 	
  	 	request.getSession().setAttribute("orderId",orderId);
  	 	request.getSession().setAttribute("userId",userId);
  	 	request.getSession().setAttribute("userPassword",userPassword);
  	 	
  	 %>
  <form action="./servlet/PayOrderCtrl">
   
  	<input type="submit" value="立刻付钱">
  </form>
  </body>
</html>
