// rconfig 全局唯一,必须定义 负责提供javascript寻址服务
function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}


var rconfig = {
	//所有模块的查找根路径。 还是根路径为标准
	baseUrl : '/zsq',
	waitSeconds: 7,
	// RequireJS获取资源时附加在URL后面的额外的query参数。作为浏览器或服务器未正确配置时的“cache bust”手段很有用。使用cache bust配置的一个示例：
	//urlArgs: 'v.1.0.0',
	urlArgs: "bust=" +  (new Date()).getTime(),
	//从CommonJS包(package)中加载模块。参见从包中加载模块
	packages:[
		{name:'zbase',location:"."},
		//应用路径配置
		{name:'ctrl',location:"../jsapp/controller"}
		,{name:'view',location:"../jsapp/view"}
		/*,
		{name:'model',location:"../watch/js/modal"},
		{name:'watch',location:"../watch"},
		{name:'watchcore',location:"../watchcore"}*/
	],
	//在deps加载完毕后执行的函数。当将require设置为一个config object在加载require.js之前使用时很有用，其作为配置的deps数组加载完毕后为require指定的函数。
	callback:null,
	//如果设置为true，则使用document.createElementNS()去创建script元素。
	xhtml:false,
	//path映射那些不直接放置于baseUrl下的模块名。设置path时起始位置是相对于baseUrl的，除非该path设置以"/"开头或含有URL协议（如http:）。在上述的配置下，"some/module"的script标签src值是"/another/path/some/v1.0/module.js"。
	paths : {
		//extend
        'bootstrap':'plugins/bootstrap/js/bootstrap',
        //core
        'jquery':'jquery',
        'jquery-validate':'zsq/jquery/jquery.validate',
        'jquery-validate-extend':'zsq/jquery/jquery.validate.plugin',
        'jquery-multiselect-zh':'zsq/jquery/jquery.multiselect.zh-cn',
        'jquery-multiselect':'zsq/jquery/jquery.multiselect.min',
		'form':'zsq/jquery/jquery.form',
        'ztree':'zsq/ztree/js/jquery.ztree.all-3.5.min',
        'md5':'jquery/jQuery.md5',
        'uploadify':'zsq/uploadify/jquery.uploadify.min',
		'jquery-ui':'zsq/jquery/jquery-ui-1.9.2.custom.min',
		'echarts':'zsq/echart/echarts',
		'echarts/chart/line':'zsq/echart/echarts',
		'pdfobject':'zsq/pdf/pdfobject',
		'iCheck':'plugins/icheck/icheck.min',
		
		//环境配置
		'easyui':'../easyui/jquery.easyui.min'
	},
	map: {
        '*': {
            'css': 'css',
            'text': 'text',
            'jquery':'jquery',
            'backbone' : 'backbone',
            'domReady':'domReady',
            'underscore':'underscore'
        }
    },
	shim : {
		"nicescroll":{
			deps:["jquery"],
			exports:"jQuery"
		},
		'backbone' : {
			deps : [ 'underscore', 'jquery' ],
			exports : 'Backbone'
		},
		'underscore' : {
			exports : '_'
		},
		'form' : {
			deps:['jquery'],
			exports : 'jQuery'
		},
		/*'keditor':{
			deps:['jquery','keditor-zh'],
			exports :'keditor'
		},*/
		'jquery-validate':{
			deps:['jquery'],
			exports:'jQuery'
		},
		'jquery-validate-extend':{
			deps:['jquery','jquery-validate'],
			exports:'jQuery'
		},
		'bootstrap':{
			deps:['jquery'],
			exports:'jQuery'
		},
		'ztree':{
			deps:['jquery'],
			exports:'jQuery'
		},
		'md5':{
			deps:['jquery'],
			exports:'jQuery'
		},
		'jquery-multiselect':{
        	deps:['jquery-ui'],
        	exports:'jQuery'
        },
        'jquery-multiselect-zh':{
			deps:['jquery-multiselect'],
			exports:'jQuery'
		},
		'jquery-ui':{
			deps:['jquery'],
			exports:'jQuery'
		},
		'plupload':{
			exports:'plupload'
		},
		'iCheck':{
			deps:['jquery'],
			exports:'$.fn.iCheck'
		},
		'easyui':{
			deps:['jquery'],
			exports:'jQuery'
		}
	}
}
require.config(rconfig);
