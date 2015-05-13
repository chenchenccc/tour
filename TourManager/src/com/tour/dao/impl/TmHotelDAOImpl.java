package com.tour.dao.impl;

import com.tour.dao.ifc.TmHotelDAO;
import com.tour.model.TmHotel;
import com.tour.model.TmHotelExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TmHotelDAOImpl extends 
SqlMapClientDaoSupport implements TmHotelDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmHotelDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int countByExample( TmHotelExample example ) {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
                "tm_hotel.ibatorgenerated_countByExample", example );
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByExample( TmHotelExample example ) {
        int rows = getSqlMapClientTemplate().delete( "tm_hotel.ibatorgenerated_deleteByExample",
                example );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int deleteByPrimaryKey( Integer id ) {
        TmHotel key = new TmHotel();
        key.setId( id );
        int rows = getSqlMapClientTemplate().delete( "tm_hotel.ibatorgenerated_deleteByPrimaryKey",
                key );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insert( TmHotel record ) {
        getSqlMapClientTemplate().insert( "tm_hotel.ibatorgenerated_insert", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public void insertSelective( TmHotel record ) {
        getSqlMapClientTemplate().insert( "tm_hotel.ibatorgenerated_insertSelective", record );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public List selectByExample( TmHotelExample example ) {
        List list = getSqlMapClientTemplate().queryForList(
                "tm_hotel.ibatorgenerated_selectByExample", example );
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public TmHotel selectByPrimaryKey( Integer id ) {
        TmHotel key = new TmHotel();
        key.setId( id );
        TmHotel record = (TmHotel) getSqlMapClientTemplate().queryForObject(
                "tm_hotel.ibatorgenerated_selectByPrimaryKey", key );
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExampleSelective( TmHotel record, TmHotelExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update(
                "tm_hotel.ibatorgenerated_updateByExampleSelective", parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByExample( TmHotel record, TmHotelExample example ) {
        UpdateByExampleParms parms = new UpdateByExampleParms( record, example );
        int rows = getSqlMapClientTemplate().update( "tm_hotel.ibatorgenerated_updateByExample",
                parms );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKeySelective( TmHotel record ) {
        int rows = getSqlMapClientTemplate().update(
                "tm_hotel.ibatorgenerated_updateByPrimaryKeySelective", record );
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    public int updateByPrimaryKey( TmHotel record ) {
        int rows = getSqlMapClientTemplate().update( "tm_hotel.ibatorgenerated_updateByPrimaryKey",
                record );
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    private static class UpdateByExampleParms extends TmHotelExample {
        
        private Object record;
        
        public UpdateByExampleParms( Object record, TmHotelExample example ) {
            super( example );
            this.record = record;
        }
        
        public Object getRecord() {
            return record;
        }
    }
}