package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmCustomer;
import com.tour.model.TmHotel;
import com.tour.model.TmOrder;

public interface TmOrderServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmOrder> queryTmOrder4List(HttpServletRequest request, TmOrder tmOrder);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmOrder queryTmOrder4Bean(TmOrder tmOrder);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmOrder(TmOrder tmOrder);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmOrder(TmOrder tmOrder);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmOrder(TmOrder tmOrder);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmOrder tmOrder);
    
    /**
     * 根据ID获取对象
     * @author chenrh
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TmOrder queryById( Integer id ) throws Exception;
}
