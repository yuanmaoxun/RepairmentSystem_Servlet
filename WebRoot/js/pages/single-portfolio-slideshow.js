/**
 *  Variables (User editable)
 *  This slideshow will works only with sngle-portfoilo.html file and with the top most section which is Port Showcase currently  
 */
var slide_img=['img/backgrounds/showcase-bg.jpg', 'img/backgrounds/counter-bg.jpg', 'img/backgrounds/bg-image-1.jpg', 'img/backgrounds/bg-image-2.jpg']; // Array containing image list participate in slide show
var speed=2000; // Time taken to a change the slide
var interval=5000; // Time, a slide will stable on the screen
var lowest_opacity=0;
var heighest_opacity=1;

/**
 * Plugin code (Not editable for general user)
 */

var current_slide=0;
$(".bg-wrapper").before("<div class=\"bg-wrapper temp\"></div>").css('background-image','url('+slide_img[slide_img.length-1]+')');
var change_slide=function(){
	var wrapper=$(".bg-wrapper").not(".temp");
	var temp=$(".bg-wrapper.temp");
	$(temp).css('background-image','url('+slide_img[current_slide]+')');
	$(wrapper).animate({
		'opacity' : lowest_opacity
		}, speed, function(){
			$(wrapper).remove();
			$(temp).removeClass("temp").before("<div class=\"bg-wrapper temp\"></div>");
			if(++current_slide==slide_img.length)
				current_slide=0;
		}
	);
};
setInterval(function(){change_slide()}, interval);