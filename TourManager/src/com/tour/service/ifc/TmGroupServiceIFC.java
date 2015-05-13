package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmGroup;

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
	
}
