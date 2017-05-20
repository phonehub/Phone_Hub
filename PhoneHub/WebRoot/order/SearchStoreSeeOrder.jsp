<%@page import="cn.edu.zhku.phonehub.order.dao.StoreSeeOrderDao"%>
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
    
    <title>My JSP 'StoreSeeOrder.jsp' starting page</title>
    
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
  	 	
  	 	//ArrayList<StoreSeeOrderDao> storeSeeOrderList = (ArrayList<StoreSeeOrderDao>)request.getAttribute("storeSeeOrderList");
  	 	//if(storeSeeOrderList != null){
  	 	//	out.write(storeSeeOrderList.toString());
  	 	//}
  	 	request.getSession().setAttribute("storeSeeOrder_select",10);
  	 	request.getSession().setAttribute("storeSeeOrder_orderId",28);
  	 	request.getSession().setAttribute("storeSeeOrder_userId",3);
  	 	request.getSession().setAttribute("storeSeeOrder_orderTime","05-17");
  	 %>
  <body>
    <form action="./servlet/StoreSeeOrderCtrl">
    	<input type="submit" value = "查找">
    </form>
    
    
  </body>
</html>
