<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<link href="../css/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<script type="text/javascript">
window.onload = function() {
		var insert = window.document.getElementById("salelist");
		var storeId = <%=session.getAttribute("storeId")%>
		$.ajax({
			type : "get",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			url : "http://localhost:8080/PhoneHub/SaleAccountCtrl?storeId="+storeId,
			success : function(data) {
					var insert = $("#salelist");
					insert.empty();  
            		insert.append('<tr><th>编号</th><th>店铺编号</th><th>商品名</th><th>销量</th></tr>'); 
					var objs = eval(data);
					var obj = objs.saleList;
					for(var i=0;i<obj.length;i++){
   						var id = obj[i].productId;
   						var sid = obj[i].storeId;
   						var name = obj[i].productName;
   						var sum = obj[i].sum;
   						insert.append('<tr><td>'+id+'</td><td>'
   						+sid+'</td><td>'
   						+name+'</td><td>'
   						+sum
   						+'</td></tr>');
					}
				}
				});
				
	}
</script>
<body>
<div style=text-align:center>
	<p>销量列表</p>
	</div>
		<div align="center">
			<table id="salelist" align="center" class="bordered" cellspacing="0" cellpadding="0">
			
			</table>
		</div>

</body>
</html>