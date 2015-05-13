package com.tour.dao.ifc;

import com.tour.model.TmDetail;
import com.tour.model.TmDetailExample;
import java.util.List;

public interface TmDetailDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int countByExample( TmDetailExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByExample( TmDetailExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insert( TmDetail record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insertSelective( TmDetail record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    List selectByExample( TmDetailExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    TmDetail selectByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExampleSelective( TmDetail record, TmDetailExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExample( TmDetail record, TmDetailExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKeySelective( TmDetail record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_detail
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKey( TmDetail record );
}