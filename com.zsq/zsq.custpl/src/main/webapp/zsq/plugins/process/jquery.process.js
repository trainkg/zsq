// 找半天也没找到一个自己满意的jquery 进度条插件 有点失望 得自己写吧

!function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    define(['jquery','text!./process-t.html','underscore','css!./jquery.process'], factory);
  } else {
    factory(root.jQuery);
  }
}(window, function($,tpl,_) {
  'use strict';
 
  // Default options
  var defaults = {
     //进度条类型, 默认采用bootstrap的进度条
     'type':'gif',//gif,css3,bootstrap
     'imgType':'load4',//
     'maskColor':'#FCFCFC',//遮罩颜色
     'opacity':'1',//遮罩透明度
     'maskStyle':null,//遮罩层style
     'loadMessage':'正在加载内容信息...'
  };
 
  // Constructor, initialise everything you need here
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

       var dom  = '<div class="u-layer">'
                + '<img alt="" src="image/loading3.gif">'
                + '</div>';
       
       if(tpl){        
          var domContext = {
            'imgType':this.options.imgType,
          }
          var _t = _.template(tpl);
          dom = _t(domContext);
          
       }
       
       var $element = $(this.element).append(dom);
       $element.css({'position':'relative'});
       var $layer = $element.find('.u-layer');
       $layer.css({'opacity':this.options.opacity,'background-color':this.options.maskColor})
       $layer.show();
    },
    complete:function(){

       var $layer = $(this.element).find('.u-layer');
       $layer.animate({opacity:0},2000,function(){
          $layer.remove();
       })
    }
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
         data[property].apply($this.data('zsq.process'));
      } else {
         data = new process($this, options);
         $this.data('zsq.process',data)
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
    
    return Plugin;
    
});
 
