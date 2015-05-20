package com.tour.web;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
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
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmDepartment(){
		List<TmDepartment> tmDepartmentList = tmDepartmentServiceProxy.queryTmDepartment4List(request,tmDepartment);
		request.setAttribute("tmDepartmentList", tmDepartmentList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( tmDepartmentList, jsonConfig );
        
        responseJson(tmDepartmentServiceProxy.countByExample(tmDepartment), jsonArr);
        return SUCCESS;
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
	  * @throws Exception 
	 * @Description: 编辑实体对象 
	  */
	public String editTmDepartment() throws Exception{
		TmDepartment _tmDepartment = tmDepartmentServiceProxy.queryById(tmDepartment.getId());
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
		    tmDepartment.setIsDel( "1" );
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
		    tmDepartment.setIsDel( "2" );
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
