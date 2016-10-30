/**
 * 测试使用 类创建
 */
declare("com.zsq.C1",null,{
	id:null,
	name:null,
	getName:function(){
		return this.name;
	},
	constructor:function(){
		// 特殊的方法  在类实例化的时候会执行该方法
	}
});

/**
 * 相当于JAVA的匿名内部类
 */
var c2 = declare(null,{
	id:null,
	name:null,
	getId:function(){
		return this.id;
	}
});

/**
 * 子类
 */
var c3 = declare(c2,{
	code:null,
	getCode:function(){
		return this.code;
	}
});

/**
 * 多继承 java 没有 参考 c++
 */
var c4 = declare([c3,c2],{
	type:null,
	getType:function(){
		return this.type;
	}
});




