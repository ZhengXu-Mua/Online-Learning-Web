<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
	<meta  http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>注册</title>
	<link rel="stylesheet" type="text/css" href="../css/comm.css">
	<link rel="stylesheet" type="text/css" href="../css/register.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/register.js"></script>
</head>
<body>
	<div class="head">
		<div class="auto">
			<img src="../images/logo.png">
		</div>
	</div>
	<div class="auto register_box">
		<form action="/XMSCode_SSM_V1/registe/registe.do" method="post">
			<h3>新用户注册</h3>
			<div class="rows">
				<label>邮箱账号</label>
				<input type="text" name="email" id="email" placeholder="请输入邮箱账号">
				<p id="p_email"></p>
			</div>
			<div class="rows">
				<label>登录密码</label>
				<input type="password" name="password" id="password" placeholder="请输入密码">
				<p id="p_password"></p>
			</div>
			<div class="rows">
				<label>昵称</label>
				<input type="nickname" name="nickname" id="nickname" placeholder="请输入昵称">
				<p id="p_nickname"></p>
			</div>
			<div class="rows">
				<label>验证码</label>
				<input type="text" name="code"  id="code" data-title="ucode" placeholder="请输入验证码">
				<input type="button" data-title="sendmess" value="发送验证码" onclick="javascript:createCode();"/>
				<p id="p_code"></p>
			</div>
			<div class="rows">
				<input type="button" data-title="submit" value="立即注册" onclick="javascript:putOn();"/>
			</div>

		</form>
	</div>
	<!-- foot -->
	<div class="foot">
		<a href="#">关于我们</a>
		<a href="#">最新动态</a>
		<a href="#">代理合作</a>
		<span>南京学码思科技教育有限公司</span>       
		<span>@2017</span> 
		<span>京ICP备</span>
		<span>1234567号</span>      
	</div>
</body>
</html>