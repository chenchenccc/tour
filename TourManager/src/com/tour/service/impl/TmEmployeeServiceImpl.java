package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.dao.ifc.TmEmployeeDAO;
import com.tour.model.TmEmployee;
import com.tour.model.TmEmployeeExample;
import com.tour.model.TmEmployeeExample.Criteria;
import com.tour.service.ifc.TmEmployeeServiceIFC;

public class TmEmployeeServiceImpl implements TmEmployeeServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmEmployeeDAO tmEmployeeDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmEmployee> queryTmEmployee4List(HttpServletRequest request, TmEmployee tmEmployee) {
		//构造Criteria
		TmEmployeeExample example = new TmEmployeeExample();
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
		return tmEmployeeDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmEmployee queryTmEmployee4Bean(TmEmployee tmEmployee) {
		TmEmployee _tmEmployee = null;
		//构造Criteria
		TmEmployeeExample example = new TmEmployeeExample();
		Criteria criteria = example.createCriteria();
	
		List<TmEmployee> list= tmEmployeeDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmEmployee = list.get(0);
		}
	return _tmEmployee;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmEmployee(TmEmployee tmEmployee) {
		tmEmployeeDao.insert(tmEmployee);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmEmployee(TmEmployee tmEmployee) {
		tmEmployeeDao.updateByPrimaryKey(tmEmployee);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmEmployee(TmEmployee tmEmployee) {
		tmEmployeeDao.updateByPrimaryKeySelective(tmEmployee);
	}
	
	public TmEmployeeDAO getTmEmployeeDao() {
		return tmEmployeeDao;
	}
	public void setTmEmployeeDao(TmEmployeeDAO tmEmployeeDao) {
		this.tmEmployeeDao = tmEmployeeDao;
	}

    public int countByExample( TmEmployee tmEmployee ) {
        //构造Criteria
        TmEmployeeExample example = new TmEmployeeExample();
        Criteria criteria = example.createCriteria();
        
        criteria.andIsDelEqualTo( "1" );
        
        return tmEmployeeDao.countByExample(example);
    }
}
