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
        "dojo/domReady!"
       ],function(declare,BorderContainer,AccordionContainer,AccordionPane,ContentPane,dom,_){
	return declare(BorderContainer,{
		//
		constructor:function(){
			//this.initContent();
		},
		/**
		 * 初始化content 信息
		 */
		postCreate:function(){
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
			
		    this.addChild(left);
		    this.addChild(new ContentPane({
		    	region:"center",
		    	content:"this is testddddddddddd"
		    }));
		}
	});
});