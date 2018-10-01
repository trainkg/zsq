<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Picker template view</title>
    <jsp:include page="/WEB-INF/commons/globalAttribute.jsp"></jsp:include>
    <!-- Bootstrap -->
    <link href="${_cp}/zsq/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="${_cp}/zsq/jquery.js"></script>
    <script src="${_cp}/zsq/validateform.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	.gray {color: gray;}
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/picker/${name}.jsp"></jsp:include>
  </body>
</html>