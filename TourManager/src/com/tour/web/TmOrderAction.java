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
import com.tour.model.TmOrder;
import com.tour.model.TmSchedule;
import com.tour.service.ifc.SmUserServiceIFC;
import com.tour.service.ifc.TmCustomerServiceIFC;
import com.tour.service.ifc.TmOrderServiceIFC;
import com.tour.service.ifc.TmScheduleServiceIFC;

@SuppressWarnings("serial")
public class TmOrderAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private TmOrderServiceIFC tmOrderServiceProxy;
	private TmCustomerServiceIFC tmCustomerServiceProxy;
	private TmScheduleServiceIFC tmScheduleServiceProxy;
	private SmUserServiceIFC smUserServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private TmOrder tmOrder;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @throws Exception 
	 * @Description: 获取实体列表 
	  */
	public String listTmOrder() throws Exception{
	    try {
            
    		List<TmOrder> tmOrderList = tmOrderServiceProxy.queryTmOrder4List(request,tmOrder);
    		List<TmOrder> retList = new ArrayList<TmOrder>(); 
    		for (TmOrder o : tmOrderList) {
                TmSchedule schedule = tmScheduleServiceProxy.queryById( o.getScheduleId() );
                TmCustomer customer = tmCustomerServiceProxy.queryById( o.getCustomId() );
                if(customer == null) {
                    o.setCustomName( "无" );
                } else {
                    SmUser smUser = smUserServiceProxy.queryById( customer.getUserId() );
                    o.setCustomName( smUser.getRealName() );
                }
                if(schedule == null) {
                    o.setScheduleName( "无" );
                } else {
                    o.setScheduleName( schedule.getName() );
                }
                retList.add( o );
            }
    		request.setAttribute("tmOrderList", retList);
    		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
            
            jsonArr= JSONArray.fromObject( retList, jsonConfig );
            
            responseJson(tmOrderServiceProxy.countByExample(tmOrder), jsonArr);
	    } catch (Exception e) {
            e.printStackTrace();
        }
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
            tmOrder.setIsConfirm( 2 );
            tmOrder.setIsDel( "1" );
            tmOrder.setCreateTime( new Date() );
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
		    tmOrder.setIsDel( "2" );
			tmOrderServiceProxy.delTmOrder(tmOrder);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	/**
     * @Description: 付款
     */
   public String payOrder(){
       try {
           tmOrder.setIsDel( "1" );
           tmOrder.setIsPay( 1 );
           tmOrderServiceProxy.delTmOrder(tmOrder);
           responseJson(true, "付款操作成功!");
       } catch (Exception e) {
           responseJson(false, "付款操作失败!");
           RJLog.error(e);
       }
       return SUCCESS;
   }
   /**
    * @Description: 确认订单
    */
  public String confirmOrder(){
      try {
          tmOrder.setIsDel( "1" );
          tmOrder.setIsConfirm( 1 );
          tmOrderServiceProxy.delTmOrder(tmOrder);
          responseJson(true, "确认订单成功!");
      } catch (Exception e) {
          responseJson(false, "确认订单失败!");
          RJLog.error(e);
      }
      return SUCCESS;
  }
  /**
   * @Description: 取消订单
   */
 public String cancelOrder(){
     try {
         tmOrder.setIsDel( "1" );
         tmOrder.setIsConfirm( 3 );
         tmOrderServiceProxy.delTmOrder(tmOrder);
         responseJson(true, "取消订单成功!");
     } catch (Exception e) {
         responseJson(false, "取消订单失败!");
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

    
    public TmCustomerServiceIFC getTmCustomerServiceProxy() {
        return tmCustomerServiceProxy;
    }

    
    public void setTmCustomerServiceProxy( TmCustomerServiceIFC tmCustomerServiceProxy ) {
        this.tmCustomerServiceProxy = tmCustomerServiceProxy;
    }

    
    public TmScheduleServiceIFC getTmScheduleServiceProxy() {
        return tmScheduleServiceProxy;
    }

    
    public void setTmScheduleServiceProxy( TmScheduleServiceIFC tmScheduleServiceProxy ) {
        this.tmScheduleServiceProxy = tmScheduleServiceProxy;
    }

    
    public SmUserServiceIFC getSmUserServiceProxy() {
        return smUserServiceProxy;
    }

    
    public void setSmUserServiceProxy( SmUserServiceIFC smUserServiceProxy ) {
        this.smUserServiceProxy = smUserServiceProxy;
    }
	
}
