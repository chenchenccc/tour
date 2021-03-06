package com.tour.dao.ifc;

import com.tour.model.SmUser;
import com.tour.model.SmUserExample;
import java.util.List;

public interface SmUserDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int countByExample( SmUserExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByExample( SmUserExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insert( SmUser record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insertSelective( SmUser record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    List selectByExample( SmUserExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    SmUser selectByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExampleSelective( SmUser record, SmUserExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExample( SmUser record, SmUserExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKeySelective( SmUser record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKey( SmUser record );
}