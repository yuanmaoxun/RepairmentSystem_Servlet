/**
 * Side Bar Navigation Menu
 */
if($.fn.metisMenu){
	$(function () {
	    $('#side-nav').metisMenu();
	});
}
var status=0;
$("[data-toggle='side-nav']").click(function(e){
	e.preventDefault();
	toggleSideNav($(this).attr('data-target'),$(this).attr('data-style'));
});
var bodyLeftMargin=$("body").css("margin-left");
function openSideNav(elem,style){
	if(status==0){
		if(style=="reveal"){
			bodyLeftMargin=$("body").css("margin-left");
			var left="-250px";
			if(localStorage.getItem('layout') == 'boxed'){
				left="-"+(250-2*parseInt($("body").css("margin-left")))+"px";
			}
			$("body").stop().animate({"margin-left":left});
		}
		$(elem).stop().animate({left: "-250px"},
			function(){
				status=1;
		});
		return true;
	}
	return false;
}
function closeSideNav(elem,style){
	if(status!=0){
		if(style=="reveal"){
			$("body").stop().animate({"margin-left":bodyLeftMargin});
		}
		$(elem).stop().animate({left: "0px"},
			function(){
				status=0;
		});
		return true;
	}
	return false;
}
function toggleSideNav(elem,style){
	if(status==0)
		openSideNav(elem,style);
	else
		closeSideNav(elem,style);
}

/**
 * Touch Settings
 */
if(typeof Hammer != 'undefined'){
	if($("#home-slider").length>0)
		Hammer(document.getElementById('home-slider')).on("swipeleft", function(event) {
			$('.slider').carousel('next');
		}).on("swiperight", function(event) {
			$('.slider').carousel('prev');
		});
	Hammer(document.body).on("swiperight", function(event) {
		closeSideNav($("[data-toggle='side-nav']").attr('data-target'), $("[data-toggle='side-nav']").attr('data-style'));
	}).on("swipeleft", function(event) {
		openSideNav($("[data-toggle='side-nav']").attr('data-target'), $("[data-toggle='side-nav']").attr('data-style'));
	});
}

/**
 * Slider
 */
if($.fn.owlCarousel){
	$(document).ready(function(){
		$(".client-slider").owlCarousel({
			items: 5,
			autoPlay: true,
			pagination: false,
		});
	});
}