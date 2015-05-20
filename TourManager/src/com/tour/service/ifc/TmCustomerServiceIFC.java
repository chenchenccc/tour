package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmCustomer;
import com.tour.model.TmCustomerGroup;
import com.tour.model.TmHotel;

public interface TmCustomerServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmCustomer> queryTmCustomer4List(HttpServletRequest request, TmCustomer tmCustomer);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmCustomer queryTmCustomer4Bean(TmCustomer tmCustomer);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmCustomer(TmCustomer tmCustomer);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmCustomer(TmCustomer tmCustomer);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmCustomer(TmCustomer tmCustomer);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmCustomer tmCustomer);
    
    /**
     * 根据ID获取对象
     * @author chenrh
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TmCustomer queryById( Integer id ) throws Exception;
}
