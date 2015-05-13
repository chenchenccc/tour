package com.tour.dao.ifc;

import com.tour.model.TmHotel;
import com.tour.model.TmHotelExample;
import java.util.List;

public interface TmHotelDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int countByExample( TmHotelExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByExample( TmHotelExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insert( TmHotel record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insertSelective( TmHotel record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    List selectByExample( TmHotelExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    TmHotel selectByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExampleSelective( TmHotel record, TmHotelExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExample( TmHotel record, TmHotelExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKeySelective( TmHotel record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_hotel
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKey( TmHotel record );
}