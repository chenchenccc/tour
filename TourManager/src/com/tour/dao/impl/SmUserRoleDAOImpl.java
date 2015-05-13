package com.tour.dao.impl;

import com.tour.dao.ifc.SmUserRoleDAO;
import com.tour.model.SmUserRole;
import com.tour.model.SmUserRoleExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class SmUserRoleDAOImpl extends 
SqlMapClientDaoSupport implements SmUserRoleDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public SmUserRoleDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int countByExample( SmUserRoleExample example ) {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
                "sm_user_role.ibatorgenerated_countByExample", example );
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByExample( SmUserRoleExample example ) {
        int rows = getSqlMapClientTemplate().delete(
                "sm_user_role.ibatorgenerated_deleteByExample", example );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByPrimaryKey( Integer id ) {
        SmUserRole key = new SmUserRole();
        key.setId( id );
        int rows = getSqlMapClientTemplate().delete(
                "sm_user_role.ibatorgenerated_deleteByPrimaryKey", key );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insert( SmUserRole record ) {
        getSqlMapClientTemplate().insert( "sm_user_role.ibatorgenerated_insert", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insertSelective( SmUserRole record ) {
        getSqlMapClientTemplate().insert( "sm_user_role.ibatorgenerated_insertSelective", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public List selectByExample( SmUserRoleExample example ) {
        List list = getSqlMapClientTemplate().queryForList(
                "sm_user_role.ibatorgenerated_selectByExample", example );
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public SmUserRole selectByPrimaryKey( Integer id ) {
        SmUserRole key = new SmUserRole();
        key.setId( id );
        SmUserRole record = (SmUserRole) getSqlMapClientTemplate().queryForObject(
                "sm_user_role.ibatorgenerated_selectByPrimaryKey", key );
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExampleSelective( SmUserRole record, SmUserRoleExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update(
                "sm_user_role.ibatorgenerated_updateByExampleSelective", parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExample( SmUserRole record, SmUserRoleExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update(
                "sm_user_role.ibatorgenerated_updateByExample", parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKeySelective( SmUserRole record ) {
        int rows = getSqlMapClientTemplate().update(
                "sm_user_role.ibatorgenerated_updateByPrimaryKeySelective", record );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKey( SmUserRole record ) {
        int rows = getSqlMapClientTemplate().update(
                "sm_user_role.ibatorgenerated_updateByPrimaryKey", record );
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    private static class UpdateByExampleParms extends SmUserRoleExample {
        
        private Object record;
        
        public UpdateByExampleParms( Object record, SmUserRoleExample example ) {
            super( example );
            this.record = record;
        }
        
        public Object getRecord() {
            return record;
        }
    }
}