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
    
    <title>订单预览界面</title>
    
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
		ArrayList<ShopCart> shopcartList = (ArrayList<ShopCart>)request.getAttribute("shopcartList");
		
		System.out.println("shopcartCommit-----shopcartList="+shopcartList);
		
		
		//request.setAttribute("shopCart",shopCart);不可以用，因为一旦用这个要用
		//这里只能以如下方式请求转发
		//request.getRequestDispatcher("b.jsp").forward(request, response);
		
		//request.getSession().setAttribute("shopcartList",shopcartList);
		//out.write(shopcartList.toString());
  	  %>
  	 
  	 <form action="./servlet/ShowOrderCtrl"> 
  	  
  	  <%
  	  	request.getSession().setAttribute("userName","peixin");
  	  	
  	   %>
  	  
  	  <!-- 这里的value要动态与shopcart中的productId对应 -->
  	  <!--  
  	 	<input type="checkbox" name="selectedProduct" value ="1" >苹果<br> 
		<input type="checkbox" name="selectedProduct" value ="3">桔子<br>
		<input type="checkbox" name="selectedProduct" value ="4">芒果<br>
	  -->
	  
	  <p align="center">购物车信息</p>
		<table border="1" align="center">
			<tr>
				<th>选项</th>
				<th>商品</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
			</tr>
			
		<%
			for(int i=0;i<shopcartList.size();i++){
				%>
				<tr>
					<th><input type="checkbox" name="selectedProduct" value="<%=shopcartList.get(i).getProductId()%>"></th>
					<th>
						<input type="image" value="<%=shopcartList.get(i).getImage()%>">
						<%=shopcartList.get(i).getProductName() %>
						<%=shopcartList.get(i).getColor() %>
					</th>
					<th><%=shopcartList.get(i).getPrice() %></th>
					<th><%=shopcartList.get(i).getNum() %></th>
					<th><%=shopcartList.get(i).getPrice()*shopcartList.get(i).getNum() %></th>
					<th><a href="">删除</a></th> <!-- 培鑫写 -->
				</tr>
				<% 
			
			}
		
		 %>
		 	<tr>
		 		<td colspan="6" align="center"><input align="middle" type="submit" value="结算" ></td>
		 	</tr>
		</table>
		
		
      </form>
  	 
  </body>
</html>
