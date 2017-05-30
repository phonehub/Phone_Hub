<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.edu.zhku.phonehub.cart.model.Cart" %>
<%@page import="cn.edu.zhku.phonehub.cart.model.CartItem" %>
<%@page import="cn.edu.zhku.phonehub.product.model.Product" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
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
      Cart cart= null;
    // cart.setUserId(2);
     if(session.getAttribute("px_cart")!=null){
     cart=(Cart)session.getAttribute("px_cart");
     }
    
    if(cart==null)
    {
     %>
 
        <a href="/index.jsp">沒有東西，去購物吧</a>
     <% }
     else
      {
       CartItem item =null;
      Product p =  null;
      List<CartItem> items = new ArrayList<CartItem>();
      items=cart.getItems();
      
   %>
  
     <table border="1" cellspacing="0">
  <caption>您的商品如下：</caption>
  <tr bgcolor="pink">
  <td>商品编号</td>
  <td>商品名称</td>
  <td>商品价格</td>
  <td>商品数量</td>
  <td>操作</td>
  </tr>
       <%
       
        for(int i= 0;i<items.size();i++){
           item=items.get(i);
           if(item!=null){
           out.println(item.getProduct().getPrice());
     %> 
     
       <tr>
   <td><%=item.getProduct().getProductId() %></td>
   <td><%=item.getProduct().getProductName() %></td>
   <td><%=item.getProduct().getPrice() %></td>
   <td><input type="text"   value=<%=item.getCount() %>  ></td>
   
   <td><a href="/PhoneHub/cart/DelCart?productId=<%=item.getProduct().getProductId() %>">删除</a></td>
   </tr>
      <%    }
       
         }
   }  %>
       </table>
     
          
  </body>
</html>
