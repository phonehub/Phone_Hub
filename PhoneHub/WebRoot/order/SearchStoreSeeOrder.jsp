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
	<script type="text/javascript">
	
	//用ajax获取
	function getOrderInfo(){
		$.ajax({
			type:"get", //请求方式
			url:""
		
		})
	
	}

	</script>


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
  
  	<table border="1" align="center">
  		<tr>
  			<td >订单信息</td>
  		</tr>
  	</table>
  	
  	<table border="1" align="center" width="80%">
  		<tr>
  			<td><a href="">订单编号升序</a></td>
  			<td><a href="">订单编号降序</a></td>
  			<td><a href="">未付款</a></td>
  			<td><a href="">已付款</a></td>
  			<td><a href="">未发货</a></td>
  			<td><a href="">已发货</a></td>
  		</tr>
  	</table>
  	<table border="1" align="center">
 	 	<tr>
  			<th>
  				<select size="1" name="storeSeeOrder_select">
  					<option value="orderId">订单编号</option>
  					<option value="orderTime">支付时间</option>
  					<option value="userId">用户编号</option>
  				</select>
  			
  				<input type="text" name="storeSeeOrder_orderId">
  				<input type="submit" value="查找">
  				
  				</th>
  		</tr>
  	
  	</table>
  	
  
  
    <form action="./servlet/StoreSeeOrderCtrl">
    	<input type="submit" value = "查找">
    </form>
    
    
  </body>
</html>
