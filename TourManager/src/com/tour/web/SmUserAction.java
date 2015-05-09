package com.tour.web;

import java.util.List;

import com.tour.commons.base.BaseAction;
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
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSmUser(){
		List<SmUser> smUserList = smUserServiceProxy.querySmUser4List(request,smUser);
		request.setAttribute("smUserList", smUserList);
		if(smUserList == null || smUserList.size() == 0) {
		    responseJson(false, "暂无结果");
		}
		
		return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSmUser(){
		SmUser _smUser = smUserServiceProxy.querySmUser4Bean(smUser);
		request.setAttribute("operate", "view");
		request.setAttribute("smUser", _smUser);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSmUser(){
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