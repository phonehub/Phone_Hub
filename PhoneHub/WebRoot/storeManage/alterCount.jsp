<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.onload = function() {
	var productId = <%=request.getParameter("productId")%>;
	var num = prompt("请输入新的库存量：");
	if(num!=null){
		$.ajax({
			type : "get",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : "http://localhost:8080/PhoneHub/AlterCountCtrl?productId="+productId+"&count="+num,
			success : function(data) {
				if(data.resualt==true){
					alert("修改成功");
					window.location.href="productList.jsp";
				}
				else{
					alert("修改失败，请重试");
					window.location.href="productList.jsp";
				}
			},
			//请求出错的处理  
			error : function() {
				window.location.href="productList.jsp";
			}

		});
	}
	else{
		window.location.href="productList.jsp";
	}
}
</script>
<body>

</body>
</html>