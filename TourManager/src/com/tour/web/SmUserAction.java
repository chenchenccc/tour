package com.tour.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmRole;
import com.tour.model.SmUser;
import com.tour.model.SmUserRole;
import com.tour.service.ifc.SmRoleServiceIFC;
import com.tour.service.ifc.SmUserRoleServiceIFC;
import com.tour.service.ifc.SmUserServiceIFC;

@SuppressWarnings("serial")
public class SmUserAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private SmUserServiceIFC smUserServiceProxy;
	private SmRoleServiceIFC smRoleServiceProxy;
	private SmUserRoleServiceIFC smUserRoleServiceProxy;
	/**
	  * @Description:  实体对象
	  */
	private SmUser smUser;
	private String oldpass;
	private String newpass;
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
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                smUser.setUpdateUserId( loginUser.getId() );
            }
            smUser.setUpdateTime( new Date() );
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
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                smUser.setCreateUserId( loginUser.getId() );
            }
            smUser.setCreateTime( new Date() );
            smUser.setIsDel( "1" );
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
	
    public String getOldpass() {
        return oldpass;
    }
    
    public void setOldpass( String oldpass ) {
        this.oldpass = oldpass;
    }
    
    public String getNewpass() {
        return newpass;
    }

    
    public void setNewpass( String newpass ) {
        this.newpass = newpass;
    }

    public String updatePassword() throws Exception {
        // 获取session
        HttpSession session = request.getSession();
        SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
        if(loginUser == null || loginUser.getId() == null) {
            responseJson( false, "用户未登录" );
            return SUCCESS;
        }
        
        Integer id = loginUser.getId();
        SmUser u = smUserServiceProxy.queryById( id );
        if( oldpass == null || !oldpass.equals( u.getPassword() )) {
            responseJson( false, "旧密码错误" );
            return SUCCESS;
        }
        u.setPassword( newpass );
        smUserServiceProxy.updataPassword(u);
        responseJson( true, "密码修改成功" );
	    return SUCCESS;
	}
    
    /**
     * @Description: 角色列表
     */
   public String roleList(){
       try {
           SmUserRole ur = new SmUserRole();
           ur.setUserId( smUser.getId() );
           List<SmUserRole> list = smUserRoleServiceProxy.querySmUserRole4List( request, ur  );
           List<SmRole> retList = new ArrayList<SmRole>();
           for (SmUserRole smUserRole : list) {
               SmRole role = smRoleServiceProxy.queryById( smUserRole.getRoleId() );
               retList.add( role );
           }
           request.setAttribute("smRoleList", retList);
           jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
           
           jsonArr= JSONArray.fromObject( retList, jsonConfig );
           
           responseJson(true, jsonArr);
       } catch (Exception e) {
           responseJson(false, "服务出错了");
           e.printStackTrace();
       }
       return SUCCESS;
   }

    
    public SmRoleServiceIFC getSmRoleServiceProxy() {
        return smRoleServiceProxy;
    }

    
    public void setSmRoleServiceProxy( SmRoleServiceIFC smRoleServiceProxy ) {
        this.smRoleServiceProxy = smRoleServiceProxy;
    }

    
    public SmUserRoleServiceIFC getSmUserRoleServiceProxy() {
        return smUserRoleServiceProxy;
    }

    
    public void setSmUserRoleServiceProxy( SmUserRoleServiceIFC smUserRoleServiceProxy ) {
        this.smUserRoleServiceProxy = smUserRoleServiceProxy;
    }
   
}
