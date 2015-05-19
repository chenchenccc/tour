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
<div id="police">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table>
		<tr>
			<td><label>旅游团名称</label></td>
			<td><label>${tmGroup.groupName}</label></td>
			<td><label>团号ID：</label></td>
			<td><label>${tmGroup.tourId}</label></td>
		</tr>
		<tr>
			<td><label>状态:</label></td>
			<td><label>
			<c:if test="${tmGroup.status eq '1'}">
			未开始
			</c:if>
			<c:if test="${tmGroup.status eq '2'}">
			正在路上
			</c:if>
			<c:if test="${tmGroup.status eq '3'}">
			已经结束
			</c:if>
			
			</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveAddSysPolice.action">
	<table border="0">
		<tr>
			<td><label><span class="x">*</span>旅游团名称</label></td>
			<td><input name="tmGroup.groupName" id="groupName"></td>
			<td><label><span class="x">*</span>团号ID</label></td>
			<td><input name="tmGroup.tourId" id="tourId"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>状态</label></td>
			<td>
			<select name="tmGroup.status">
				<option value="1">未开始</option>
				<option value="2">正在路上</option>
				<option value="3">已经结束</option>
				
			</select>
			</td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveEditSysPolice.action">

	<table border="0">
		<tr><input type="hidden" name="tmGroup.id" value="${tmGroup.id }"/>
			<td><label><span class="x">*</span>旅游团名称</label></td>
			<td><input name="tmGroup.groupName" id="groupName" value="${tmGroup.groupName}"></td>
			<td><label><span class="x">*</span>团号ID</label></td>
			<td><input name="tmGroup.tourId" id="tourId" value="${tmGroup.tourId}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>状态</label></td>
			<td>
			<!-- TODO 状态选中状态 -->
			<select name="tmGroup.status">
				<option value="1" >未开始</option>
				<option value="2" >正在路上</option>
				<option value="3" >已经结束</option>
				
			</select>
			</td>
		</tr>
	</table>
</form>
</c:if>
</div>