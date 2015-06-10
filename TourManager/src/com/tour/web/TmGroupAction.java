package com.tour.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.tour.commons.base.BaseAction;
import com.tour.commons.utils.JsonDateValueProcessor;
import com.tour.commons.utils.RJLog;
import com.tour.model.SmUser;
import com.tour.model.TmEmployee;
import com.tour.model.TmGroup;
import com.tour.model.TmSchedule;
import com.tour.service.ifc.TmEmployeeServiceIFC;
import com.tour.service.ifc.TmGroupServiceIFC;
import com.tour.service.ifc.TmScheduleServiceIFC;

@SuppressWarnings("serial")
public class TmGroupAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmGroupServiceIFC tmGroupServiceProxy;
	private TmScheduleServiceIFC tmScheduleServiceProxy;
	private TmEmployeeServiceIFC tmEmployeeServiceProxy;
	/**
	  * @Description:  实体对象
	  */
	private TmGroup tmGroup;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @throws Exception 
	 * @Description: 获取实体列表 
	  */
	public String listTmGroup() throws Exception{
	    try {
    		List<TmGroup> tmGroupList = tmGroupServiceProxy.queryTmGroup4List(request,tmGroup);
    		List<TmGroup> retList = new ArrayList<TmGroup>();
    		for (TmGroup g : tmGroupList) {
                String guilderIds = g.getGuilderIds();
                if(guilderIds != null) {
                    StringBuffer sb = new StringBuffer();
                    String[] guilderIdArr = guilderIds.split( "," );
                    for (String gid : guilderIdArr) {
                        TmEmployee guilder = tmEmployeeServiceProxy.queryById( Integer.parseInt( gid ));
                        sb.append( guilder.getRealName() ).append( ";" );
                    }
                    g.setGuilderNames( sb.toString() );
                } else {
                    g.setGuilderNames( "暂无导游" );
                }
                
                TmSchedule schedule = tmScheduleServiceProxy.queryById( g.getScheduleId() );
                if(schedule != null) {
                    g.setScheduleName( schedule.getName() );
                } else {
                    g.setScheduleName( "暂无日程" );
                }
                
                retList.add( g );
            }
    		request.setAttribute("tmGroupList", retList);
    		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
            
            jsonArr= JSONArray.fromObject( retList, jsonConfig );
            
            responseJson(tmGroupServiceProxy.countByExample(tmGroup), jsonArr);
	    } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmGroup(){
		TmGroup _tmGroup = tmGroupServiceProxy.queryTmGroup4Bean(tmGroup);
		request.setAttribute("operate", "view");
		request.setAttribute("tmGroup", _tmGroup);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @throws Exception 
	 * @Description: 编辑实体对象 
	  */
	public String editTmGroup() throws Exception{
		TmGroup _tmGroup = tmGroupServiceProxy.queryById( tmGroup.getId() );
		request.setAttribute("operate", "edit");
		request.setAttribute("tmGroup", _tmGroup);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmGroup(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                tmGroup.setUpdateUserId( loginUser.getId() );
            }
            tmGroup.setIsDel( "1" );
            tmGroup.setUpdateTime( new Date() );
			tmGroupServiceProxy.saveEditTmGroup(tmGroup);
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
	public String addTmGroup(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }  
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmGroup(){
		try {
		    // 
		    TmSchedule s = tmScheduleServiceProxy.queryById( tmGroup.getScheduleId() );
		    
		    if(tmGroup.getStartTime().after( new Date ())) {
		        tmGroup.setStatus( 1 ); // 未开始
		    } else if(getDateAfter( tmGroup.getStartTime(), s.getTotalDay() ).after( new Date())) {
		        tmGroup.setStatus( 1 ); // 在路上
		    } else {
		        tmGroup.setStatus( 3 ); // 已经结束
		    }
		    
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                tmGroup.setCreateUserId( loginUser.getId() );
            }
            tmGroup.setCreateTime( new Date() );
		    tmGroup.setIsDel( "1" );
			tmGroupServiceProxy.saveAddTmGroup(tmGroup);
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
	public String delTmGroup(){
		try {
		    tmGroup.setIsDel( "2" );
			tmGroupServiceProxy.delTmGroup(tmGroup);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public TmGroupServiceIFC getTmGroupServiceProxy() {
		return tmGroupServiceProxy;
	}
	public void setTmGroupServiceProxy(TmGroupServiceIFC tmGroupServiceProxy) {
		this.tmGroupServiceProxy = tmGroupServiceProxy;
	}
	public TmGroup getTmGroup() {
		return tmGroup;
	}
	public void setTmGroup(TmGroup tmGroup) {
		this.tmGroup = tmGroup;
	}

    
    public TmScheduleServiceIFC getTmScheduleServiceProxy() {
        return tmScheduleServiceProxy;
    }

    
    public void setTmScheduleServiceProxy( TmScheduleServiceIFC tmScheduleServiceProxy ) {
        this.tmScheduleServiceProxy = tmScheduleServiceProxy;
    }

    
    public TmEmployeeServiceIFC getTmEmployeeServiceProxy() {
        return tmEmployeeServiceProxy;
    }

    
    public void setTmEmployeeServiceProxy( TmEmployeeServiceIFC tmEmployeeServiceProxy ) {
        this.tmEmployeeServiceProxy = tmEmployeeServiceProxy;
    }
	
}
