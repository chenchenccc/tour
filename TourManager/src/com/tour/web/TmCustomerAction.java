package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmCustomer;
import com.tour.service.ifc.TmCustomerServiceIFC;

@SuppressWarnings("serial")
public class TmCustomerAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmCustomerServiceIFC tmCustomerServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmCustomer tmCustomer;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmCustomer(){
		List<TmCustomer> tmCustomerList = tmCustomerServiceProxy.queryTmCustomer4List(request,tmCustomer);
		request.setAttribute("tmCustomerList", tmCustomerList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmCustomer(){
		TmCustomer _tmCustomer = tmCustomerServiceProxy.queryTmCustomer4Bean(tmCustomer);
		request.setAttribute("operate", "view");
		request.setAttribute("tmCustomer", _tmCustomer);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmCustomer(){
		TmCustomer _tmCustomer = tmCustomerServiceProxy.queryTmCustomer4Bean(tmCustomer);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmCustomer", _tmCustomer);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmCustomer(){
		try {
			tmCustomerServiceProxy.saveEditTmCustomer(tmCustomer);
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
	public String addTmCustomer(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmCustomer(){
		try {
			tmCustomerServiceProxy.saveAddTmCustomer(tmCustomer);
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
	public String delTmCustomer(){
		try {
			tmCustomerServiceProxy.delTmCustomer(tmCustomer);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmCustomerServiceIFC getTmCustomerServiceProxy() {
		return tmCustomerServiceProxy;
	}
	public void setTmCustomerServiceProxy(TmCustomerServiceIFC tmCustomerServiceProxy) {
		this.tmCustomerServiceProxy = tmCustomerServiceProxy;
	}
	public TmCustomer getTmCustomer() {
		return tmCustomer;
	}
	public void setTmCustomer(TmCustomer tmCustomer) {
		this.tmCustomer = tmCustomer;
	}
}
