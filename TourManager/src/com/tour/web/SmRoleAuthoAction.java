package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmRoleAutho;
import com.tour.service.ifc.SmRoleAuthoServiceIFC;

@SuppressWarnings("serial")
public class SmRoleAuthoAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmRoleAuthoServiceIFC smRoleAuthoServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private SmRoleAutho smRoleAutho;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSmRoleAutho(){
		List<SmRoleAutho> smRoleAuthoList = smRoleAuthoServiceProxy.querySmRoleAutho4List(request,smRoleAutho);
		request.setAttribute("smRoleAuthoList", smRoleAuthoList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSmRoleAutho(){
		SmRoleAutho _smRoleAutho = smRoleAuthoServiceProxy.querySmRoleAutho4Bean(smRoleAutho);
		request.setAttribute("operate", "view");
		request.setAttribute("smRoleAutho", _smRoleAutho);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSmRoleAutho(){
		SmRoleAutho _smRoleAutho = smRoleAuthoServiceProxy.querySmRoleAutho4Bean(smRoleAutho);
		request.setAttribute("operate", "edit");
		request.setAttribute("smRoleAutho", _smRoleAutho);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSmRoleAutho(){
		try {
			smRoleAuthoServiceProxy.saveEditSmRoleAutho(smRoleAutho);
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
	public String addSmRoleAutho(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSmRoleAutho(){
		try {
			smRoleAuthoServiceProxy.saveAddSmRoleAutho(smRoleAutho);
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
	public String delSmRoleAutho(){
		try {
			smRoleAuthoServiceProxy.delSmRoleAutho(smRoleAutho);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public SmRoleAuthoServiceIFC getSmRoleAuthoServiceProxy() {
		return smRoleAuthoServiceProxy;
	}
	public void setSmRoleAuthoServiceProxy(SmRoleAuthoServiceIFC smRoleAuthoServiceProxy) {
		this.smRoleAuthoServiceProxy = smRoleAuthoServiceProxy;
	}
	public SmRoleAutho getSmRoleAutho() {
		return smRoleAutho;
	}
	public void setSmRoleAutho(SmRoleAutho smRoleAutho) {
		this.smRoleAutho = smRoleAutho;
	}
}
