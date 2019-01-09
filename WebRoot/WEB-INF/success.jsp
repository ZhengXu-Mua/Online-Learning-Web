<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%><!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学码网</title>
	<link rel="stylesheet" type="text/css" href="../css/index.css">
	<link rel="stylesheet" type="text/css" href="../css/comm.css">
	<link rel="stylesheet" type="text/css" href="../css/course.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/course.js"></script>
	<script type="text/javascript" src="../js/jqPaginator.js"></script>
	<script type="text/javascript" src="../js/index.js"></script>

</head>
<body id="body">
	<!-- 引入头部start -->
	<%@ include file="head.jsp" %>
	<!-- 引入头部end -->
	
	<!-- car_box -->
	<div class="order_box pay_box success autoH">
		<div class="auto">
			<h1>成功付款</h1>
			<div class="order_pic">	
				<p class="p1 autoH"><a class="right" href="">我有疑问，需要反馈？</a></p>
				<div class="successInfo">
					<p>
						<span class="left icon"><img src="../images/success_03.png"></span>您已经成功付款<span>${totalPrice }</span>元
					</p>
					<p>
					<a href="#">已购买的课程</a> | <a href="#">订单详情</a> | <a href="#">联系我们</a>
					</p>
					<p><span class="left"><img src="../images/success_07.png"></span>安全提醒：下单后，用邮箱给您发送链接办理退款的都是骗子</p>
				</div>
				
			</div>

		</div>
		
	</div>
	<!-- foot -->
	<div class="foot foot_blue">
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