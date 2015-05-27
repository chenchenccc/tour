package com.tour.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmAutho;
import com.tour.model.SmUser;
import com.tour.service.ifc.SmAuthoServiceIFC;

@SuppressWarnings("serial")
public class SmAuthoAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmAuthoServiceIFC smAuthoServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private SmAutho smAutho;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSmAutho(){
		List<SmAutho> smAuthoList = smAuthoServiceProxy.querySmAutho4List(request,smAutho);
		request.setAttribute("smAuthoList", smAuthoList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( smAuthoList, jsonConfig );
        
        responseJson(smAuthoServiceProxy.countByExample(smAutho), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSmAutho(){
		SmAutho _smAutho = smAuthoServiceProxy.querySmAutho4Bean(smAutho);
		request.setAttribute("operate", "view");
		request.setAttribute("smAutho", _smAutho);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSmAutho(){
	    
		SmAutho _smAutho = smAuthoServiceProxy.queryById( smAutho.getId() );
		request.setAttribute("operate", "edit");
		request.setAttribute("smAutho", _smAutho);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSmAutho(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                smAutho.setUpdateUserId( loginUser.getId().longValue() );
            }
            smAutho.setUpdateTime( new Date() );
		    smAutho.setIsDel( "1" );
			smAuthoServiceProxy.saveEditSmAutho(smAutho);
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
	public String addSmAutho(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSmAutho(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                smAutho.setCreateUserId( loginUser.getId() );
            }
            smAutho.setCreateTime( new Date() );
		    smAutho.setIsDel( "1" );
			smAuthoServiceProxy.saveAddSmAutho(smAutho);
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
	public String delSmAutho(){
		try {
		    smAutho.setIsDel( "2" );
			smAuthoServiceProxy.delSmAutho(smAutho);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public SmAuthoServiceIFC getSmAuthoServiceProxy() {
		return smAuthoServiceProxy;
	}
	public void setSmAuthoServiceProxy(SmAuthoServiceIFC smAuthoServiceProxy) {
		this.smAuthoServiceProxy = smAuthoServiceProxy;
	}
	public SmAutho getSmAutho() {
		return smAutho;
	}
	public void setSmAutho(SmAutho smAutho) {
		this.smAutho = smAutho;
	}
}
