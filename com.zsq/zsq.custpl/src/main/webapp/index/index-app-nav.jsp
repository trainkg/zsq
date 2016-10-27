<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="easyui-panel">
	<a href="#" class="easyui-linkbutton" data-options="plain:true">Home</a>
	<a href="#" class="easyui-menubutton"
		data-options="menu:'#mm1',iconCls:'icon-edit'">Edit</a> 
	<a href="#"
		class="easyui-menubutton"
		data-options="menu:'#mm2',iconCls:'icon-help'">Help</a>
	<a href="#"
		class="easyui-menubutton" data-options="menu:'#mm3'">About</a>
</div>
<div id="mm1" style="width: 150px;">
	<div data-options="iconCls:'icon-undo'">Undo</div>
	<div data-options="iconCls:'icon-redo'">Redo</div>
	<div class="menu-sep"></div>
	<div>Cut</div>
	<div>Copy</div>
	<div>Paste</div>
	<div class="menu-sep"></div>
	<div>
		<span>Toolbar</span>
		<div>
			<div>Address</div>
			<div>Link</div>
			<div>Navigation Toolbar</div>
			<div>Bookmark Toolbar</div>
			<div class="menu-sep"></div>
			<div>New Toolbar...</div>
		</div>
	</div>
	<div data-options="iconCls:'icon-remove'">Delete</div>
	<div>Select All</div>
</div>
<div id="mm2" style="width: 100px;">
	<div>Help</div>
	<div>Update</div>
	<div>About</div>
</div>
<div id="mm3" class="menu-content"
	style="background: #f0f0f0; padding: 10px; text-align: left">
	<img src="http://www.jeasyui.com/images/logo1.png"
		style="width: 150px; height: 50px">
	<p style="font-size: 14px; color: #444;">Try jQuery EasyUI to build
		your modern, interactive, javascript applications.</p>
</div>