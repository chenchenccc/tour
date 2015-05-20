<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<style>
#police table,#police td,#police th{border:1px solid #ccc;border-collapse:collapse;}
</style>
<div id="autho">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>权限名称：</label></td>
			<td><label>${smAutho.authoName}</label></td>
		</tr>
		<tr>
			<td><label>URL:</label></td>
			<td><label>${smAutho.url}</label></td>
		</tr>
		<tr>
			<td><label>描述:</label></td>
			<td><label>${smAutho.description}</label></td>
		</tr>
		<tr>
			<td><label>上级权限:</label></td>
			<td><label>${smAutho.superId}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/smAutho_saveAddSmAutho.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>权限名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.authoName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>URL</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.url" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>上级权限</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.superId" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.description" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/smAutho_saveEditSmAutho.action">
<input type="hidden" name="smAutho.id" value="${smAutho.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>权限名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.authoName" value="${smAutho.authoName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>URL</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.url" value="${smAutho.url }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>上级权限</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.superId" value="${smAutho.superId }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smAutho.description" value="${smAutho.description }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>