package com.tour.web;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmUserRole;
import com.tour.service.ifc.SmUserRoleServiceIFC;

@SuppressWarnings("serial")
public class SmUserRoleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmUserRoleServiceIFC smUserRoleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private SmUserRole smUserRole;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSmUserRole(){
		List<SmUserRole> smUserRoleList = smUserRoleServiceProxy.querySmUserRole4List(request,smUserRole);
		request.setAttribute("smUserRoleList", smUserRoleList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( smUserRoleList, jsonConfig );
        
        responseJson(smUserRoleServiceProxy.countByExample(smUserRole), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSmUserRole(){
		SmUserRole _smUserRole = smUserRoleServiceProxy.querySmUserRole4Bean(smUserRole);
		request.setAttribute("operate", "view");
		request.setAttribute("smUserRole", _smUserRole);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSmUserRole(){
		SmUserRole _smUserRole = smUserRoleServiceProxy.querySmUserRole4Bean(smUserRole);
		request.setAttribute("operate", "edit");
		request.setAttribute("smUserRole", _smUserRole);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSmUserRole(){
		try {
			smUserRoleServiceProxy.saveEditSmUserRole(smUserRole);
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
	public String addSmUserRole(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSmUserRole(){
		try {
			smUserRoleServiceProxy.saveAddSmUserRole(smUserRole);
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
	public String delSmUserRole(){
		try {
			smUserRoleServiceProxy.delSmUserRole(smUserRole);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public SmUserRoleServiceIFC getSmUserRoleServiceProxy() {
		return smUserRoleServiceProxy;
	}
	public void setSmUserRoleServiceProxy(SmUserRoleServiceIFC smUserRoleServiceProxy) {
		this.smUserRoleServiceProxy = smUserRoleServiceProxy;
	}
	public SmUserRole getSmUserRole() {
		return smUserRole;
	}
	public void setSmUserRole(SmUserRole smUserRole) {
		this.smUserRole = smUserRole;
	}
}
