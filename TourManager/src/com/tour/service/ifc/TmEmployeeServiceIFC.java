package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmEmployee;
import com.tour.model.TmHotel;

public interface TmEmployeeServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmEmployee> queryTmEmployee4List(HttpServletRequest request, TmEmployee tmEmployee);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmEmployee queryTmEmployee4Bean(TmEmployee tmEmployee);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmEmployee(TmEmployee tmEmployee);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmEmployee(TmEmployee tmEmployee);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmEmployee(TmEmployee tmEmployee);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmEmployee tmEmployee);


    /**
     * 根据id获取对象
     * @author chenrh
     *
     * @param id
     * @return
     */
    TmEmployee queryById( Integer id );
}
