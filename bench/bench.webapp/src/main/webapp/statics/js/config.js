/**
 *  DOJO 全局配置
 */
dojoConfig = {
    has: {
        "dojo-firebug": false,
        "dojo-debug-messages": false
    },
    baseUrl:'/bench',
    parseOnload:false,
    packages:[
       {name:'test',location:"statics/js/test"},
       //dojo命名空间 由于根路径没有默认指定在dojo所在的目录
       {name:'dojo',location:"zsq/dojo/dojo"},
       {name:'dijit',location:"zsq/dojo/dijit"},
       {name:'dojox',location:"zsq/dojo/dojox"},
       // 扩展Widget命名空间
       {name:'extend',location:"zsq/extend"},
       // 将bootstrap3.0 的响应式JS DOJO实现
       {name:'bt',location:"zsq/bootstrap"},
       {name:'zsq',location:"statics/js"}
    ],
    paths:{
      'underscore' : 'zsq/underscore.16.0'
    },
    waitSeconds:5,
    map:{
    	"*":{
    		ready:'dojo/domReady'
    	}
    },
    cacheBust:false,
    shim:{
    	'underscore' : {
			exports : '_'
		}
    }
};