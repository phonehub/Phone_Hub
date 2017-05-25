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
  <!-- //这是得不到的 session.getAttribute("showPreviewOrder")-->
  
  

    
   <form action="./servlet/CommitOrderCtrl">
   
   <%
  	ArrayList<ShowPreviewOrder> showPreviewOrder = (ArrayList<ShowPreviewOrder>)request.getAttribute("showPreviewOrder");

  	//out.write("界面---showPreviewOrder="+showPreviewOrder);
  	//request.setAttribute("previewOrder",showPreviewOrder);//失败
  	session.setAttribute("previewOrder",showPreviewOrder); //再将预览的商品信息传给CommitOrderCtrl
   %>

	<p align="center">订单预览信息</p>
	<table border="1" align="center">
			<tr>
				<td>收货人</td>
				<td><%=showPreviewOrder.get(0).getUserName() %></td>
				<td>电话</td>
				<td><%=showPreviewOrder.get(0).getPhone() %></td>
			</tr>
	</table>
	<table border="1" align="center">
			<tr>
				<td>收货地址</td>
				<td><%=showPreviewOrder.get(0).getProvince() %></td>
				<td><%=showPreviewOrder.get(0).getCity() %></td>
				<td><%=showPreviewOrder.get(0).getDetailAddress() %></td>
			</tr>
	</table >
	<br>
		
	<table border="1" align="center">
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
			for(int i=0;i<showPreviewOrder.size();i++){
				%>
				<tr>
					
					<th><input type="image" value="<%=showPreviewOrder.get(i).getImage1()%>"></th>
					<th><%=showPreviewOrder.get(i).getProductName() %></th>
					<th><%=showPreviewOrder.get(i).getColor() %></th>
					<th><%=showPreviewOrder.get(i).getRam() %></th>
					<th><%=showPreviewOrder.get(i).getNetworkType() %></th>
					<th><%=showPreviewOrder.get(i).getPrice() %></th>
					<th><%=showPreviewOrder.get(i).getNum() %></th>
					<th><%=showPreviewOrder.get(i).getPrice()*showPreviewOrder.get(i).getNum() %></th>
				</tr>
				<% 
			}
		
		 %>
		 <tr><td colspan="8" align="center"><input type="submit" value="下单"></td></tr>
	</table>


  	
   </form>
  
  </body>
</html>
