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
import com.tour.model.TmDetail;
import com.tour.model.TmEmployee;
import com.tour.model.TmSchedule;
import com.tour.service.ifc.TmDetailServiceIFC;
import com.tour.service.ifc.TmEmployeeServiceIFC;
import com.tour.service.ifc.TmScheduleServiceIFC;

@SuppressWarnings("serial")
public class TmScheduleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmScheduleServiceIFC tmScheduleServiceProxy;
	private TmDetailServiceIFC tmDetailServiceProxy;
	private TmEmployeeServiceIFC tmEmployeeServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmSchedule tmSchedule;
	private TmDetail tmDetail;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listTmSchedule(){
	    try {
    		List<TmSchedule> tmScheduleList = tmScheduleServiceProxy.queryTmSchedule4List(request,tmSchedule);
    		List<TmSchedule> retList = new ArrayList<TmSchedule>();
    		for (TmSchedule s : tmScheduleList) {
    		    String guiderIds = s.getGuiderIds();
    		    String[] guiderArr = new String[]{};
    		    if(guiderIds != null) {
    		        guiderArr = guiderIds.split( "," );
    		    }
    		    StringBuffer guiderNames = new StringBuffer();
    		    for (String guilderId : guiderArr) {
                    TmEmployee guilder = tmEmployeeServiceProxy.queryById( Integer.parseInt( guilderId ) );
                    if(guilder != null) {
                        guiderNames.append( guilder.getRealName() ).append( ";" );
                    }
                }
    		    s.setGuiderNames( guiderNames.toString() );
    		    retList.add( s );
            }
    		request.setAttribute("tmScheduleList", retList);
    		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
            
            jsonArr= JSONArray.fromObject( retList, jsonConfig );
            
            responseJson(tmScheduleServiceProxy.countByExample(tmSchedule), jsonArr);
	    } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewTmSchedule(){
		TmSchedule _tmSchedule = tmScheduleServiceProxy.queryTmSchedule4Bean(tmSchedule);
		request.setAttribute("operate", "view");
		request.setAttribute("tmSchedule", _tmSchedule);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editTmSchedule(){
		TmSchedule _tmSchedule = tmScheduleServiceProxy.queryTmSchedule4Bean(tmSchedule);
		request.setAttribute("operate", "edit");
		request.setAttribute("tmSchedule", _tmSchedule);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditTmSchedule(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                tmSchedule.setUpdateUserId( loginUser.getId().longValue() );
            }
            tmSchedule.setUpdateTime( new Date() );
			tmScheduleServiceProxy.saveEditTmSchedule(tmSchedule);
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
	public String addTmSchedule(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddTmSchedule(){
		try {
		    HttpSession session = request.getSession();
            SmUser loginUser = (SmUser) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                tmSchedule.setCreateUserId( loginUser.getId() );
            }
            tmSchedule.setCreateTime( new Date() );
			tmScheduleServiceProxy.saveAddTmSchedule(tmSchedule);
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
	public String delTmSchedule(){
		try {
		    tmSchedule.setIsDel( "2" );
			tmScheduleServiceProxy.delTmSchedule(tmSchedule);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询日程详细信息
	 * @author chenrh
	 *
	 * @return
	 */
	public String queryDetailInfo() {
	    Integer id = tmSchedule.getId();
	    if(id == null || id.equals( 0 )) {
	        return ERROR;
	    }
	    // 获取日程
	    tmSchedule = tmScheduleServiceProxy.queryTmSchedule4Bean( tmSchedule );
	    
	    // 获取详细
	    List<TmDetail> ret = new ArrayList<TmDetail>();
	    if( tmSchedule == null || tmSchedule.getDetailId() == null ) {
	        return SUCCESS;
	    }
	    String detailIds = tmSchedule.getDetailId();
	    String[] list = detailIds.split( "," );
	    for (String d : list) {
            int i = Integer.parseInt( d );
            TmDetail detail = tmDetailServiceProxy.queryTmDetailById( i );
            ret.add( detail );
        }
	    jsonArr = JSONArray.fromObject( ret );
	    responseJson( ret.size(), jsonArr );
	    return SUCCESS;
	}
	
	public TmScheduleServiceIFC getTmScheduleServiceProxy() {
		return tmScheduleServiceProxy;
	}
	public void setTmScheduleServiceProxy(TmScheduleServiceIFC tmScheduleServiceProxy) {
		this.tmScheduleServiceProxy = tmScheduleServiceProxy;
	}
	public TmSchedule getTmSchedule() {
		return tmSchedule;
	}
	public void setTmSchedule(TmSchedule tmSchedule) {
		this.tmSchedule = tmSchedule;
	}

    
    public TmDetailServiceIFC getTmDetailServiceProxy() {
        return tmDetailServiceProxy;
    }

    
    public void setTmDetailServiceProxy( TmDetailServiceIFC tmDetailServiceProxy ) {
        this.tmDetailServiceProxy = tmDetailServiceProxy;
    }

    
    public TmDetail getTmDetail() {
        return tmDetail;
    }

    
    public void setTmDetail( TmDetail tmDetail ) {
        this.tmDetail = tmDetail;
    }

    
    public TmEmployeeServiceIFC getTmEmployeeServiceProxy() {
        return tmEmployeeServiceProxy;
    }

    
    public void setTmEmployeeServiceProxy( TmEmployeeServiceIFC tmEmployeeServiceProxy ) {
        this.tmEmployeeServiceProxy = tmEmployeeServiceProxy;
    }
	
}
