<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>日程管理</title>
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
          <td><input name="tmSchedule.name" id="name" /></td>
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
  <script type="text/javascript" src="../js/jquery-easyui-1.3.5/datagrid-detailview.js"></script>
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
		//view: detailview,
		height:$("#body").height()-$('#search_area').height()-5,
		width:$("#body").width(),
//		idField:'id',
		singleSelect:true, 
		nowrap:true,
		striped: true,
		fitColumns:true,
		rownumbers:true,
		loadMsg : /*showProcess(true, '温馨提示', '正在加载数据, 请稍后...')*/'正在加载数据',
		url: getPath() + "/tmSchedule_listTmSchedule.action",  
		columns:[[
			{field:'lineCode',title:'线路编号',width:60,halign:"center", align:"center"},
			{field:'name',title:'名称',width:60,halign:"center", align:"center"},
			{field:'totalPeople',title:'总人数',width:60,halign:"center", align:"center"},
			{field:'totalDay',title:'总天数',width:60,halign:"center", align:"center"},
			{field:'guiderNames',title:'负责导游',width:60,halign:"center", align:"center"},
			{field:'departure',title:'出发地',width:60,halign:"center", align:"center"},
			{field:'destination',title:'目的地',width:60,halign:"center", align:"center"},
			{field:'startTime',title:'开始时间',width:60,halign:"center", align:"center"},
			
			{field:'endTime',title:'结束时间',width:60,halign:"center", align:"center"},
			{field:'type',title:'路线类型',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"短线";
				else if(value == '2') return"长线";
			}},
			{field:'grade',title:'团类型',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"标准团";
				else if(value == '2') return"定制团";
			}}
			
		]],
		/*detailFormatter:function(index,row){
           	return '<div class="ddv" style="padding:5px 0"></div>';
       	},
       	onExpandRow: function(index,row){
		    var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
		    $.ajax({
				type: "POST",
				url: getPath() +　'/tmSchedule_queryDetailInfo.action',
				processData: true,
				data: {'tmSchedule.id' : row.id},
				success: function(data){
					var json = eval('(' + data + ')');
					ddv.html('');
					for(var i in json.rows) {
						var obj = json.rows[i];
						ddv.append('<h4>第'+(++i)+'天    游：'+obj.tour + '</h4>');
						ddv.append(obj.description);
					}
       				$('#dg').datagrid('fixDetailRowHeight',index);
				}
       		});
		    
		   
		},*/
		showPageList:[10,20,30,40,50],
		pageNumber: 1, // 初始页数
		pageSize: 10,  // 初始
		pagination: true,
		toolbar: [{
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
							url: getPath() + '/tmSchedule_saveEditTmSchedule.action',
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
			$.post(getPath()+"/tmSchedule_editTmSchedule.action",
				{"tmSchedule.id": row.id},
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
							$.post(getPath() + '/tmSchedule_delTmSchedule.action',
								{"tmSchedule.id" :  row.id},
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
			text: '编辑详情',
			iconCls: 'icon-ok',
			handler: function(){
				$('#dd').dialog({
			        buttons: [{
			            text:'保存',
			            iconCls:'icon-ok',
			            handler:function(){
			        		var formData=$("#detail").serialize();
							// 保存编辑对象		        		
			        		$.ajax({
								type: "POST",
								url: getPath() + '/tmSchedule_saveDetail.action',
								processData:true,
								data:formData,
								success: function(data){
									console.log(data);
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
				row = $('#tt').datagrid('getSelected');
				if (row) {
					$("#content").html(''); // 先将content的内容清空
					// 获取编辑对象
					$.post(getPath()+"/tmSchedule_editDetail.action",
						{"tmSchedule.id": row.id},
					    function(result){
							$("#content").append(result);
					    });
					$("#dd").dialog('open').dialog('setTitle', '编辑详情');
					$('#form').form('load', row);
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
	$("#content").append(row.lineCode+" "+row.name+" 详细旅游线路");
	$.post(getPath()+"/tmSchedule_queryDetailInfo.action",
		{"tmSchedule.id" : row.id },
	    function(result){ 
	    	var json = eval('(' + result + ')');
			for(var i in json.rows) {
				var obj = json.rows[i];
				$("#content").append('<h4>第'+(++i)+'天    游：'+obj.tour + '</h4>');
				$("#content").append(obj.description);
			}
			//$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}

</script>
</html>
	