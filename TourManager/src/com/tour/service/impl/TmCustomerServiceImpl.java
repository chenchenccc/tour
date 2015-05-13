package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.TmCustomerDAO;
import com.tour.model.TmCustomer;
import com.tour.model.TmCustomerExample;
import com.tour.model.TmCustomerExample.Criteria;
import com.tour.service.ifc.TmCustomerServiceIFC;

public class TmCustomerServiceImpl implements TmCustomerServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmCustomerDAO tmCustomerDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmCustomer> queryTmCustomer4List(HttpServletRequest request, TmCustomer tmCustomer) {
		//构造Criteria
		TmCustomerExample example = new TmCustomerExample();
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
		return tmCustomerDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmCustomer queryTmCustomer4Bean(TmCustomer tmCustomer) {
		TmCustomer _tmCustomer = null;
		//构造Criteria
		TmCustomerExample example = new TmCustomerExample();
		Criteria criteria = example.createCriteria();
	
		List<TmCustomer> list= tmCustomerDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmCustomer = list.get(0);
		}
	return _tmCustomer;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmCustomer(TmCustomer tmCustomer) {
		tmCustomerDao.insert(tmCustomer);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmCustomer(TmCustomer tmCustomer) {
		tmCustomerDao.updateByPrimaryKey(tmCustomer);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmCustomer(TmCustomer tmCustomer) {
		tmCustomerDao.updateByPrimaryKeySelective(tmCustomer);
	}
	
	public TmCustomerDAO getTmCustomerDao() {
		return tmCustomerDao;
	}
	public void setTmCustomerDao(TmCustomerDAO tmCustomerDao) {
		this.tmCustomerDao = tmCustomerDao;
	}


    @Override
    public int countByExample( TmCustomer tmCustomer ) {
        // TODO Auto-generated method stub
        return 0;
    }
}
