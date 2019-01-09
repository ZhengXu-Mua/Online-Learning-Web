<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/login.css">

</head>
<body>
<form action="/XMSCode_SSM_V1/login/toLogin.do" method="post">
	<div class="login_box">
		<div class="left col_50">
			<!-- <img src="images/login/logo_2.png">
			<h3>视频点播系统</h3> -->
		</div>
		<div class="right col_50 login_form">
			<div class="row_1 row_350 margin_40" >
				<input type="text" data-name="uname" name="email" placeholder="请输入用户名" autocomplete="off">
				
			</div>
			<div class="row_1 row_350">
				<input type="password" data-name="upass" name="password" placeholder="请输入密码">
				<label>${message}</label>
			</div>
			
			<div class="row_1">
				<input type="checkbox" name=""> 记住密码
				<a href="#" class="color_999 a_right">忘记密码</a>
			</div>
			<div class="row_1">
				<input type="submit" value="登录" />
			</div>
			<div class="row_1">
				<a href="register.html" class="color_blue a_right">立即注册</a>
			</div>

		</div>
	</div>
</form>
</body>
</html>