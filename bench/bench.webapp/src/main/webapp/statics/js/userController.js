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
        'gridx/Grid',
        'gridx/core/model/cache/Sync',
        "gridx/modules/IndirectSelect",
		"gridx/modules/extendedSelect/Row",
		"gridx/modules/ColumnResizer",
		"gridx/modules/RowHeader",
		"gridx/modules/Pagination",
		"gridx/modules/pagination/PaginationBar",
		"gridx/modules/VirtualVScroller",
        "dojo/domReady!"
       ],function(declare,BorderContainer,AccordionContainer,AccordionPane,ContentPane,dom,_,JsonRest, Memory, Cache, Observable,Grid,Gcache){
	return declare(BorderContainer,{
		//
		constructor:function(){
			//this.initContent();
		},
		/**
		 * 初始化content 信息
		 */
		postCreate:function(){
			
			var userStore = new JsonRest({target:"ru/user/"});
			var cacheStore = new Memory({});
			var inventoryStore = new Cache(userStore, cacheStore);
		
			var left = new AccordionContainer({
				region:'left',
				style:"width:300px;"
			});
			
			var user = inventoryStore.get("1");
			user.then(function(items){
				_.each(items,function(item){
					left.addChild(new AccordionPane({
						title:item.name
					}));
				})
			});
			
		    this.addChild(left);
		    
		    var columns = [
               {field: 'id', name: 'Identity'},
               {field: 'title', name: 'Title'},
               {field: 'artist', name: 'Artist'}
            ];
		    
		    var store = new Memory({
		        data: [
		            {id: 1, title: 'Hey There', artist: 'Bette Midler'},
		            {id: 2, title: 'Love or Confusion', artist: 'Jimi Hendrix'},
		            {id: 3, title: 'Sugar Street', artist: 'Andy Narell'}
		        ]
		    });
		    
		    var grid = new Grid({
		    	region:"center",
		        cacheClass: Gcache,
		        store: store,
		        structure: columns,
		        modules: [
					"gridx/modules/IndirectSelect",
					"gridx/modules/extendedSelect/Row",
					"gridx/modules/ColumnResizer",
					"gridx/modules/RowHeader",
					"gridx/modules/Pagination",
					"gridx/modules/pagination/PaginationBar",
					"gridx/modules/VirtualVScroller"
	      		]
		    }); 
		    
		    this.addChild(grid);
		    
		    inventoryStore.remove(1);
		    inventoryStore.put({'id':1,name:"张珊"});
		    console.log(inventoryStore.add({name:"李四"}));
		    
		}
	});
});