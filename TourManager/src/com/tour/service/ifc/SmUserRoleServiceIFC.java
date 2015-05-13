package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmUserRole;
import com.tour.model.TmHotel;

public interface SmUserRoleServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<SmUserRole> querySmUserRole4List(HttpServletRequest request, SmUserRole smUserRole);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	SmUserRole querySmUserRole4Bean(SmUserRole smUserRole);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddSmUserRole(SmUserRole smUserRole);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditSmUserRole(SmUserRole smUserRole);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delSmUserRole(SmUserRole smUserRole);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(SmUserRole smUserRole);
}
