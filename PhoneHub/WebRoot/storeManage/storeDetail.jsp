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
		alert("running");
		var insert = window.document.getElementById("insert");
		var userId = <%=session.getAttribute("userId")%>;
		var status;
		$.ajax({
			type : "get",
			dataType : "json",
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : "http://localhost:8080/PhoneHub/GetStoreDetail?userId="+userId,
			success : function(data) {
				alert(<%=session.getAttribute("storeId") %>);
				if(data==null){
					var resualt = "";
					var button = "button";
					var value = "开通店铺"
					resualt += "<tr><p>您暂未开通店铺</p></tr></br><input type="+button+" value="+value+">";
					insert.innerHTML = resualt;
				}
				if(1 == data.status){
					status="审核通过";
				}
				else if(2 == data.status){
					status="待审核";
				}
				else if(3 == data.status){
					status="审核不通过";
				}
				else if(4 == data.status){
					status="禁售";
				}
				else if(5 == data.status){
					status="暂停营业";
				}
				var str = "";
				str += "<tr><th>店铺编号</th><td>" + data.storeId + "</td></tr>"
						+ "<tr><th>店名</th><td>" + data.storeName + "</td></tr>"
						+ "<tr><th>地址</th><td>" + data.location + "</td></tr>"
						+ "<tr><th>法人代表</th><td>" + data.holderName+ "</td></tr>" 
						+ "<tr><th>经营品牌</th><td>"+ data.businessBrand + "</td></tr>"
						+ "<tr><th>身份证证号</th><td>" + data.idCardNumber+ "</td></tr>" 
						+ "<tr><th>身份证</th><td>" + data.idCard+ "</td></tr>"
						+"<tr><th>状态</th><td>" + status + "</td></tr>";
				insert.innerHTML = str;
			},
			//请求出错的处理  
			error : function() {
				alert("false");
			}

		});
	}
</script>
<style type="text/css">
table, td{
	font:100% Arial, Helvetica, sans-serif; 
}
table{width:80%;border-collapse:collapse;margin:1em 0;}
th, td{text-align:center;padding:.5em;border:1px solid #fff;}
th{background:#328aa4 url(tr_back.gif) repeat-x;color:#fff;}
td{background:#e5f1f4;}

/* tablecloth styles */

tr.even td{background:#e5f1f4;}
tr.odd td{background:#f8fbfc;}

th.over, tr.even th.over, tr.odd th.over{background:#4a98af;}
th.down, tr.even th.down, tr.odd th.down{background:#bce774;}
th.selected, tr.even th.selected, tr.odd th.selected{}

td.over, tr.even td.over, tr.odd td.over{background:#ecfbd4;}
td.down, tr.even td.down, tr.odd td.down{background:#bce774;color:#fff;}
td.selected, tr.even td.selected, tr.odd td.selected{background:#bce774;color:#555;}

/* use this if you want to apply different styleing to empty table cells*/
td.empty, tr.odd td.empty, tr.even td.empty{background:#fff;}
</style>
	<body>
	<div align="center">
	<p>店铺登记信息</p>
	</div>
		<div align="center">
			<table id="insert">
			</table>
		</div>
	</body>
</html>