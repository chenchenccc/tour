package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmDetail;
import com.tour.service.ifc.TmDetailServiceIFC;

@SuppressWarnings("serial")
public class TmDetailAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmDetailServiceIFC tmDetailServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmDetail tmDetail;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmDetail(){
		List<TmDetail> tmDetailList = tmDetailServiceProxy.queryTmDetail4List(request,tmDetail);
		request.setAttribute("tmDetailList", tmDetailList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmDetail(){
		TmDetail _tmDetail = tmDetailServiceProxy.queryTmDetail4Bean(tmDetail);
		request.setAttribute("operate", "view");
		request.setAttribute("tmDetail", _tmDetail);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmDetail(){
		TmDetail _tmDetail = tmDetailServiceProxy.queryTmDetail4Bean(tmDetail);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmDetail", _tmDetail);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmDetail(){
		try {
			tmDetailServiceProxy.saveEditTmDetail(tmDetail);
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
	public String addTmDetail(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmDetail(){
		try {
			tmDetailServiceProxy.saveAddTmDetail(tmDetail);
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
	public String delTmDetail(){
		try {
			tmDetailServiceProxy.delTmDetail(tmDetail);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmDetailServiceIFC getTmDetailServiceProxy() {
		return tmDetailServiceProxy;
	}
	public void setTmDetailServiceProxy(TmDetailServiceIFC tmDetailServiceProxy) {
		this.tmDetailServiceProxy = tmDetailServiceProxy;
	}
	public TmDetail getTmDetail() {
		return tmDetail;
	}
	public void setTmDetail(TmDetail tmDetail) {
		this.tmDetail = tmDetail;
	}
}
