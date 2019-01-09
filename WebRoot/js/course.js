$(function(){

	$(".course_box .courses a").each(function(){
		// console.log($(this).index()+1);

		if(($(this).index()+1) % 5 == 0){
			$(this).css("margin-right",0);
		}

	})

	$(".category span").click(function(event) {
		$(this).addClass('current').siblings().removeClass('current');
		var i = $(this).index()-1;
		// console.log(i);
		$(this).siblings('label').attr("title",i);
	});

	// 全选/反选
//	$("input[name=all]").click(function(){
//		// console.log($(this).prop("checked"));
//		console.log($("input[name=pro]").length);
//		// $("input[name=pro]").prop("checked",$(this).prop("checked"));
//		$("input[type=checkbox]").prop("checked",$(this).prop("checked"));
//		
//	})

	// 全部商品
	$(".car_box span[name=all_counts]").html($(".car_box ul li").length);


//	$("input[type=checkbox]").prop("checked",true);
	

	

	
	
	
	

	

	// 确认付款
	$("#confirm").click(function(){
		// 满足6位数字
		if(new RegExp(/^[0-9]{6}$/).test($("#payPassword_rsainput").val())){
			window.location = "paySuccess.html";
		}
	})


})