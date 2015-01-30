<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/commons/globalAttribute.jsp"%>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>DOJO TEMPLATE</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body id="content">
    <h1>你好，世界！我是 {name} ${_CP}</h1>
    
    <script src="${_CP}/statics/js/config.js"></script>
    <script src="${_CP}/zsq/dojo/dojo/dojo.js" data-dojo-config="async: true"></script>
    <!-- <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
    
    <div>
    	<h3>基于模板的自定义组件</h3>
    	<div data-dojo-type="extend/hlWidget/hlWidget" data-dojo-props="name:'zhuyy'">
    		<p>this is content info</p>
    	</div>
    </div>
    <!-- 用户自定义script位置 -->
    <script type="text/javascript">
    	/* require(['dojo/dom','dojo/dom-construct','test/test','dojo/parser'],function(dom, domConstruct,Test,parser){
    		var content = dom.byId("content");
    		domConstruct.place("<i>Dojo!</i>",content);
    		var obj = new Test('1','triankg');
    		obj.print();
    		parser.parse();
    	}); */
    	require(['dojo/parser','extend/hlWidget/hlWidget'],function(parser){
			parser.parse();
		}); 
    </script>
  </body>
</html>