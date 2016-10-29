/**
 * 侧边栏导航,基于bootstrapDOM扩展, 依赖bootstrap3的响应式插件, 只支持常用的slidebar用法
 * 标准的DOM 结构 ul > li > ul > li* > a 只支持2级结构
 */
!function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    define(['jquery','bootstrap','css!./jquery.sidebar'], factory);
  } else {
    factory(root.jQuery);
  }
}(window, function($) {
  'use strict';
 
  // Default options
  var defaults = {
	 'model':'single',//'single':''mutilp'
	 'data':[{
		 'icon':'',//图标class
		 'name':'',
		 'href':'',
		 'sub':[]//子导航
	 }]
  };
 
  //标准结构 添加在UL上面 不考虑其他标签
  var process = function(element, options) {
    this.element = element;
    this.options = options;
  };

  process.DEFAULT = defaults;
 
  // Plugin methods and shared properties
  process.prototype = {
    // Reset constructor - http://goo.gl/EcWdiy
    constructor: process,
  
    init: function() {
    	this._initConfig();
    	$.when(_initDom()).then(function(){if(this.onAfterInit)this.onAfterInit()});
    },
    //读取配置,适配相应的插件对象
    _initConfig:function(){
    	var config = this.options;
    },
    //生成DOM内部函数
    _initDom:function(){
    	var data = $.extend([],this.options.data);
    	$.each(data,function(item){
    		_initDomItem(item);
    	});
    },
    //递归函数 循环创建信息
    _initDomItem:function(item){
       
       if(item.icon){
    	   
       }
    },
    open:function(){
    	//TODO
    },
    close:function(){
    	//TODO
    },
    onAfterInit:null
  }
 
  // Create the jQuery plugin
  function Plugin(options) {
    // Do a deep copy of the options - http://goo.gl/gOSSrg
    var property = options;
    var options = $.extend(true, {}, defaults, options);
    
    return this.each(function() {
      var $this = $(this);
      var data = process.prototype;

      if (typeof property == 'string' && $.isFunction(data[property])) {
         data[property].apply($this.data('zsq.sidebar'));
      } else {
         data = new process($this, options);
         $this.data('zsq.sidebar',data)
         data.init();
      }
    });
  };
 
  // Expose defaults and Constructor (allowing overriding of prototype methods for example)
  var old = $.fn.process;

  $.fn.process = Plugin;
  $.fn.process.Constructor = process;
  

  	// LOOKUP NO CONFLICT
    // =================
    
    $.fn.process.noConflict = function () {
        $.fn.process = old
        return this
    }
    
    $(document).on('')
    return Plugin;
    
});
 
