package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmRole;

public interface SmRoleServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<SmRole> querySmRole4List(HttpServletRequest request, SmRole smRole);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	SmRole querySmRole4Bean(SmRole smRole);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddSmRole(SmRole smRole);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditSmRole(SmRole smRole);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delSmRole(SmRole smRole);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(SmRole smRole);
}
