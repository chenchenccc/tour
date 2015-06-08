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
<div id="department">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>部门名称：</label></td>
			<td><label>${tmDepartment.deptName}</label></td>
		</tr>
		<tr>
			<td><label>描述:</label></td>
			<td><label>${tmDepartment.description}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/tmDepartment_saveAddTmDepartment.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>部门名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmDepartment.deptName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmDepartment.description" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/tmDepartment_saveEditTmDepartment.action">
<input type="hidden" name="tmDepartment.id" value="${tmDepartment.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>部门名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmDepartment.deptName" value="${tmDepartment.deptName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmDepartment.description" value="${tmDepartment.description }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>