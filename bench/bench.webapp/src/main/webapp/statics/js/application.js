/**
 * 系统管理application.js
 * peculiar.1@163.com 
 */
define([
        'dojo/_base/declare',
        "dijit/layout/TabContainer",
        "dijit/layout/ContentPane",
        "dijit/layout/BorderContainer",
        "dijit/layout/AccordionContainer",
        "dijit/layout/AccordionPane",
        "zsq/userController",
        "dojo/dom",
        "underscore",
        "dojo/domReady!"
    ],function(declare,TabContainer,ContentPane,BorderContainer,AccordionContainer,AccordionPane,useWidget,dom,_){
	return declare(null,{
		/*
		 * id: show DOM select
		 */
		context:{
			id:'_ZSQ_CONTENT'
		},
		/**
		 * APP 导航
		 */
		navigation:null,
		// 顶部模块
		topM:null,
		// 左侧模块
		leftM:null,
		// 中心模块
		centerM:null,
		// 底部模块
		btmM:null,
		foot:null,
		constructor:function(config){
			this.context = _.extend({},this.context,config);
			var bc = new BorderContainer({
		        style: "height: 100%; width: 100%;"
		    });
			
			 // create a ContentPane as the left pane in the BorderContainer
		    var cp0 = new ContentPane({
		        region: "top",
		        style:"background-color: #F8F8F8;border-color: #E7E7E7;",
		        content: "ZSQ系统管理"
		    });
		    
		    bc.addChild(cp0);
			
		    /*var cp1 = new ContentPane({
		        region: "left",
		        style: "width: 200px;",
		        content: "hello world"
		    });
		    bc.addChild(cp1);*/
		    
		    // tab
		    var tab = new TabContainer({
		        region: "center"
		    });
		    
		    // create a ContentPane as the center pane in the BorderContainer
		    var cp2 = new ContentPane({
		    	title:"首页2",
		        content: "how are you?"
		    });
		    tab.addChild(cp2);
		    
		    var cp3 = new ContentPane({
		    	title:"首页3",
		        content: "how are you?"
		    });
		    tab.addChild(cp3);
		    
		    var cp4 = new ContentPane({
		    	title:"首页4",
		        content: "how are you?"
		    });
		    tab.addChild(cp4);
		    
		    var cp5 = new BorderContainer({
		    	title:"首页5",
		        closable:true,
		        selected:true
		    });
		    
		    var left = new AccordionContainer({
				region:'left',
				style:"width:200px;"
			});
			left.addChild(new AccordionPane({
				title:"PAGE #1"
			}));
			left.addChild(new AccordionPane({
				title:"PAGE #2"
			}));
			left.addChild(new AccordionPane({
				title:"PAGE #3"
			}));
			
			
		    cp5.addChild(left);
		    
		    cp5.addChild(new ContentPane({
		    	region:"center",
		    	content:"this is test"
		    }));
		    tab.addChild(cp5);
		    
		    bc.addChild(tab);
		    
		    // create a ContentPane as the left pane in the BorderContainer
		    var cp3 = new ContentPane({
		        region: "bottom",
		        content: "THIS IS BTM"
		    });
		    bc.addChild(cp3);

		    // put the top level widget into the document, and then call startup()
		    bc.placeAt(document.body);
		    bc.startup();
		}
	});
});

