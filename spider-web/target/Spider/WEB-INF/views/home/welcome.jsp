<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userInfo</title>
<script type="text/javascript"  src="${ctx}/static/js/jquery.js"></script>
</head>
<body>
	欢迎进入我的网页！！！
	<button id="start">启动爬虫</button>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#start").click(function(){
				$.ajax({
					url:"WelcomeController/startSpider",
					success:function(data){
						alert(data.msg);
					},
					error:function(err){alert(err)}
				});
			});
		});
	</script>
</body>
</html>