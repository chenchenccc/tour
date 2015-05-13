package com.tour.dao.impl;

import com.tour.dao.ifc.TmScheduleDAO;
import com.tour.model.TmSchedule;
import com.tour.model.TmScheduleExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TmScheduleDAOImpl extends 
SqlMapClientDaoSupport implements TmScheduleDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmScheduleDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int countByExample( TmScheduleExample example ) {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
                "tm_schedule.ibatorgenerated_countByExample", example );
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByExample( TmScheduleExample example ) {
        int rows = getSqlMapClientTemplate().delete( "tm_schedule.ibatorgenerated_deleteByExample",
                example );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByPrimaryKey( Integer id ) {
        TmSchedule key = new TmSchedule();
        key.setId( id );
        int rows = getSqlMapClientTemplate().delete(
                "tm_schedule.ibatorgenerated_deleteByPrimaryKey", key );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insert( TmSchedule record ) {
        getSqlMapClientTemplate().insert( "tm_schedule.ibatorgenerated_insert", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insertSelective( TmSchedule record ) {
        getSqlMapClientTemplate().insert( "tm_schedule.ibatorgenerated_insertSelective", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public List selectByExample( TmScheduleExample example ) {
        List list = getSqlMapClientTemplate().queryForList(
                "tm_schedule.ibatorgenerated_selectByExample", example );
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmSchedule selectByPrimaryKey( Integer id ) {
        TmSchedule key = new TmSchedule();
        key.setId( id );
        TmSchedule record = (TmSchedule) getSqlMapClientTemplate().queryForObject(
                "tm_schedule.ibatorgenerated_selectByPrimaryKey", key );
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExampleSelective( TmSchedule record, TmScheduleExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update(
                "tm_schedule.ibatorgenerated_updateByExampleSelective", parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExample( TmSchedule record, TmScheduleExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update( "tm_schedule.ibatorgenerated_updateByExample",
                parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKeySelective( TmSchedule record ) {
        int rows = getSqlMapClientTemplate().update(
                "tm_schedule.ibatorgenerated_updateByPrimaryKeySelective", record );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKey( TmSchedule record ) {
        int rows = getSqlMapClientTemplate().update(
                "tm_schedule.ibatorgenerated_updateByPrimaryKey", record );
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table tm_schedule
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    private static class UpdateByExampleParms extends TmScheduleExample {
        
        private Object record;
        
        public UpdateByExampleParms( Object record, TmScheduleExample example ) {
            super( example );
            this.record = record;
        }
        
        public Object getRecord() {
            return record;
        }
    }
}