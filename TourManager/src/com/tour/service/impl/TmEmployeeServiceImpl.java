package com.tour.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tour.dao.ifc.TmDepartmentDAO;
import com.tour.dao.ifc.TmEmployeeDAO;
import com.tour.model.TmDepartment;
import com.tour.model.TmEmployee;
import com.tour.model.TmEmployeeExample;
import com.tour.model.TmEmployeeExample.Criteria;
import com.tour.service.ifc.TmEmployeeServiceIFC;

public class TmEmployeeServiceImpl implements TmEmployeeServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private TmEmployeeDAO tmEmployeeDao;
	private TmDepartmentDAO tmDepartmentDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<TmEmployee> queryTmEmployee4List(HttpServletRequest request, TmEmployee tmEmployee) {
		//构造Criteria
		TmEmployeeExample example = new TmEmployeeExample();
		Criteria criteria = example.createCriteria();
		List<TmEmployee> ret = new ArrayList<TmEmployee>();
        try {
            if(null != request.getParameter("rows") && null != request.getParameter("page")) {
                int limit = Integer.parseInt(request.getParameter("rows"));
                int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
                example.setLimitStart(start);
                example.setLimitEnd(limit);
            }
            
            criteria = criteria.andIsDelEqualTo( "1" );
            
            if(tmEmployee != null && tmEmployee.getRealName() != null) {
                criteria.andRealNameLike( "%" + tmEmployee.getRealName() + "%" );
            }
            if(tmEmployee != null && tmEmployee.getEmployeeNum() != null) {
                criteria.andEmployeeNumLike( "%" + tmEmployee.getEmployeeNum() + "%" );
            }
            if(tmEmployee != null && tmEmployee.getIsGuider() != null) {
                criteria.andIsGuiderEqualTo( tmEmployee.getIsGuider() );
            }
            
            // 获取关联部门
            List<TmEmployee> list = tmEmployeeDao.selectByExample(example);
            
            for (TmEmployee e : list) {
                if(e == null || e.getDeptId() == null) {
                    ret.add( e );
                    continue;
                }
                TmDepartment d = tmDepartmentDao.selectByPrimaryKey( e.getDeptId() );
                e.setDeptName( d.getDeptName() );
                ret.add( e );
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     
        
		return ret;
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


    
    public TmDepartmentDAO getTmDepartmentDao() {
        return tmDepartmentDao;
    }

    public void setTmDepartmentDao( TmDepartmentDAO tmDepartmentDao ) {
        this.tmDepartmentDao = tmDepartmentDao;
    }

    public TmEmployee queryById( Integer id ) {
        return tmEmployeeDao.selectByPrimaryKey( id );
    }
}
