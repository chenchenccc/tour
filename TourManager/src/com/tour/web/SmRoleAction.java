package com.tour.web;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmRole;
import com.tour.service.ifc.SmRoleServiceIFC;

@SuppressWarnings("serial")
public class SmRoleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmRoleServiceIFC smRoleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private SmRole smRole;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSmRole(){
		List<SmRole> smRoleList = smRoleServiceProxy.querySmRole4List(request,smRole);
		request.setAttribute("smRoleList", smRoleList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( smRoleList, jsonConfig );
        
        responseJson(smRoleServiceProxy.countByExample(smRole), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSmRole(){
		SmRole _smRole = smRoleServiceProxy.querySmRole4Bean(smRole);
		request.setAttribute("operate", "view");
		request.setAttribute("smRole", _smRole);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSmRole(){
		SmRole _smRole = smRoleServiceProxy.queryById( smRole.getId() );
		request.setAttribute("operate", "edit");
		request.setAttribute("smRole", _smRole);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSmRole(){
		try {
		    smRole.setIsDel( "1" );
			smRoleServiceProxy.saveEditSmRole(smRole);
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
	public String addSmRole(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSmRole(){
		try {
		    smRole.setIsDel( "1" );
			smRoleServiceProxy.saveAddSmRole(smRole);
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
	public String delSmRole(){
		try {
		    smRole.setIsDel( "2" );
			smRoleServiceProxy.delSmRole(smRole);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public SmRoleServiceIFC getSmRoleServiceProxy() {
		return smRoleServiceProxy;
	}
	public void setSmRoleServiceProxy(SmRoleServiceIFC smRoleServiceProxy) {
		this.smRoleServiceProxy = smRoleServiceProxy;
	}
	public SmRole getSmRole() {
		return smRole;
	}
	public void setSmRole(SmRole smRole) {
		this.smRole = smRole;
	}
}
