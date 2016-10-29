/**
 * 数据模型列表试图 
 */
define(['jquery','backbone','underscore','text!./modelListView-temp.html'],function($,Backbone,_,template){
	
	var defalut_settings = {};
	
 	var modelListView = Backbone.View.extend({
 		//菜单比较特殊,jquery easyui 会放到最外围 不再该VIEW视图获取范围内
 		//mmView:null,
 		//数据库列表
 		dbView:null,
 		context:{},
 		initialize:function(config){
 			this.context = _.extend({},defalut_settings,config);
 		},
 		render:function(){
 			this.$el.html(template);
 			$.parser.parse(this.$el);
 			//this.mmView = this.$el.find("#m-db-menu");
 			this.dbView = this.$el.find("#m-dblist");
 			this.initPluginEventHander();
 		},
 		//插件相关业务处理
 		initPluginEventHander:function(){
 			var view = this;
 			//菜单右键
 			this.dbView.datalist({
 				border:false,
 				url:'/db/tables',
 				method:'get',
 				lines:true,
 				onRowContextMenu:function(e,index,row){
 					e.preventDefault();
 					e.stopPropagation();
 					$("#m-db-menu").menu('show', {
 						left: e.pageX,
 						top: e.pageY
 					});
 				}
 			});
 			
 			
 			//----------------------------------------------废弃
 			//面板右键
 			$("#m-db-panel").on('contextmenu',function(e){
 				console.log(e.currenttarget);
				e.preventDefault();
				e.stopPropagation();
				$("#m-panel-menu").menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			});
 			
 			//导航菜单事件
 			$("#m-db-menu").menu({
 			    onClick:function(item){
 			    }
 			});
 			
 			//面板右键
 			$("#m-panel-menu").menu({
 			    onClick:function(item){
 			    	if(item.name == 'new'){
 			    		view.openConnectionConfigWindow();
 			    	}
 			    }
 			});
 			//----------------------------------------------废弃
 		},
 		//打开连接配置中心
 		openConnectionConfigWindow:function(/*连接单元*/item){
	 		var windom = '<div id="win"></div>';
	 		$('body').append(windom);
	 		$('#win').dialog({
	 		    title: '连接配置',
	 		    width: 600,
	 		    height: 450,
	 		    closed: false,
	 		    cache: false,
	 		    href: 'jsapp/view/model/dbConnectionConfig.html',
	 		    modal: true,
	 		    onClose:function(){
	 		    	$(this).dialog("destroy");
	 		    },
	 		    buttons:[
				{
					text:'连接测试',
					handler:function(){
										
					}
				},
	 		    {
					text:'保存',
					handler:function(){}
				}]
	 		});
 		}
 	});
 	return modelListView;
});