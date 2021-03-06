//>>built
require({cache:{"url:dojox/form/resources/_CheckedMultiSelectItem.html":"<div class=\"dijitReset ${baseClass}\"\n\t><input class=\"${baseClass}Box\" data-dojo-type=\"dijit.form.CheckBox\" data-dojo-attach-point=\"checkBox\" \n\t\tdata-dojo-attach-event=\"_onClick:_changeBox\" type=\"${_type.type}\" data-dojo-props='disabled:${disabled}, readOnly:${readOnly}' baseClass=\"${_type.baseClass}\"\n\t/><div class=\"dijitInline ${baseClass}Label\" data-dojo-attach-point=\"labelNode\" data-dojo-attach-event=\"onclick:_onClick\"></div\n></div>\n","url:dojox/form/resources/_CheckedMultiSelectMenuItem.html":"<tr class=\"dijitReset dijitMenuItem\" dojoAttachPoint=\"focusNode\" role=\"menuitemcheckbox\" tabIndex=\"-1\"\n\tdojoAttachEvent=\"ondijitclick:_onClick\"\n\t><td class=\"dijitReset dijitMenuItemIconCell\" role=\"presentation\"\n\t\t><div src=\"${_blankGif}\" alt=\"\" class=\"dijitMenuItemIcon ${_iconClass}\" dojoAttachPoint=\"iconNode\"\n\t\t\t><input class=\"dojoxCheckedMultiSelectCheckBoxInput\" dojoAttachPoint=\"inputNode\" type=\"${_type.type}\"\n\t\t/></div></td\n\t><td class=\"dijitReset dijitMenuItemLabel\" colspan=\"2\" dojoAttachPoint=\"containerNode,labelNode\"></td\n\t><td class=\"dijitReset dijitMenuItemAccelKey\" style=\"display: none\" dojoAttachPoint=\"accelKeyNode\"></td\n\t><td class=\"dijitReset dijitMenuArrowCell\" role=\"presentation\">&nbsp;</td\n></tr>","url:dojox/form/resources/CheckedMultiSelect.html":"<div class=\"dijit dijitReset dijitInline dijitLeft\" id=\"widget_${id}\"\n\t><div data-dojo-attach-point=\"comboButtonNode\"\n\t></div\n\t><div data-dojo-attach-point=\"selectNode\" class=\"dijit dijitReset dijitInline ${baseClass}Wrapper\" data-dojo-attach-event=\"onmousedown:_onMouseDown,onclick:focus\"\n\t\t><select class=\"${baseClass}Select dojoxCheckedMultiSelectHidden\" multiple=\"true\" data-dojo-attach-point=\"containerNode,focusNode\"></select\n\t\t><div data-dojo-attach-point=\"wrapperDiv\"></div\n\t></div\n></div>"}});
define("dojox/form/CheckedMultiSelect",["dojo/_base/declare","dojo/_base/lang","dojo/_base/array","dojo/_base/event","dojo/dom-geometry","dojo/dom-class","dojo/dom-construct","dojo/i18n","dijit/_WidgetBase","dijit/_TemplatedMixin","dijit/_WidgetsInTemplateMixin","dijit/registry","dijit/Menu","dijit/MenuItem","dijit/Tooltip","dijit/form/_FormSelectWidget","dijit/form/ComboButton","dojo/text!dojox/form/resources/_CheckedMultiSelectMenuItem.html","dojo/text!dojox/form/resources/_CheckedMultiSelectItem.html","dojo/text!dojox/form/resources/CheckedMultiSelect.html","dojo/i18n!dojox/form/nls/CheckedMultiSelect","dijit/form/CheckBox"],function(_1,_2,_3,_4,_5,_6,_7,_8,_9,_a,_b,_c,_d,_e,_f,_10,_11,_12,_13,_14,_15){
var _16=_1("dojox.form._CheckedMultiSelectItem",[_9,_a,_b],{templateString:_13,baseClass:"dojoxMultiSelectItem",option:null,parent:null,disabled:false,readOnly:false,postMixInProperties:function(){
this._type=this.parent.multiple?{type:"checkbox",baseClass:"dijitCheckBox"}:{type:"radio",baseClass:"dijitRadio"};
if(!this.disabled){
this.disabled=this.option.disabled=this.option.disabled||false;
}
if(!this.readOnly){
this.readOnly=this.option.readOnly=this.option.readOnly||false;
}
this.inherited(arguments);
},postCreate:function(){
this.inherited(arguments);
this.labelNode.innerHTML=this.option.label;
},_changeBox:function(){
if(this.get("disabled")||this.get("readOnly")){
return;
}
if(this.parent.multiple){
this.option.selected=this.checkBox.get("value")&&true;
}else{
this.parent.set("value",this.option.value);
}
this.parent._updateSelection();
this.parent.focus();
},_onClick:function(e){
if(this.get("disabled")||this.get("readOnly")){
_4.stop(e);
}else{
this.checkBox._onClick(e);
}
},_updateBox:function(){
this.checkBox.set("value",this.option.selected);
},_setDisabledAttr:function(_17){
this.disabled=_17||this.option.disabled;
this.checkBox.set("disabled",this.disabled);
_6.toggle(this.domNode,"dojoxMultiSelectDisabled",this.disabled);
},_setReadOnlyAttr:function(_18){
this.checkBox.set("readOnly",_18);
this.readOnly=_18;
}});
var _19=_1("dojox.form._CheckedMultiSelectMenu",_d,{multiple:false,buildRendering:function(){
this.inherited(arguments);
var o=(this.menuTableNode=this.domNode),n=(this.domNode=_7.create("div",{style:{overflowX:"hidden",overflowY:"scroll"}}));
if(o.parentNode){
o.parentNode.replaceChild(n,o);
}
_6.remove(o,"dijitMenuTable");
n.className=o.className+" dojoxCheckedMultiSelectMenu";
o.className="dijitReset dijitMenuTable";
o.setAttribute("role","listbox");
n.setAttribute("role","presentation");
n.appendChild(o);
},resize:function(mb){
if(mb){
_5.setMarginBox(this.domNode,mb);
if("w" in mb){
this.menuTableNode.style.width="100%";
}
}
},onClose:function(){
this.inherited(arguments);
if(this.menuTableNode){
this.menuTableNode.style.width="";
}
},onItemClick:function(_1a,evt){
if(typeof this.isShowingNow=="undefined"){
this._markActive();
}
this.focusChild(_1a);
if(_1a.disabled||_1a.readOnly){
return false;
}
if(!this.multiple){
this.onExecute();
}
_1a.onClick(evt);
}});
var _1b=_1("dojox.form._CheckedMultiSelectMenuItem",_e,{templateString:_12,option:null,parent:null,iconClass:"",postMixInProperties:function(){
if(this.parent.multiple){
this._iconClass="dojoxCheckedMultiSelectMenuCheckBoxItemIcon";
this._type={type:"checkbox"};
}else{
this._iconClass="";
this._type={type:"hidden"};
}
this.disabled=this.option.disabled;
this.checked=this.option.selected;
this.label=this.option.label;
this.readOnly=this.option.readOnly;
this.inherited(arguments);
},onChange:function(_1c){
},_updateBox:function(){
_6.toggle(this.domNode,"dojoxCheckedMultiSelectMenuItemChecked",!!this.option.selected);
this.domNode.setAttribute("aria-checked",this.option.selected);
this.inputNode.checked=this.option.selected;
if(!this.parent.multiple){
_6.toggle(this.domNode,"dijitSelectSelectedOption",!!this.option.selected);
}
},_onClick:function(e){
if(!this.disabled&&!this.readOnly){
if(this.parent.multiple){
this.option.selected=!this.option.selected;
this.parent.onChange();
this.onChange(this.option.selected);
}else{
if(!this.option.selected){
_3.forEach(this.parent.getChildren(),function(_1d){
_1d.option.selected=false;
});
this.option.selected=true;
this.parent.onChange();
this.onChange(this.option.selected);
}
}
}
this.inherited(arguments);
}});
var _1e=_1("dojox.form.CheckedMultiSelect",_10,{templateString:_14,baseClass:"dojoxCheckedMultiSelect",required:false,invalidMessage:"$_unset_$",_message:"",dropDown:false,labelText:"",tooltipPosition:[],postMixInProperties:function(){
this.inherited(arguments);
this._nlsResources=_8.getLocalization("dojox.form","CheckedMultiSelect",this.lang);
if(this.invalidMessage=="$_unset_$"){
this.invalidMessage=this._nlsResources.invalidMessage;
}
},_fillContent:function(){
this.inherited(arguments);
if(this.options.length&&!this.value&&this.srcNodeRef){
var si=this.srcNodeRef.selectedIndex||0;
this.value=this.options[si>=0?si:0].value;
}
if(this.dropDown){
_6.toggle(this.selectNode,"dojoxCheckedMultiSelectHidden");
this.dropDownMenu=new _19({id:this.id+"_menu",style:"display: none;",multiple:this.multiple,onChange:_2.hitch(this,"_updateSelection")});
}
},startup:function(){
if(this.dropDown){
this.dropDownButton=new _11({label:this.labelText,dropDown:this.dropDownMenu,baseClass:"dojoxCheckedMultiSelectButton",maxHeight:this.maxHeight},this.comboButtonNode);
}
this.inherited(arguments);
},_onMouseDown:function(e){
e.preventDefault();
},validator:function(){
if(!this.required){
return true;
}
return _3.some(this.getOptions(),function(opt){
return opt.selected&&opt.value!=null&&opt.value.toString().length!=0;
});
},validate:function(_1f){
_f.hide(this.domNode);
var _20=this.isValid(_1f);
if(!_20){
this.displayMessage(this.invalidMessage);
}
return _20;
},isValid:function(_21){
return this.validator();
},getErrorMessage:function(_22){
return this.invalidMessage;
},displayMessage:function(_23){
_f.hide(this.domNode);
if(_23){
_f.show(_23,this.domNode,this.tooltipPosition);
}
},onAfterAddOptionItem:function(_24,_25){
},_addOptionItem:function(_26){
var _27;
if(this.dropDown){
_27=new _1b({option:_26,parent:this.dropDownMenu});
this.dropDownMenu.addChild(_27);
}else{
_27=new _16({option:_26,parent:this,disabled:this.disabled,readOnly:this.readOnly});
this.wrapperDiv.appendChild(_27.domNode);
}
this.onAfterAddOptionItem(_27,_26);
},_refreshState:function(){
this.validate(this.focused);
},onChange:function(_28){
this._refreshState();
},reset:function(){
this.inherited(arguments);
_f.hide(this.domNode);
},_updateSelection:function(){
this.inherited(arguments);
this._handleOnChange(this.value);
_3.forEach(this._getChildren(),function(_29){
_29._updateBox();
});
_7.empty(this.containerNode);
var _2a=this;
_3.forEach(this.value,function(_2b){
var opt=_7.create("option",{"value":_2b,"label":_2b,"selected":"selected"});
_7.place(opt,_2a.containerNode);
});
if(this.dropDown&&this.dropDownButton){
var i=0,_2c="";
_3.forEach(this.options,function(_2d){
if(_2d.selected){
i++;
_2c=_2d.label;
}
});
this.dropDownButton.set("label",this.multiple?_2.replace(this._nlsResources.multiSelectLabelText,{num:i}):_2c);
}
},_getChildren:function(){
if(this.dropDown){
return this.dropDownMenu.getChildren();
}else{
return _3.map(this.wrapperDiv.childNodes,function(n){
return _c.byNode(n);
});
}
},invertSelection:function(_2e){
if(this.multiple){
_3.forEach(this.options,function(i){
i.selected=!i.selected;
});
this._updateSelection();
}
},_setDisabledAttr:function(_2f){
this.inherited(arguments);
if(this.dropDown){
this.dropDownButton.set("disabled",_2f);
}
_3.forEach(this._getChildren(),function(_30){
if(_30&&_30.set){
_30.set("disabled",_2f);
}
});
},_setReadOnlyAttr:function(_31){
this.inherited(arguments);
if("readOnly" in this.attributeMap){
this[this.attributeMap.readOnly].setAttribute("readonly",_31);
}
this.readOnly=_31;
_3.forEach(this._getChildren(),function(_32){
if(_32&&_32.set){
_32.set("readOnly",_31);
}
});
},uninitialize:function(){
_f.hide(this.domNode);
_3.forEach(this._getChildren(),function(_33){
_33.destroyRecursive();
});
this.inherited(arguments);
}});
return _1e;
});
