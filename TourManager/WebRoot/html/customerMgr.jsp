<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>客户管理</title>
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
          <td>姓名</td>
          <td><input name="tmCustomer.realName" id="realName" /></td>
          <td>身份证号后六位</td>
          <td><input name="tmCustomer.identityNum" id="identityNum" /></td>
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
		url: getPath() + "/tmCustomer_listTmCustomer.action",  
		columns:[[
			{field:'realName',title:'姓名',width:60,halign:"center", align:"center"},
			{field:'age',title:'年龄',width:60,halign:"center", align:"center"},
			{field:'sex',title:'性别',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '0') return"未知";
				else if(value == '1') return"男";
				else if(value == '2') return"女";
			}},
			{field:'type',title:'游客类型',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"散客";
				else if(value == '2') return"组团";
			}},
			{field:'tel',title:'联系方式',width:60,halign:"center", align:"center"},
			{field:'identityNum',title:'身份证号',width:60,halign:"center", align:"center"},
			{field:'classify',title:'游客类别',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"成人";
				else if(value == '2') return"小孩";
				else if(value == '3') return"学生";
			}},
			{field:'isKey',title:'是否负责人',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"是";
				else if(value == '2') return"否";
			}},
			{field:'superName',title:'所属负责人',width:60,halign:"center", align:"center"}
			
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
			        		var identityReg=/^\d{17}([0-9]|X)$/;
			        		console.log($("#identityNum").val());
			        		if(!identityReg.test($("#identityNum").val())) {
			        			//alert("身份证号码格式不正确，必须为18位数字，请重新输入！");
			        			//return;
			        		}
			        		$.ajax({
								type: "POST",
								url: getPath() + '/tmCustomer_saveAddTmCustomer.action',
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
				$.post(getPath()+"/tmCustomer_addTmCustomer.action",
				    function(result){
						$("#content").append(result);
				    });
				$("#dd").dialog('open').dialog('setTitle', '添加');
			    $('#form').form('clear');
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
							$.post(getPath() + '/tmCustomer_delTmCustomer.action',
								{"tmCustomer.id" :  row.id},
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
	$.post(getPath()+"/tmCustomer_viewTmCustomer.action",
		{"tmCustomer.id" : row.id },
	    function(result){ 
			$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}

</script>
</html>
	