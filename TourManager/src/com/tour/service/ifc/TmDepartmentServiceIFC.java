package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmCustomer;
import com.tour.model.TmDepartment;
import com.tour.model.TmHotel;

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
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmDepartment tmDepartment);
    
    /**
     * 根据ID获取对象
     * @author chenrh
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TmDepartment queryById( Integer id ) throws Exception;
}
