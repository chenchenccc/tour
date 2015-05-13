package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmDepartment;
import com.tour.service.ifc.TmDepartmentServiceIFC;

@SuppressWarnings("serial")
public class TmDepartmentAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmDepartmentServiceIFC tmDepartmentServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmDepartment tmDepartment;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmDepartment(){
		List<TmDepartment> tmDepartmentList = tmDepartmentServiceProxy.queryTmDepartment4List(request,tmDepartment);
		request.setAttribute("tmDepartmentList", tmDepartmentList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmDepartment(){
		TmDepartment _tmDepartment = tmDepartmentServiceProxy.queryTmDepartment4Bean(tmDepartment);
		request.setAttribute("operate", "view");
		request.setAttribute("tmDepartment", _tmDepartment);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmDepartment(){
		TmDepartment _tmDepartment = tmDepartmentServiceProxy.queryTmDepartment4Bean(tmDepartment);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmDepartment", _tmDepartment);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmDepartment(){
		try {
			tmDepartmentServiceProxy.saveEditTmDepartment(tmDepartment);
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
	public String addTmDepartment(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmDepartment(){
		try {
			tmDepartmentServiceProxy.saveAddTmDepartment(tmDepartment);
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
	public String delTmDepartment(){
		try {
			tmDepartmentServiceProxy.delTmDepartment(tmDepartment);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmDepartmentServiceIFC getTmDepartmentServiceProxy() {
		return tmDepartmentServiceProxy;
	}
	public void setTmDepartmentServiceProxy(TmDepartmentServiceIFC tmDepartmentServiceProxy) {
		this.tmDepartmentServiceProxy = tmDepartmentServiceProxy;
	}
	public TmDepartment getTmDepartment() {
		return tmDepartment;
	}
	public void setTmDepartment(TmDepartment tmDepartment) {
		this.tmDepartment = tmDepartment;
	}
}
