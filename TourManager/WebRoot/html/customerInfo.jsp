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
<div id="customer">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>姓名：</label></td>
			<td><label>${tmCustomer.realName}</label></td>
		</tr>
		<tr>
			<td><label>年龄:</label></td>
			<td><label>${tmCustomer.age}</label></td>
		</tr>
		<tr>
			<td><label>性别:</label></td>
			<td><label>${tmCustomer.sex}</label></td>
		</tr>
		<tr>
			<td><label>游客类型:</label></td>
			<td><label>${tmCustomer.type}</label></td>
		</tr>
		<tr>
			<td><label>联系方式:</label></td>
			<td><label>${tmCustomer.tel}</label></td>
		</tr>
		<tr>
			<td><label>身份证号:</label></td>
			<td><label>${tmCustomer.identityNum}</label></td>
		</tr>
		<tr>
			<td><label>游客类型:</label></td>
			<td><label>${tmCustomer.classify}</label></td>
		</tr>
		<tr>
			<td><label>是否负责人:</label></td>
			<td><label>${tmCustomer.isKey}</label></td>
		</tr>
		<tr>
			<td><label>所属负责人:</label></td>
			<td><label>${tmCustomer.superName}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/tmCustomer_saveAddTmCustomer.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>姓名</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.realName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>年龄</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.age data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>性别</td>
	      	<td>
	      	<select name="tmCustomer.sex" class="easyui-combobox"><option value="1">男</option><option value="2">女</option><option value="0">未知</option></select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>游客类型</td>
	      	<td>
	      		<select name="tmCustomer.type" class="easyui-combobox"><option value="1">大人</option><option value="2">小孩</option><option value="3">学生</option></select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>联系方式</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.tel" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>身份证号</td>
	      	<td><input id="identityNum" class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.identityNum" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>游客类别</td>
	      	<td>
	      		<select name="tmCustomer.classify" class="easyui-combobox"><option value="1">散客</option><option value="2">组团</option></select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>是否负责人</td>
	      	<td>
	      		<select name="tmCustomer.isKey" class="easyui-combobox"><option value="1">是</option><option value="2">否</option></select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>所属负责人</td>
	      	<td>
	      	<select name="tmCustomer.superId" class="easyui-combogrid" style="width:250px" data-options="
			            panelWidth: 500,
			            idField: 'id',
			            textField: 'realName',
			            url: getPath()+'/tmCustomer_listTmCustomer.action',
			            method: 'post',
			            columns: [[
			                {field:'realName',title:'姓名',width:80,align:'center'},
			                {field:'age',title:'年龄',width:120,align:'center'},
			                {field:'sex',title:'性别',width:80,align:'center',formatter:function(value,rowData,rowIndex){
								if(value == '0') return'未知';
								else if(value == '1') return'男';
								else if(value == '2') return'女';
							}},
			                {field:'tel',title:'联系方式',width:80,align:'center'}
			            ]],
			            fitColumns: true
			        ">
			    </select>
	      	</td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/tmCustomer_saveEditTmCustomer.action">
<input type="hidden" name="tmCustomer.id" value="${tmCustomer.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>姓名</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.realName" value="${tmCustomer.realName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>年龄</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.age" value="${tmCustomer.age }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>性别</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.sex" value="${tmCustomer.sex }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>游客类型</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.type" value="${tmCustomer.type }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>联系方式</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.tel" value="${tmCustomer.tel }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>身份证号</td>
	      	<td><input id="identityNum" class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.identityNum" value="${tmCustomer.identityNum }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>游客类别</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.classify" value="${tmCustomer.classify }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>是否负责人</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.isKey" value="${tmCustomer.isKey }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>所属负责人</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmCustomer.superName" value="${tmCustomer.superName }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>