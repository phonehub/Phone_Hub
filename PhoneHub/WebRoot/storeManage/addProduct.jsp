<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

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
</head>
<body>
<div class="form-group" align="center">
<form action="/PhoneHub/servlet/AddProductCtrl" enctype="multipart/form-data" charset="utf-8" method="post">
商&emsp;品&emsp;名：<input type="text" name="productName" /></br>
价 &emsp;&emsp;&emsp;格：<input type="text" name="price" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><br>
C &emsp; P&emsp; U：<input type="text" name="cpu" /></br>
R &emsp; A&emsp; M：<input type="text" name="ram" /></br>
品 &emsp;&emsp;&emsp;牌：<input type="text" name="brand" /></br>
屏  幕  大  小：<input type="text" name="screenSize" /><br>
体 &emsp;&emsp;&emsp;积：<input type="text" name="size" /><br>
网  络  类  型：<input type="text" name="networkType" /></br>
颜 &emsp;&emsp;&emsp;色：<input type="text" name="color" /></br>
操  作  系  统：<input type="text" name="system" /></br>
容  量  大  小：<input type="text" name="memory" /></br>
电  池  容  量：<input type="text" name="battery" /></br>
前置摄像头：<input type="text" name="frontCamera" /></br>
后置摄像头：<input type="text" name="behindCamera" /></br>
核 &emsp;心 &emsp;数:<input type="text" name="coreNum" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></br>
库 &emsp;存 &emsp;量:<input type="text" name="num" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/></br>
重 &emsp;&emsp;&emsp;量：<input type="text" name="weight" /></br>
产  品  描  述：<input type="text" name="description" /></br>
图 &emsp;片 &emsp;1：<input type="file" name="image1" /></br>
图 &emsp;片 &emsp;2：<input type="file" name="image2" /></br>
图 &emsp;片 &emsp;3：<input type="file" name="image3" /></br>
</br>
<input type="submit" value="提交">
</div>
</body>
</html>