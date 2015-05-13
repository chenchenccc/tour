package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.commons.global.PageBean;
import com.tour.dao.ifc.SmRoleAuthoDAO;
import com.tour.model.SmRoleAutho;
import com.tour.model.SmRoleAuthoExample;
import com.tour.model.SmRoleAuthoExample.Criteria;
import com.tour.service.ifc.SmRoleAuthoServiceIFC;

public class SmRoleAuthoServiceImpl implements SmRoleAuthoServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private SmRoleAuthoDAO smRoleAuthoDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<SmRoleAutho> querySmRoleAutho4List(HttpServletRequest request, SmRoleAutho smRoleAutho) {
		//构造Criteria
		SmRoleAuthoExample example = new SmRoleAuthoExample();
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
		return smRoleAuthoDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public SmRoleAutho querySmRoleAutho4Bean(SmRoleAutho smRoleAutho) {
		SmRoleAutho _smRoleAutho = null;
		//构造Criteria
		SmRoleAuthoExample example = new SmRoleAuthoExample();
		Criteria criteria = example.createCriteria();
	
		List<SmRoleAutho> list= smRoleAuthoDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_smRoleAutho = list.get(0);
		}
	return _smRoleAutho;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSmRoleAutho(SmRoleAutho smRoleAutho) {
		smRoleAuthoDao.insert(smRoleAutho);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSmRoleAutho(SmRoleAutho smRoleAutho) {
		smRoleAuthoDao.updateByPrimaryKey(smRoleAutho);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSmRoleAutho(SmRoleAutho smRoleAutho) {
		smRoleAuthoDao.updateByPrimaryKeySelective(smRoleAutho);
	}
	
	public SmRoleAuthoDAO getSmRoleAuthoDao() {
		return smRoleAuthoDao;
	}
	public void setSmRoleAuthoDao(SmRoleAuthoDAO smRoleAuthoDao) {
		this.smRoleAuthoDao = smRoleAuthoDao;
	}
}
