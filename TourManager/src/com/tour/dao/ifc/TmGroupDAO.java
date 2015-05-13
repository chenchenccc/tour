package com.tour.dao.ifc;

import com.tour.model.TmGroup;
import com.tour.model.TmGroupExample;
import java.util.List;

public interface TmGroupDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int countByExample( TmGroupExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByExample( TmGroupExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insert( TmGroup record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insertSelective( TmGroup record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    List selectByExample( TmGroupExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    TmGroup selectByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExampleSelective( TmGroup record, TmGroupExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExample( TmGroup record, TmGroupExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKeySelective( TmGroup record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_group
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKey( TmGroup record );
}