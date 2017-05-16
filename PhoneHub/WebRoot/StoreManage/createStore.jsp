<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="cn.edu.zhku.phonehub.store.model.Store" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/PhoneHub/servlet/CreateStoreCtrl" enctype="multipart/form-data" charset="utf-8" method="post">
<input type="text" name="userId" /></br>
<input type="text" name="location" /><br>
<input type="text" name="storeName" /></br>
<input type="file" name="IDCard" /></br>
<input type="file" name="IDCard" /></br>
<input type="submit" value="提交">
</form>
<%
Store store = new Store();
store.setStoreName("hello");
out.print(store.getStoreName());



 %>
</body>
</html>