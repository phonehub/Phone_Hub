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
var storeId = <%=request.getParameter("storeId")%>;
	if(confirm("是否通过审核")){
		$.ajax({
			type : "get",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : "http://localhost:8080/PhoneHub/PassApplyCtrl?storeId="+storeId,
			success : function(data) {
				if(data.resualt==true){
					alert("审核成功");
					window.location.href="storeList.jsp";
				}
				else{
					alert("审核失败，请重试");
					window.location.href="storeList.jsp";
				}
			},
			//请求出错的处理  
			error : function() {
				window.location.href="storeList.jsp";
			}

		});
	}
	else{
		$.ajax({
			type : "get",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : "http://localhost:8080/PhoneHub/RefuseApplyCtrl?storeId="+storeId,
			success : function(data) {
				if(data.resualt==true){
					alert("审核不通过");
					window.location.href="storeList.jsp";
				}
				else{
					alert("失败，请重试");
					window.location.href="storeList.jsp";
				}
			},
			//请求出错的处理  
			error : function() {
				window.location.href="storeList.jsp";
			}

		});
	}
}
</script>
<body>

</body>
</html>