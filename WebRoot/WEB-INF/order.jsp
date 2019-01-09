<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/index.css">
	<link rel="stylesheet" type="text/css" href="../css/comm.css">
	<link rel="stylesheet" type="text/css" href="../css/course.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/course.js"></script>
	<script type="text/javascript" src="../js/index.js"></script>
	<script type="text/javascript">
		function order(){
			var itemIds = [];
			var inputs = $("input[type=hidden]");
			for(var i =0;i<inputs.length;i++){
				itemIds[i] = inputs[i].value;
			}
			document.location.href = "/XMSCode_SSM_V1/main/order.do?itemIds="+itemIds;
		}
	</script>

</head>
<body id="body">
	<!-- 引入头部start -->
	<%@ include file="head.jsp" %>
	<!-- 引入头部end -->
	
	<!-- car_box -->
	<div class="order_box autoH">
		<div class="auto">
			<h1>确认订单</h1>
			<div class="order_pic order_check">	
				<p class="p2 autoH"><span class="left">商品信息</span></p>
				<ul>
					<c:forEach items="${items}" var="item">
						<li>
							<input type="hidden" value="${item.id}"/>
							<a class="left" href="#"><img src="${item.c_picture_url}" alt=""></a>
							<span class="proName left"><a href="#">${item.c_name }</a></span>
							<span class="price left">￥${item.c_price}</span>
						</li>
					</c:forEach>
				</ul>

				<p class="p1 p3 autoH"><a href="#" class="f16"><span class="left">使用优惠券</span></a><a class="right" href="">什么是优惠券?</a></p>
				<div class="bottom">
					<p>共<span>${fn:length(items)}</span>件商品，商品总金额:<span class="pay oldPrice">￥399.00</span></p>	
					<p>实付款:<span class="pay payment">￥${totalPrice }</span></p>
					<p>购买账号:<span class="uname">${User.nickname }</span></p>
					<p><a href="/XMSCode_SSM_V1/main/toCar.do">返回购物车</a><a href="javascript:order();"><span>提交订单</span></a></p>
					<p><input type="checkbox" name="confirm"> 我已经阅读并同意<a href="#">《用户付费协议》</a></p>
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