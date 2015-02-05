/**
 * 用户管理
 * peculiar.1@163.com
 * @author trainkg 
 */
define([
        'dojo/_base/declare',
        "dijit/layout/BorderContainer",
        "dijit/layout/AccordionContainer",
        "dijit/layout/AccordionPane",
        "dijit/layout/ContentPane",
        "dojo/dom",
        "underscore",
        "dojo/store/JsonRest", 
        "dojo/store/Memory", 
        "dojo/store/Cache", 
        "dojo/store/Observable",
        "dojo/domReady!"
       ],function(declare,BorderContainer,AccordionContainer,AccordionPane,ContentPane,dom,_,JsonRest, Memory, Cache, Observable){
	return declare(BorderContainer,{
		//
		constructor:function(){
			//this.initContent();
		},
		/**
		 * 初始化content 信息
		 */
		postCreate:function(){
			
			var userStore = new JsonRest({target:"ru/user"});
			var cacheStore = new Memory({});
			var inventoryStore = new Cache(userStore, cacheStore);
		
			var left = new AccordionContainer({
				region:'left',
				style:"width:200px;"
			});
			
			var user = inventoryStore.query("/1");
			var user1 = inventoryStore.query("/1");
			user.forEach(function(item){
				left.addChild(new AccordionPane({
					title:item.name
				}));
			});
			
		    this.addChild(left);
		    this.addChild(new ContentPane({
		    	region:"center",
		    	content:"this is testddddddddddd"
		    }));
		    inventoryStore.remove(1);
		    inventoryStore.put({'id':1,name:"张珊"});
		    console.log(inventoryStore.add({name:"李四"}));
		    
		}
	});
});