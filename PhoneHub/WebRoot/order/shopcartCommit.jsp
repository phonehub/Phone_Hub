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
    
    <title>My JSP 'showOrder.jsp' starting page</title>
    
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
  	 	//测试数据ArrayList<ShopCartDao>
		ArrayList<ShopCart> shopCart = null;
		ShopCart product1 = new ShopCart();
		product1.setUserId(1);
		product1.setProductId(1);
		product1.setStoreId(1);
		product1.setNum(1);
		product1.setProductName("小米6");
		product1.setPrice(2888);
		product1.setImage(null);
		product1.setColor("亮白");
		
		ShopCart product2 = new ShopCart();
		product2.setUserId(2);
		product2.setProductId(3);
		product2.setStoreId(1);
		product2.setNum(1);
		product2.setProductName("华为P10");
		product2.setPrice(3588);
		product2.setImage(null);
		//product2.setColor("玫瑰金");
		
		shopCart = new ArrayList<ShopCart>();
		shopCart.add(product1);
		shopCart.add(product2);
		
		System.out.println("shopcartCommit-----shopCart="+shopCart);
		
		//request.setAttribute("shopCart",shopCart);  //不可以用，因为一旦用这个要用
		//这里只能以如下方式请求转发
		//request.getRequestDispatcher("b.jsp").forward(request, response);
		
		request.getSession().setAttribute("shopCart",shopCart);
		
  	  %>
  	 
  	 <form action="./servlet/ShowOrderCtrl">
  	  
  	  <%
  	  	request.getSession().setAttribute("userName","peixin");
  	   %>
  	  
  	 	<input type="checkbox" name="selectedProduct" value ="1" >苹果<br> <!-- 这里的value要动态与shopcart中的productId对应 -->
		<input type="checkbox" name="selectedProduct" value ="3">桔子<br>
		<input type="checkbox" name="selectedProduct" value ="4">芒果<br>
		<input type="submit" value="结算">
      </form>
  	 
  </body>
</html>
