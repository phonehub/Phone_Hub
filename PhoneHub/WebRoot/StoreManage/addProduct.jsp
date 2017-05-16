<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/PhoneHub/servlet/AddProductCtrl" enctype="multipart/form-data" charset="utf-8" method="post">
商品名：<input type="text" name="productName" /></br>
价格：<input type="text" name="price" /><br>
CPU：<input type="text" name="cpu" /></br>
RAM：<input type="text" name="ram" /></br>
品牌:<input type="text" name="brand" /></br>
屏幕大小：<input type="text" name="screenSize" /><br>
体积:<input type="text" name="size" /><br>
网络类型：<input type="text" name="networkType" /></br>
颜色:<input type="text" name="color" /></br>
操作系统<input type="text" name="system" /></br>
容量大小：<input type="text" name="memory" /></br>
电池容量：<input type="text" name="battery" /></br>
前置摄像头：<input type="text" name="frontCamera" /></br>
后置摄像头：<input type="text" name="behindCamera" /></br>
核心数：<input type="text" name="coreNum" /></br>
库存量：<input type="text" name="num" /></br>
重量：<input type="text" name="weight" /></br>
产品描述：<input type="text" name="description" /></br>
图片1：<input type="file" name="image1" /></br>
图片2：<input type="file" name="image2" /></br>
图片3：<input type="file" name="image3" /></br>
<input type="submit" value="提交">
</body>
</html>