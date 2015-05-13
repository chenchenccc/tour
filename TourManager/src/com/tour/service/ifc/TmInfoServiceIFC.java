package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmHotel;
import com.tour.model.TmInfo;

public interface TmInfoServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmInfo> queryTmInfo4List(HttpServletRequest request, TmInfo tmInfo);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmInfo queryTmInfo4Bean(TmInfo tmInfo);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmInfo(TmInfo tmInfo);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmInfo(TmInfo tmInfo);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmInfo(TmInfo tmInfo);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmInfo tmInfo);
}
