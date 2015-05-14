package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.dao.ifc.TmDetailDAO;
import com.tour.model.TmDetail;
import com.tour.model.TmDetailExample;
import com.tour.model.TmDetailExample.Criteria;
import com.tour.service.ifc.TmDetailServiceIFC;

public class TmDetailServiceImpl implements TmDetailServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmDetailDAO tmDetailDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmDetail> queryTmDetail4List(HttpServletRequest request, TmDetail tmDetail) {
		//构造Criteria
		TmDetailExample example = new TmDetailExample();
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
		return tmDetailDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmDetail queryTmDetail4Bean(TmDetail tmDetail) {
		TmDetail _tmDetail = null;
		//构造Criteria
		TmDetailExample example = new TmDetailExample();
		Criteria criteria = example.createCriteria();
	
		List<TmDetail> list= tmDetailDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmDetail = list.get(0);
		}
	return _tmDetail;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmDetail(TmDetail tmDetail) {
		tmDetailDao.insert(tmDetail);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmDetail(TmDetail tmDetail) {
		tmDetailDao.updateByPrimaryKey(tmDetail);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmDetail(TmDetail tmDetail) {
		tmDetailDao.updateByPrimaryKeySelective(tmDetail);
	}
	
	public TmDetailDAO getTmDetailDao() {
		return tmDetailDao;
	}
	public void setTmDetailDao(TmDetailDAO tmDetailDao) {
		this.tmDetailDao = tmDetailDao;
	}


    @Override
    public int countByExample( TmDetail tmDetail ) {
        //构造Criteria
        TmDetailExample example = new TmDetailExample();
        Criteria criteria = example.createCriteria();
        
        criteria.andIsDelEqualTo( "1" );
        
        return tmDetailDao.countByExample(example);
    }
}
