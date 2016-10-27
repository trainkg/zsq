<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>自动化开发平台</title>
    <%@include file="./common/metas/easyui-deps.jsp" %>
    <style type="text/css">
    	html{width: 100%;height: 100%}
    	body{width: 100%;height: 100%;margin: 0;padding: 0}
    </style>
</head>
<body id="app-content">
</body>
<script type="text/javascript" src="./zsq/r.js"></script>
<script type="text/javascript" src="./zsq/base.js"></script>
<script type="text/javascript">
	require(['ctrl/base','backbone','easyui'],function(App,Backbone){
		new App();
		Backbone.history.start({pushState: true});
	})
</script>
</html>