package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmRoleAutho;
import com.tour.model.TmHotel;

public interface SmRoleAuthoServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<SmRoleAutho> querySmRoleAutho4List(HttpServletRequest request, SmRoleAutho smRoleAutho);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	SmRoleAutho querySmRoleAutho4Bean(SmRoleAutho smRoleAutho);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddSmRoleAutho(SmRoleAutho smRoleAutho);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditSmRoleAutho(SmRoleAutho smRoleAutho);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delSmRoleAutho(SmRoleAutho smRoleAutho);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(SmRoleAutho smRoleAutho);
}
