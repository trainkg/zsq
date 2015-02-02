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
	return declare(ContentPane,{
		//
		ctx:null,
		constructor:function(){
			var bc = new BorderContainer({
				 style: "height: 100%; width: 100%;"
			});
			this.initContent();
			this.ctx = bc;
		},
		/**
		 * 初始化content 信息
		 */
		initContent:function(){
			/*var left = new AccordionContainer({
				region:'left'
			});
			left.addChild(new AccordionPane({
				title:"PAGE #1"
			}));
			left.addChild(new AccordionPane({
				title:"PAGE #2"
			}));
			left.addChild(new AccordionPane({
				title:"PAGE #3"
			}));*/
			//this.content.addChild(left);
		}
	});
});