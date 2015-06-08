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
<div id="employee">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>员工号：</label></td>
			<td><label>${tmEmployee.employeeNum}</label></td>
		</tr>
		<tr>
			<td><label>姓名:</label></td>
			<td><label>${tmEmployee.realName}</label></td>
		</tr>
		<tr>
			<td><label>联系电话:</label></td>
			<td><label>${tmEmployee.tel}</label></td>
		</tr>
		<tr>
			<td><label>所属部门:</label></td>
			<td><label>${tmEmployee.deptName}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/tmEmployee_saveAddTmEmployee.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>员工号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmEmployee.employeeNum" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>姓名</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmEmployee.realName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>登录名</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="smUser.loginName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>初始密码</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="password" name="smUser.password" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>联系电话</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmEmployee.tel" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>所属部门</td>
	      	<td><select name="tmEmployee.deptId" class="easyui-combogrid" style="width:250px; z-index:100" data-options="
		            panelWidth: 500,
		            idField: 'id',
		            textField: 'deptName',
		            url: getPath()+'/tmDepartment_listTmDepartment.action',
		            method: 'post',
		            columns: [[
		                {field:'deptName',title:'部门名称',width:80,align:'center'},
		                {field:'superId',title:'上级部门ID',width:120,align:'center'},
		                {field:'description',title:'描述',width:80,align:'center'}
		            ]],
		            fitColumns: true
		        ">
		    </select></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/tmEmployee_saveEditTmEmployee.action">
<input type="hidden" name="tmEmployee.id" value="${tmEmployee.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>员工号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmEmployee.employeeNum" value="${tmEmployee.employeeNum }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>姓名</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmEmployee.realName" value="${tmEmployee.realName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>联系电话</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmEmployee.tel" value="${tmEmployee.tel }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>所属部门</td>
	      	<td><select name="tmEmployee.deptId" class="easyui-combogrid" style="width:250px" data-options="
		            panelWidth: 500,
		            idField: 'id',
		            textField: 'deptName',
		            url: getPath()+'/tmDepartment_listTmDepartment.action',
		            method: 'post',
		            columns: [[
		                {field:'deptName',title:'部门名称',width:80,align:'center'},
		                {field:'superId',title:'上级部门ID',width:120,align:'center'},
		                {field:'description',title:'描述',width:80,align:'center'}
		            ]],
		        ">
		    </select></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>