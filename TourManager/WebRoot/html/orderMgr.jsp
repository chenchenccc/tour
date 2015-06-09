<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>订单管理</title>
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
          <td>客户姓名</td>
          <td><input name="smAutho.customName" id="authoName" /></td>
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
		url: getPath() + "/tmOrder_listTmOrder.action",  
		columns:[[
			{field:'customName',title:'客户名称',width:60,halign:"center", align:"center"},
			{field:'totalPeople',title:'总人数',width:60,halign:"center", align:"center"},
			{field:'scheduleName',title:'日程名称',width:60,halign:"center", align:"center"},
			{field:'totalPrice',title:'总价格',width:60,halign:"center", align:"center"},
			{field:'isPay',title:'是否付款',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"<font color='black'>已付款</font>";
				else if(value == '2') return"<font color='red'>未付款</font>";
			}},
			{field:'isConfirm',title:'是否确认',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"<font color='black'>已确认</font>";
				else if(value == '2') return"<font color='red'>未确认</font>";
				else if(value == '3') return"<font color='gray'>已取消</font>";
			}},
			{field:'orderType',title:'订单类型',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"<font color='green'>散客订单</font>";
				else if(value == '2') return"<font color='blue'>包团订单</font>";
			}}
		]],
		showPageList:[10,20,30,40,50],
		pageNumber: 1, // 初始页数
		pageSize: 10,  // 初始
		pagination: true,
		toolbar: [{
			text: '删除',
			iconCls: 'icon-remove',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if (row) {$.messager.confirm('警告','确定删除？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/tmOrder_delTmOrder.action',
								{"tmOrder.id" :  row.id},
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
			text: '付款',
			iconCls: 'icon-ok',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if(row.isPay == 1) {
					showMsg('警告','用户已付款，不能再进行付款操作','alert');
					return;
				}
				if (row) {$.messager.confirm('警告','确定客户已经付款？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/tmOrder_payOrder.action',
								{"tmOrder.id" :  row.id},
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
		},{
			text: '确认订单',
			iconCls: 'icon-ok',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if(row.isPay == 2) {
					showMsg('警告','用户未付款，不能确认订单！','alert');
					return;
				}
				if(row.isConfirm == 3) {
					showMsg('警告','订单已取消，不能进行确认订单操作','alert');
					return;
				}
				if(row.isConfirm == 1) {
					showMsg('警告','订单已确认，不能再进行确认订单操作','alert');
					return;
				}
				if (row) {$.messager.confirm('警告','是否客户确认订单？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/tmOrder_confirmOrder.action',
								{"tmOrder.id" :  row.id},
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
		},{
			text: '取消订单',
			iconCls: 'icon-no',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if(row.isConfirm == 3) {
					showMsg('警告','订单已取消，不能再进行取消操作','alert');
					return;
				}
				if(row.isConfirm == 1) {
					showMsg('警告','订单已确认，不能再进行取消操作','alert');
					return;
				}
				if (row) {$.messager.confirm('警告','确定取消订单？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/tmOrder_cancelOrder.action',
								{"tmOrder.id" :  row.id},
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
	$.post(getPath()+"/tmOrder_viewTmOrder.action",
		{"tmOrder.id" : row.id },
	    function(result){ 
			$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}

</script>
</html>
	