/**
 * 数据模型列表试图 
 */
define(['jquery','backbone','underscore','text!./globalConfigView-temp.html'],function($,Backbone,_,template){
	
	var defalut_settings = {};
	
 	var modelListView = Backbone.View.extend({
 		context:{},
 		initialize:function(config){
 			this.context = _.extend({},defalut_settings,config);
 		},
 		render:function(){
 			this.$el.html(template);
 			$.parser.parse(this.$el);
 			this.initPluginEventHander();
 		},
 		//插件相关业务处理
 		initPluginEventHander:function(){
 			var view = this;
 			view.$el.find('#dg-model-define').datagrid({
 				fit:true,
 				border:false,
 				toolbar: [
 				{
 					text:'添加',
	            	iconCls:'icon-add',
		            handler:function(){alert('add');}
		        },'-',
		        {
		            text:'配置',
		            iconCls:'icon-cut',
		            handler:function(){
		            	view.gotoConfigPage();
		            }
		        },'-',
		        {
		            text:'更新',
		            iconCls:'icon-save',
		            handler:function(){alert('save');}
		        },
		        {
		            text:'删除',
		            iconCls:'icon-save',
		            handler:function(){alert('save');}
		        }],
 			    url:'dbconfig/models',
 			    columns:[[
 			        {field:'modelName',title:'模块名称',width:80},
 			        {field:'description',title:'模块描述',width:120}
 			    ]]
 			});
 		},
 		/*
 		 * 前往当前选中行的配置页面 
 		 */
 		gotoConfigPage:function(){
 			
 		}
 	});
 	return modelListView;
});