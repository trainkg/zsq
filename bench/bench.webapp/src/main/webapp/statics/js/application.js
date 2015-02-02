/**
 * 系统管理application.js
 * peculiar.1@163.com 
 */
define([
        'dojo/_base/declare',
        "dijit/layout/TabContainer",
        "dijit/layout/ContentPane",
        "dijit/layout/BorderContainer",
        "dojo/dom",
        "underscore",
        "dojo/domReady!"
    ],function(declare,TabContainer,ContentPane,BorderContainer,dom,_){
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
		foot:null,
		constructor:function(config){
			this.context = _.extend({},this.context,config);
			var bc = new BorderContainer({
		        style: "height: 100%; width: 100%;"
		    });
			
		    // create a ContentPane as the left pane in the BorderContainer
		    var cp1 = new ContentPane({
		        region: "left",
		        style: "width: 200px;",
		        content: "hello world"
		    });
		    bc.addChild(cp1);

		    // create a ContentPane as the center pane in the BorderContainer
		    var cp2 = new ContentPane({
		        region: "center",
		        content: "how are you?"
		    });
		    bc.addChild(cp2);

		    // put the top level widget into the document, and then call startup()
		    bc.placeAt(document.body);
		    bc.startup();
		}
	});
});

