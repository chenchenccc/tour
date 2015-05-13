package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmDepartment;

public interface TmDepartmentServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmDepartment> queryTmDepartment4List(HttpServletRequest request, TmDepartment tmDepartment);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmDepartment queryTmDepartment4Bean(TmDepartment tmDepartment);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmDepartment(TmDepartment tmDepartment);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmDepartment(TmDepartment tmDepartment);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmDepartment(TmDepartment tmDepartment);
	
}
