<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/commons/globalAttribute.jsp"%>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>DOJO TEMPLATE</title>
    <!-- <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="zsq/dojo/dijit/themes/claro/claro.css">
    <link rel="stylesheet" href="zsq/dojo/gridx/resources/claro/Gridx.css" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	html, body {
		    width: 100%;
		    height: 100%;
		    margin: 0;
		    overflow:hidden;
		    font-size: 13px;
		    background-color: #B0C4DE;
		}
    </style>
  </head>
  <body id="_zsq_site" class="claro">
   	<script src="${_CP}/statics/js/config.js"></script>
    <script src="//cdn.bootcss.com/dojo/1.10.4/dojo.js" data-dojo-config="async: true"></script>
   	<script type="text/javascript">
   		require(["zsq/application"],function(Application){
   			var config = {};
   			new Application(config);
   		});
	</script>
  </body>
</html>