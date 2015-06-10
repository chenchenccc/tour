<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>员工管理</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/icon.css" />
</head>
<body class="easyui-layout" >
<div id="body" region="center" > 
  <!-- 查询条件区域 -->
  <div id="search_area" >
    <div id="conditon">
      <table border="0">
        <tr>
         <form id="ff" method="post">
          <td>员工号：</td>
          <td><input name="tmEmployee.employeeNum" id="employeeNum" /></td>
          <td>姓名：</td>
          <td><input name="tmEmployee.realName" id="realName" /></td>
          <td>
              <a href="javascript:void(0)" class="easyui-linkbutton my-search-button" onclick="query();" iconCls="icon-search" plain="true">查询</a>
          </td>
         </form>
        </tr>
      </table>
    </div>
    <span id="openOrClose">0</span> 
  </div>
  <!-- 数据表格区域 -->
  <table id="tt" style="table-layout:fixed;"></table>
  <!-- Dialog -->
  <div id="dd"><div id="content" region="center" border="false" style="padding: 10px;  border: 1px solid #ccc; z-index: 1"></div>
 
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
	
	$("#tt").datagrid({
		height:$("#body").height()-$('#search_area').height()-5,
		width:$("#body").width(),
//		idField:'id',
		singleSelect:true, 
		nowrap:true,
		striped: true,
		fitColumns:true,
		rownumbers:true,
		loadMsg : /*showProcess(true, '温馨提示', '正在加载数据, 请稍后...')*/'正在加载数据',
		url: getPath() + "/tmEmployee_listTmEmployee.action",  
		columns:[[
			{field:'employeeNum',title:'员工号',width:60,halign:"center", align:"center"},
			{field:'realName',title:'姓名',width:60,halign:"center", align:"center"},
			{field:'tel',title:'联系电话',width:60,halign:"center", align:"center"},
			{field:'deptName',title:'所属部门',width:60,halign:"center", align:"center"},
			{field:'sex',title:'性别',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '0') return"<font color='black'>未知</font>";
				else if(value == '1') return"<font color='pink'>男</font>";
				else if(value == '2') return"<font color='green'>女</font>";
			}}
		]],
		showPageList:[10,20,30,40,50],
		pageNumber: 1, // 初始页数
		pageSize: 10,  // 初始
		pagination: true,
		toolbar: [{
			text: '添加',
			iconCls: 'icon-add',
			handler: function(){
				$('#dd').dialog({
			        buttons: [{
			            text:'保存',
			            iconCls:'icon-ok',
			            handler:function(){
			        		 // 保存添加对象
			        		var formData=$("#saveform").serialize();
			        		$.ajax({
								type: "POST",
								url: getPath() + '/tmEmployee_saveAddTmEmployee.action',
								processData: true,
								data: formData,
								success: function(data){
			        				var result = eval("("+data+")");
									if (result && result.success) {
										$('#tt').datagrid('reload');
										$.messager.show({title : '信息',msg : result.msg});
									} else {
										$.messager.show({title : '错误',msg : result.msg});
									}
			        			
								}
			        		});
			                $("#dd").dialog('close');
			            }
			        },{
			            text:'取消',
			            iconCls:'icon-cancel',
			            handler:function(){
			                $("#dd").dialog('close');
			            }
			        }]
			    });
				$("#content").html(''); // 先将content的内容清空
				// 保存对象
				$.post(getPath()+"/tmEmployee_addTmEmployee.action",
				    function(result){
						$("#content").append(result);
				    });
				$("#dd").dialog('open').dialog('setTitle', '添加');
			    $('#form').form('clear');
			}
		},{
			text: '修改',
			iconCls: 'icon-edit',
			handler: function(){
				$('#dd').dialog({
		        buttons: [{
		            text:'保存',
		            iconCls:'icon-ok',
		            handler:function(){
		        		var formData=$("#saveform").serialize();
						// 保存编辑对象		        		
		        		$.ajax({
							type: "POST",
							url: getPath() + '/tmEmployee_saveEditTmEmployee.action',
							processData:true,
							data:formData,
							success: function(data){
								var result = eval("("+data+")");
								if (result && result.success) {
									$('#tt').datagrid('reload');
									$.messager.show({title : '信息',msg : result.msg});
								} else {
									$.messager.show({title : '错误',msg : result.msg});
								}
		        				$('#tt').datagrid('reload');
							}
		        		});
		                $("#dd").dialog('close');
						$('#tt').datagrid('reload');
		            }
		        },{
		            text:'取消',
		            iconCls:'icon-cancel',
		            handler:function(){
		                $("#dd").dialog('close');
		            }
		        }]
		    });
			var row = $('#tt').datagrid('getSelected');
			if(row == null) {
				showMsg('警告','请选择一条记录','alert');
				return;
			}
			$("#content").html(''); // 先将content的内容清空
			// 获取编辑对象
			$.post(getPath()+"/tmEmployee_editTmEmployee.action",
				{"tmEmployee.id": row.id},
			    function(result){  
					$("#content").append(result);
			    });
			$("#dd").dialog('open').dialog('setTitle', '修改');
			$('#form').form('load', row);
		}
		},{
			text: '删除',
			iconCls: 'icon-remove',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if (row) {$.messager.confirm('警告','确定删除？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/tmEmployee_delTmEmployee.action',
								{"tmEmployee.id" :  row.id,
								"tmEmployee.isDel" :  '2'
								},
								function(json) {
									var result = eval(json);
									if (result && result.success) {
										$.messager.show({title : '提示', msg : '删除成功'});
										$('#tt').datagrid('reload'); 
									} else {
										$.messager.show({title : '错误',msg : result.msg});
									}
								},'json');
						}
					});
				} else {
					showMsg('警告','请选择一条记录','alert');
				}
			}
		},'-',{
			text: '角色',
			iconCls: 'icon-ok',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if (row) {
					viewRole();
					
				} else {
					showMsg('警告','请选择一条记录','alert');
				}
			}
		},'-',{
			text: '帮助',
			iconCls: 'icon-help',
			handler: function(){showMsg('帮助','这里是帮助内容','alert');}
		}],
		onDblClickRow:function(rowIndex, rowData){
			viewDetail(rowData.id);
		}
	});
	$('#dd').dialog({
	    width: 500,
	    height: 300,
	    closed: true,
	    cache: false,
	    modal: true,
        iconCls: 'icon-save'
    });

});
function fuzzyquery() {
	$('#tt').datagrid({
		queryParams : form2Obj("fuzzy")
	});
}
/**
 * 查看详细信息
 */
function viewDetail(data){
	////
	$('#dd').dialog({
        buttons: [{
            text:'确定',
            iconCls:'icon-ok',
            handler:function(){
                $("#dd").dialog('close');
            }
        }],collapsible:true,resizable:true
    });
	////
	var row = $('#tt').datagrid('getSelected');
	$("#content").html(''); // 先将content的内容清空
	// 查看对象
	$.post(getPath()+"/tmEmployee_viewTmEmployee.action",
		{"tmEmployee.id" : row.id },
	    function(result){ 
			$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}
/**
 * 查看权限
 */
function viewRole(){
	var row = $('#tt').datagrid('getSelected');
	$("#content").html(''); // 先将content的内容清空
	$("#content").append('<font color="red">'+row.realName+'</font>拥有如下角色：<br/>')
	// 查看权限
	$.post(getPath() + '/smUser_roleList.action',
		{"smUser.id" :  row.userId},
		function(json) {
			var result = eval(json);
			console.log(result);
			if (result && result.success) {
				// $('#tt').datagrid('reload'); 
				var data = result.msg;
				for(var i in data) {
					$("#content").append("<a onclick='delRole("+data[i].id+")'>"+data[i].roleName+", ");
				}
				
				$("#content").append("<hr />添加角色");
				
				$.post(getPath() + '/smUser_addRoleList.action',
					{"smUser.id" :  row.userId},
					function(json) {
						var result = eval(json);
						console.log(result);
						if (result && result.success) {
							// $('#tt').datagrid('reload'); 
							var data = result.msg;
							for(var i in data) {
								$("#content").append('<input type="checkbox" name="role" value="'+data[i].id+'">'+data[i].roleName);
							}
						} else {
							$.messager.show({title : 'Error',msg : result.msg});
						}
					},'json');
			} else {
				$.messager.show({title : 'Error',msg : result.msg});
			}
		},'json');
	
	
	////
	$('#dd').dialog({
        buttons: [{
            text:'确定',
            iconCls:'icon-ok',
            handler:function(){
            	saveRole();
                $("#dd").dialog('close');
            }
        }]
    });
	////
	$("#dd").dialog('open').dialog('setTitle', '查看权限');
}
function saveRole() {
	var row = $('#tt').datagrid('getSelected');
	var result = new Array();
    $("[name = role]:checkbox").each(function () {
        if ($(this).is(":checked")) {
            result.push($(this).attr("value"));
        }
    });
    //alert(result.join(","));
    // 删除对象
	$.post(getPath()+"/smUserRole_saveAddSmUserRole.action",
		{"smUserRole.userId" : row.userId, "roleIds": result.join(",") },
	    function(result){ 
			//$("#content").append(result);
			var json = eval("("+result+")");
			console.log(json);
			if (json && json.success) {
				//	$('#tt').datagrid('reload'); ;
				viewRole();
				$("#dd").dialog('close');
				$.messager.show({title : 'Info',msg : "添加角色成功！"});
			} else {
				$.messager.show({title : 'Error',msg : json.msg});
			}
	    });
}
function delRole(id) {
	var row = $('#tt').datagrid('getSelected');
	$.messager.confirm('警告','确定取消该角色？',
	function(r) {
		if (r) {
			// 删除对象
			$.post(getPath()+"/smUserRole_delSmUserRole.action",
				{"smUserRole.userId" : row.userId, "smUserRole.roleId": id },
			    function(result){ 
					//$("#content").append(result);
					
					var json = eval("("+result+")");
					console.log(json);
					if (json && json.success) {
						//	$('#tt').datagrid('reload'); ;
						viewRole();
						$.messager.show({title : 'Info',msg : "取消权限成功！"});
					} else {
						$.messager.show({title : 'Error',msg : json.msg});
					}
			    });
		}
	});
	
}
</script>
</html>
	