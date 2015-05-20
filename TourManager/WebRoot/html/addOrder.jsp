<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加订单</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/icon.css" />
</head>
<body class="easyui-layout" >
<div class="easyui-panel" fit="true" >
	<div style="padding:20px">
	<form id="ff" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>预订客户:</td>
	            <td><select class="easyui-combogrid" style="width:250px" data-options="
			            panelWidth: 500,
			            idField: 'id',
			            textField: 'realName',
			            url: getPath()+'/tmCustomer_listTmCustomer.action',
			            method: 'post',
			            columns: [[
			                {field:'realName',title:'用户姓名',width:80,align:'center'},
			                {field:'identityNum',title:'身份证号',width:120,align:'center'},
			                {field:'tel',title:'电话号码',width:80,align:'center'},
			                {field:'sex',title:'性别',width:80,align:'center',formatter:function(value,rowData,rowIndex){
								if(value == '0') return'<font color=black>未知</font>';
								else if(value == '1') return'<font color=pink>男</font>';
								else if(value == '2') return'<font color=green>女</font>';
								
							}}
			            ]],
			            fitColumns: true
			        ">
			    </select></td>
	        </tr>
	        <tr>
	            <td>人数</td>
	            <td><input class="easyui-textbox" type="text" name="totalPeople" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>所选日程:</td>
	            <td><select class="easyui-combogrid" style="width:250px" data-options="
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
			    </select></td>
	        </tr>
	        <tr>
	            <td>订单描述:</td>
	            <td><input class="easyui-textbox" name="orderDesc" data-options="multiline:true" style="height:60px"></input></td>
	        </tr>
	        <tr>
	            <td>订单类型:</td>
	            <td>
	                <select class="easyui-combobox" name="orderType"><option value="1">散客订单</option><option value="2">包团订单</option></select>
	            </td>
	        </tr>
	        <tr>
	            <td>总价格:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="price" data-options="readonly:true"></input>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="text-align:center;padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">预订</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">取消</a>
	    </div>
	    </div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
function getPath() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return projectName;
}

$(function(){
	function submitForm(){
	    $('#ff').form('submit');
	}
	function clearForm(){
	    $('#ff').form('clear');
	}

});
</script>
</html>
	