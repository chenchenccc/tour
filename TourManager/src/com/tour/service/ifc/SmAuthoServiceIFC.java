package com.tour.service.ifc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmAutho;
import com.tour.model.TmHotel;

public interface SmAuthoServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<SmAutho> querySmAutho4List(HttpServletRequest request, SmAutho smAutho);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	SmAutho querySmAutho4Bean(SmAutho smAutho);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddSmAutho(SmAutho smAutho);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditSmAutho(SmAutho smAutho);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delSmAutho(SmAutho smAutho);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(SmAutho smAutho);
    
    /**
     * @Description: 根据ID获取对象
     */
    public SmAutho queryById(Integer id);
}
