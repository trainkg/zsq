/**
 * 测试使用
 */
define(['dojo/_base/declare'],function(declare){
	return declare(null,{
		constructor:function(id,name){
			this.id = id;
			this.name = name;
		},
		print:function(){
			console.log("this object id is " + this.id +' and name is ' + this.name);
		}
	});
});