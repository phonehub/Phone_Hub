<%@ page language="java" import="java.util.*,cn.edu.zhku.phonehub.user.model.User" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'select.jsp' starting page</title>
    
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
  <% User user =(User)session.getAttribute("user"); %>
  <table>
<tr><th><td>用户名</td><td>头像</td><td>钱包</td> <th></tr>
<tr><td><%=user.getUserName() %></td><td><img  src="/PhoneHub/<%=user.getHeadImage() %> "  height="90" width="200"></td><td><%=user.getWallet() %></td></tr>
  </table>
  </body>
</html>
