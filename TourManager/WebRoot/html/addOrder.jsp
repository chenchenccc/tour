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
	            <td>Name:</td>
	            <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>Email:</td>
	            <td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
	        </tr>
	        <tr>
	            <td>Subject:</td>
	            <td><input class="easyui-textbox" type="text" name="subject" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>Message:</td>
	            <td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:60px"></input></td>
	        </tr>
	        <tr>
	            <td>Language:</td>
	            <td>
	                <select class="easyui-combobox" name="language"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="text-align:center;padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
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
	