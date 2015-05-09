package com.tour.service.ifc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmUser;

public interface SmUserServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<SmUser> querySmUser4List(HttpServletRequest request, SmUser smUser);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	SmUser querySmUser4Bean(SmUser smUser);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddSmUser(SmUser smUser);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditSmUser(SmUser smUser);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delSmUser(SmUser smUser);
	
}
