//>>built
define("dojox/mobile/bidi/Carousel",["dojo/_base/declare","./common","dojo/dom-style"],function(_1,_2,_3){
return _1(null,{buildRendering:function(){
this.inherited(arguments);
if(!this.isLeftToRight()){
if(this.navButton){
_3.set(this.btnContainerNode,"float","left");
this.disconnect(this._prevHandle);
this.disconnect(this._nextHandle);
this._prevHandle=this.connect(this.prevBtnNode,"onclick","onNextBtnClick");
this._nextHandle=this.connect(this.nextBtnNode,"onclick","onPrevBtnClick");
}
if(this.pageIndicator){
_3.set(this.piw.domNode,"float","left");
}
}
},_setTitleAttr:function(_4){
this.titleNode.innerHTML=this._cv?this._cv(_4):_4;
this._set("title",_4);
if(this.textDir){
this.titleNode.innerHTML=_2.enforceTextDirWithUcc(this.titleNode.innerHTML,this.textDir);
this.titleNode.style.textAlign=(this.dir.toLowerCase()==="rtl")?"right":"left";
}
},_setTextDirAttr:function(_5){
if(_5&&this.textDir!==_5){
this.textDir=_5;
this.titleNode.innerHTML=_2.removeUCCFromText(this.titleNode.innerHTML);
this.titleNode.innerHTML=_2.enforceTextDirWithUcc(this.titleNode.innerHTML,this.textDir);
if(this.items.length>0){
this.onComplete(this.items);
}
}
}});
});
