package com.tour.dao.impl;

import com.tour.dao.ifc.TmInfoDAO;
import com.tour.model.TmInfo;
import com.tour.model.TmInfoExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TmInfoDAOImpl extends 
SqlMapClientDaoSupport implements TmInfoDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmInfoDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int countByExample( TmInfoExample example ) {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
                "tm_info.ibatorgenerated_countByExample", example );
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByExample( TmInfoExample example ) {
        int rows = getSqlMapClientTemplate().delete( "tm_info.ibatorgenerated_deleteByExample",
                example );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByPrimaryKey( Integer id ) {
        TmInfo key = new TmInfo();
        key.setId( id );
        int rows = getSqlMapClientTemplate().delete( "tm_info.ibatorgenerated_deleteByPrimaryKey",
                key );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insert( TmInfo record ) {
        getSqlMapClientTemplate().insert( "tm_info.ibatorgenerated_insert", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insertSelective( TmInfo record ) {
        getSqlMapClientTemplate().insert( "tm_info.ibatorgenerated_insertSelective", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public List selectByExample( TmInfoExample example ) {
        List list = getSqlMapClientTemplate().queryForList(
                "tm_info.ibatorgenerated_selectByExample", example );
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmInfo selectByPrimaryKey( Integer id ) {
        TmInfo key = new TmInfo();
        key.setId( id );
        TmInfo record = (TmInfo) getSqlMapClientTemplate().queryForObject(
                "tm_info.ibatorgenerated_selectByPrimaryKey", key );
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExampleSelective( TmInfo record, TmInfoExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update(
                "tm_info.ibatorgenerated_updateByExampleSelective", parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExample( TmInfo record, TmInfoExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update( "tm_info.ibatorgenerated_updateByExample",
                parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKeySelective( TmInfo record ) {
        int rows = getSqlMapClientTemplate().update(
                "tm_info.ibatorgenerated_updateByPrimaryKeySelective", record );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKey( TmInfo record ) {
        int rows = getSqlMapClientTemplate().update( "tm_info.ibatorgenerated_updateByPrimaryKey",
                record );
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table tm_info
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    private static class UpdateByExampleParms extends TmInfoExample {
        
        private Object record;
        
        public UpdateByExampleParms( Object record, TmInfoExample example ) {
            super( example );
            this.record = record;
        }
        
        public Object getRecord() {
            return record;
        }
    }
}