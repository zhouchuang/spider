<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
	<head>
		<link rel="stylesheet" type="text/css" href="${ctx}/static/raphael/css/normalize.css" />
		<%-- <link rel="stylesheet" type="text/css" href="${ctx}/static/raphael/css/default.css"> --%>
		<style type="text/css">
			.demo-chat{width: 50%;margin: 0 auto;}
		</style>
	</head>
</html>
<div class="widget-header widget-header-flat widget-header-small">
	<h5><i class="icon-signal"></i>${direct}电影评论量</h5>
	
</div>
<div class="widget-body">
	<div class="htmleaf-content"> 
		<div class="demo-chat" >
			<canvas id="canvas" height="450" width="600"></canvas>
		</div>
	</div>
</div>
<script src="${ctx}/static/ace/1.9.1/jquery.min.js"></script>
<script src="${ctx}/static/raphael/js/Chart.js"></script>
<script  type="text/javascript">
	$(document).ready(function(){
	var data = [
	        	<c:forEach items="${list}" var="movie" varStatus="i">
	        		{ label: "${movie.title}",  rate: "${movie.rate}", rating_people: "${movie.rating_people}",color:"${movie.color}"},	
	        	</c:forEach>
	        	];
	        	var  tlabels = [];
	        	$.each(data,function(i,m){
	        	tlabels.push(m.label);
	        	});
	        	var trates = [];
	        	$.each(data,function(i,m){
	        	trates.push(m.rate);
	        	});
	        	var trating_peoples = [];
	        	$.each(data,function(i,m){
	        	trating_peoples.push(m.rating_people);
	        	});
	        	var colors = [];
	        	$.each(data,function(i,m){
	        		colors.push(m.color);
	        	});

	        	var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
	        	var barChartData = {
	        			//labels : ["January","February","March","April","May","June","July"],
	        			labels:trates,
	        			datasets : [
	        				/* {
	        					fillColor : "rgba(220,220,220,0.5)",
	        					strokeColor : "rgba(220,220,220,0.8)",
	        					highlightFill: "rgba(220,220,220,0.75)",
	        					highlightStroke: "rgba(220,220,220,1)",
	        					//data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
	        					data:tlabels
	        				}, */
	        				{
	        					fillColor : "rgba(151,187,205,0.5)",
	        					strokeColor : "rgba(151,187,205,0.8)",
	        					highlightFill : "rgba(151,187,205,0.75)",
	        					highlightStroke : "rgba(151,187,205,1)",
	        					//data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
	        					data:trating_peoples
	        				}
	        			]

	        		}      
	        	var ctxs = document.getElementById("canvas").getContext("2d");
	        	window.myBar = new Chart(ctxs).Bar(barChartData, {
	        		responsive : true
	        	});
});
</script>