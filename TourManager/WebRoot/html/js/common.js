/*
	公共方法文件
	@eric
*/
var $parent = self.parent.$;

$(function(){
	//隐藏显示查询条件区域
	$('#openOrClose').on("click",function(){
		$('#conditon').toggle(80);
		setTimeout(domresize,100);//条件隐藏，改变表格高度
	});	
})

//监听窗口大小变化
window.onresize = function(){
	setTimeout(domresize,300);
};
//改变表格宽高
function domresize(){
	$('#tt').datagrid('resize',{  
		height:$("#body").height()-$('#search_area').height()-5,
		width:$("#body").width()
	});
}

///////////////////////////////
function showMsg(title, msg, isAlert) {
      if (isAlert !== undefined && isAlert) {
          $.messager.alert(title, msg);
      } else {
          $.messager.show({
              title: title,
              msg: msg,
              showType: 'show'
          });
      }
  }
 

//确认框
 function showConfirm(title, msg, callback) {
     $.messager.confirm(title, msg, function (r) {
         if (r) {
          if (jQuery.isFunction(callback))
                callback.call();
        }
      });
  }
//进度框
  function showProcess(isShow, title, msg) {
   if (!isShow) {
        $.messager.progress('close');
          return;
    }
     var win = $.messager.progress({
         title: title,
         msg: msg
    });
 }
//例如在表单提交时，为了防止重复提交，会显示一个进度框。提交完成时，关闭进度框并提示操作信息：

 function submitForm(url) {
     $('#ff').form('submit', {
        url: (url === undefined ? "/Ajax/Common.ashx" : url) + "?Type=" + typeCode,
          onSubmit: function () {
          var flag = $(this).form('validate');
          if (flag) {
              showProcess(true, '温馨提示', '正在提交数据...');
          }
            return flag
         },
        success: function (data) {
              showProcess(false);
              if (data == 1) {
                 top.showMsg('温馨提示', '提交成功！');
                  if (parent !== undefined) {
                    if ($.isFunction(window.reloadParent)) {
                        reloadParent.call();
                     } else {
                          parent.$("#tt").datagrid('reload');
                        parent.closeMyWindow();
                    }
                 }
           } else {
             $.messager.alert('温馨提示', data);
           }
     },
      onLoadError: function () {
             showProcess(false);
           $.messager.alert('温馨提示', '由于网络或服务器太忙，提交失败，请重试！');
       }
     });
  }
function form2Obj(formId) {
	var arr = $("#" + formId).serializeArray();
	return serializeArray2Obj(arr);
}
function serializeArray2Obj(arr) {
	var obj = {};
	for (var i = 0; i < arr.length; i++) {
		var t = arr[i];
		obj[t.name] = t.value;
	}
	return obj;
}
function query() {
	$('#tt').datagrid({
		queryParams : form2Obj("ff")
	});
}

//关键页面代码如下：
//    <div class="easyui-layout" style="text-align: left; height: 270px;" fit="true">
//   
//         <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
// 
//            <form id="ff" method="post">
// 
//            <input type="hidden" name="id" value="" />
// 
//           <table border="0" cellpadding="0" cellspacing="0">
//  
//                  <tr>
// 
//                     <td>
//  
//                         <label for="AdminLogin">
//
//                             登录名：</label>
//
//                      </td>
//  
//                      <td>
//   
//                        <input class="easyui-validatebox" style="width: 300px;" type="text" required="true"
//   
//                             validtype="length[0,20]" name="AdminLogin"></input>
//  
//                    </td>
//
//               </tr>
//
//              <tr>
//
//                   <td>
// 
//                        <label for="RoleID">
//  
//                          所属角色：</label>
// 
//                 </td>
//
//                   <td>
//  
//                          <input class="easyui-combobox" valuefield="ID" textfield="RoleName" panelheight="auto"
//  
//                            editable="false" style="width: 300px;" url="/Ajax/Common.ashx?Type=GetRoles"
// 
//                             required="true" name="RoleID"></input>
// 
//                   </td>
//  
//                 </tr>
//  
//                 <tr>
//
//                   <td colspan="2" style='color: Red'>
//  
//                       在编辑时，输入管理员密码表示重新设置密码。
//  58:   
//  59:                      </td>
//  60:   
//  61:                  </tr>
//  62:   
//  63:                  <tr>
//  64:   
//  65:                      <td>
//  66:   
//  67:                          <label for="AdminPassword">
//  68:   
//  69:                              密码：</label>
//  70:   
//  71:                      </td>
//  72:   
//  73:                      <td>
//  74:   
//  75:                          <input class="easyui-validatebox" style="width: 300px;" type="text" validtype="length[6,20]"
//  76:   
//  77:                              id='txtPassword' name="AdminPassword"></input>
//  78:   
//  79:                      </td>
//  80:   
//  81:                  </tr>
//  82:   
//  83:                  <tr>
//  84:   
//  85:                      <td>
//  86:   
//  87:                          <label for="AdminPassword2">
//  88:   
//  89:                              确认密码：</label>
//  90:   
//  91:                      </td>
//  92:   
//  93:                      <td>
//  94:   
//  95:                          <input class="easyui-validatebox" style="width: 300px;" type="text" validtype="length[6,20]"
//  96:   
//  97:                              id='txtPassword2' name="AdminPassword2"></input>
//  98:   
//  99:                      </td>
// 100:   
// 101:                  </tr>
// 102:   
// 103:                  <tr>
// 104:   
// 105:                      <td>
// 106:   
// 107:                          <label for="Defatulflag">
// 108:   
// 109:                              是否上架：</label>
// 110:   
// 111:                      </td>
// 112:   
// 113:                      <td>
// 114:   
// 115:                          <input type="checkbox" name="Defatulflag" class="easyui-validatebox" type="text"
// 116:   
// 117:                              required="true" value="1" />
// 118:   
// 119:                      </td>
// 120:   
// 121:                  </tr>
// 122:   
// 123:              </table>
// 124:   
// 125:              </form>
// 126:   
// 127:          </div>
// 128:   
// 129:          <div region="south" border="false" style="text-align: right; padding: 5px 5px 5px 0;">
// 130:   
// 131:              <a class="easyui-linkbutton" iconcls="icon-save" href="javascript:void(0)" onclick="javascript:submitForm();">
// 132:   
// 133:                  提交</a> 
// 134:   
// 135:          </div>
// 136:   
// 137:      </div>
// 138:   
// 139:      <script type="text/javascript">
// 140:   
// 141:          $(function () {
// 142:   
// 143:              if (autoLoad == 1) {
// 144:   
// 145:                  $('#txtPassword').keypress(function () {
// 146:   
// 147:                      if ($(this).val().length > 0) {
// 148:   
// 149:                          $('#txtPassword2').validatebox({
// 150:   
// 151:                              required: true
// 152:   
// 153:                          });
// 154:   
// 155:                      }
// 156:   
// 157:                  }).change(function () {
// 158:   
// 159:                      if ($(this).val().length > 0) {
// 160:   
// 161:                          $('#txtPassword2').validatebox({
// 162:   
// 163:                              required: true
// 164:   
// 165:                          });
// 166:   
// 167:                      } else {
// 168:   
// 169:                          $('#txtPassword2').validatebox({
// 170:   
// 171:                              required: false
// 172:   
// 173:                          });
// 174:   
// 175:                      }
// 176:   
// 177:                  });
// 178:   
// 179:   
// 180:   
// 181:              } else {
// 182:   
// 183:                  $('#txtPassword,#txtPassword2').validatebox({
// 184:   
// 185:                      required: true
// 186:   
// 187:                  }); ;
// 188:   
// 189:              }
// 190:   
// 191:          });
// 192:   
// 193:      </script>