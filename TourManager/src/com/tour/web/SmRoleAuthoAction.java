package com.tour.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmRoleAutho;
import com.tour.model.SmUser;
import com.tour.service.ifc.SmRoleAuthoServiceIFC;

@SuppressWarnings("serial")
public class SmRoleAuthoAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmRoleAuthoServiceIFC smRoleAuthoServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private SmRoleAutho smRoleAutho;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
    
    private String authoIds;
    
    public String getAuthoIds() {
        return authoIds;
    }

    
    public void setAuthoIds( String authoIds ) {
        this.authoIds = authoIds;
    }

    /**
	  * @Description: 获取实体列表 
	  */
	public String listSmRoleAutho(){
		List<SmRoleAutho> smRoleAuthoList = smRoleAuthoServiceProxy.querySmRoleAutho4List(request,smRoleAutho);
		request.setAttribute("smRoleAuthoList", smRoleAuthoList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( smRoleAuthoList, jsonConfig );
        
        responseJson(smRoleAuthoServiceProxy.countByExample(smRoleAutho), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSmRoleAutho(){
		SmRoleAutho _smRoleAutho = smRoleAuthoServiceProxy.querySmRoleAutho4Bean(smRoleAutho);
		request.setAttribute("operate", "view");
		request.setAttribute("smRoleAutho", _smRoleAutho);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSmRoleAutho(){
		SmRoleAutho _smRoleAutho = smRoleAuthoServiceProxy.querySmRoleAutho4Bean(smRoleAutho);
		request.setAttribute("operate", "edit");
		request.setAttribute("smRoleAutho", _smRoleAutho);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSmRoleAutho(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                smRoleAutho.setUpdateUserId( loginUser.getId() );
            }
            smRoleAutho.setUpdateTime( new Date() );
			smRoleAuthoServiceProxy.saveEditSmRoleAutho(smRoleAutho);
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
	public String addSmRoleAutho(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSmRoleAutho(){
		try {
		    if(authoIds != null) {
		        String[] idArr = authoIds.split( "," );
		        for (String s : idArr) {
                    smRoleAutho.setAuthoId( Integer.parseInt( s ) );
                    smRoleAutho.setRoleId( smRoleAutho.getRoleId() );
                    smRoleAutho.setId( null );
                    smRoleAutho.setIsDel( "1" );
                    SmRoleAutho ra = smRoleAuthoServiceProxy.querySmRoleAutho4Bean( smRoleAutho );
                    if(ra == null) {
                        smRoleAuthoServiceProxy.saveAddSmRoleAutho(smRoleAutho);
                    }
                }
		        
		    }
			//smRoleAuthoServiceProxy.saveAddSmRoleAutho(smRoleAutho);
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
	public String delSmRoleAutho(){
		try {
		    smRoleAutho.setIsDel( "2" );
			smRoleAuthoServiceProxy.delSmRoleAutho(smRoleAutho);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public SmRoleAuthoServiceIFC getSmRoleAuthoServiceProxy() {
		return smRoleAuthoServiceProxy;
	}
	public void setSmRoleAuthoServiceProxy(SmRoleAuthoServiceIFC smRoleAuthoServiceProxy) {
		this.smRoleAuthoServiceProxy = smRoleAuthoServiceProxy;
	}
	public SmRoleAutho getSmRoleAutho() {
		return smRoleAutho;
	}
	public void setSmRoleAutho(SmRoleAutho smRoleAutho) {
		this.smRoleAutho = smRoleAutho;
	}
}
