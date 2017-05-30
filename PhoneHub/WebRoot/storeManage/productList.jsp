<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
	</head>
	<script type="text/javascript">
	window.onload = function() {
		var insert = window.document.getElementById("productlist");
		var storeId = <%=session.getAttribute("storeId")%>
		alert("run here");
		$.ajax({
			type : "get",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url : "http://localhost:8080/PhoneHub/GetProductListCtrl?storeId="+storeId,
			success : function(data) {
					var insert = $("#productlist");
					insert.empty();  
            		insert.append('<tr><th>编号</th><th>商品名</th><th>品牌</th><th>颜色</th><th>容量</th><th>库存</th><th>状态</th><th>修改库存</th><th>下架</th></tr>'); 
					var objs = eval(data);
					var obj = objs.productList;
					for(var i=0;i<obj.length;i++){
   						var id = obj[i].productId;
   						var name = obj[i].productName;
   						var brand = obj[i].brand;
   						var color = obj[i].color;
   						var memory = obj[i].memory;
   						var num = obj[i].num;
   						var stauts = obj[i].stauts;
   						var button = "button";
						var value = "修改";
   						if(stauts==1){
   							stauts = "已下架";
   						}
   						else{
   							stauts = "在售中";
   						}
   						insert.append('<tr><td>'+id+'</td><td>'
   						+name+'</td><td>'
   						+brand+'</td><td>'
   						+color+'</td><td>'
   						+memory+'</td><td>'
   						+num+'</td><td>'
   						+stauts+'</td><td>'
   						+'<a href="alterCount.jsp?productId='+id+'" >修改</a>'+'</td><td>'
   						+'<a href="dropProduct.jsp?productId='+id+'" >下架</a>'
   						+'</td></tr>');
					}
				}
				});
	}
	
	function alter(){
		alert();
	}
	
</script>
<style type="text/css">
table {
    *border-collapse: collapse; /* IE7 and lower */
    border-spacing: 0;
    width:80%
}
.bordered{
	border:solid #ccc 1px;
	-moz-border=radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	-webkit-box-shadow:0 1px 1px #ccc;
	-moz-box-shadow:0 1px 1px #ccc;
	box-shadow:0 1px 1px #ccc
}
.bordered tr{
	-o-transition: all 0.1s ease-in-out; 
	-webkit-transition: all 0.1s ease-in-out; 
	-moz-transition: all 0.1s ease-in-out; 
	-ms-transition: all 0.1s ease-in-out; 
	transition: all 0.1s ease-in-out;
}
.bordered .highlight, 
.bordered tr:hover { 
	background: #fbf8e9;
} 
.bordered td, 
.bordered th { 
	border-left: 1px solid #ccc; 
	border-top: 1px solid #ccc;
	padding: 10px; 
	text-align: left; 
} 
.bordered th {
	background-color: #dce9f9;
	background-image: 
	-webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
	background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9); 
	background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9); 
	background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9); 
	background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9); 
	background-image: linear-gradient(top, #ebf3fc, #dce9f9); 
	filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0, startColorstr=#ebf3fc, endColorstr=#dce9f9); 
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient (GradientType=0, startColorstr=#ebf3fc, endColorstr=#dce9f9)"; 
	-webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;
	 -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset; 
	 box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
	 border-top: none; text-shadow: 0 1px 0 rgba(255,255,255,.5); 
} 
.bordered td:first-child,
.bordered th:first-child { 
	border-left: none; 
} 
.bordered th:first-child { 
	-moz-border-radius: 6px 0 0 0; 
	-webkit-border-radius: 6px 0 0 0; 
	border-radius: 6px 0 0 0; 
} 
.bordered th:last-child { 
-moz-border-radius: 0 6px 0 0; 
-webkit-border-radius: 0 6px 0 0; 
border-radius: 0 6px 0 0; } 
.bordered tr:last-child td:first-child { 
-moz-border-radius: 0 0 0 6px; 
-webkit-border-radius: 0 0 0 6px; 
border-radius: 0 0 0 6px; } 
.bordered tr:last-child td:last-child { 
-moz-border-radius: 0 0 6px 0; 
-webkit-border-radius: 0 0 6px 0;
 border-radius: 0 0 6px 0; }
</style>
	<body>
	<div style=text-align:center>
	<p>商品列表</p>
	</div>
		<div>
			<table id="productlist" align="center" class="bordered">
			
			</table>
		</div>
	</body>
</html>