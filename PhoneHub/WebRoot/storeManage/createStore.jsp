<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="cn.edu.zhku.phonehub.store.model.Store" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
form{
margin-left:auto;
margin-right:auto;
max-width: 500px;
background: #D2E9FF;
padding: 20px 20px 20px 20px;
font: 12px Arial, Helvetica, sans-serif;
color: #666;
}
form  input[type="text"]{
	border: 1px solid #DADADA;
color: #888;
height: 30px;
margin-bottom: 16px;
margin-right: 6px;
margin-top: 2px;
outline: 0 none;
padding: 3px 3px 3px 5px;
width: 70%;
font-size: 12px;
line-height:15px;
box-shadow: inset 0px 1px 4px #ECECEC;
-moz-box-shadow: inset 0px 1px 4px #ECECEC;
-webkit-box-shadow: inset 0px 1px 4px #ECECEC;
}
</style>
<body>
<div>
<form action="/PhoneHub/servlet/CreateStoreCtrl" enctype="multipart/form-data" charset="utf-8" method="post">
用户编号：<input type="text" name="userId" /></br>
店铺名：<input type="text" name="storeName" /></br>
地址：<input type="text" name="location" /><br>
经营品牌：<input type="text" name="businessBrand" /><br>
身份证正面：<input type="file" name="idCard" /></br>
身份证反面：<input type="file" name="idCard" /></br>
身份证号：<input type="text" name="idCardNumber" /><br>
<input type="submit" value="提交">
</form>
</div>
</body>
</html>