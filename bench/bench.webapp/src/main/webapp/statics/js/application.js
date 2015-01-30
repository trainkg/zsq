/**
 * 系统管理application.js
 * peculiar.1@163.com 
 */
define([
        'dojo/_base/declare',
        "dijit/layout/TabContainer",
        "dijit/layout/ContentPane",
        "dojo/domReady!"
    ],function(declare,TabContainer,ContentPane){
	return declare(null,{
		/*
		 * id: show DOM select
		 */
		id:'_ZSQ_CONTENT',
		/**
		 * APP 导航
		 */
		navigation:null,
		foot:null,
		constructor:function(config){
			var tableConfig = {};
			this.navigation =  new TabContainer(tableConfig,this.id);
			
			var content = new ContentPane({
				title:"系统管理",
				content:"this is test info1"
			});
			
			
			var content1 = new ContentPane({
				title:"系统管理",
				content:"this is test info2"
			});
			
			this.navigation.startup();
		}
	});
});

