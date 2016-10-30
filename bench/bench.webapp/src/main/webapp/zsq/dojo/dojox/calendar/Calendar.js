//>>built
require({cache:{"url:dojox/calendar/templates/Calendar.html":"<div>\n\t<div data-dojo-attach-point=\"buttonContainer\" class=\"buttonContainer\">\n\t\t<div data-dojo-attach-point=\"toolbar\" data-dojo-type=\"dijit.Toolbar\" >\n\t\t\t<button data-dojo-attach-point=\"previousButton\" data-dojo-type=\"dijit.form.Button\" >&#x25C0;</button>\n\t\t\t<button data-dojo-attach-point=\"nextButton\" data-dojo-type=\"dijit.form.Button\" >&#x25B6;</button>\n\t\t\t<span data-dojo-type=\"dijit.ToolbarSeparator\"></span>\n\t\t\t<button data-dojo-attach-point=\"todayButton\" data-dojo-type=\"dijit.form.Button\" >Today</button>\n\t\t\t<span data-dojo-type=\"dijit.ToolbarSeparator\"></span>\n\t\t\t<button data-dojo-attach-point=\"dayButton\" data-dojo-type=\"dijit.form.Button\" >Day</button>\n\t\t\t<button data-dojo-attach-point=\"fourDaysButton\" data-dojo-type=\"dijit.form.Button\" >4 Days</button>\n\t\t\t<button data-dojo-attach-point=\"weekButton\" data-dojo-type=\"dijit.form.Button\" >Week</button>\t\t\t\n\t\t\t<button data-dojo-attach-point=\"monthButton\" data-dojo-type=\"dijit.form.Button\" >Month</button>\n\t\t</div>\n\t</div>\n\t<div data-dojo-attach-point=\"viewContainer\" class=\"viewContainer\"></div>\n</div>\n"}});
define("dojox/calendar/Calendar",["dojo/_base/declare","dojo/_base/lang","./CalendarBase","./ColumnView","./ColumnViewSecondarySheet","./VerticalRenderer","./DecorationRenderer","./MatrixView","./HorizontalRenderer","./LabelRenderer","./ExpandRenderer","./Keyboard","./Mouse","dojo/text!./templates/Calendar.html","dijit/form/Button","dijit/Toolbar","dijit/ToolbarSeparator"],function(_1,_2,_3,_4,_5,_6,_7,_8,_9,_a,_b,_c,_d,_e){
return _1("dojox.calendar.Calendar",_3,{templateString:_e,_createDefaultViews:function(){
var _f=_1([_5,_c,_d]);
var _10=_1([_4,_c,_d])(_2.mixin({secondarySheetClass:_f,verticalRenderer:_6,horizontalRenderer:_9,expandRenderer:_b,horizontalDecorationRenderer:_7,verticalDecorationRenderer:_7},this.columnViewProps));
var _11=_1([_8,_c,_d])(_2.mixin({horizontalRenderer:_9,horizontalDecorationRenderer:_7,labelRenderer:_a,expandRenderer:_b},this.matrixViewProps));
this.columnView=_10;
this.matrixView=_11;
var _12=[_10,_11];
this.installDefaultViewsActions(_12);
return _12;
},installDefaultViewsActions:function(_13){
this.matrixView.on("rowHeaderClick",_2.hitch(this,this.matrixViewRowHeaderClick));
this.columnView.on("columnHeaderClick",_2.hitch(this,this.columnViewColumnHeaderClick));
}});
});
