<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<style>
#police table,#police td,#police th{border:1px solid #ccc;border-collapse:collapse;}
</style>
<div id="group">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>团名称：</label></td>
			<td><label>${tmGroup.groupName}</label></td>
		</tr>
		<tr>
			<td><label>团号:</label></td>
			<td><label>${tmGroup.tourId}</label></td>
		</tr>
		<tr>
			<td><label>所属日程:</label></td>
			<td><label>${tmGroup.scheduleName}</label></td>
		</tr>
		<tr>
			<td><label>导游:</label></td>
			<td><label>${tmGroup.guiderNames}</label></td>
		</tr>
		<tr>
			<td><label>开始时间:</label></td>
			<td><label>${tmGroup.startTime}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/tmGroup_saveAddTmGroup.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>旅游团名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmGroup.groupName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>团号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmGroup.tourId" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>日程路线</td>
	      	<td>
	      	<select name="tmGroup.scheduleId" class="easyui-combogrid" style="width:250px" data-options="
			            panelWidth: 500,
			            idField: 'id',
			            textField: 'name',
			            url: getPath()+'/tmSchedule_listTmSchedule.action',
			            method: 'post',
			            columns: [[
			                {field:'name',title:'日程名称',width:80,align:'center'},
			                {field:'totalDay',title:'总天数',width:120,align:'center'},
			                {field:'totalPeople',title:'总人数',width:80,align:'center'},
			                {field:'price',title:'价格',width:80,align:'center'},
			                {field:'type',title:'类型',width:80,align:'center',formatter:function(value,rowData,rowIndex){
								if(value == '1') return'<font color=black>短线</font>';
								else if(value == '2') return'<font color=pink>长线</font>';
							}},
							{field:'gride',title:'等级',width:80,align:'center',formatter:function(value,rowData,rowIndex){
								if(value == '1') return'<font color=black>标准团</font>';
								else if(value == '2') return'<font color=pink>定制团</font>';
							}},
			                {field:'departure',title:'出发地',width:80,align:'center'},
			                {field:'destination',title:'目的地',width:80,align:'center'},
			                {field:'startTime',title:'开始时间',width:80,align:'center'},
			                {field:'endTime',title:'结束时间',width:80,align:'center'},
			                {field:'grider_ids',title:'导游',width:80,align:'center'}
			            ]],
			            fitColumns: true
			        ">
			    </select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>开始时间</td>
	      	<td>
	      	<input id="startTime" name="tmGroup.startTime" type="text" class="easyui-datetimebox" />
	      	<!--<input class="easyui-textbox" style="width:250px" type="text" name="tmGroup.startTime" data-options="required:true"></input>
	      	--></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/tmGroup_saveEditTmGroup.action">
<input type="hidden" name="tmGroup.id" value="${tmGroup.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>旅游团名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmGroup.groupName" value="${tmGroup.groupName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>状态</td>
	      	<td><select name="tmOrder.status" class="easyui-combobox"><option value="1">未开始</option><option value="2">在路上</option><option value="3">已经结束</option></select></td>
	  	</tr>
	  	<!--<tr>
	      	<td><span class="x">*</span>开始时间</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="tmGroup.startTime" value="${tmGroup.startTime }" data-options="required:true"></input></td>
	  	</tr>
	--></table>
</form>
</c:if>
</div>