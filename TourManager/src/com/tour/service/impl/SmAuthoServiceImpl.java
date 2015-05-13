package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.SmAuthoDAO;
import com.tour.model.SmAutho;
import com.tour.model.SmAuthoExample;
import com.tour.model.SmAuthoExample.Criteria;
import com.tour.service.ifc.SmAuthoServiceIFC;

public class SmAuthoServiceImpl implements SmAuthoServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private SmAuthoDAO smAuthoDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<SmAutho> querySmAutho4List(HttpServletRequest request, SmAutho smAutho) {
		//构造Criteria
		SmAuthoExample example = new SmAuthoExample();
		Criteria criteria = example.createCriteria();
	
		return smAuthoDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public SmAutho querySmAutho4Bean(SmAutho smAutho) {
		SmAutho _smAutho = null;
		//构造Criteria
		SmAuthoExample example = new SmAuthoExample();
		Criteria criteria = example.createCriteria();
	
		List<SmAutho> list= smAuthoDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_smAutho = list.get(0);
		}
	return _smAutho;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSmAutho(SmAutho smAutho) {
		smAuthoDao.insert(smAutho);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSmAutho(SmAutho smAutho) {
		smAuthoDao.updateByPrimaryKey(smAutho);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSmAutho(SmAutho smAutho) {
		smAuthoDao.updateByPrimaryKeySelective(smAutho);
	}
	
	public SmAuthoDAO getSmAuthoDao() {
		return smAuthoDao;
	}
	public void setSmAuthoDao(SmAuthoDAO smAuthoDao) {
		this.smAuthoDao = smAuthoDao;
	}
}
