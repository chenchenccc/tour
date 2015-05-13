package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.TmGroupDAO;
import com.tour.model.TmGroup;
import com.tour.model.TmGroupExample;
import com.tour.model.TmGroupExample.Criteria;
import com.tour.service.ifc.TmGroupServiceIFC;

public class TmGroupServiceImpl implements TmGroupServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmGroupDAO tmGroupDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmGroup> queryTmGroup4List(HttpServletRequest request, TmGroup tmGroup) {
		//构造Criteria
		TmGroupExample example = new TmGroupExample();
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
		return tmGroupDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmGroup queryTmGroup4Bean(TmGroup tmGroup) {
		TmGroup _tmGroup = null;
		//构造Criteria
		TmGroupExample example = new TmGroupExample();
		Criteria criteria = example.createCriteria();
	
		List<TmGroup> list= tmGroupDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmGroup = list.get(0);
		}
	return _tmGroup;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmGroup(TmGroup tmGroup) {
		tmGroupDao.insert(tmGroup);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmGroup(TmGroup tmGroup) {
		tmGroupDao.updateByPrimaryKey(tmGroup);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmGroup(TmGroup tmGroup) {
		tmGroupDao.updateByPrimaryKeySelective(tmGroup);
	}
	
	public TmGroupDAO getTmGroupDao() {
		return tmGroupDao;
	}
	public void setTmGroupDao(TmGroupDAO tmGroupDao) {
		this.tmGroupDao = tmGroupDao;
	}


    @Override
    public int countByExample( TmGroup tmGroup ) {
        // TODO Auto-generated method stub
        return 0;
    }
}
