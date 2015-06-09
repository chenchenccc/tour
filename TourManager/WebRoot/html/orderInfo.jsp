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
<div id="order">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>预订客户：</label></td>
			<td><label>${tmOrder.customName}</label></td>
		</tr>
		<tr>
			<td><label>总人数:</label></td>
			<td><label>${tmOrder.totalPeople}</label></td>
		</tr>
		<tr>
			<td><label>日程名称:</label></td>
			<td><label>${tmOrder.scheduleName}</label></td>
		</tr>
		<tr>
			<td><label>总价格:</label></td>
			<td><label>${tmOrder.totalPrice}</label></td>
		</tr>
		<tr>
			<td><label>订单类型:</label></td>
			<td><label>${tmOrder.orderType}</label></td>
		</tr>
	</table>
</form>
</c:if>
</div>