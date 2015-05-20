package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmCustomer;
import com.tour.model.TmGroup;
import com.tour.model.TmHotel;

public interface TmGroupServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmGroup> queryTmGroup4List(HttpServletRequest request, TmGroup tmGroup);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmGroup queryTmGroup4Bean(TmGroup tmGroup);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmGroup(TmGroup tmGroup);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmGroup(TmGroup tmGroup);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmGroup(TmGroup tmGroup);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmGroup tmGroup);
    
    /**
     * 根据ID获取对象
     * @author chenrh
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TmGroup queryById( Integer id ) throws Exception;
}
