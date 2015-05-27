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
import com.tour.model.TmOrder;
import com.tour.service.ifc.TmOrderServiceIFC;

@SuppressWarnings("serial")
public class TmOrderAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmOrderServiceIFC tmOrderServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmOrder tmOrder;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmOrder(){
		List<TmOrder> tmOrderList = tmOrderServiceProxy.queryTmOrder4List(request,tmOrder);
		request.setAttribute("tmOrderList", tmOrderList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( tmOrderList, jsonConfig );
        
        responseJson(tmOrderServiceProxy.countByExample(tmOrder), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmOrder(){
		TmOrder _tmOrder = tmOrderServiceProxy.queryTmOrder4Bean(tmOrder);
		request.setAttribute("operate", "view");
		request.setAttribute("tmOrder", _tmOrder);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmOrder(){
		TmOrder _tmOrder = tmOrderServiceProxy.queryTmOrder4Bean(tmOrder);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmOrder", _tmOrder);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmOrder(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                tmOrder.setUpdateUserId( loginUser.getId().longValue() );
            }
            tmOrder.setUpdateTime( new Date() );
			tmOrderServiceProxy.saveEditTmOrder(tmOrder);
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
	public String addTmOrder(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmOrder(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                tmOrder.setCreateUserId( loginUser.getId() );
            }
            tmOrder.setCreateTime( new Date() );
            responseJson(true, "添加成功!");
			tmOrderServiceProxy.saveAddTmOrder(tmOrder);
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
	public String delTmOrder(){
		try {
			tmOrderServiceProxy.delTmOrder(tmOrder);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmOrderServiceIFC getTmOrderServiceProxy() {
		return tmOrderServiceProxy;
	}
	public void setTmOrderServiceProxy(TmOrderServiceIFC tmOrderServiceProxy) {
		this.tmOrderServiceProxy = tmOrderServiceProxy;
	}
	public TmOrder getTmOrder() {
		return tmOrder;
	}
	public void setTmOrder(TmOrder tmOrder) {
		this.tmOrder = tmOrder;
	}
}
