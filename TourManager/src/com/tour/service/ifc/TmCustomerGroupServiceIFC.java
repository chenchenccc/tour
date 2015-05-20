package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmUser;
import com.tour.model.TmCustomerGroup;
import com.tour.model.TmHotel;

public interface TmCustomerGroupServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmCustomerGroup> queryTmCustomerGroup4List(HttpServletRequest request, TmCustomerGroup tmCustomerGroup);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmCustomerGroup queryTmCustomerGroup4Bean(TmCustomerGroup tmCustomerGroup);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmCustomerGroup(TmCustomerGroup tmCustomerGroup);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmCustomerGroup(TmCustomerGroup tmCustomerGroup);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmCustomerGroup(TmCustomerGroup tmCustomerGroup);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmCustomerGroup tmCustomerGroup);
    
    /**
     * 根据ID获取对象
     * @author chenrh
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TmCustomerGroup queryById( Integer id ) throws Exception;
}
