package com.tour.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.dao.ifc.SmRoleDAO;
import com.tour.dao.ifc.SmUserDAO;
import com.tour.dao.ifc.SmUserRoleDAO;
import com.tour.model.SmRole;
import com.tour.model.SmUser;
import com.tour.model.SmUserExample;
import com.tour.model.SmUserRole;
import com.tour.model.SmUserRoleExample;
import com.tour.model.SmUserExample.Criteria;
import com.tour.service.ifc.SmUserServiceIFC;

public class SmUserServiceImpl implements SmUserServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private SmUserDAO smUserDao;
	
	private SmUserRoleDAO smUserRoleDao;
	
	private SmRoleDAO SmRoleDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<SmUser> querySmUser4List(HttpServletRequest request, SmUser smUser) throws Exception {
		//构造Criteria
		SmUserExample example = new SmUserExample();
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
		return smUserDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public SmUser querySmUser4Bean(SmUser smUser) throws Exception {
		SmUser _smUser = null;
		//构造Criteria
		SmUserExample example = new SmUserExample();
		Criteria criteria = example.createCriteria();
	
		if(smUser != null && smUser.getCreateTime() != null) {
		    criteria.andCreateTimeEqualTo( smUser.getCreateTime() );
		}
		if(smUser != null && smUser.getRealName() != null) {
            criteria.andRealNameEqualTo( smUser.getRealName() );
        }
		if(smUser != null && smUser.getIsAdmin() != null) {
            criteria.andIsAdminEqualTo( smUser.getIsAdmin() );
        }
		List<SmUser> list= smUserDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_smUser = list.get(0);
		}
	return _smUser;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSmUser(SmUser smUser) throws Exception {
		smUserDao.insert(smUser);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSmUser(SmUser smUser) throws Exception {
		smUserDao.updateByPrimaryKey(smUser);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSmUser(SmUser smUser) throws Exception {
		smUserDao.updateByPrimaryKeySelective(smUser);
	}
	
	public SmUserDAO getSmUserDao() {
		return smUserDao;
	}
	public void setSmUserDao(SmUserDAO smUserDao) {
		this.smUserDao = smUserDao;
	}
	
    public SmUserRoleDAO getSmUserRoleDao() {
        return smUserRoleDao;
    }

    public void setSmUserRoleDao( SmUserRoleDAO smUserRoleDao ) {
        this.smUserRoleDao = smUserRoleDao;
    }

    public SmRoleDAO getSmRoleDao() {
        return SmRoleDao;
    }

    public void setSmRoleDao( SmRoleDAO smRoleDao ) {
        SmRoleDao = smRoleDao;
    }

    public int countByExample( SmUser smUser ) throws Exception {
        //构造Criteria
        SmUserExample example = new SmUserExample();
        Criteria criteria = example.createCriteria();
        
        criteria.andIsDelEqualTo( "1" );
        
        return smUserDao.countByExample(example);
    }

    public SmUser checkUsername( String username ) throws Exception {
        //构造Criteria
        SmUserExample example = new SmUserExample();
        Criteria criteria = example.createCriteria();
        criteria.andLoginNameEqualTo( username );
        List list = smUserDao.selectByExample( example );
        if(list != null && list.size() > 0) {
            return (SmUser) list.get( 0 );
        }
        return null;
    }

    public List<SmRole> getRoleList( Integer userId ) throws Exception {
        List<SmRole> ret = new ArrayList<SmRole>(); 
        try {
            SmUserRoleExample example = new SmUserRoleExample();
            com.tour.model.SmUserRoleExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo( userId );
            List<SmUserRole> userRoleList = smUserRoleDao.selectByExample( example  );
            
            if( userRoleList != null && userRoleList.size() > 0 ) {
                for (SmUserRole ur : userRoleList) {
                    SmRole i = SmRoleDao.selectByPrimaryKey( ur.getRoleId() );
                    ret.add( i );
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ret;
    }

    @Override
    public void updataPassword( SmUser smUser ) {
        smUserDao.updateByPrimaryKey( smUser );
    }


    @Override
    public SmUser queryById( Integer id ) throws Exception {
        return smUserDao.selectByPrimaryKey( id );
    }
}
