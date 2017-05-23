<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ModifyOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	request.getSession().setAttribute("modify_orderId",21);
  	request.getSession().setAttribute("modify_province","广东省");
  	request.getSession().setAttribute("modify_city","东莞市");
  	request.getSession().setAttribute("modify_detailAddress","梅花院21号");
  	request.getSession().setAttribute("modify_phone","15820359482");
  	request.getSession().setAttribute("modify_name","少侠");
  	request.getSession().setAttribute("modify_amount","9999");
  	request.getSession().setAttribute("modify_message","至尊价格");
  
   %>
  <body>
   <form action="./servlet/ModifyOrderCtrl">
   
   	<input type="submit" value="店铺修改订单信息">
  </body>
</html>
