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
		    <td><label>团号</label></td>
			<td><label>${tmSchedule.groupId}</label></td>
			<td><label></label>线路编号</td>
			<td><label>${tmSchedule.lineCode}</label></td>
			
		</tr>
		<tr>
			<td><label>名称</label></td>
			<td><label>${tmSchedule.name}</label></td>
			<td><label>总人数</label></td>
			<td><label>${tmSchedule.totalPeople}</label></td>
		</tr>
		<tr>
			<td><label>总天数</label></td>
			<td><label>${tmSchedule.totalDay}</label></td>
			<td><label>负责导游</label></td>
			<td><label>${tmSchedule.guiderIds}</label></td>
		</tr>
		
		 <tr>  <td><label>出发地</label></td>
			<td><label>${tmSchedule.departure}</label></td>
			<td><label>目的地</label></td>
			<td><label>${tmSchedule.destination}</label></td>
		</tr>
		
		<tr>
			<td><label>开始时间</label></td>
			<td><label>${tmSchedule.startTime}</label></td>
			<td><label>结束时间</label></td>
			<td><label>${tmSchedule.endTime}</label></td>
		</tr>
		<tr>
			<td><label>路线类型</label></td>
			<td><label>
			<c:if test="${tmSchedule.type eq '1'}">
			短线
			</c:if>
			<c:if test="${tmSchedule.type eq '2'}">
			长线
			</c:if>
			</label></td>
			<td><label>团类型</label></td>
			<td><label>
			<c:if test="${tmSchedule.grade eq '1'}">
			标准团
			</c:if>
			<c:if test="${tmSchedule.grade eq '2'}">
			定制团
			</c:if>
			</label></td>
		</tr>
		
		
		
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveAddSysPolice.action">
	<table border="0">
		<tr>
			<td><label><span class="x">*</span>团号</label></td>
			<td><input name="tmSchedule.groupId" id="groupId"></td>
			<td><label><span class="x">*</span>线路编号</label></td>
			<td><input name="tmSchedule.lineCode" id="lineCode"></td>
		</tr>
		
		<tr>
			<td><label><span class="x">*</span>名称</label></td>
			<td><input name="tmSchedule.name" id="name"></td>
			<td><label><span class="x">*</span>总人数</label></td>
			<td><input name="tmSchedule.totalPeople" id="totalPeople"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>总天数</label></td>
			<td><input name="tmSchedule.totalDay" id="totalDay"></td>
			<td><label><span class="x">*</span>负责导游</label></td>
			<td><input name="tmSchedule.guiderIds" id="guiderIds"></td>
		</tr>
		
		<tr>
			<td><label><span class="x">*</span>出发地</label></td>
			<td><input name="tmSchedule.departure" id="departure"></td>
			<td><label><span class="x">*</span>目的地</label></td>
			<td><input name="tmSchedule.destination" id="destination"></td>
		</tr>
		
		<tr>
			<td><label><span class="x">*</span>开始时间</label></td>
			<td><input name="tmSchedule.startTime" id="startTime"></td>
			<td><label><span class="x">*</span>结束时间</label></td>
			<td><input name="tmSchedule.endTime" id="endTime"></td>
		</tr>
		
		
		<tr>
			<td><label><span class="x">*</span>路线类型</label></td>
			<td>
			<select name="tmSchedule.type">
				<option value="1">短线</option>
				<option value="2">长线</option>
			</select>
			</td>
			
			<td><label><span class="x">*</span>团类型</label></td>
			<td>
			<select name="tmHotel.grade">
				<option value="1">标准团</option>
				<option value="2">定制团</option>
				
			</select>
			</td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/system/sysPolice_saveEditSysPolice.action">

	<table border="0">
		<tr><input type="hidden" name="tmHotel.id" value="${tmHotel.id }"/>
			<td><label><span class="x">*</span>酒店名称</label></td>
			<td><input name="tmHotel.name" id="name" value="${tmHotel.name}"></td>
			<td><label><span class="x">*</span>酒店区域</label></td>
			<td><input name="tmHotel.regionId" id="regionId" value="${tmHotel.regionId}"></td>
		</tr>
		<tr>
			<td><label><span class="x">*</span>酒店星级</label></td>
			<td>
			<!-- TODO 星级选中状态 -->
			<select name="tmHotel.star">
				<option value="1" >一星级</option>
				<option value="2" >二星级</option>
				<option value="3" >三星级</option>
				<option value="4" >四星级</option>
				<option value="5" >五星级</option>
			</select>
			</td>
		</tr>
	</table>
</form>
</c:if>
</div>