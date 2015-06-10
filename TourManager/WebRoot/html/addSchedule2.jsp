<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加日程</title>
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
	            <td>名称</td>
	            <td><input class="easyui-textbox" type="text" name="tmSchedule.name" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>开始地</td>
	            <td><input class="easyui-textbox" type="text" name="tmSchedule.departure" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>目的地</td>
	            <td><input class="easyui-textbox" type="text" name="tmSchedule.destination" data-options="required:true"></input></td>
	        </tr>

	        <tr>
	            <td>总天数</td>
	            <td><input class="easyui-textbox" type="text" name="tmSchedule.totalDay" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>总人数</td>
	            <td><input class="easyui-textbox" type="text" name="tmSchedule.totalPeople" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>开始时间</td>
	            <td>
	            	<input id="startTime" name="tmSchedule.startTime" type="text" class="easyui-datebox" />  
	            </td>
	        </tr>
	        <tr>
	            <td>结束时间</td>
	            <td>
	            	<input id="endTime" name="tmSchedule.endTime" type="text" class="easyui-datebox" />
	            </td>
	        </tr>
	        <!--<tr>
	            <td>日程类型:</td>
	            <td>
	                <select class="easyui-combobox" name="tmSchedule.type"><option value="1">短线</option><option value="2">长线</option></select>
	            </td>
	        </tr>
	        <tr>
	            <td>等级:</td>
	            <td>
	                <select class="easyui-combobox" name="tmSchedule.grade"><option value="1">标准团</option><option value="2">定制团</option></select>
	            </td>
	        </tr>
	        <tr>
	            <td>价格:</td>
	            <td><input class="easyui-textbox" type="text" name="tmSchedule.price" data-options="required:true"></input></td>
	        </tr>
	    --></table>
	</form>
	<div style="text-align:center;padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveForm()">预订</a>
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

function saveForm(){
    //$('#ff').form('submit');
    var formData=$("#ff").serialize();
	// 保存编辑对象		        		
     	$.ajax({
		type: "POST",
		url: getPath() + '/tmSchedule_saveAddTmSchedule.action',
		processData:true,
		data:formData,
		success: function(data){
			var result = eval("("+data+")");
			if (result && result.success) {
				$('#tt').datagrid('reload');
				showMsg('信息','添加成功','alert');
			} else {
				$.messager.show({title : '错误',msg : result.msg});
			}
     		clearForm();
		}
     });
}
function clearForm(){
    $('#ff').form('clear');
}
</script>
</html>
	