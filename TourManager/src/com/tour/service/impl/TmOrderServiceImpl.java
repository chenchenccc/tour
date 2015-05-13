package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.TmOrderDAO;
import com.tour.model.TmOrder;
import com.tour.model.TmOrderExample;
import com.tour.model.TmOrderExample.Criteria;
import com.tour.service.ifc.TmOrderServiceIFC;

public class TmOrderServiceImpl implements TmOrderServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmOrderDAO tmOrderDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmOrder> queryTmOrder4List(HttpServletRequest request, TmOrder tmOrder) {
		//构造Criteria
		TmOrderExample example = new TmOrderExample();
		Criteria criteria = example.createCriteria();
	
		return tmOrderDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmOrder queryTmOrder4Bean(TmOrder tmOrder) {
		TmOrder _tmOrder = null;
		//构造Criteria
		TmOrderExample example = new TmOrderExample();
		Criteria criteria = example.createCriteria();
	
		List<TmOrder> list= tmOrderDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmOrder = list.get(0);
		}
	return _tmOrder;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmOrder(TmOrder tmOrder) {
		tmOrderDao.insert(tmOrder);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmOrder(TmOrder tmOrder) {
		tmOrderDao.updateByPrimaryKey(tmOrder);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmOrder(TmOrder tmOrder) {
		tmOrderDao.updateByPrimaryKeySelective(tmOrder);
	}
	
	public TmOrderDAO getTmOrderDao() {
		return tmOrderDao;
	}
	public void setTmOrderDao(TmOrderDAO tmOrderDao) {
		this.tmOrderDao = tmOrderDao;
	}
}