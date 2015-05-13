package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.SmRoleDAO;
import com.tour.model.SmRole;
import com.tour.model.SmRoleExample;
import com.tour.model.SmRoleExample.Criteria;
import com.tour.service.ifc.SmRoleServiceIFC;

public class SmRoleServiceImpl implements SmRoleServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private SmRoleDAO smRoleDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<SmRole> querySmRole4List(HttpServletRequest request, SmRole smRole) {
		//构造Criteria
		SmRoleExample example = new SmRoleExample();
		Criteria criteria = example.createCriteria();
	
		return smRoleDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public SmRole querySmRole4Bean(SmRole smRole) {
		SmRole _smRole = null;
		//构造Criteria
		SmRoleExample example = new SmRoleExample();
		Criteria criteria = example.createCriteria();
	
		List<SmRole> list= smRoleDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_smRole = list.get(0);
		}
	return _smRole;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSmRole(SmRole smRole) {
		smRoleDao.insert(smRole);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSmRole(SmRole smRole) {
		smRoleDao.updateByPrimaryKey(smRole);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSmRole(SmRole smRole) {
		smRoleDao.updateByPrimaryKeySelective(smRole);
	}
	
	public SmRoleDAO getSmRoleDao() {
		return smRoleDao;
	}
	public void setSmRoleDao(SmRoleDAO smRoleDao) {
		this.smRoleDao = smRoleDao;
	}
}
