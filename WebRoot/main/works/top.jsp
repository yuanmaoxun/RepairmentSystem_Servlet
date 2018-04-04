<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Relient - Responsive Multiperpose Theme</title>
		
		<!-- Preloader CSS -->
		<!-- <script src="js/pace.min.js"></script>-->
		
		<!-- Meta Viewport -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
		
		<!-- Meta description and keywords -->
		<meta name="description" content="">
		<meta name="keywords" content="">
		
		<!-- Shortcut icons And Apple touch icon -->
		<link rel="shortcut icon" href="img/favicon.png" >
		<link rel="apple-touch-icon" href="img/favicon.png" >
		
		<!-- Preloader CSS -->
		<!--<link rel="stylesheet" href="css/pace.css" >-->
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		
		<!-- Universal stylesheet (Shouldbe used with all multiperpose pages) -->
		<link rel="stylesheet" href="css/multiperpose.css">
		<link rel="stylesheet" href="css/main.css">
		
		<!-- Custom CSS (Page Specific) < Editable > -->
		<link rel="stylesheet" href="css/pages/page-multi-perpose.css">
		
		<!-- Custom CSS (color theme) < Editable > -->
		<link rel="stylesheet" href="css/color-theme/business/blue.css">
		
		<!-- CSS Only for demo delete in original vrsion -->
		<link rel="stylesheet" href="css/demo.css">
		<style>
			#div1{
				margin:0px 0px 0px 0px;
			}
		</style>
  </head>
  <body class="bg-17" style="background-color:#d5e2e1">
	
		
		<div class="layout full-width" ">
	
			 <div class="slider-wrapper" style="height:230px; background-color:#b2b3df;box-shadow: inset 10px 10px 20px #d5e2e1;border-radius:30px;"><!--蓝色框框高度-->
					<div class="container" style="height:230px; top:50px;">
					<div class="row">
						<div class="carousel slider" id="main-slider" data-ride="carousel" style="height:200px;top=50px;">
							<!-- Indicators -->
							<!-- Wrapper for slides -->
							<div class="carousel-inner" id="div1" style="height:200px;top:20px;"><!--蓝色框中的字体高度-->
								<div class="item active">
								  <div class="container">
										<div class="row">
											<div class="col-xs-12" style="height:200px;top:0px;">
												<div class="carousel-caption" style="top:0px;">
													<h3 class="slider-heading animated fadeInDownBig a-d-3 text-center" style="margin-top:5px;">设备维修系统</h3>
													<h4 class="slider-subheading animated fadeInDown a-d-7 color-inverse text-center">欢迎 ${loginInfo}</h4>
												  <div class="col-lg-4 col-md-6 col-sm-12 text-left" style="height:30px;">
														<ul class="list-unstyled slider-content">
															<li class="animated fadeInUp a-d-9"><span class="fa fa-check-square-o"></span> 精益求精  日臻完善</li>
															<!-- <li class="animated fadeInUp a-d-16"><span class="fa fa-check-square-o"></span> 日臻完善</li>-->
														</ul>
														
													</div>
													<div class="col-lg-4 col-md-6 hidden-xs hidden-sm text-center">
													<ul class="list-unstyled slider-content">
														<li class="animated fadeInDown a-d-9"><span class="fa fa-check-square-o"></span> 竭诚服务 让您安心</li>
															<!--<li class="animated fadeInDown a-d-13"><span class="fa fa-check-square-o"></span> 让您安心 </li>-->
													</ul>
													</div>
													<div class="col-lg-4 hidden-xs hidden-sm hidden-md text-right">
														<ul class="list-unstyled slider-content">
															<li class="animated fadeInUp a-d-9"><span class="fa fa-check-square-o"></span> <a href="/RepairmentSystem/login.html" style="color:#ffffff" target="_parent">退出</a></li>
															<!--<li class="animated fadeInUp a-d-16"><span class="fa fa-check-square-o"></span> Clean and cmmented code</li>-->
														</ul>
														
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
				
						  </div>
							
					  </div>
					</div>
				</div>
				
	</div>

	</div>	
		<!-- jQuery -->
		<script src="js/jquery-2.1.1.min.js"></script>
		
		<!-- Bootstrap -->
		 <script src="js/bootstrap.min.js"></script>
		
		<!-- Universal JS for all pages js < Editable > -->
		<script src="js/multiperpose.js"></script>
		
		<!-- JS for specific this page <Editable> -->
		<script src="js/pages/page-multi-perpose.js"></script>

	</body>
</html>
