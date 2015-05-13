package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmEmployee;
import com.tour.service.ifc.TmEmployeeServiceIFC;

@SuppressWarnings("serial")
public class TmEmployeeAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmEmployeeServiceIFC tmEmployeeServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmEmployee tmEmployee;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmEmployee(){
		List<TmEmployee> tmEmployeeList = tmEmployeeServiceProxy.queryTmEmployee4List(request,tmEmployee);
		request.setAttribute("tmEmployeeList", tmEmployeeList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmEmployee(){
		TmEmployee _tmEmployee = tmEmployeeServiceProxy.queryTmEmployee4Bean(tmEmployee);
		request.setAttribute("operate", "view");
		request.setAttribute("tmEmployee", _tmEmployee);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmEmployee(){
		TmEmployee _tmEmployee = tmEmployeeServiceProxy.queryTmEmployee4Bean(tmEmployee);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmEmployee", _tmEmployee);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmEmployee(){
		try {
			tmEmployeeServiceProxy.saveEditTmEmployee(tmEmployee);
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
	public String addTmEmployee(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmEmployee(){
		try {
			tmEmployeeServiceProxy.saveAddTmEmployee(tmEmployee);
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
	public String delTmEmployee(){
		try {
			tmEmployeeServiceProxy.delTmEmployee(tmEmployee);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmEmployeeServiceIFC getTmEmployeeServiceProxy() {
		return tmEmployeeServiceProxy;
	}
	public void setTmEmployeeServiceProxy(TmEmployeeServiceIFC tmEmployeeServiceProxy) {
		this.tmEmployeeServiceProxy = tmEmployeeServiceProxy;
	}
	public TmEmployee getTmEmployee() {
		return tmEmployee;
	}
	public void setTmEmployee(TmEmployee tmEmployee) {
		this.tmEmployee = tmEmployee;
	}
}
