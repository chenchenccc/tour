package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmUser;
import com.tour.model.TmHotel;

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
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(SmUser smUser);

    /**
     * 判断用户名是否存在
     * @author chenrh
     *
     * @param username
     * @return
     */
    public SmUser checkUsername( String username );

}
