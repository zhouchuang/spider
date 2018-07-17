<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>彭敏奢侈品官网 | 首页 </title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="js/jquery.min.js"></script>
	 	<!---strat-slider---->
	    <link rel="stylesheet" type="text/css" href="css/slider.css" />
		<script type="text/javascript" src="js/modernizr.custom.28468.js"></script>
		<script type="text/javascript" src="js/jquery.cslider.js"></script>
			<script type="text/javascript">
				$(function() {
				
					$('#da-slider').cslider({
						autoplay	: true,
						bgincrement	: 450
					});
				
				});
			</script>
		<!---//strat-slider---->
		 <!-- scroll -->
		 <script type="text/javascript">
			$(document).ready(function() {
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
		 <!-- //scroll -->

</head>
<body>
	<!-- start slider -->
<div class="slider_bg">
			<!-- start header -->
	<div class="wrap">
			<div class="header">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt=""/></a>
				</div>
		<!-- start top-nav-->
		<div class="h_right">
			<ul class="menu">		
				<li class="active"><a  href="#home">首页</a></li>
				<li><a href="#services" class="scroll">服务</a></li>
				<li><a href="#portfolio" class="scroll">资质证书</a></li>
				<li><a href="#about" class="scroll">关于</a></li>
				<li class="last"><a href="#contact"  class="scroll">联系我们</a></li>
			</ul>			
			<!-- start smart_nav * -->
	        <nav class="nav">
	            <ul class="nav-list">
	                <li class="nav-item"><a  href="#home">首页</a></li>
	                <li class="nav-item"><a href="#services" class="scroll">服务</a></li>
	                <li class="nav-item"><a href="#portfolio" class="scroll">资质证书</a></li>	            
	                <li class="nav-item"><a href="#about" class="scroll">关于</a></li>
	                <li class="nav-item"><a href="#contact"  class="scroll">联系我们</a></li>
	                <div class="clear"></div>
	            </ul>
	        </nav>
	        <script type="text/javascript" src="js/responsive.menu.js"></script>
			<!-- end smart_nav * -->
		</div>
		<div class="clear"></div>

			</div>
			</div>
			<!---//End-header--->
<!-- start main -->
				<!---start-da-slider----->
				<div id="da-slider" class="da-slider">
				<div class="da-slide">
					<p>欢迎来到我们的二手奢侈品交易网站!</p>
					<h2>告诉我们你想要的</h2>
					<p class="a"><a href="#">我们会尽情为您服务</a></p>
				</div>
				<div class="da-slide">
					<p>彭敏</p>
					<h2>电话13888888888</h2>
					<p class="a"><a href="#">地址：西安市某个地方</a></p>
				</div>
				<nav class="da-arrows">
					<span class="da-arrows-prev"></span>
					<span class="da-arrows-next"></span>
				</nav>
			</div>
 			<!---//End-da-slider----->
 		</div>
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
		  <div class="services" id="services">
		  	<div class="wrap">
		  		<h3>服务</h3>
		  		<p>Proin iaculis purus consequat sem cure.</p>
				<div class="col_1_of_3 span_1_of_3">
					<img src="images/service1.png" alt=""/>
					<h4><a href="#">E-Commerce</a></h4>
					<p>这里可以写你的公司的一些描述</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					<img src="images/service2.png" alt=""/>
					<h4><a href="#">Responsive Web</a></h4>
					<p>这里可以写你的公司的一些描述</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					<img src="images/service3.png" alt=""/>
					<h4><a href="#">Web Security</a></h4>
					<p>这里可以写你的公司的一些描述</p>
				</div>
				 <div class="clear"></div>
   		   </div>
   		 </div>
 		<div class="portfolio" id="portfolio">
		  	<div class="wrap">
		  		<h3>证书</h3>
		  		<p>我们是一家合格的企业</p>
			<div class="col_1_of_3 span_1_of_3">
					  <div class="view view-fourth">
                        <img src="images/port1.jpg">
	                    <div class="mask">
	                        <h2>Ebony</h2>
	                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
	                        <a href="#" class="info">Read More</a>
	                    </div>
                	</div>
					<h4><a href="#">Ebony & lvory</a></h4>
					<p>Branding</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					 <div class="view view-fourth">
                        <img src="images/port2.jpg">
	                    <div class="mask">
	                        <h2>Stationary</h2>
	                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
	                        <a href="#" class="info">Read More</a>
	                    </div>
                	</div>
					<h4><a href="#">Smart Stationary</a></h4>
					<p>Print Design</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					 <div class="view view-fourth">
                        <img src="images/port3.jpg">
	                    <div class="mask">
	                        <h2>Poster</h2>
	                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
	                        <a href="#" class="info">Read More</a>
	                    </div>
                	</div>
					<h4><a href="#">Clever Poster</a></h4>
					<p>Print Design</p>
				</div>
			  <div class="col_1_of_3 span_1_of_3">
					 <div class="view view-fourth">
                        <img src="images/port4.jpg">
	                    <div class="mask">
	                        <h2>Record</h2>
	                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
	                        <a href="#" class="info">Read More</a>
	                    </div>
                	</div>
					<h4><a href="#">Vinyl Record</a></h4>
					<p>Product Mock-Up</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					  <div class="view view-fourth">
                        <img src="images/port5.jpg">
	                    <div class="mask">
	                        <h2>Design</h2>
	                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
	                        <a href="#" class="info">Read More</a>
	                    </div>
                	</div>
					<h4><a href="#">Tree House Template</a></h4>
					<p>Web Design</p>
				</div>
				<div class="col_1_of_3 span_1_of_3">
					 <div class="view view-fourth">
                        <img src="images/port6.jpg">
	                    <div class="mask">
	                        <h2>Branding</h2>
	                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
	                        <a href="#" class="info">Read More</a>
	                    </div>
                	</div>
					<h4><a href="#">Burned Logo</a></h4>
					<p>Branding</p>
				</div>
			<div class="clear"></div>								  						
			</div>   		 
   		 </div>
   		 <!---start-about---->
		  <div class="about" id="about">
		  	<div class="wrap">
		  		<h3>关于</h3>
		  		<p class="a">这里写关于我们的信息.比如哪一年做了什么事</p>
				<!---start-about-time-line---->
				<div class="about-time-line">
					<li>
							<div class="cbp_tmicon img1"> </div>
							<div class="cbp_tmlabel">
								<h2>JULY 2010</h2>
								<h2>Our Humble Beginnings</h2>
								<p>Proin iaculis purus consequat sem cure  digni ssim. Donec porttitora entum suscipit aenean rhoncus posuere odio in tincidunt. Proin iaculis purus consequat sem cure digni ssim. Donec porttitora entum suscipit.</p>
							</div>
					</li>
					<li>
							<div class="cbp_tmicon1 img2"> </div>
							<div class="cbp_tmlabel cbp_tmlabel1">
								<h2>JANUARY 2011</h2>
								<h2>Facing Startup Battles </h2>
								<p>Proin iaculis purus consequat sem cure digni ssim. Donec porttitora entum suscipit aenean rhoncus posuere odio in tincidunt. Proin iaculis purus consequat sem cure digni ssim. Donec porttitora entum suscipit aenean rhoncus posuere odio in tincidunt.</p>
							</div>
					</li><br />
					<li>
							<div class="cbp_tmicon2 img3"> </div>
							<div class="cbp_tmlabel">
								<h2>DECEMBER 2012</h2>
								<h2>Enter The Dark Days </h2>
								<p>Proin iaculis purus consequat sem cure digni ssim. Donec porttitora entum suscipit aenean rhoncus posuere odio in tincidunt. Proin iaculis purus consequat sem cure digni.</p>
							</div>
					</li>
					<li>
							<div class="cbp_tmicon3 img4"> </div>
							<div class="cbp_tmlabel cbp_tmlabel1">
								<h2>FEBRUARY 2014</h2>
								<h2>Our Triumph </h2>
								<p>Proin iaculis purus consequat sem cure digni ssim. Donec porttitora entum suscipit aenean rhoncus posuere odio in tincidunt. Proin iaculis purus consequat sem cure digni ssim. Donec porttitora entum suscipit aenean.</p>
							</div>
					</li>
					<li>
							<div class="cbp_tmicon4 img5"> </div>
					</li>
					<div class="clear"> </div>
   		   </div>
   		 </div>    
   		</div>
 			<!---//end-about---->     
           <!----start-team-members---->
				<div class="team-members">
					<div class="wrap"> 
						<div class="tm-head">
							<h3>我们的团队</h3>
							<p>西安最大的二手奢侈品交易平台</p>
						</div>
						<div class="tm-head-grids">
							<div class="tm-head-grid">
								<img src="images/team-member1.jpg" alt="" />
								<h4>彭敏</h4>
								<h5>CEO</h5>
								<ul class="top-social-icons">
									<li><a class="twitter simptip-position-bottom simptip-movable" data-tooltip="twitter" href="#"> </a></li>
									<li><a class="facebook simptip-position-bottom simptip-movable" data-tooltip="Facebook" href="#"> </a></li>
									<li><a class="pin simptip-position-bottom simptip-movable" data-tooltip="pintrest" href="#"> </a></li>
									<div class="clear"> </div>
								</ul>
							</div>
							<div class="tm-head-grid">
								<img src="images/team-member2.jpg" alt="" />
								<h4>Rico Massimo</h4>
								<h5>Coder</h5>
								<ul class="top-social-icons">
									<li><a class="twitter simptip-position-bottom simptip-movable" data-tooltip="twitter" href="#"> </a></li>
									<li><a class="facebook simptip-position-bottom simptip-movable" data-tooltip="Facebook" href="#"> </a></li>
									<li><a class="pin simptip-position-bottom simptip-movable" data-tooltip="pintrest" href="#"> </a></li>
									<div class="clear"> </div>
								</ul>
							</div>
							<div class="tm-head-grid">
								<img src="images/team-member3.jpg" alt="" />
								<h4>Uku Mason</h4>
								<h5>Graphic Designer</h5>
								<ul class="top-social-icons">
									<li><a class="twitter simptip-position-bottom simptip-movable" data-tooltip="twitter" href="#"> </a></li>
									<li><a class="facebook simptip-position-bottom simptip-movable" data-tooltip="Facebook" href="#"> </a></li>
									<li><a class="pin simptip-position-bottom simptip-movable" data-tooltip="pintrest" href="#"> </a></li>
									<div class="clear"> </div>
								</ul>
							</div>
							<div class="clear"> </div>
						</div>
						<p class="team-info">Proin iaculis purus consequat sem cure  digni ssim donec porttitora entum suscipit aenean rhoncus posuere odio in tincidunt proin iaculis.</p>
					</div>
				</div>
				<!----//End-team-members----> 
				<!---strat-image-cursuals---->
                  <div class="t-clients">
                  	<div class="wrap"> 											 
							<div class="nbs-flexisel-container"><div class="nbs-flexisel-inner"><ul class="flexiselDemo3 nbs-flexisel-ul" style="left: -253.6px; display: block;">					    					    					       
							<li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c3.png"></li><li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c4.png"></li><li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c1.png"></li><li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c2.png"></li><li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c3.png"></li><li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c4.png"></li><li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c1.png"></li><li onClick="location.href='#';" class="nbs-flexisel-item" style="width: 253.6px;"><img src="images/c2.png"></li></ul><div class="nbs-flexisel-nav-left" style="top: 21.5px;"></div><div class="nbs-flexisel-nav-right" style="top: 21.5px;"></div></div></div> 
							<div class="clear"> </div>      
						  <!---strat-image-cursuals---->
								<script type="text/javascript" src="js/jquery.flexisel.js"></script>
								<!---End-image-cursuals---->
								<script type="text/javascript">
								$(window).load(function() {
								    $(".flexiselDemo3").flexisel({
								        visibleItems: 5,
								        animationSpeed: 1000,
								        autoPlay: true,
								        autoPlaySpeed: 3000,            
								        pauseOnHover: true,
								        enableResponsiveBreakpoints: true,
								        responsiveBreakpoints: { 
								            portrait: { 
								                changePoint:480,
								                visibleItems: 1
								            }, 
								            landscape: { 
								                changePoint:640,
								                visibleItems: 2
								            },
								            tablet: { 
								                changePoint:768,
								                visibleItems: 3
								            }
								        }
								    });
								});
								</script>
						<!---->
				  <!---->
				  </div>				
			</div>
             <div class="contact" id="contact">
		  	<div class="wrap">
		  		<h3>联系我们</h3>
		  		<p class="a">请把你的想法告诉我们，我么会热情为您服务</p>
				<div class="form">
				     <div class="form-text">
					    <input type="text" class="textbox" value="你的名字" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '你的名字';}">
						<input type="text" class="textbox" value="你的电话" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '你的电话';}">
						<input name="Website" type="text" class="Subject" value="你的邮箱" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '你的邮箱';}">
					</div>
						 <textarea placeholder="你的想法"></textarea>
						 <div class="clear"> </div>
						 <input type="submit" value="发送消息">					 
				 </div>
   		   </div>
   		 </div>
         <!----start-bottom-footer---->
				<div class="bottom-footer">
					<div class="wrap"> 
						<div class="bottom-footer-left">
							<p>&#169; Copyright 2016 Template. <a href="http://chuang1217.vicp.net/spider" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
						</div>
						<div class="bottom-footer-center">
							<ul class="bottom-social-icons">
								<li><a class="bottom-twitter" href="#"> </a></li>
								<li><a class="bottom-facebook" href="#"> </a></li>
								<li><a class="bottom-pin" href="#"> </a></li>
								<li><a class="bottom-google" href="#"> </a></li>
								<div class="clear"> </div>
							</ul>
						</div>			  
						<div class="clear"> </div>
					</div>
				</div>
				<!----//End-bottom-footer---->
 <!-- scroll_top_btn -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>

		 <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>

</body>
</html>