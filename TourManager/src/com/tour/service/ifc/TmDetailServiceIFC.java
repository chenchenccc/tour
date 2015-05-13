package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmDetail;
import com.tour.model.TmHotel;

public interface TmDetailServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmDetail> queryTmDetail4List(HttpServletRequest request, TmDetail tmDetail);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmDetail queryTmDetail4Bean(TmDetail tmDetail);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmDetail(TmDetail tmDetail);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmDetail(TmDetail tmDetail);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmDetail(TmDetail tmDetail);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmDetail tmDetail);
}
