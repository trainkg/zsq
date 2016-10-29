/**
 * 
 * 系统全局控制器,采用路由定义的访问入口,在单页面应用中,
 * 
 * <><><><><><>重要<><><><><><>
 * 最外层的页面流程采用路由管理,内部的事件处理不允许走路由绑定
 * <><><><><><>重要<><><><><><>
 * 
 * 
 */
define(['jquery','backbone',
        './app-layout'
       ],function($,Backbone,Layout){
 	var navController = Backbone.Router.extend({
 		//全局布局对象管理器
 		layout:null,
 		initialize:function(){
 			this.initComponent();
 		},
 		routes:{
 		},
 		initComponent:function(){
 			var mlConfig = {
 				el:'#app-content'
 			};
 			this.Layout = new Layout(mlConfig);
 			this.Layout.render();
 		}
 	});
 	return navController;
})