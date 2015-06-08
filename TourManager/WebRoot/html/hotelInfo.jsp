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
	<table cellpadding="5">
		<tr>
			<td><label>酒店名称</label></td>
			<td><label>${tmHotel.name}</label></td>
		</tr>
		<tr>
			<td><label>酒店区域:</label></td>
			<td><label>${tmHotel.regionName}</label></td>
		</tr>
		<tr>
			<td><label>酒店星级:</label></td>
			<td><label>
			<c:if test="${tmHotel.star eq '1'}">
			一星级
			</c:if>
			<c:if test="${tmHotel.star eq '2'}">
			二星级
			</c:if>
			<c:if test="${tmHotel.star eq '3'}">
			三星级
			</c:if>
			<c:if test="${tmHotel.star eq '4'}">
			四星级
			</c:if>
			<c:if test="${tmHotel.star eq '5'}">
			五星级
			</c:if>
			</label></td>
		</tr>
		<tr>
			<td><label>地址:</label></td>
			<td><label>${tmHotel.address}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/tmHotel_saveAddTmHotel.action">
	<table border="0">
		<tr>
			<td><label><span class="x">*</span>酒店名称</label></td>
			<td><input name="tmHotel.name" id="name"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>酒店区域</label></td>
			<td><input name="tmHotel.regionName" id="regionName"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>地址</label></td>
			<td><input name="tmHotel.address" id="address"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>酒店星级</label></td>
			<td>
			<select name="tmHotel.star">
				<option value="1">一星级</option>
				<option value="2">二星级</option>
				<option value="3">三星级</option>
				<option value="4">四星级</option>
				<option value="5">五星级</option>
			</select>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/system/tmHotel_saveEditTmHotel.action">

	<table border="0">
		<tr><input type="hidden" name="tmHotel.id" value="${tmHotel.id }"/>
			<td><label><span class="x">*</span>酒店名称</label></td>
			<td><input name="tmHotel.name" id="name" value="${tmHotel.name}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>酒店区域</label></td>
			<td><input name="tmHotel.regionName" id="regionName" value="${tmHotel.regionName}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>地址</label></td>
			<td><input name="tmHotel.address" id="address" value="${tmHotel.address}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>酒店星级</label></td>
			<td>
			<!-- TODO 星级选中状态 -->
			<select name="tmHotel.star">
				<option value="1" >一星级</option>
				<option value="2" >二星级</option>
				<option value="3" >三星级</option>
				<option value="4" >四星级</option>
				<option value="5" >五星级</option>
			</select>
			</td>
		</tr>
	</table>
</form>
</c:if>
</div>