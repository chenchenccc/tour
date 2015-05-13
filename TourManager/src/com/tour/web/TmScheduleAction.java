package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmSchedule;
import com.tour.service.ifc.TmScheduleServiceIFC;

@SuppressWarnings("serial")
public class TmScheduleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmScheduleServiceIFC tmScheduleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmSchedule tmSchedule;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmSchedule(){
		List<TmSchedule> tmScheduleList = tmScheduleServiceProxy.queryTmSchedule4List(request,tmSchedule);
		request.setAttribute("tmScheduleList", tmScheduleList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmSchedule(){
		TmSchedule _tmSchedule = tmScheduleServiceProxy.queryTmSchedule4Bean(tmSchedule);
		request.setAttribute("operate", "view");
		request.setAttribute("tmSchedule", _tmSchedule);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmSchedule(){
		TmSchedule _tmSchedule = tmScheduleServiceProxy.queryTmSchedule4Bean(tmSchedule);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmSchedule", _tmSchedule);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmSchedule(){
		try {
			tmScheduleServiceProxy.saveEditTmSchedule(tmSchedule);
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
	public String addTmSchedule(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmSchedule(){
		try {
			tmScheduleServiceProxy.saveAddTmSchedule(tmSchedule);
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
	public String delTmSchedule(){
		try {
			tmScheduleServiceProxy.delTmSchedule(tmSchedule);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmScheduleServiceIFC getTmScheduleServiceProxy() {
		return tmScheduleServiceProxy;
	}
	public void setTmScheduleServiceProxy(TmScheduleServiceIFC tmScheduleServiceProxy) {
		this.tmScheduleServiceProxy = tmScheduleServiceProxy;
	}
	public TmSchedule getTmSchedule() {
		return tmSchedule;
	}
	public void setTmSchedule(TmSchedule tmSchedule) {
		this.tmSchedule = tmSchedule;
	}
}
