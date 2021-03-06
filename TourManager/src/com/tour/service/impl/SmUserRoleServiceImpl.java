package com.tour.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.dao.ifc.SmUserRoleDAO;
import com.tour.model.SmUserRole;
import com.tour.model.SmUserRoleExample;
import com.tour.model.SmUserRole;
import com.tour.model.SmUserRoleExample;
import com.tour.model.SmUserRoleExample.Criteria;
import com.tour.service.ifc.SmUserRoleServiceIFC;

public class SmUserRoleServiceImpl implements SmUserRoleServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private SmUserRoleDAO smUserRoleDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<SmUserRole> querySmUserRole4List(HttpServletRequest request, SmUserRole smUserRole) {
		//构造Criteria
		SmUserRoleExample example = new SmUserRoleExample();
		Criteria criteria = example.createCriteria();

        try {
            if(null != request.getParameter("rows") && null != request.getParameter("page")) {
                int limit = Integer.parseInt(request.getParameter("rows"));
                int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
                example.setLimitStart(start);
                example.setLimitEnd(limit);
            }
            
            if(smUserRole !=null && smUserRole.getUserId()!=null) {
                criteria.andUserIdEqualTo( smUserRole.getUserId() );
            }
            if(smUserRole !=null && smUserRole.getRoleId()!=null) {
                criteria.andRoleIdEqualTo( smUserRole.getRoleId() );
            }
            criteria = criteria.andIsDelEqualTo( "1" );
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return smUserRoleDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public SmUserRole querySmUserRole4Bean(SmUserRole smUserRole) {
		SmUserRole _smUserRole = null;
		//构造Criteria
		SmUserRoleExample example = new SmUserRoleExample();
		Criteria criteria = example.createCriteria();
		
		if(smUserRole != null && smUserRole.getUserId()!= null) {
		    criteria.andUserIdEqualTo( smUserRole.getUserId() );
		}
		if(smUserRole!=null && smUserRole.getRoleId()!= null) {
		    criteria.andRoleIdEqualTo( smUserRole.getRoleId() );
		}
		if(smUserRole!=null && smUserRole.getIsDel()!= null) {
            criteria.andIsDelEqualTo( smUserRole.getIsDel() );
        }
		List<SmUserRole> list= smUserRoleDao.selectByExample(example);
		if(list != null && list.size() > 0){
			_smUserRole = list.get(0);
		}
	return _smUserRole;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSmUserRole(SmUserRole smUserRole) {
		smUserRoleDao.insert(smUserRole);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSmUserRole(SmUserRole smUserRole) {
		smUserRoleDao.updateByPrimaryKey(smUserRole);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSmUserRole(SmUserRole smUserRole) {
	    SmUserRoleExample example = new SmUserRoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo( smUserRole.getUserId() );
        criteria.andRoleIdEqualTo( smUserRole.getRoleId() );
        criteria.andIsDelEqualTo( "1" );
        List list = smUserRoleDao.selectByExample( example );
        if(list != null && list.size()> 0) {
            SmUserRole record = (SmUserRole) list.get( 0 );
            smUserRole.setId( record.getId() );
            smUserRoleDao.updateByPrimaryKeySelective(smUserRole);
        }
	}
	
	public SmUserRoleDAO getSmUserRoleDao() {
		return smUserRoleDao;
	}
	public void setSmUserRoleDao(SmUserRoleDAO smUserRoleDao) {
		this.smUserRoleDao = smUserRoleDao;
	}


    @Override
    public int countByExample( SmUserRole smUserRole ) {
        //构造Criteria
        SmUserRoleExample example = new SmUserRoleExample();
        Criteria criteria = example.createCriteria();
        
        criteria.andIsDelEqualTo( "1" );
        
        return smUserRoleDao.countByExample(example);
    }


    @Override
    public SmUserRole queryById( Integer id ) {
        return smUserRoleDao.selectByPrimaryKey( id );
    }
}
