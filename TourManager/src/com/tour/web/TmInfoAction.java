package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmInfo;
import com.tour.service.ifc.TmInfoServiceIFC;

@SuppressWarnings("serial")
public class TmInfoAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmInfoServiceIFC tmInfoServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmInfo tmInfo;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmInfo(){
		List<TmInfo> tmInfoList = tmInfoServiceProxy.queryTmInfo4List(request,tmInfo);
		request.setAttribute("tmInfoList", tmInfoList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmInfo(){
		TmInfo _tmInfo = tmInfoServiceProxy.queryTmInfo4Bean(tmInfo);
		request.setAttribute("operate", "view");
		request.setAttribute("tmInfo", _tmInfo);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmInfo(){
		TmInfo _tmInfo = tmInfoServiceProxy.queryTmInfo4Bean(tmInfo);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmInfo", _tmInfo);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmInfo(){
		try {
			tmInfoServiceProxy.saveEditTmInfo(tmInfo);
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
	public String addTmInfo(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmInfo(){
		try {
			tmInfoServiceProxy.saveAddTmInfo(tmInfo);
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
	public String delTmInfo(){
		try {
			tmInfoServiceProxy.delTmInfo(tmInfo);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmInfoServiceIFC getTmInfoServiceProxy() {
		return tmInfoServiceProxy;
	}
	public void setTmInfoServiceProxy(TmInfoServiceIFC tmInfoServiceProxy) {
		this.tmInfoServiceProxy = tmInfoServiceProxy;
	}
	public TmInfo getTmInfo() {
		return tmInfo;
	}
	public void setTmInfo(TmInfo tmInfo) {
		this.tmInfo = tmInfo;
	}
}
