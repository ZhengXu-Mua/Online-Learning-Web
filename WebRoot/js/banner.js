
            $(function(){
                var items = $('.banner').children();
                var len = items.length;
                var index = 0;
                var str = 0;
                var dots =  $('.points').children();
                var t;
                console.log(len);
                console.log(dots);
                
                $(items[index]).fadeIn(1000);
                
                //自动播放函数play()
                function play(){
                    $(dots).removeClass("current");
                    // console.log(index);
                    if(index >=0 & index < len-1){
                        index++;
                    }else{
                        index=0;
                    };
                    next(index);
                    str = index;
                } 
                $(dots.eq(0)).addClass("current")
                t = setInterval(play,4000);
                // play();
                function next(i){
                    //当前正在滚动的动画
                    var current=items.filter(".current");
                    current.stop(true,true);
                    current.removeClass(".current").fadeOut(500),
                    items.eq(i).addClass("current").fadeIn(1000);
                    $(dots.eq(i)).addClass("current").siblings().removeClass("current");
                }
                //点击左侧按钮的函数
                $(".prev").click(function(){
                    index--;
                    index=index<0?len-1:index;
                    next(index);
                    
                });
                //点击右侧按钮的函数
                $(".next").click(function(){
                    index++;
                    index=index>len-1?0:index;
                    next(index);
                    
                })
                //小圆点
                $(".points span").click(function(){
                    var num = $(this).index();
                    next(num);
                    index = num;
                })

                //进入暂停
                $(".banner_box").mouseover(function(){
                	clearInterval(t);
                }).mouseout(function(){
                	t = setInterval(play,4000);
                })
            });
        