<%@ page language="java" 
import="java.util.*" 
import="cn.edu.zhku.phonehub.order.model.ShowPreviewOrder"
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
    
    <title>My JSP 'showPreviewOrder.jsp' starting page</title>
    
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
  <!-- //这是得不到的 -->
  <%=session.getAttribute("showPreviewOrder") %>
  

    
   <form action="./servlet/CommitOrderCtrl">
   
   <%
  	ArrayList<ShowPreviewOrder> showPreviewOrder = (ArrayList<ShowPreviewOrder>)request.getAttribute("showPreviewOrder");

  	out.write("界面---showPreviewOrder="+showPreviewOrder);
  	//request.setAttribute("previewOrder",showPreviewOrder);//失败
  	session.setAttribute("previewOrder",showPreviewOrder); //再将预览的商品信息传给CommitOrderCtrl
   %>
  	<input type="submit" value="确定">
   </form>
  
  </body>
</html>
