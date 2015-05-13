package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmGroup;
import com.tour.service.ifc.TmGroupServiceIFC;

@SuppressWarnings("serial")
public class TmGroupAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmGroupServiceIFC tmGroupServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmGroup tmGroup;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmGroup(){
		List<TmGroup> tmGroupList = tmGroupServiceProxy.queryTmGroup4List(request,tmGroup);
		request.setAttribute("tmGroupList", tmGroupList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmGroup(){
		TmGroup _tmGroup = tmGroupServiceProxy.queryTmGroup4Bean(tmGroup);
		request.setAttribute("operate", "view");
		request.setAttribute("tmGroup", _tmGroup);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmGroup(){
		TmGroup _tmGroup = tmGroupServiceProxy.queryTmGroup4Bean(tmGroup);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmGroup", _tmGroup);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmGroup(){
		try {
			tmGroupServiceProxy.saveEditTmGroup(tmGroup);
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
	public String addTmGroup(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmGroup(){
		try {
			tmGroupServiceProxy.saveAddTmGroup(tmGroup);
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
	public String delTmGroup(){
		try {
			tmGroupServiceProxy.delTmGroup(tmGroup);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmGroupServiceIFC getTmGroupServiceProxy() {
		return tmGroupServiceProxy;
	}
	public void setTmGroupServiceProxy(TmGroupServiceIFC tmGroupServiceProxy) {
		this.tmGroupServiceProxy = tmGroupServiceProxy;
	}
	public TmGroup getTmGroup() {
		return tmGroup;
	}
	public void setTmGroup(TmGroup tmGroup) {
		this.tmGroup = tmGroup;
	}
}
