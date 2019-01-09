$(function(){
	//$(".header_blue").hide();
	// column margin-right:0
	$(".main .column .course_box").each(function(){
		// console.log($(this).index());
		if($(this).index() % 5 == 0){
			$(this).css("margin-right",0);
		}
	})
})