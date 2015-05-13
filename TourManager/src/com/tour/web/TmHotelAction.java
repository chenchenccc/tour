package com.tour.web;

import java.util.List;

import net.sf.json.JSONArray;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.RJLog;
import com.tour.model.TmHotel;
import com.tour.service.ifc.TmHotelServiceIFC;

@SuppressWarnings("serial")
public class TmHotelAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmHotelServiceIFC tmHotelServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmHotel tmHotel;
	
	private JSONArray json = null;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmHotel(){
		List<TmHotel> tmHotelList = tmHotelServiceProxy.queryTmHotel4List(request,tmHotel);
		request.setAttribute("tmHotelList", tmHotelList);
		json = new JSONArray();
		
        JSONArray ret = json.fromObject(tmHotelList);
        
        responseJson(tmHotelServiceProxy.countByExample(tmHotel), ret);
		return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmHotel(){
		TmHotel _tmHotel = tmHotelServiceProxy.queryTmHotel4Bean(tmHotel);
		request.setAttribute("operate", "view");
		request.setAttribute("tmHotel", _tmHotel);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmHotel(){
		TmHotel _tmHotel = tmHotelServiceProxy.queryTmHotel4Bean(tmHotel);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmHotel", _tmHotel);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmHotel(){
		try {
			tmHotelServiceProxy.saveEditTmHotel(tmHotel);
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
	public String addTmHotel(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmHotel(){
		try {
			tmHotelServiceProxy.saveAddTmHotel(tmHotel);
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
	public String delTmHotel(){
		try {
			tmHotelServiceProxy.delTmHotel(tmHotel);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmHotelServiceIFC getTmHotelServiceProxy() {
		return tmHotelServiceProxy;
	}
	public void setTmHotelServiceProxy(TmHotelServiceIFC tmHotelServiceProxy) {
		this.tmHotelServiceProxy = tmHotelServiceProxy;
	}
	public TmHotel getTmHotel() {
		return tmHotel;
	}
	public void setTmHotel(TmHotel tmHotel) {
		this.tmHotel = tmHotel;
	}
}
