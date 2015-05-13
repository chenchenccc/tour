package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.TmHotelDAO;
import com.tour.model.TmHotel;
import com.tour.model.TmHotelExample;
import com.tour.model.TmHotelExample.Criteria;
import com.tour.service.ifc.TmHotelServiceIFC;

public class TmHotelServiceImpl implements TmHotelServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmHotelDAO tmHotelDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmHotel> queryTmHotel4List(HttpServletRequest request, TmHotel tmHotel) {
		//构造Criteria
		TmHotelExample example = new TmHotelExample();
		Criteria criteria = example.createCriteria();
	
		return tmHotelDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmHotel queryTmHotel4Bean(TmHotel tmHotel) {
		TmHotel _tmHotel = null;
		//构造Criteria
		TmHotelExample example = new TmHotelExample();
		Criteria criteria = example.createCriteria();
	
		List<TmHotel> list= tmHotelDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmHotel = list.get(0);
		}
	return _tmHotel;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmHotel(TmHotel tmHotel) {
		tmHotelDao.insert(tmHotel);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmHotel(TmHotel tmHotel) {
		tmHotelDao.updateByPrimaryKey(tmHotel);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmHotel(TmHotel tmHotel) {
		tmHotelDao.updateByPrimaryKeySelective(tmHotel);
	}
	
	public TmHotelDAO getTmHotelDao() {
		return tmHotelDao;
	}
	public void setTmHotelDao(TmHotelDAO tmHotelDao) {
		this.tmHotelDao = tmHotelDao;
	}
}
