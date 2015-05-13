<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<style>
#police table,#police td,#police th{border:1px solid #ccc;border-collapse:collapse;}
</style>
<div id="police">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table>
		<tr>
			<td><label>警员编号</label></td>
			<td><label>${sysPolice.jybh}</label></td>
			<td><label>姓名:</label></td>
			<td><label>${sysPolice.xm}</label></td>
		</tr>
		<tr>
			<td><label>性别:</label></td>
			<td><label>
			<c:if test="${sysPolice.xb eq '0'}">
			男
			</c:if>
			<c:if test="${sysPolice.xb eq '1'}">
			女
			</c:if>
			</label></td>
			<td><label>电子邮箱:</label></td>
			<td><label>${sysPolice.dzyx}</label></td>
		</tr>
		<tr>
			<td><label>密码:</label></td>
			<td><label>${sysPolice.mm}</label></td>
			<td><label>座机号码:</label></td>
			<td><label>${sysPolice.zj}</label></td>
		</tr>
		<tr>
			<td><label>手机号码1:</label></td>
			<td><label>${sysPolice.sjhm1}</label></td>
			<td><label>手机号码2:</label></td>
			<td><label>${sysPolice.sjhm2}</label></td>
		</tr>
		<tr>
			<td><label>手机号码3:</label></td>
			<td><label>${sysPolice.sjhm3}</label></td>
			<td><label>身份证号</label></td>
			<td><label>${sysPolice.sfzh}</label></td>
		</tr>
		<tr>
			<td><label>手机串号:</label></td>
			<td colspan="3"><label>${sysPolice.imei}</label></td>
		</tr>
		<tr>
			<td><label>失效时间:</label></td>
			<td><label>
			<fmt:formatDate value="${sysPolice.sxsj}" type="date"/>
			</label></td>
			<td><label>状态:</label></td>
			<td><label>
			<c:if test="${sysPolice.zt eq 'enable'}">注册</c:if>
			<c:if test="${sysPolice.zt eq 'disable'}">
				<font color="red">禁用</font>
			</c:if>
			</label></td>
		</tr>
		<tr>
			<td><label>所有角色:</label></td>
			<td colspan="3">
			<c:forEach items="${sysRole}" var="role">
				<label>${role.jsmc}</label>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td><label>所属部门:</label></td>
			<td colspan="3">
			<c:forEach items="${sysDepartment }" var="dept">
				<label>${dept.bmmc}</label>
			</c:forEach>
			</td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveAddSysPolice.action">
	<table border="0">
		<tr>
			<td><label><span class="x">*</span>警员编号</label></td>
			<td><input name="sysPolice.jybh" id="jybh"></td>
			<td><label><span class="x">*</span>姓名:</label></td>
			<td><input name="sysPolice.xm" id="xm"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>性别:</label></td>
			<td>
			<select name="sysPolice.xb">
				<option value="0">男</option>
				<option value="1">女</option>
			</select>
			<!--<input name="sysPolice.xb"></td>
			--><td><label>电子邮箱:</label></td>
			<td><input name="sysPolice.dzyx" validType="email" class="easyui-validatebox"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>密码:</label></td>
			<td><input name="sysPolice.mm" id="pwd1" type="password"></td>
			<td><label><span class="x">*</span>确认密码:</label></td>
			<td><input name="password" id="pwd2" type="password"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>座机号码:</label></td>
			<td><input name="sysPolice.zj"></td>
			<td><label>手机号码1:</label></td>
			<td><input name="sysPolice.sjhm1" class="easyui-validatebox" validType="length[11,11]" invalidMessage="请输入11位手机号！"></td>
		</tr>
		<tr>
			<td><label>手机号码2:</label></td>
			<td><input name="sysPolice.sjhm2" class="easyui-validatebox" validType="length[11,11]" invalidMessage="请输入11位手机号！"></td>
			<td><label>手机号码3:</label></td>
			<td><input name="sysPolice.sjhm3" class="easyui-validatebox" validType="length[11,11]" invalidMessage="请输入11位手机号！"></td>
		</tr>
		<tr>
			<td><label>身份证号</label></td>
			<td><input name="sysPolice.sfzh" class="easyui-validatebox" validType="length[18,18]" invalidMessage="请输入18位身份证号！"></td>
			<td><label>手机串号:</label></td>
			<td><input name="sysPolice.imei"></td>
		</tr>
		<tr>
			<td><label>失效时间:</label></td>
			<td>
			<input name="sysPolice.sxsj" class="easyui-datebox" />
			</td>
			 <td><label>状态:</label></td>
			<td>
			<select name="sysPolice.zt" class="easyui-combobox" missingMessage="请选择状态!" required="true">
			   <option value="enable" selected="selected">开通</option>
			   <option value="disable">禁用</option>
			</select> 
			</td>
		</tr>
		<tr>
			<td><lable>角色</lable></td>
			<td colspan="3">
			${sysRole }
			</td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveEditSysPolice.action">

	<table border="0">
		<tr><input type="hidden" name="sysPolice.id" value="${sysPolice.id }"/>
			<td><label><span class="x">*</span>警员编号</label></td>
			<td><input name="sysPolice.jybh" id="jybh" value="${sysPolice.jybh}"></td>
			<td><label><span class="x">*</span>姓名:</label></td>
			<td><input name="sysPolice.xm" id="xm" value="${sysPolice.xm}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>性别:</label></td>
			<td>
			<c:if test="${sysPolice.xb eq '0'}">
			<select name="sysPolice.xb">
				<option value="0" selected="selected">男</option>
				<option value="1" >女</option>
			</select>
			</c:if>
			<c:if test="${sysPolice.xm eq '1'}">
			<select name="sysPolice.xb">
				<option value="0">男</option>
				<option value="1" selected="selected">女</option>
			</select>
			</c:if>
			</td>
			<td><label>电子邮箱:</label></td>
			<td><input name="sysPolice.dzyx" value="${sysPolice.dzyx}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>密码:</label></td>
			<td><input name="sysPolice.mm" id="pw1" type="password" value="${sysPolice.mm}"></td>
			<td><label><span class="x">*</span>确认密码:</label></td>
			<td><input name="password" id="pwd2" type="password" value="${sysPolice.mm}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>座机号码:</label></td>
			<td><input name="sysPolice.zj" value="${sysPolice.zj}"></td>
			<td><label>手机号码1:</label></td>
			<td><input name="sysPolice.sjhm1" value="${sysPolice.sjhm1}"></td>
		</tr>
		<tr>
			<td><label>手机号码2:</label></td>
			<td><input name="sysPolice.sjhm2" value="${sysPolice.sjhm2}"></td>
			<td><label>手机号码3:</label></td>
			<td><input name="sysPolice.sjhm3" value="${sysPolice.sjhm3}"></td>
		</tr>
		<tr>
			<td><label>身份证号</label></td>
			<td><input name="sysPolice.sfzh" value="${sysPolice.sfzh}"></td>
			<td><label>手机串号:</label></td>
			<td><input name="sysPolice.imei" value="${sysPolice.imei}"></td>
		</tr>
		<tr>
			<td><label>角色</label></td>
			<td colspan="3"><!-- <input type="checkbox" name="itemNo" value="1"/><input type="checkbox" name="itemNo" value="2"/><input type="checkbox" name="itemNo" value="3"/>部门管理员 --></td>
		</tr>
		<tr>
			<td><label>失效时间:</label></td>
			<td>
			
			<input class="easyui-datebox" name="sysPolice.sxsj" value="<fmt:formatDate value="${sysPolice.sxsj}" type="date"/>"></td>
			<td><label>状态:</label></td>
			<td>
				<c:if test="${sysPolice.zt eq 'enable'}">
				<select name="sysPolice.zt" class="easyui-combobox" missingMessage="请选择状态!" required="true">
				   <option value="enable" selected="selected">开通</option>
				   <option value="disable">禁用</option>
				</select> 
				</c:if>
				<c:if test="${sysPolice.zt eq 'disable'}">
				<select name="sysPolice.zt" class="easyui-combobox" missingMessage="请选择状态!" required="true">
				   <option value="enable">开通</option>
				   <option value="disable" selected="selected">禁用</option>
				</select> 
				</c:if>
			</td>
		</tr>
	</table>
</form>
</c:if>
</div>