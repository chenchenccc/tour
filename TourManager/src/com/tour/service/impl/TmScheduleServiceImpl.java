package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.TmScheduleDAO;
import com.tour.model.TmHotelExample;
import com.tour.model.TmSchedule;
import com.tour.model.TmScheduleExample;
import com.tour.model.TmScheduleExample.Criteria;
import com.tour.service.ifc.TmScheduleServiceIFC;

public class TmScheduleServiceImpl implements TmScheduleServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmScheduleDAO tmScheduleDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmSchedule> queryTmSchedule4List(HttpServletRequest request, TmSchedule tmSchedule) {
		//构造Criteria
		TmScheduleExample example = new TmScheduleExample();
		Criteria criteria = example.createCriteria();

        try {
            if(null != request.getParameter("rows") && null != request.getParameter("page")) {
                int limit = Integer.parseInt(request.getParameter("rows"));
                int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
                example.setLimitStart(start);
                example.setLimitEnd(limit);
            }
            
            criteria = criteria.andIsDelEqualTo( "1" );
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return tmScheduleDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmSchedule queryTmSchedule4Bean(TmSchedule tmSchedule) {
		TmSchedule _tmSchedule = null;
		//构造Criteria
		TmScheduleExample example = new TmScheduleExample();
		Criteria criteria = example.createCriteria();
	
		List<TmSchedule> list= tmScheduleDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmSchedule = list.get(0);
		}
	return _tmSchedule;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmSchedule(TmSchedule tmSchedule) {
		tmScheduleDao.insert(tmSchedule);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmSchedule(TmSchedule tmSchedule) {
		tmScheduleDao.updateByPrimaryKey(tmSchedule);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmSchedule(TmSchedule tmSchedule) {
		tmScheduleDao.updateByPrimaryKeySelective(tmSchedule);
	}
	
	public TmScheduleDAO getTmScheduleDao() {
		return tmScheduleDao;
	}
	public void setTmScheduleDao(TmScheduleDAO tmScheduleDao) {
		this.tmScheduleDao = tmScheduleDao;
	}


    public int countByExample( TmSchedule tmSchedule ) {
        //构造Criteria
        TmScheduleExample example = new TmScheduleExample();
        Criteria criteria = example.createCriteria();
        
        criteria.andIsDelEqualTo( "1" );
        
        return tmScheduleDao.countByExample(example);
    }
}
