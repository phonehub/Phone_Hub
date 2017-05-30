<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function change(status){
		if(status==1){
			status="审核通过";
			return status;
		}
		else if(status==2){
			status="待审核";
			return status;
		}
		else{
			status="审核不通过";
			return status;
		}
	}
window.onload = function() {
		alert("running");
		var status;
		$.ajax({
			type : "get",
			dataType : "json",
			contentType: "application/json; charset=utf-8",
			url : "http://localhost:8080/PhoneHub/GetStoreListCtrl",
			success : function(data) {
					alert("success");
					var insert = $("#storelist");
					insert.empty();  
            		insert.append('<tr><th>编号</th><th>店名</th><th>地址</th><th>店主</th><th>经营品牌</th><th>身份证号</th><th>状态</th><th>详细</th><th>审核</th></tr>'); 
					var objs = eval(data);
					var obj = objs.storelist;
					for(var i=0;i<obj.length;i++){
						var id = obj[i].storeId;
						
   						var name = obj[i].storeName;
   						
   						var location=obj[i].location;
   						
   						var holder = obj[i].holderName;
   						
   						var brand = obj[i].businessBrand;
   						
   						var idCardNumber = obj[i].idCardNumber;
   						
   						var status = obj[i].status;
   						status = change(status);
   						insert.append('<tr><td>'+id+'</td><td>'
   						+name+'</td><td>'
   						+location+'</td><td>'
   						+holder+'</td><td>'
   						+brand+'</td><td>'
   						+idCardNumber+'</td><td>'
   						+status+'</td><td>'
   						+'<a href="detail.jsp?storeId='+id+'" >详情</a>'+'</td><td>'
   						+'<a href="verify.jsp?storeId='+id+'" >更改审核</a>'
   						+'</td></tr>');
					}
					
			},
			//请求出错的处理  
			error : function() {
				alert("false");
			}

		});
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
</head>
<body>
<body>
	<div style=text-align:center>
	<p>店铺列表</>
<div>
			<table id="storelist" class="bordered" align="center">
			
			</table>
			</div>
</body>
</html>