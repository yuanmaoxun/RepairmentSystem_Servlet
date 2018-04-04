/**
 * Loader
 */
if(typeof Pace != 'undefined'){
	Pace.on('hide', function(){
		$(".overlay").fadeOut(500,function(){
			$(this).remove();
		});
	});
}


/**
 * Colors
 */
$(document).ready(function(){
	$.each($("[data-bgcolor]"), function(){
		$(this).css("background-color",$(this).attr("data-bgcolor"));
	});
	$.each($("[data-color]"), function(){
		$(this).css("color",$(this).attr("data-color"));
	});
});

/**
 * Scrolling
 */
$("[data-scroll-target]").click(function(e){
	e.preventDefault();
	$("html,body").animate({scrollTop: $($(this).attr("data-scroll-target")).position().top},500);
});

/**
 *  Tooltip
 */

$('[title]').filter("[data-toggle='tooltip']").tooltip({
	trigger: 'hover focus',
	html: $(this).attr('title'),
	container: 'body',
});

/**
 *  Float Lebel Setting
 */
$("input,textarea,select").keyup(function(){
	if($(this).val().trim()!="")
		$("label[for='"+$(this).attr('id')+"']").addClass('active');
	else
		$("label[for='"+$(this).attr('id')+"']").removeClass('active');
}).blur(function(){
	if($(this).val().trim()!="")
		$("label[for='"+$(this).attr('id')+"']").addClass('active');
	else
		$("label[for='"+$(this).attr('id')+"']").removeClass('active');
});