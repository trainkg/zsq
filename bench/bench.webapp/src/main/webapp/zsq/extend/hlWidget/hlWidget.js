/**
 *  创建自定义小挂件 
 */
define([
        'dojo/_base/declare',
        'dijit/_WidgetBase',
        'dijit/_TemplatedMixin',
        'dojo/text!./templates/hlWidget.html'
    ],function(declare,_WidgetBase,_TeamlateMixin,template){
		return declare([_WidgetBase,_TeamlateMixin],{
			// 模板文件
			templateString:template
		});
	}
);