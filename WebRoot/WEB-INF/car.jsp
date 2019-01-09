<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/index.css">
	<link rel="stylesheet" type="text/css" href="../css/comm.css">
	<link rel="stylesheet" type="text/css" href="../css/course.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/course.js"></script>
	<script type="text/javascript" src="../js/index.js"></script>
	<script type="text/javascript">
		function deleteAll(){
			//记录当前mytr中被选中的label的data-id值
			var $label = $(".car .checked");
			if($label.length==0){
				alert("请至少选中一条记录...");
				return ;
			}
			//记录所有选中label的data-id值
			var ids = [];
			$.each($label,function(index,obj){
				ids.push($(obj).attr("id"));
			});
			
			document.location.href="/XMSCode_SSM_V1/main/deleteAll.do?item_ids="+ids;
			return ;
			
		}
		$(function choose(){
			$(".check").unbind().on("click",function(){
				if ($(this).hasClass("checked")) {
					var price = parseFloat($(this).siblings(".price").html().substring(1))+0.0;
			        $("span[name = prices]").html((parseFloat($("span[name = prices]").html())+0.00-price).toFixed(2));
			        $("span[name = count]").html( parseFloat($("span[name = count]").html())-1 );
			        $(this).removeClass("checked"); 
			        $("input[name=all]").removeClass("checked");
			    } else {
			        $(this).addClass("checked");
			        var price = parseFloat($(this).siblings(".price").html().substring(1))+0.0;
			        $("span[name = prices]").html((parseFloat($("span[name = prices]").html())+0.00+price).toFixed(2));
			        $("span[name = count]").html( parseFloat($("span[name = count]").html())+1 );
			    }
			});
		});
		$(function(){
			$("input[name=all]").click(function(){
				$("input[type=checkbox]").prop("checked",$(this).prop("checked"));
				if ($(this).hasClass("checked")) {
					$(this).removeClass("checked");
					$(".check").removeClass("checked");
					$("span[name = prices]").html((0.00).toFixed(2)); 
				}else{
					$(this).addClass("checked");
					$(".check").addClass("checked");
					var item_prices = document.getElementsByName("price");
					var prices = 0.0;
					for(var i=0;i<item_prices.length;i++){
						prices += parseFloat($(item_prices[i]).html().substring(1));
					}
					$("span[name = prices]").html(prices.toFixed(2));
				}
			})
		});
		function toOrder(){
			//记录当前mytr中被选中的label的data-id值
			var $label = $(".car .checked");
			if($label.length==0){
				alert("请至少选中一条记录...");
				return ;
			}
			//记录所有选中label的data-id值
			var ids = [];
			$.each($label,function(index,obj){
				ids.push($(obj).attr("id"));
			});
			
			document.location.href="/XMSCode_SSM_V1/main/toOrder.do?item_ids="+ids;
			return ;
		}
		
	</script>

</head>
<body id="body">
	<!-- 引入头部start -->
	<%@ include file="head.jsp" %>
	<!-- 引入头部end -->
	
	<!-- car_box -->
	<div class="car_box autoH">
		<div class="auto">
			<h1>购物车</h1>
			<div class="tit2">
				<span class="s1">商品信息</span><span class="s2">金额</span><span>操作</span>
			</div>
			<ul class="car">
				<c:forEach items="${items}" var="item">
					<li>
						<input type="checkbox" class="check" name="item_checkbox" id="${item.id}">
						<a href="#"><img src="${ item.c_picture_url}" alt=""></a>
						<span class="proName"><a href="#">${item.c_name}</a></span>
						<span name="price" class="price">￥${item.c_price}</span>
						<span class="del" onclick="javascript:document.location.href='/XMSCode_SSM_V1/main/delete.do?item_id=${item.id}'">删除</span>
					</li>
				</c:forEach>
				
			</ul>
			<div class="tit2 autoH tit_bottom">
				<p class="left">
					<input class="chooseAll" type="checkbox" name="all"> 全选
					<a href="#" class="delAll" onclick="deleteAll()">删除</a>
				</p>
				<p class="right">
					<span>已选商品<span name="count">0</span>件</span>
					<span>合计:<span name="prices">0.00</span></span>
					<a href="javascript:toOrder();"><span name="pay">结算</span></a>
				</p>
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