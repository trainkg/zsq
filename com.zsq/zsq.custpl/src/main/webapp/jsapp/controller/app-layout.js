/**
 * 数据模型列表试图 
 */
define(['jquery','backbone','underscore','text!./layout-template.html','css!./layout.css'],function($,Backbone,_,template){
	
	var defalut_settings = {};
	
 	var modelListView = Backbone.View.extend({
 		//功能导航菜单
 		navActView:null,
 		//选项卡菜单
 		tabView:null,
 		context:{},
 		initialize:function(config){
 			this.context = _.extend({},defalut_settings,config);
 		},
 		events: {
 		   //"click .unit-nav" : "navHander",
 		},
 		//插件内事件处理
 		initEvent:function(){
 			var view = this;
 			//树导航事件监听
 			this.navActView.tree({
 				onClick:function(node){
 					view.navHander(node);
 	 			}
 			});
 		},
 		render:function(){
 			this.$el.html(template);
 			$.parser.parse(this.$el);
 			this.navActView = this.$el.find("#nav-tree");
 			this.tabView    = this.$el.find("#s-tabs");
 			
 			this.initEvent();
 			//
 		},
 		//导航处理
 		navHander:function(/*tree node*/node){
 			var layout = this;
 			if(node.attributes && node.attributes.view){
 				var tab = layout.tabView.tabs("getTab",node.text);
 				if(!tab){
 					require([node.attributes.view],function(TabView){
 						
 	 					layout.tabView.tabs('add',{
 	 						id:node.text,
 	 					    title:node.text,
 	 					    content:'<div class="m-real-content" style="width:100%;height:100%;padding:0;margin:0"></div>',
 	 					    closable:true
 	 					});

 	 					
 	 					tab = layout.tabView.tabs("getTab",node.text);
 	 					var tabConfig = {
 	 	 					el:tab.find(".m-real-content")
 	 					};
 	 					
 	 					var tabItem = new TabView(tabConfig);
 	 					tabItem.render();

 	 				});
 				}else{
 					layout.tabView.tabs("select",node.text);
 				}
 			}
 		}
 	});
 	return modelListView;
})