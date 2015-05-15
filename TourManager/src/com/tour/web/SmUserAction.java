package com.tour.web;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmUser;
import com.tour.service.ifc.SmUserServiceIFC;

@SuppressWarnings("serial")
public class SmUserAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmUserServiceIFC smUserServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private SmUser smUser;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @throws Exception 
	 * @Description: 获取实体列表 
	  */
	public String listSmUser() throws Exception{
		List<SmUser> smUserList = smUserServiceProxy.querySmUser4List(request,smUser);
		request.setAttribute("smUserList", smUserList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( smUserList, jsonConfig );
        
        responseJson(smUserServiceProxy.countByExample(smUser), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @throws Exception 
	 * @Description: 查看实体对象 
	  */
	public String viewSmUser() throws Exception{
		SmUser _smUser = smUserServiceProxy.querySmUser4Bean(smUser);
		request.setAttribute("operate", "view");
		request.setAttribute("smUser", _smUser);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @throws Exception 
	 * @Description: 编辑实体对象 
	  */
	public String editSmUser() throws Exception{
		SmUser _smUser = smUserServiceProxy.querySmUser4Bean(smUser);
		request.setAttribute("operate", "edit");
		request.setAttribute("smUser", _smUser);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSmUser(){
		try {
			smUserServiceProxy.saveEditSmUser(smUser);
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
	public String addSmUser(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSmUser(){
		try {
			smUserServiceProxy.saveAddSmUser(smUser);
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
	public String delSmUser(){
		try {
			smUserServiceProxy.delSmUser(smUser);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public SmUserServiceIFC getSmUserServiceProxy() {
		return smUserServiceProxy;
	}
	public void setSmUserServiceProxy(SmUserServiceIFC smUserServiceProxy) {
		this.smUserServiceProxy = smUserServiceProxy;
	}
	public SmUser getSmUser() {
		return smUser;
	}
	public void setSmUser(SmUser smUser) {
		this.smUser = smUser;
	}
}
