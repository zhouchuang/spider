<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爬虫管理</title>
<script type="text/javascript"  src="${ctx}/static/js/jquery.js"></script>
</head>
<body>
	<label>抓取地址</label>
	<input style="width:800px;" id="url" value="https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=1000" />
	<button id="start">启动我的电影爬虫</button>
	<button id="update">启动我的更新电影爬虫</button>
	
	<hr>
	
	<label>抓取地址</label>
	<input style="width:800px;" id="bookurl" value="https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4?start=20&type=T" />
	<button id="startBook">启动我的书籍爬虫</button>
	
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#start").click(function(){
				$(this).attr("disabled","disabled");
				$.ajax({
					url:"${ctx}/DoubanMovieController/startDoubanMovieSpider",
					data:{'url':$("#url").val()},
					success:function(data){
						data = JSON.parse(data);  
						alert(data.msg);
						$("#start").attr("disabled",false);
					},
					error:function(err){alert(err)}
				});
			});
			
			$("#startBook").click(function(){
				$(this).attr("disabled","disabled");
				$.ajax({
					url:"${ctx}/DoubanMovieController/startDoubanBookSpider",
					data:{'url':$("#bookurl").val()},
					success:function(data){
						data = JSON.parse(data);  
						alert(data.msg);
						$("#startBook").attr("disabled",false);
					},
					error:function(err){alert(err)}
				});
			});
			
			
			
			
			$("#update").click(function(){
				$(this).attr("disabled","disabled");
				$.ajax({
					url:"${ctx}/DoubanMovieController/startUpdateDoubanMovieSpider",
					data:{'url':$("#url").val()},
					success:function(data){
						data = JSON.parse(data);  
						alert(data.msg);
						$("#update").attr("disabled",false);
					},
					error:function(err){alert(err)}
				});
			});
		});
	</script>
</body>
</html>