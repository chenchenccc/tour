package com.tour.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.model.TmHotel;
import com.tour.model.TmSchedule;

public interface TmScheduleServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<TmSchedule> queryTmSchedule4List(HttpServletRequest request, TmSchedule tmSchedule);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	TmSchedule queryTmSchedule4Bean(TmSchedule tmSchedule);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddTmSchedule(TmSchedule tmSchedule);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditTmSchedule(TmSchedule tmSchedule);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delTmSchedule(TmSchedule tmSchedule);
	
	/**
     * @Description: 实体列表总数
     */
    public int countByExample(TmSchedule tmSchedule);
}
