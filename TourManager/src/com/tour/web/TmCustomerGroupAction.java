package com.tour.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmUser;
import com.tour.model.TmCustomerGroup;
import com.tour.service.ifc.TmCustomerGroupServiceIFC;

@SuppressWarnings("serial")
public class TmCustomerGroupAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmCustomerGroupServiceIFC tmCustomerGroupServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmCustomerGroup tmCustomerGroup;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmCustomerGroup(){
		List<TmCustomerGroup> tmCustomerGroupList = tmCustomerGroupServiceProxy.queryTmCustomerGroup4List(request,tmCustomerGroup);
		request.setAttribute("tmCustomerGroupList", tmCustomerGroupList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( tmCustomerGroupList, jsonConfig );
        
        responseJson(tmCustomerGroupServiceProxy.countByExample(tmCustomerGroup), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmCustomerGroup(){
		TmCustomerGroup _tmCustomerGroup = tmCustomerGroupServiceProxy.queryTmCustomerGroup4Bean(tmCustomerGroup);
		request.setAttribute("operate", "view");
		request.setAttribute("tmCustomerGroup", _tmCustomerGroup);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmCustomerGroup(){
		TmCustomerGroup _tmCustomerGroup = tmCustomerGroupServiceProxy.queryTmCustomerGroup4Bean(tmCustomerGroup);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmCustomerGroup", _tmCustomerGroup);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmCustomerGroup(){
		try {
			tmCustomerGroupServiceProxy.saveEditTmCustomerGroup(tmCustomerGroup);
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
	public String addTmCustomerGroup(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmCustomerGroup(){
		try {
			tmCustomerGroupServiceProxy.saveAddTmCustomerGroup(tmCustomerGroup);
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
	public String delTmCustomerGroup(){
		try {
			tmCustomerGroupServiceProxy.delTmCustomerGroup(tmCustomerGroup);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmCustomerGroupServiceIFC getTmCustomerGroupServiceProxy() {
		return tmCustomerGroupServiceProxy;
	}
	public void setTmCustomerGroupServiceProxy(TmCustomerGroupServiceIFC tmCustomerGroupServiceProxy) {
		this.tmCustomerGroupServiceProxy = tmCustomerGroupServiceProxy;
	}
	public TmCustomerGroup getTmCustomerGroup() {
		return tmCustomerGroup;
	}
	public void setTmCustomerGroup(TmCustomerGroup tmCustomerGroup) {
		this.tmCustomerGroup = tmCustomerGroup;
	}
}
