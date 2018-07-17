<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>豆瓣大数据分析</title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="${ctx}/static/ace/css/bootstrap.min.css" rel="stylesheet" />
		<link href="${ctx}/static/ace/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx}/static/ace/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${ctx}/static/ace/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<!-- page specific plugin styles -->
		
		<!-- ace styles -->
		<link rel="stylesheet" href="${ctx}/static/ace/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/static/ace/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="${ctx}/static/ace/css/ace-skins.min.css" />
		<!--[if lt IE 9]>
		  <link rel="stylesheet" href="${ctx}/static/ace/css/ace-ie.min.css" />
		<![endif]-->
	</head>
	<body>
		<%@ include file="head.jsp" %>
		<div class="container-fluid" id="main-container">
			<a href="#" id="menu-toggler"><span></span></a><!-- menu toggler -->



			<div id="sidebar">

		



				<ul class="nav nav-list">

					

					<li class="active open">

					  <a href="${ctx}/DoubanMovieController/showRateTop/2016">

						<i class="icon-film"></i>

						<span>豆瓣电影</span>

						

					  </a>

					<ul class="submenu">
						<li><a href="${ctx}/DoubanMovieController/showRateTop/-1"><i class="icon-double-angle-right"></i> 年度最高评分</a></li>
						<li><a href="${ctx}/DoubanMovieController/showRatePeopleTop/-1"><i class="icon-double-angle-right"></i> 年度最热门</a></li>
						<li  class="active" ><a href="${ctx}/DoubanMovieController/showDirectTop"><i class="icon-double-angle-right"></i> 拍电影最多导演</a></li>
						<li><a href="${ctx}/DoubanMovieController/showDirectFilms?direct="><i class="icon-double-angle-right"></i> 导演作品评分</a></li>
					  </ul>
					</li>



					

					<li>

					  <a href="typography.html">

						<i class=" icon-headphones"></i>

						<span>豆瓣音乐</span>

						

					  </a>

					</li>

					<li>

					  <a href="typography.html">

						<i class="icon-book"></i>

						<span>豆瓣读书</span>

						

					  </a>

					</li>

				</ul><!--/.nav-list-->

				<div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div>

			</div><!--/#sidebar-->
			<div id="main-content" class="clearfix">
					

					<div id="breadcrumbs">

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">主页</a><span class="divider"><i class="icon-angle-right"></i></span></li>

							<li class="active">豆瓣电影</li>
						</ul><!--.breadcrumb-->



						

					</div><!--#breadcrumbs-->



					<div id="page-content" class="clearfix">
						<%@ include file="bar.jsp" %>
						<div class="widget-header widget-header-flat widget-header-small">
							<h5><i class="icon-signal"></i>作品最多的十个导演</h5>
						</div>
						
						<div class="widget-body">
						 <div class="widget-main">
						 
							<div id="piechart-placeholder" style="width: 90%; min-height: 150px; padding: 0px; position: relative;">
							</div>
							
							<div class="hr hr8 hr-double"></div>
							
							<div class="clearfix">
								<c:forEach items="${list}" var="movie" varStatus="i">
									<div class="grid3">
										<span class="${movie.color}"><i class="icon-user icon-2x blue"></i><a href="${ctx}/DoubanMovieController/showDirectFilms?direct=${movie.direct}">&nbsp; ${movie.direct}</a></span>
										<h6 class="pull-right">${movie.film_total}部</h6>
										<%-- <td class="legendLabel pull-right">${movie.film_total}部</td> --%>
									</div>	
								</c:forEach>
							</div>
						 </div><!--/widget-main-->
						</div><!--/widget-body-->
	
					</div>
				</div>			
						
			</div><!-- #main-content -->
		</div><!--/.fluid-container#main-container-->
		<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse">
			<i class="icon-double-angle-up icon-only"></i>
		</a>
		<!-- basic scripts -->
		<script src="${ctx}/static/ace/1.9.1/jquery.min.js"></script>
		<script type="text/javascript">
		window.jQuery || document.write("<script src='${ctx}/static/ace/js/jquery-1.9.1.min.js'>\x3C/script>");
		</script>
		
		<script src="${ctx}/static/ace/js/bootstrap.min.js"></script>
		<!-- page specific plugin scripts -->
		
		<!--[if lt IE 9]>
		<script type="text/javascript" src="${ctx}/static/ace/js/excanvas.min.js"></script>
		<![endif]-->
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery-ui-1.10.2.custom.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery.ui.touch-punch.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery.slimscroll.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery.easy-pie-chart.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery.sparkline.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery.flot.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery.flot.pie.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/ace/js/jquery.flot.resize.min.js"></script>
		<!-- ace scripts -->
		<script src="${ctx}/static/ace/js/ace-elements.min.js"></script>
		<script src="${ctx}/static/ace/js/ace.min.js"></script>
		<!-- inline scripts related to this page -->
		
		<script type="text/javascript">
		
$(function() {
	$('.dialogs,.comments').slimScroll({
        height: '300px'
    });
	
	$('#tasks').sortable();
	$('#tasks').disableSelection();
	$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
		if(this.checked) $(this).closest('li').addClass('selected');
		else $(this).closest('li').removeClass('selected');
	});
	var oldie = $.browser.msie && $.browser.version < 9;
	$('.easy-pie-chart.percentage').each(function(){
		var $box = $(this).closest('.infobox');
		var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
		var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
		var size = parseInt($(this).data('size')) || 50;
		$(this).easyPieChart({
			barColor: barColor,
			trackColor: trackColor,
			scaleColor: false,
			lineCap: 'butt',
			lineWidth: parseInt(size/10),
			animate: oldie ? false : 1000,
			size: size
		});
	})
	$('.sparkline').each(function(){
		var $box = $(this).closest('.infobox');
		var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
		$(this).sparkline('html', {tagValuesAttribute:'data-values', type: 'bar', barColor: barColor , chartRangeMin:$(this).data('min') || 0} );
	});
	
	
  var data = [
	<c:forEach items="${list}" var="movie" varStatus="i">
		{ label: "${movie.direct}",  data: "${movie.film_total}", color: "${movie.color}"},	
	</c:forEach>


	/* { label: "social networks",  data: 38.7, color: "#68BC31"},
	{ label: "search engines",  data: 24.5, color: "#2091CF"},
	{ label: "ad campaings",  data: 8.2, color: "#AF4E96"},
	{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
	{ label: "other",  data: 10, color: "#FEE074"} */
  ];
 var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'250px'});
 $.plot(placeholder, data, {
	
	series: {
        pie: {
            show: true,
			tilt:0.8,
			highlight: {
				opacity: 0.25
			},
			stroke: {
				color: '#fff',
				width: 2
			},
			startAngle: 2
			
        }
    },
    legend: {
        show: true,
		position: "ne", 
	    labelBoxBorderColor: null,
		margin:[-30,15]
    }
	,
	grid: {
		hoverable: true,
		clickable: true
	},
	tooltip: true, //activate tooltip
	tooltipOpts: {
		content: "%s : %y.1",
		shifts: {
			x: -30,
			y: -50
		}
	}
	
 });
 
  var $tooltip = $("<div class='tooltip top in' style='display:none;'><div class='tooltip-inner'></div></div>").appendTo('body');
  placeholder.data('tooltip', $tooltip);
  var previousPoint = null;
  placeholder.on('plothover', function (event, pos, item) {
	if(item) {
		if (previousPoint != item.seriesIndex) {
			previousPoint = item.seriesIndex;
			var tip = item.series['label'] + " : " + item.series['percent']+'%';
			$(this).data('tooltip').show().children(0).text(tip);
		}
		$(this).data('tooltip').css({top:pos.pageY + 10, left:pos.pageX + 10});
	} else {
		$(this).data('tooltip').hide();
		previousPoint = null;
	}
	
 });
		var d1 = [];
		for (var i = 0; i < Math.PI * 2; i += 0.5) {
			d1.push([i, Math.sin(i)]);
		}
		var d2 = [];
		for (var i = 0; i < Math.PI * 2; i += 0.5) {
			d2.push([i, Math.cos(i)]);
		}
		var d3 = [];
		for (var i = 0; i < Math.PI * 2; i += 0.2) {
			d3.push([i, Math.tan(i)]);
		}
		
		var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
		$.plot("#sales-charts", [
			{ label: "Domains", data: d1 },
			{ label: "Hosting", data: d2 },
			{ label: "Services", data: d3 }
		], {
			hoverable: true,
			shadowSize: 0,
			series: {
				lines: { show: true },
				points: { show: true }
			},
			xaxis: {
				tickLength: 0
			},
			yaxis: {
				ticks: 10,
				min: -2,
				max: 2,
				tickDecimals: 3
			},
			grid: {
				backgroundColor: { colors: [ "#fff", "#fff" ] },
				borderWidth: 1,
				borderColor:'#555'
			}
		});
		$('[data-rel="tooltip"]').tooltip();
})
		</script>
	</body>
</html>
