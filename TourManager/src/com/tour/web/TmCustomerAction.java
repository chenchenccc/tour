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
import com.tour.model.SmUser;
import com.tour.model.TmCustomer;
import com.tour.service.ifc.SmUserServiceIFC;
import com.tour.service.ifc.TmCustomerServiceIFC;

@SuppressWarnings("serial")
public class TmCustomerAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmCustomerServiceIFC tmCustomerServiceProxy;
	private SmUserServiceIFC smUserServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmCustomer tmCustomer;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @throws Exception 
	 * @Description: 获取实体列表 
	  */
	public String listTmCustomer() throws Exception{
	    try {
	        List<TmCustomer> tmCustomerList = tmCustomerServiceProxy.queryTmCustomer4List(request,tmCustomer);
	        List<TmCustomer> retList = new ArrayList<TmCustomer>();
	        for (TmCustomer c : tmCustomerList) {
	            // 获取superName
	            TmCustomer superCustomer = tmCustomerServiceProxy.queryById( c.getSuperId() );
	            if(superCustomer == null) {
	                c.setSuperName( "无" );
	            } else {
	                c.setSuperName( superCustomer.getRealName() );
	            }
	            
	            // 获取realName
	            SmUser user = smUserServiceProxy.queryById( c.getUserId() );
	            if(user == null) {
	                c.setRealName( "" );
	            } else {
	                c.setRealName( user.getRealName() );
	            }
	            retList.add( c );
	        }
	        request.setAttribute("tmCustomerList", retList);
	        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
	        
	        jsonArr= JSONArray.fromObject( retList, jsonConfig );
	        
	        responseJson(tmCustomerServiceProxy.countByExample(tmCustomer), jsonArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmCustomer(){
		TmCustomer _tmCustomer = tmCustomerServiceProxy.queryTmCustomer4Bean(tmCustomer);
		request.setAttribute("operate", "view");
		request.setAttribute("tmCustomer", _tmCustomer);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmCustomer(){
		TmCustomer _tmCustomer = tmCustomerServiceProxy.queryTmCustomer4Bean(tmCustomer);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmCustomer", _tmCustomer);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmCustomer(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                tmCustomer.setUpdateUserId( loginUser.getId() );
            }
            tmCustomer.setIsDel( "1" );
            tmCustomer.setUpdateTime( new Date() );
            
            TmCustomer c = tmCustomerServiceProxy.queryById( tmCustomer.getId() );
            tmCustomer.setUserId( c.getUserId() );
			tmCustomerServiceProxy.saveEditTmCustomer(tmCustomer);
			responseJson(true, "修改成功!");
		} catch (Exception e) {
			responseJson(false, "修改失败!");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	  * @Description: 添加实体对象 
	  */
	public String addTmCustomer(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmCustomer(){
		try {
		    HttpSession session = request.getSession();
		    SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
		    
		    // 添加user
		    SmUser smUser = new SmUser();
		    smUser.setAge( tmCustomer.getAge() );
		    smUser.setTel( tmCustomer.getTel() );
		    smUser.setRealName( tmCustomer.getRealName() );
		    smUser.setCreateTime( new Date() );
		    smUser.setLoginName( "" );
		    smUser.setPassword( "" );
		    
		    if(loginUser != null) {
                smUser.setCreateUserId( loginUser.getId());
            }
		    smUser.setIsAdmin( 2 );
		    smUser.setIsDel( "1" );
		    
		    smUserServiceProxy.saveAddSmUser( smUser );
		    
		    SmUser u = smUserServiceProxy.querySmUser4Bean( smUser );
		    // 添加tmCustomer
		    if(loginUser != null) {
		        tmCustomer.setCreateUserId( loginUser.getId() );
		    }
		    smUserServiceProxy.saveAddSmUser( smUser );
		    tmCustomer.setUserId( u.getId() );
            tmCustomer.setCreateTime( new Date() );
            tmCustomer.setIsDel( "1" );
			tmCustomerServiceProxy.saveAddTmCustomer(tmCustomer);
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
	public String delTmCustomer(){
		try {
		    tmCustomer.setIsDel( "2" );
			tmCustomerServiceProxy.delTmCustomer(tmCustomer);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmCustomerServiceIFC getTmCustomerServiceProxy() {
		return tmCustomerServiceProxy;
	}
	public void setTmCustomerServiceProxy(TmCustomerServiceIFC tmCustomerServiceProxy) {
		this.tmCustomerServiceProxy = tmCustomerServiceProxy;
	}
	public TmCustomer getTmCustomer() {
		return tmCustomer;
	}
	public void setTmCustomer(TmCustomer tmCustomer) {
		this.tmCustomer = tmCustomer;
	}

    public SmUserServiceIFC getSmUserServiceProxy() {
        return smUserServiceProxy;
    }
    
    public void setSmUserServiceProxy( SmUserServiceIFC smUserServiceProxy ) {
        this.smUserServiceProxy = smUserServiceProxy;
    }
}
