package com.tour.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.dao.ifc.SmAuthoDAO;
import com.tour.dao.ifc.SmRoleAuthoDAO;
import com.tour.dao.ifc.SmRoleDAO;
import com.tour.model.SmAutho;
import com.tour.model.SmRole;
import com.tour.model.SmRoleAutho;
import com.tour.model.SmRoleAuthoExample;
import com.tour.model.SmRoleExample;
import com.tour.model.SmRoleExample.Criteria;
import com.tour.service.ifc.SmRoleServiceIFC;

public class SmRoleServiceImpl implements SmRoleServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private SmRoleDAO smRoleDao;
	private SmRoleAuthoDAO smRoleAuthoDao;
	private SmAuthoDAO smAuthoDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<SmRole> querySmRole4List(HttpServletRequest request, SmRole smRole) {
		//构造Criteria
		SmRoleExample example = new SmRoleExample();
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
		return smRoleDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public SmRole querySmRole4Bean(SmRole smRole) {
		SmRole _smRole = null;
		//构造Criteria
		SmRoleExample example = new SmRoleExample();
		Criteria criteria = example.createCriteria();
	
		List<SmRole> list= smRoleDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_smRole = list.get(0);
		}
	return _smRole;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSmRole(SmRole smRole) {
		smRoleDao.insert(smRole);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSmRole(SmRole smRole) {
		smRoleDao.updateByPrimaryKey(smRole);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSmRole(SmRole smRole) {
		smRoleDao.updateByPrimaryKeySelective(smRole);
	}
	
	public SmRoleDAO getSmRoleDao() {
		return smRoleDao;
	}
	public void setSmRoleDao(SmRoleDAO smRoleDao) {
		this.smRoleDao = smRoleDao;
	}
    
    public SmRoleAuthoDAO getSmRoleAuthoDao() {
        return smRoleAuthoDao;
    }

    public void setSmRoleAuthoDao( SmRoleAuthoDAO smRoleAuthoDao ) {
        this.smRoleAuthoDao = smRoleAuthoDao;
    }
    
    public SmAuthoDAO getSmAuthoDao() {
        return smAuthoDao;
    }
    
    public void setSmAuthoDao( SmAuthoDAO smAuthoDao ) {
        this.smAuthoDao = smAuthoDao;
    }

    @Override
    public int countByExample( SmRole smRole ) {
        //构造Criteria
        SmRoleExample example = new SmRoleExample();
        Criteria criteria = example.createCriteria();
        
        criteria.andIsDelEqualTo( "1" );
        
        return smRoleDao.countByExample(example);
    }


    public List<SmAutho> getAuthoList( List<Integer> roleIds ) {
        if(roleIds == null || roleIds.size() == 0) {
            return null;
        }
        SmRoleAuthoExample example = new SmRoleAuthoExample();
        com.tour.model.SmRoleAuthoExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdIn( roleIds );
        
        List<SmRoleAutho> list = smRoleAuthoDao.selectByExample( example  );
        
        List<SmAutho> ret = new ArrayList<SmAutho>();
        for (SmRoleAutho ra : list) {
            ret.add( smAuthoDao.selectByPrimaryKey( ra.getAuthoId() ) );
        }
        return ret;
    }


    @Override
    public SmAutho queryById( Integer id ) {
        return smAuthoDao.selectByPrimaryKey( id );
    }
}
