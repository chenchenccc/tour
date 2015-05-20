package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmCustomer;
import com.tour.model.TmHotel;

public interface TmHotelServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmHotel> queryTmHotel4List(HttpServletRequest request, TmHotel tmHotel);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmHotel queryTmHotel4Bean(TmHotel tmHotel);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmHotel(TmHotel tmHotel);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmHotel(TmHotel tmHotel);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmHotel(TmHotel tmHotel);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmHotel tmHotel);
    /**
     * 根据ID获取对象
     * @author chenrh
     *
     * @param id
     * @return
     * @throws Exception
     */
    public TmHotel queryById( Integer id ) throws Exception;
}
