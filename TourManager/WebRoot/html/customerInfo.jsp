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
			<td><label>客户Id</label></td>
			<td><label>${tmCustomer.userId}</label></td>
			<td><label>年龄</label></td>
			<td><label>${tmCustomer.age}</label></td>
		</tr>
		<tr>
			<td><label>性别：</label></td>
			<td><label>
			<c:if test="${tmCustomer.sex eq '0'}">
			未知
			</c:if>
			<c:if test="${tmCustomer.sex eq '1'}">
			男
			</c:if>
			<c:if test="${tmCustomer.sex eq '2'}">
			女
			</c:if>
			</label></td>
			<td><label>旅客类型:</label></td>
			<td><label>
			<c:if test="${tmCustomer.sex eq '1'}">
			成人
			</c:if>
			<c:if test="${tmCustomer.sex eq '2'}">
			小孩
			</c:if>
			<c:if test="${tmCustomer.sex eq '3'}">
			学生
			</c:if>
			</label></td>
		</tr>
		<tr>
			<td><label>联系方式</label></td>
			<td><label>${tmCustomer.tel}</label></td>
			<td><label>身份证号</label></td>
			<td><label>${tmCustomer.identityNum}</label></td>
		</tr>
		<tr>
			<td><label>游客类别</label></td>
			<td><label>
			<c:if test="${tmCustomer.classify eq '1'}">
			散客
			</c:if>
			<c:if test="${tmCustomer.classify eq '2'}">
			组团
			</c:if>
			</label></td>
			<td><label>是否负责人</label></td>
			<td><label>
			<c:if test="${tmCustomer.isKey eq '1'}">
			是
			</c:if>
			<c:if test="${tmCustomer.isKey eq '2'}">
			否
			</c:if>
			</label></td>
		</tr>
		<tr>
			<td><label>所属负责人</label></td>
			<td><label>${tmCustomer.superId}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveAddSysPolice.action">
	<table border="0">
		<tr>
			<td><label><span class="x">*</span>客户Id</label></td>
			<td><input name="tmCustomer.userId." id="userId"></td>
			<td><label><span class="x">*</span>年龄</label></td>
			<td><input name="tmCustomer.age." id="age">
		</tr>
		<tr>
			<td><label><span class="x">*</span>性别：</label></td>
			<td>
			<select name="tmCustomer.sex">
				<option value="0">未知</option>
				<option value="1">男</option>
				<option value="2">女</option>
			</select>
			</td>
			<td><label><span class="x">*</span>旅客类型:</label></td>
			<td>
			<select name="tmCustomer.type">
				<option value="1">成人</option>
				<option value="2">小孩</option>
				<option value="3">学生</option>
			</select>
			</td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>联系方式</label></td>
			<td><input name="tmCustomer.tel." id="tel"></td>
			<td><label><span class="x">*</span>身份证号</label></td>
			<td><input name="tmCustomer.identityNum." id="identityNum"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>游客类别</label></td>
			<td>
			<select name="tmCustomer.classify">
				<option value="1">散客</option>
				<option value="2">组团</option>
			</select>
			</td>
			<td><label><span class="x">*</span>是否负责人</label></td>
			<td><select name="tmCustomer.isKey">
				<option value="1">是</option>
				<option value="2">否</option>
			</select></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>所属负责人</label></td>
			<td><input name="tmCustomer.superId." id="superId"></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveEditSysPolice.action">

	<table border="0">
		<tr>
			<td><label><span class="x">*</span>客户Id</label></td>
			<td><input name="tmCustomer.userId." id="userId"></td>
			<td><label><span class="x">*</span>年龄</label></td>
			<td><input name="tmCustomer.age." id="age">
		</tr>
		<tr>
			<td><label><span class="x">*</span>性别：</label></td>
			<td>
			<select name="tmCustomer.sex">
				<option value="0">未知</option>
				<option value="1">男</option>
				<option value="2">女</option>
			</select>
			</td>
			<td><label><span class="x">*</span>旅客类型:</label></td>
			<td>
			<select name="tmCustomer.type">
				<option value="1">成人</option>
				<option value="2">小孩</option>
				<option value="3">学生</option>
			</select>
			</td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>联系方式</label></td>
			<td><input name="tmCustomer.tel." id="tel"></td>
			<td><label><span class="x">*</span>身份证号</label></td>
			<td><input name="tmCustomer.identityNum." id="identityNum"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>游客类别</label></td>
			<td>
			<select name="tmCustomer.classify">
				<option value="1">散客</option>
				<option value="2">组团</option>
			</select>
			</td>
			<td><label><span class="x">*</span>是否负责人</label></td>
			<td><select name="tmCustomer.isKey">
				<option value="1">是</option>
				<option value="2">否</option>
			</select></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>所属负责人</label></td>
			<td><input name="tmCustomer.superId." id="superId"></td>
		</tr>
		
	</table>
</form>
</c:if>
</div>