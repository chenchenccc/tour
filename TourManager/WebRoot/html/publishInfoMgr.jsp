<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>发布消息</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/icon.css" />
</head>
<body class="easyui-layout" >
<div class="easyui-panel" fit="true" width="500px">
	<div style="padding:20px">
	<form id="ff" method="post">
	    <table cellpadding="5">
		    <tr>
		        <td>标题:</td>
		        <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    </tr>
		    <tr>
		        <td>作者:</td>
		        <td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    </tr>
		    <tr>
		        <td>发布时间:</td>
		        <td><input class="easyui-textbox" type="text" name="subject" data-options="required:true"></input></td>
		    </tr>
		    <tr>
		        <td>内容:</td>
		        <td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:60px"></input></td>
		    </tr>
		    <tr>
		        <td>类型:</td>
		        <td>
		            <select class="easyui-combobox" name="language"><option value="ar">文本</option><option value="bg">图片消息</option></select>
		        </td>
		    </tr>
		</table>
	</form>
	<div style="text-align:center;padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">发布</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">存为草稿</a>
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
	