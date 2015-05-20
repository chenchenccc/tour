package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.SmRole;
import com.tour.model.SmUser;

public interface SmUserServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<SmUser> querySmUser4List(HttpServletRequest request, SmUser smUser) throws Exception;
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	SmUser querySmUser4Bean(SmUser smUser) throws Exception;
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddSmUser(SmUser smUser) throws Exception;
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditSmUser(SmUser smUser) throws Exception;
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delSmUser(SmUser smUser) throws Exception;
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(SmUser smUser) throws Exception;

    /**
     * 判断用户名是否存在
     * @author chenrh
     *
     * @param username
     * @return
     */
    public SmUser checkUsername( String username ) throws Exception;

    /**
     * 获取用户下角色
     * @author chenrh
     *
     * @param userId
     * @return
     */
    public List<SmRole> getRoleList( Integer userId ) throws Exception;
    
    /**
     * 根据ID获取对象
     * @author chenrh
     *
     * @param id
     * @return
     */
    public SmUser queryById( Integer id ) throws Exception;


    /**
     * 更新密码
     * @author chenrh
     *
     * @param smUser
     */
    void updataPassword( SmUser smUser );
    

}
