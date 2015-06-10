package com.tour.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.PropertyGridBean;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmUser;
import com.tour.model.TmDepartment;
import com.tour.model.TmEmployee;
import com.tour.service.ifc.SmUserServiceIFC;
import com.tour.service.ifc.TmDepartmentServiceIFC;
import com.tour.service.ifc.TmEmployeeServiceIFC;

@SuppressWarnings("serial")
public class TmEmployeeAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmEmployeeServiceIFC tmEmployeeServiceProxy;
	private SmUserServiceIFC smUserServiceProxy;
	private TmDepartmentServiceIFC tmDepartmentServiceIFC;
	
	
	/**
	  * @Description:  实体对象
	  */
	private TmEmployee tmEmployee;
	private SmUser smUser;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();

    /**
     * @Description: 获取实体列表 
     */
   public String guiderList(){
       try {
           tmEmployee = new TmEmployee();
           tmEmployee.setIsGuider( 1 );
           List<TmEmployee> tmEmployeeList = tmEmployeeServiceProxy.queryTmEmployee4List(request,tmEmployee);
           request.setAttribute("tmEmployeeList", tmEmployeeList);
           jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
           
           jsonArr = JSONArray.fromObject( tmEmployeeList, jsonConfig );
           
           responseJson(tmEmployeeServiceProxy.countByExample(tmEmployee), jsonArr);
        
       } catch (Exception e) {
           e.printStackTrace();
       }
       return SUCCESS;
   }
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmEmployee(){
		List<TmEmployee> tmEmployeeList = tmEmployeeServiceProxy.queryTmEmployee4List(request,tmEmployee);
		request.setAttribute("tmEmployeeList", tmEmployeeList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr = JSONArray.fromObject( tmEmployeeList, jsonConfig );
        
        responseJson(tmEmployeeServiceProxy.countByExample(tmEmployee), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @throws Exception 
	 * @Description: 查看实体对象 
	  */
	public String viewTmEmployee() throws Exception{
		TmEmployee _tmEmployee = tmEmployeeServiceProxy.queryTmEmployee4Bean(tmEmployee);
		if(_tmEmployee != null && _tmEmployee.getDeptId() != null ) {
		    TmDepartment d = tmDepartmentServiceIFC.queryById( _tmEmployee.getDeptId() );
		    _tmEmployee.setDeptName( d.getDeptName() );
		}
		request.setAttribute("operate", "view");
		request.setAttribute("tmEmployee", _tmEmployee);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmEmployee(){
		TmEmployee _tmEmployee = tmEmployeeServiceProxy.queryById( tmEmployee.getId() );
		request.setAttribute("operate", "edit");
		request.setAttribute("tmEmployee", _tmEmployee);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmEmployee(){
		try {
			tmEmployeeServiceProxy.saveEditTmEmployee(tmEmployee);
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
	public String addTmEmployee(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmEmployee(){
		try {
		    // 判断loginName是否存在
		    SmUser i = smUserServiceProxy.checkUsername( smUser.getLoginName() );
		    if( i != null) {
		        responseJson( false, "登陆名已经存在" );
		        return SUCCESS;
		    }
		    smUser.setIsAdmin( 1 );
		    smUser.setIsDel( "1" );
		    smUser.setRealName( tmEmployee.getRealName() );
            // 添加user
		    smUserServiceProxy.saveAddSmUser( smUser );
		    
		    // 查询
		    SmUser u = smUserServiceProxy.checkUsername( smUser.getLoginName() );
		    Integer uid = u.getId();
		    tmEmployee.setUserId( uid );
		    tmEmployee.setIsDel( "1" );
			tmEmployeeServiceProxy.saveAddTmEmployee(tmEmployee);
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
	public String delTmEmployee(){
		try {
			tmEmployeeServiceProxy.delTmEmployee(tmEmployee);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	/**
	 * 获取个人信息
	 * @author chenrh
	 *
	 * @return
	 * @throws Exception 
	 */
	public String getPersonalInfo() throws Exception {
	    tmEmployee = new TmEmployee();
	    // 获取session中的smUser
	    HttpSession session = request.getSession();
	    SmUser smUser = (SmUser) session.getAttribute( "loginUser" );
	    if(smUser == null ) {
	        // 用户未登录
	        responseJson(0, null);
	        return null;
	    }
	    Integer userId = smUser.getId();
	    tmEmployee.setUserId( userId );
//	    TmEmployee e = tmEmployeeServiceProxy.queryTmEmployee4Bean( tmEmployee );
	    SmUser user = smUserServiceProxy.queryById( userId );
	    List<PropertyGridBean> list = new ArrayList<PropertyGridBean>();
	    {
	        PropertyGridBean<String> p = new PropertyGridBean<String>();
	        p.setName( "登陆名" );
	        p.setValue( smUser.getLoginName() );
	        p.setGroup( "基本信息" );
	        p.setEditor( "text" );
	        list.add( p );
	    }
	    {
            PropertyGridBean<String> p = new PropertyGridBean<String>();
            p.setName( "姓名" );
            p.setValue( user.getRealName() );
            p.setGroup( "基本信息" );
            p.setEditor( "text" );
            list.add( p );
        }
	    {
            PropertyGridBean<String> p = new PropertyGridBean<String>();
            p.setName( "年龄" );
            p.setValue( smUser.getAge().toString() );
            p.setGroup( "基本信息" );
            p.setEditor( "numberbox" );
            list.add( p );
        }
	    {
            PropertyGridBean<String> p = new PropertyGridBean<String>();
            p.setName( "联系电话" );
            p.setValue( smUser.getTel() );
            p.setGroup( "基本信息" );
            p.setEditor( "numberbox" );
            list.add( p );
        }
	    jsonArr = JSONArray.fromObject( list );
	    responseJson(6, jsonArr);
        return SUCCESS;
	}
	
	public String savePersonalInfo() {
//	    responseJson(0, null);
	    responseJson( true, "haha" );
        return SUCCESS;
	}

    public TmEmployeeServiceIFC getTmEmployeeServiceProxy() {
		return tmEmployeeServiceProxy;
	}
	public void setTmEmployeeServiceProxy(TmEmployeeServiceIFC tmEmployeeServiceProxy) {
		this.tmEmployeeServiceProxy = tmEmployeeServiceProxy;
	}
	public TmEmployee getTmEmployee() {
		return tmEmployee;
	}
	public void setTmEmployee(TmEmployee tmEmployee) {
		this.tmEmployee = tmEmployee;
	}

    
    public SmUserServiceIFC getSmUserServiceProxy() {
        return smUserServiceProxy;
    }

    
    public void setSmUserServiceProxy( SmUserServiceIFC smUserServiceProxy ) {
        this.smUserServiceProxy = smUserServiceProxy;
    }

    
    public SmUser getSmUser() {
        return smUser;
    }

    
    public void setSmUser( SmUser smUser ) {
        this.smUser = smUser;
    }
	
}
