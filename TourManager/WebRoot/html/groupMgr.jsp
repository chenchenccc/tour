<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>酒店管理</title>
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
          <td>名称</td>
          <td><input name="tmGroup.name" id="name" /></td>
          <td>所属区域</td>
          <td><input name="tmGroup.region" id="region" /></td>
          <td>酒店星级</td>
          <td><input name="tmGroup.star" id="star" /></td>
          <td>
              <a href="javascript:void(0)" class="easyui-linkbutton my-search-button" onclick="query();" iconCls="icon-search" plain="true">查询</a>
          </td>
        </tr>
      </table>
    </div>
    <span id="openOrClose">0</span> 
  </div>
  <!-- 数据表格区域 -->
  <table id="tt" style="table-layout:fixed;"></table>
  <!-- Dialog -->
  <div id="dd"><div id="content" region="center" border="false" style="padding: 10px;  border: 1px solid #ccc;"></div>
 
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
		url: getPath() + "/tmGroup_listTmGroup.action",  
		columns:[[
			{field:'groupName',title:'旅游团名称',width:60,halign:"center", align:"center"},
			{field:'tourId',title:'团号ID',width:60,halign:"center", align:"center"},
			{field:'status',title:'状态',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"<font color='black'>未开始</font>";
				else if(value == '2') return"<font color='pink'>正在路上</font>";
				else if(value == '3') return"<font color='green'>已经结束</font>";
				
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
								url: getPath() + '/tmGroup_saveAddTmGroup.action',
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
				$.post(getPath()+"/tmGroup_addTmGroup.action",
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
							url: getPath() + '/tmGroup_saveEditTmGroup.action',
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
			$.post(getPath()+"/tmGroup_editTmGroup.action",
				{"tmGroup.id": row.id},
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
							$.post(getPath() + '/tmGroup_delTmGroup.action',
								{"tmGroup.id" :  row.id},
								function(json) {
									var result = eval(json);
									if (result && result.success) {
										$('#tt').datagrid('reload'); 
									} else {
										$.messager.show({title : 'Error',msg : result.msg});
									}
								},'json');
						}
					});
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
        }]
    });
	////
	var row = $('#tt').datagrid('getSelected');
	$("#content").html(''); // 先将content的内容清空
	// 查看对象
	$.post(getPath()+"/tmGroup_viewTmGroup.action",
		{"tmGroup.id" : row.id },
	    function(result){ 
			$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}

</script>
</html>
	