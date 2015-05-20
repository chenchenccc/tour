package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.dao.ifc.TmCustomerGroupDAO;
import com.tour.model.TmCustomerGroup;
import com.tour.model.TmCustomerGroupExample;
import com.tour.model.TmCustomerGroupExample.Criteria;
import com.tour.service.ifc.TmCustomerGroupServiceIFC;

public class TmCustomerGroupServiceImpl implements TmCustomerGroupServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmCustomerGroupDAO tmCustomerGroupDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmCustomerGroup> queryTmCustomerGroup4List(HttpServletRequest request, TmCustomerGroup tmCustomerGroup) {
		//构造Criteria
		TmCustomerGroupExample example = new TmCustomerGroupExample();
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
		return tmCustomerGroupDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmCustomerGroup queryTmCustomerGroup4Bean(TmCustomerGroup tmCustomerGroup) {
		TmCustomerGroup _tmCustomerGroup = null;
		//构造Criteria
		TmCustomerGroupExample example = new TmCustomerGroupExample();
		Criteria criteria = example.createCriteria();
	
		List<TmCustomerGroup> list= tmCustomerGroupDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmCustomerGroup = list.get(0);
		}
	return _tmCustomerGroup;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmCustomerGroup(TmCustomerGroup tmCustomerGroup) {
		tmCustomerGroupDao.insert(tmCustomerGroup);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmCustomerGroup(TmCustomerGroup tmCustomerGroup) {
		tmCustomerGroupDao.updateByPrimaryKey(tmCustomerGroup);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmCustomerGroup(TmCustomerGroup tmCustomerGroup) {
		tmCustomerGroupDao.updateByPrimaryKeySelective(tmCustomerGroup);
	}
	
	public TmCustomerGroupDAO getTmCustomerGroupDao() {
		return tmCustomerGroupDao;
	}
	public void setTmCustomerGroupDao(TmCustomerGroupDAO tmCustomerGroupDao) {
		this.tmCustomerGroupDao = tmCustomerGroupDao;
	}


    @Override
    public int countByExample( TmCustomerGroup tmCustomerGroup ) {
        //构造Criteria
        TmCustomerGroupExample example = new TmCustomerGroupExample();
        Criteria criteria = example.createCriteria();
        
        criteria.andIsDelEqualTo( "1" );
        
        return tmCustomerGroupDao.countByExample(example);
    }


    @Override
    public TmCustomerGroup queryById( Integer id ) throws Exception {
        return tmCustomerGroupDao.selectByPrimaryKey( id );
    }
}
