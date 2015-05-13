package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmEmployee;

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
	
}
