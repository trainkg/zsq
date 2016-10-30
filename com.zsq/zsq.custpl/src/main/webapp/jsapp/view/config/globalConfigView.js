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
 		}
 	});
 	return modelListView;
});