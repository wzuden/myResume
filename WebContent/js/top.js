$(document).ready(function(){
 $(".personal-zone").hover(function(){
    $(this).find("div").removeClass("fn-hide")
    $(this).find("i").css("transform","rotate(180deg)");

 },
 	function(){
 	$("i").css("transform","rotate(360deg)");	
    $(this).find("div").addClass("fn-hide");
});

$(".list li ").click(function(){
 $(this).addClass("active").siblings().removeClass("active");

});
$(".list li a").click(function(e){
   e.preventDefault();
   $('html, body').animate({
    'scrollTop': $($(this).attr('href')).offset().top
  }, 400);

});
var $navs = $(".list li a"),          // 导航
    $modules = $('.module'),       // 模块
    $window = $(window),
    navLength = $navs.length - 1;
   
$window.on('scroll', function() {
    var scrollTop = $window.scrollTop(), 
              len = navLength;
    for (; len > -1; len--) {
     var that = $modules.eq(len);
     if ((scrollTop+40)>= that.offset().top) {
       $(".list li ").removeClass('active').eq(len).addClass('active');
       break;
    }
  }
   if (scrollTop>100){
                    $("#back-to-top").fadeIn(1500);
                }
                else
                {
                    $("#back-to-top").fadeOut(1500);
                }
});
$("#back-to-top").click(function(){
                $('body,html').animate({scrollTop:0},1000);
                return false;
 });

});


