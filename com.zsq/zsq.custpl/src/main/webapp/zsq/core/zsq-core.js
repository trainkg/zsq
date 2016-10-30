/*!
 * event and config center peculiar.1@163.com
 * */
+function(root,factory){
    if (typeof define === 'function' && define.amd) {
        define(['jquery'], factory);
    } else {
        factory(root.jQuery);
    }
}(window, function ($) {
    'use strict';
    
    var ZSQUI = {
//        JSPATH     : 'BJUI/',
//        PLUGINPATH : 'BJUI/plugins/',
        IS_DEBUG   : true,
        KeyPressed : { //key press state
            ctrl  : false,
            shift : false
        },
        keyCode: {
            ENTER : 13, ESC  : 27, END : 35, HOME : 36,
            SHIFT : 16, CTRL : 17, TAB : 9,
            LEFT  : 37, RIGHT: 39, UP  : 38, DOWN : 40,
            DELETE: 46, BACKSPACE: 8
        },
        eventType: {
            initUI         : 'ajaxTimeout',         // When document load completed or ajax load completed, B-JUI && Plugins init 
            beforeInitUI   : 'bjui.beforeInitUI',   // If your DOM do not init [add to DOM attribute 'data-noinit="true"']
            afterInitUI    : 'bjui.afterInitUI',    // 
            ajaxStatus     : 'bjui.ajaxStatus',     // When performing ajax request, display or hidden progress bar
            resizeGrid     : 'bjui.resizeGrid',     // When the window or dialog resize completed
            beforeAjaxLoad : 'bjui.beforeAjaxLoad', // When perform '$.fn.ajaxUrl', to do something...
            
            beforeLoadNavtab  : 'bjui.beforeLoadNavtab',
            beforeLoadDialog  : 'bjui.beforeLoadDialog',
            afterLoadNavtab   : 'bjui.afterLoadNavtab',
            afterLoadDialog   : 'bjui.afterLoadDialog',
            beforeCloseNavtab : 'bjui.beforeCloseNavtab',
            beforeCloseDialog : 'bjui.beforeCloseDialog',
            afterCloseNavtab  : 'bjui.afterCloseNavtab',
            afterCloseDialog  : 'bjui.afterCloseDialog'
        },
        pageInfo: {pageCurrent:'pageCurrent', pageSize:'pageSize', orderField:'orderField', orderDirection:'orderDirection'},
        alertMsg: {displayPosition:'topcenter', alertTimeout: 6000}, //alertmsg display position && close timeout
        ajaxTimeout: 30000,
        statusCode: {ok:200, error:300, timeout:301},
        keys: {statusCode:'statusCode', message:'message'},
        ui: {
            windowWidth      : 0,
            showSlidebar     : true,      // After the B-JUI initialization, display slidebar
            clientPaging     : true,      // Response paging and sorting information on the client
            overwriteHomeTab : false      // When open an undefined id of navtab, whether overwrite the home navtab
        },
        debug: function(msg) {
            if (this.IS_DEBUG) {
                if (typeof(console) != 'undefined') console.log(msg)
                else alert(msg)
            }
        },
        /*loginInfo: {
            url    : 'login.html',
            title  : 'Login',
            width  : 420,
            height : 260,
            mask   : true
        },
        loadLogin: function() {
            var login = this.loginInfo
            
            $('body').dialog({id:'bjui-login', url:login.url, title:login.title, width:login.width, height:login.height, mask:login.mask})
        },*/
        init: function(options) {
            var op = $.extend({}, options)
            
            $.extend(BJUI.statusCode, op.statusCode)
            $.extend(BJUI.pageInfo, op.pageInfo)
            $.extend(BJUI.alertMsg, op.alertMsg)
            $.extend(BJUI.loginInfo, op.loginInfo)
            $.extend(BJUI.ui, op.ui)
            
            if (op.JSPATH) this.JSPATH = op.JSPATH
            if (op.PLUGINPATH) this.PLUGINPATH = op.PLUGINPATH
            if (op.ajaxTimeout) this.ajaxTimeout = op.ajaxTimeout
            
            this.IS_DEBUG = op.debug || false
            
            if ((!$.cookie || !$.cookie('bjui_theme')) && op.theme) $(this).theme('setTheme', op.theme)
        },
        regional: {},
        setRegional: function(key, value) {
            BJUI.regional[key] = value
        },
        getRegional : function(key) {
            if (String(key).indexOf('.') >= 0) {
                var msg, arr = String(key).split('.')
                
                for (var i = 0; i < arr.length; i++) {
                    if (!msg) msg = BJUI.regional[arr[i]]
                    else msg = msg[arr[i]]
                }
                
                return msg
            } else {
                return BJUI.regional[key]
            }
        },
        doRegional: function(frag, regional) {
            $.each(regional, function(k, v) {
                frag = frag.replaceAll('#'+ k +'#', v)
            })
            
            return frag
        }
    }
    
    window.ZSQUI = ZSQUI;    
});