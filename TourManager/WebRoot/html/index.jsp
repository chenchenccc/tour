<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>旅游管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path %>/html/css/default.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/jquery-easyui-1.3.5/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/JQuery-zTree-v3.5.15/css/zTreeStyle/zTreeStyle.css">
</head>
<body class="easyui-layout">
<!-- 无脚本时的提示 -->
<noscript>
	<div style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
		<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
	</div>
</noscript>
<!-- 头部标题 -->
<div data-options="region:'north',border:false" style="height:60px; padding:5px; background:#F3F3F3"> 
	<span class="northTitle">旅游管理系统</span>
    <span class="loginInfo">欢迎 <font color="red">${loginPolice.xm}</font> , 角色:
    <c:forEach items="${loginRole}" var="loginRole">
	    ${loginRole.jsmc },
    </c:forEach>
    <a href="#" id="editpass"><font color="blue">修改密码</font></a> <a href="#" id="loginOut"><font color="blue">安全退出</font></a>
    </span>
</div>

<!-- 左侧导航 -->
<div data-options="region:'west',split:true,title:'导航菜单', fit:false" style="width:200px;"> 
	<ul id="menuTree" class="ztree"></ul>
</div>

<!-- 页脚信息 -->
<div region="south" split="true" style="height: 30px; background:#F3F3F3;">
			<div class="footer">
			<span id="nowTime"></span>
			</div>
		</div>
<!-- 内容tabs -->
<div id="mainPanle" region="center">
	<div id="tabs" class="easyui-tabs" fit="true" border="false">
		<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
			<h1>欢迎页</h1><div id="test"></div>
		</div>
	</div>
</div>
<!--修改密码窗口-->
	<div id="w">
	<div class="easyui-layout" fit="true">
		<div region="center" border="false" style="padding: 10px;  border: 1px solid #ccc;">
			<table cellpadding='2'>
				<tr><td>旧密码：</td><td><input id="txtOldPass" type="password" /></td></tr>
				<tr><td>新密码：</td><td><input id="txtNewPass" type="password" /></td></tr>
				<tr><td>确认密码：</td><td><input id="txtRePass" type="password" /></td></tr>
			</table>
		</div>
	</div>
	</div>
<!-- 用于弹出框 -->
<div id="parent_win"></div>
<div id="mm" class="easyui-menu" style="width: 150px;">
	<div id="mm-tabclose">
		关闭
	</div>
	<div id="mm-tabcloseall">
		全部关闭
	</div>
	<div id="mm-tabcloseother">
		除此之外全部关闭
	</div>
	<div class="menu-sep"></div>
	<div id="mm-tabcloseright">
		当前页右侧全部关闭
	</div>
	<div id="mm-tabcloseleft">
		当前页左侧全部关闭
	</div>
	<div class="menu-sep"></div>
	<div id="mm-exit">
		退出
	</div>
</div>
</body>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/JQuery-zTree-v3.5.15/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/html/js/extends.js"></script>
<script type="text/javascript" src="<%=path %>/html/js/common.js"></script>
<script type="text/javascript">
/*
	主页加载方法
	@eric
*/
function getPath() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return projectName;
}
//系统时间显示
setInterval("document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	view: {
		selectedMulti: false
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("menuTree");
			if(node.isParent) {
				zTree.expandNode();
			} else {
				addTabs(node.name, getPath() + node.file);
			}
		}
	}
};

var zNodes;
$(function() {
	//zNodes = ${loginModuleList };
	zNodes =[
		{ id:1, pId:0, name:"系统管理", open:true},
		{ id:11, pId:1, name:"员工管理", file:"user/user.html"},
		{ id:12, pId:1, name:"部门管理", file:"backup.html"},
		{ id:13, pId:1, name:"角色管理", file:"authority.html"},
		{ id:14, pId:1, name:"权限管理", file:"role.html"},
		{ id:2, pId:0, name:"旅游管理", open:true},
		{ id:21, pId:2, name:"酒店管理", file:""},
		{ id:22, pId:2, name:"导游管理", file:""},
		{ id:23, pId:2, name:"客户管理", file:""},
		{ id:24, pId:2, name:"日程管理", file:""},
		{ id:25, pId:2, name:"订单管理", file:""},
		{ id:26, pId:2, name:"旅游团管理", file:""},
		{ id:3, pId:0, name:"系统消息", open:true},
		{ id:31, pId:3, name:"发布消息", file:""},
		{ id:32, pId:3, name:"查看消息", file:""},
	];
	if(zNodes != ''){
	   	InitLeftMenu();
	} else {
		$('#menuTree').append('暂无菜单');
	}
//	$.post( getPath() + "/system/sysModule_ztree.action",
//   		function (msg){      
//   			zNodes = msg;
//   			InitLeftMenu();
//  		 }, "text");
	
//	InitLeftMenu();
	
	tabClose();
	tabCloseEven();

	openPwd();

	$('#editpass').click(function() {
		$('#w').window('open');
	});

	$('#btnEp').click(function() {
		serverLogin();
	})

	$('#loginOut').click(function() {
		$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
			if (r) {
				location.href = getPath() + '/login.jsp';
			}
		});

	})
});
// 初始化左侧菜单
function InitLeftMenu() {
	$.fn.zTree.init($("#menuTree"), setting, eval(zNodes));
	var zTree = $.fn.zTree.getZTreeObj("menuTree");
}

//添加一个选项卡面板 
function addTab(subtitle,url){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			width:$('#mainPanle').width()-10,
			height:$('#mainPanle').height()-26
		});
	}else{
		$('#tabs').tabs('select',subtitle);
	}
	tabClose();
}

function createFrame(url)
{
	var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

//添加一个选项卡面板 
function addTabs(title, url, icon){
	if(!$('#tabs').tabs('exists', title)){
		$('#tabs').tabs('add',{  
			title:title,  
			content:'<iframe src="'+url+'" frameBorder="0" border="0" scrolling="no" style="width: 100%; height: 100%;"/>',  
			closable:true
		});
	} else {
		$('#tabs').tabs('select', title);
	}
}
function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children("span").text();
		$('#tabs').tabs('close',subtitle);
	})

	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY,
		});
		
		var subtitle =$(this).children("span").text();
		$('#mm').data("currtab",subtitle);
		
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven() {
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});	
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t!=currtab_title)
				$('#tabs').tabs('close',t);
		});	
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			showMsg('系统提示','后边没有了！','error');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			showMsg('系统提示','到头了，前边没有了！','error');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}
//设置登录窗口
function openPwd() {
//	$('#w').window( {
//		title : '修改密码',
//		width : 300,
//		modal : true,
//		shadow : false,
//		closed : true,
//		height : 200,
//		resizable : false
//	});
	$('#w').dialog({
		title: '修改密码',
	    width: 300,
	    height: 200,
	    closed: true,
	    cache: false,
	    modal: true,
        iconCls: 'icon-edit',
        buttons: [{
            text:'保存',
            iconCls:'icon-ok',
            handler:function(){
        		serverLogin();
                $("#w").dialog('close');
            }
        },{
            text:'取消',
            iconCls:'icon-cancel',
            handler:function(){
                $("#w").dialog('close');
            }
        }]
    });
}
//关闭登录窗口
function close() {
	$('#w').window('close');
}

//修改密码
function serverLogin() {
	var oldpass = $('#txtOldPass');
	var newpass = $('#txtNewPass');
	var rePass = $('#txtRePass');

	if (oldpass.val() === '') {
		showMsg('系统提示', '请输入旧密码！', 'warning');
		return false;
	}
	if (newpass.val() === '') {
		showMsg('系统提示', '请输入新密码！', 'warning');
		return false;
	}
	if (rePass.val() === '') {
		showMsg('系统提示', '请再一次输入密码！', 'warning');
		return false;
	}

	if (newpass.val() != rePass.val()) {
		showMsg('系统提示', '两次密码不一至！请重新输入', 'warning');
		return false;
	}

	showMsg('系统提示', '恭喜，密码修改成功！<br>您的新密码为：'+newpass.val(), 'info');
	close();
	
/*	$.post('/ajax/editpassword.ashx?newpass=' + newpass.val(), function(msg) {
		msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
		newpass.val('');
		rePass.val('');
		close();
	})*/

}

</script>

</html>
