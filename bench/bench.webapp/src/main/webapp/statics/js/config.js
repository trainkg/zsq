/**
 *  DOJO 全局配置
 */
dojoConfig = {
    has: {
        "dojo-firebug": true,
        "dojo-debug-messages": true
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
       {name:'extend',location:"zsq/extend"}
    ],
    waitSeconds:5,
    map:{
    	"*":{
    		ready:'dojo/domReady'
    	}
    },
    cacheBust:true
};