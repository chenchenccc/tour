package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmRole;
import com.tour.service.ifc.SmRoleServiceIFC;

@SuppressWarnings("serial")
public class SmRoleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmRoleServiceIFC smRoleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private SmRole smRole;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSmRole(){
		List<SmRole> smRoleList = smRoleServiceProxy.querySmRole4List(request,smRole);
		request.setAttribute("smRoleList", smRoleList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSmRole(){
		SmRole _smRole = smRoleServiceProxy.querySmRole4Bean(smRole);
		request.setAttribute("operate", "view");
		request.setAttribute("smRole", _smRole);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSmRole(){
		SmRole _smRole = smRoleServiceProxy.querySmRole4Bean(smRole);
		request.setAttribute("operate", "edit");
		request.setAttribute("smRole", _smRole);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSmRole(){
		try {
			smRoleServiceProxy.saveEditSmRole(smRole);
			responseJson(true, "修改成功!");
		} catch (Exception e) {
			responseJson(false, "修改失败!");
			RJLog.error(e);
		}
	return SUCCESS;
	}
	
	/**
	  * @Description: 添加实体对象 
	  */
	public String addSmRole(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSmRole(){
		try {
			smRoleServiceProxy.saveAddSmRole(smRole);
			responseJson(true, "添加成功!");
		} catch (Exception e) {
			responseJson(false, "添加失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	/**
	  * @Description: 删除实体对象
	  */
	public String delSmRole(){
		try {
			smRoleServiceProxy.delSmRole(smRole);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public SmRoleServiceIFC getSmRoleServiceProxy() {
		return smRoleServiceProxy;
	}
	public void setSmRoleServiceProxy(SmRoleServiceIFC smRoleServiceProxy) {
		this.smRoleServiceProxy = smRoleServiceProxy;
	}
	public SmRole getSmRole() {
		return smRole;
	}
	public void setSmRole(SmRole smRole) {
		this.smRole = smRole;
	}
}
