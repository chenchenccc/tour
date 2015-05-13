package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.TmInfoDAO;
import com.tour.model.TmInfo;
import com.tour.model.TmInfoExample;
import com.tour.model.TmInfoExample.Criteria;
import com.tour.service.ifc.TmInfoServiceIFC;

public class TmInfoServiceImpl implements TmInfoServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmInfoDAO tmInfoDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmInfo> queryTmInfo4List(HttpServletRequest request, TmInfo tmInfo) {
		//构造Criteria
		TmInfoExample example = new TmInfoExample();
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
		return tmInfoDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public TmInfo queryTmInfo4Bean(TmInfo tmInfo) {
		TmInfo _tmInfo = null;
		//构造Criteria
		TmInfoExample example = new TmInfoExample();
		Criteria criteria = example.createCriteria();
	
		List<TmInfo> list= tmInfoDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_tmInfo = list.get(0);
		}
	return _tmInfo;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddTmInfo(TmInfo tmInfo) {
		tmInfoDao.insert(tmInfo);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditTmInfo(TmInfo tmInfo) {
		tmInfoDao.updateByPrimaryKey(tmInfo);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delTmInfo(TmInfo tmInfo) {
		tmInfoDao.updateByPrimaryKeySelective(tmInfo);
	}
	
	public TmInfoDAO getTmInfoDao() {
		return tmInfoDao;
	}
	public void setTmInfoDao(TmInfoDAO tmInfoDao) {
		this.tmInfoDao = tmInfoDao;
	}


    @Override
    public int countByExample( TmInfo tmInfo ) {
        // TODO Auto-generated method stub
        return 0;
    }
}
