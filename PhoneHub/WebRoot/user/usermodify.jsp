<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usermidify.jsp' starting page</title>
    


  <script>
  function check() {
	var p1=document.getElementById("password");
	var p2=document.getElementById("password1");
     if (p1.value.length<6||p1.value.length>20) {
        alert("用户名不合规格,长度要在[6,20]");
        return false;
    } 
     if (p1.value!=p2.value) {
        alert("两次输入密码不一致！");
        return false;
    }
    return true;
}
function formsubmit() {
	    if(!check())
		    return false;
	
		document.form.action = "/PhoneHub/user/ModifyCtrl";
		document.form.submit();
		alert("成功");
		}
  </script>
  </head>
  
  <body>
    <form action="" enctype="multipart/form-data"  method="post" name="form">

   请输入新的密码<input type="password" id="password" name="passWord" value="111111"><br>
   请再次输入：<input type="password" id="password1"><br>
    <input type="file" name="HeadImage" value="上传头像"><br>
       <input type="hidden" name="userName" value="111" > 
     <input type="submit" onclick="formsubmit() "value="提交">
    </form>
  </body>
</html>
