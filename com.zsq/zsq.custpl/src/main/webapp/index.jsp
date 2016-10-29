<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>自动化开发平台</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="/zsq/plugins/bootstrap/css/bootstrap.min.css">
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%@include file="./common/metas/easyui-deps.jsp" %>
    <style type="text/css">
    	/* input[type=text]{
    		width: 200px;
    	}  */
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