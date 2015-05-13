package com.tour.dao.impl;

import com.tour.dao.ifc.TmEmployeeDAO;
import com.tour.model.TmEmployee;
import com.tour.model.TmEmployeeExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TmEmployeeDAOImpl extends 
SqlMapClientDaoSupport implements TmEmployeeDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmEmployeeDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int countByExample( TmEmployeeExample example ) {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
                "tm_employee.ibatorgenerated_countByExample", example );
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByExample( TmEmployeeExample example ) {
        int rows = getSqlMapClientTemplate().delete( "tm_employee.ibatorgenerated_deleteByExample",
                example );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByPrimaryKey( Integer id ) {
        TmEmployee key = new TmEmployee();
        key.setId( id );
        int rows = getSqlMapClientTemplate().delete(
                "tm_employee.ibatorgenerated_deleteByPrimaryKey", key );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insert( TmEmployee record ) {
        getSqlMapClientTemplate().insert( "tm_employee.ibatorgenerated_insert", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insertSelective( TmEmployee record ) {
        getSqlMapClientTemplate().insert( "tm_employee.ibatorgenerated_insertSelective", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public List selectByExample( TmEmployeeExample example ) {
        List list = getSqlMapClientTemplate().queryForList(
                "tm_employee.ibatorgenerated_selectByExample", example );
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmEmployee selectByPrimaryKey( Integer id ) {
        TmEmployee key = new TmEmployee();
        key.setId( id );
        TmEmployee record = (TmEmployee) getSqlMapClientTemplate().queryForObject(
                "tm_employee.ibatorgenerated_selectByPrimaryKey", key );
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExampleSelective( TmEmployee record, TmEmployeeExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update(
                "tm_employee.ibatorgenerated_updateByExampleSelective", parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExample( TmEmployee record, TmEmployeeExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update( "tm_employee.ibatorgenerated_updateByExample",
                parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKeySelective( TmEmployee record ) {
        int rows = getSqlMapClientTemplate().update(
                "tm_employee.ibatorgenerated_updateByPrimaryKeySelective", record );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKey( TmEmployee record ) {
        int rows = getSqlMapClientTemplate().update(
                "tm_employee.ibatorgenerated_updateByPrimaryKey", record );
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table tm_employee
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    private static class UpdateByExampleParms extends TmEmployeeExample {
        
        private Object record;
        
        public UpdateByExampleParms( Object record, TmEmployeeExample example ) {
            super( example );
            this.record = record;
        }
        
        public Object getRecord() {
            return record;
        }
    }
}