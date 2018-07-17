<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
</html>


<div class="widget-body">
 <div class="widget-main">
 
	<div id="piechart-placeholder" style="width: 90%; min-height: 150px; padding: 0px; position: relative;">
	</div>
	
	<div class="hr hr8 hr-double"></div>
	
	<div class="clearfix">
		<c:forEach items="${list}" var="movie" varStatus="i">
			<div class="grid3 row-fluid" >
				<div  class="span3">
					<img style="margin:2px;"  src="${movie.movie_pic_path}" class="img-rounded"  data-title='${movie.title}' data-rate='${movie.rate}' data-direct='${movie.direct}' data-synopsis='${movie.synopsis}' data-main_performer='${movie.main_performer}'" />
				</div>
				<div class="span9">
					<strong> ${movie.title}</strong></br></br>
					<td class="legendLabel">评分:${movie.rate}</td></br>
					<td class="legendLabel">评论量:${movie.rating_people}</td></br>
					<td class="legendLabel">时长:${movie.film_length}分钟</td>
				</div>
			</div>	
		</c:forEach>
	</div>
 </div>
</div>

<script src="${ctx}/static/ace/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/ace/js/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/static/ace/js/jquery.flot.pie.min.js"></script>
<script type="text/javascript" src="${ctx}/static/ace/js/jquery.flot.resize.min.js"></script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
$(document).ready(function(){
	
	$(".img-rounded").click(function(){
		bootbox.confirm("<b>"+$(this).data("title")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='#49afcd'>"+$(this).data("rate")+"</font></b><br><br><small>导演："+$(this).data("direct")+"</small><br><small>主演："+$(this).data("main_performer")+"</small><br><br><div class=\"hr hr8 hr-double\"></div>"+$(this).data("synopsis"), function(result) {
		});
	});
	var data = [
	   	<c:forEach items="${list}" var="movie" varStatus="i">
	   		{ label: "${movie.title}",  data: "${movie.rate}", color: "${movie.color}"},	
	   	</c:forEach>
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
});
</script>