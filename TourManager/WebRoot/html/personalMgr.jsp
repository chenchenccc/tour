<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人信息管理</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/icon.css" />
</head>
<body class="easyui-layout" >
<table id="pg" style="width:800px"></table>
<button onclick="savePersonInfo()">保存</button>
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
	$('#pg').propertygrid({
	    url: getPath() + '/tmEmployee_getPersonalInfo.action',
	    showGroup: true,
	    showHeader: false,
	    scrollbarSize: 0
	});
	
});
function savePersonInfo() {
	var s = '';
	var rows = $('#pg').propertygrid('getChanges');
	if(rows.length == 0) {
		alert('没有修改任何数据');
	}
	// 保存修改数据
	
	/*$.ajax({
		type: "POST",
		url: getPath() + '/tmEmployee_savePersonalInfo.action',
		processData: true,
		data: rows,
		success: function(data){
			var result = eval("("+data+")");
			if (result && result.success) {
				$.messager.show({title : '信息',msg : result.msg});
			} else {
				$.messager.show({title : '错误',msg : result.msg});
			}
		   			
		}
	});*/
}

</script>
</html>
	