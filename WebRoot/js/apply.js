$(window).ready(function() {
	
    $(".i-text").keyup(function()
	{
		var inp_v = $(this).val();
		var inp_l = inp_v.length;
		//$("p").html( "input的值为：" + inp_v +"; " + "值的长度为:" + inp_l);//测试用
		
		for( var x = 0; x<=6; x++)
		{
			// $("p").html( inp_l );//测试
			
			$(".sixDigitPassword").find("i").eq( inp_l ).addClass("active").siblings("i").removeClass("active");
			$(".sixDigitPassword").find("i").eq( inp_l ).prevAll("i").find("b").css({"display":"block"});
			$(".sixDigitPassword").find("i").eq( inp_l - 1 ).nextAll("i").find("b").css({"display":"none"});
			
			$(".guangbiao").css({"left":inp_l * 51});//光标位置
			
			if( inp_l == 0)
			{
				$(".sixDigitPassword").find("i").eq( 0 ).addClass("active").siblings("i").removeClass("active");
				$(".sixDigitPassword").find("b").css({"display":"none"});
				$(".guangbiao").css({"left":0});
			}
			else if( inp_l == 6)
			{
				$(".sixDigitPassword").find("b").css({"display":"block"});
				$(".sixDigitPassword").find("i").eq(5).addClass("active").siblings("i").removeClass("active");
				$(".guangbiao").css({"left":5 * 51});
			}
			
			
		}
	});
	
});