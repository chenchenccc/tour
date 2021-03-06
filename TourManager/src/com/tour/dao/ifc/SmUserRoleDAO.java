package com.tour.dao.ifc;

import com.tour.model.SmUserRole;
import com.tour.model.SmUserRoleExample;
import java.util.List;

public interface SmUserRoleDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int countByExample( SmUserRoleExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByExample( SmUserRoleExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int deleteByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insert( SmUserRole record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    void insertSelective( SmUserRole record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    List selectByExample( SmUserRoleExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    SmUserRole selectByPrimaryKey( Integer id );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExampleSelective( SmUserRole record, SmUserRoleExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByExample( SmUserRole record, SmUserRoleExample example );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKeySelective( SmUserRole record );

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table sm_user_role
     * @ibatorgenerated  Wed May 13 14:51:35 CST 2015
     */
    int updateByPrimaryKey( SmUserRole record );
}