package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.TmDepartmentDAO;
import com.tour.model.TmDepartment;
import com.tour.model.TmDepartmentExample;
import com.tour.model.TmDepartmentExample.Criteria;
import com.tour.service.ifc.TmDepartmentServiceIFC;

public class TmDepartmentServiceImpl implements TmDepartmentServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmDepartmentDAO tmDepartmentDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmDepartment> queryTmDepartment4List(HttpServletRequest request, TmDepartment tmDepartment) {
		//构造Criteria
		TmDepartmentExample example = new TmDepartmentExample();
		Criteria criteria = example.createCriteria();
	
		return tmDepartmentDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmDepartment queryTmDepartment4Bean(TmDepartment tmDepartment) {
		TmDepartment _tmDepartment = null;
		//构造Criteria
		TmDepartmentExample example = new TmDepartmentExample();
		Criteria criteria = example.createCriteria();
	
		List<TmDepartment> list= tmDepartmentDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmDepartment = list.get(0);
		}
	return _tmDepartment;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmDepartment(TmDepartment tmDepartment) {
		tmDepartmentDao.insert(tmDepartment);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmDepartment(TmDepartment tmDepartment) {
		tmDepartmentDao.updateByPrimaryKey(tmDepartment);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmDepartment(TmDepartment tmDepartment) {
		tmDepartmentDao.updateByPrimaryKeySelective(tmDepartment);
	}
	
	public TmDepartmentDAO getTmDepartmentDao() {
		return tmDepartmentDao;
	}
	public void setTmDepartmentDao(TmDepartmentDAO tmDepartmentDao) {
		this.tmDepartmentDao = tmDepartmentDao;
	}
}
