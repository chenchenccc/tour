///**  
//* @Project: WISP_MGR_2.0
//* @Title: TransactionManager.java
//* @Package com.rj.commons.utils
//* @Description: TODO
//* @author 潘银达 mshin@qq.com  
//* @date 2012-2-2 下午01:28:07
//* @Copyright: 2012 www.rongji.com Inc. All rights reserved.
//* @version V2.0  
//*/
//
//package com.rj.commons.utils;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
///** 
// * @ClassName: TransactionManager 
// * @Description: 事务管理
// * @author 潘银达 mshin@qq.com  
// * @date 2012-2-2 下午01:28:07 
// *  
// */
//
//public class TransactionManager {
//	
//    private Connection conn;  
//    
//    protected TransactionManager(Connection conn) {  
//        this.conn = conn;  
//    }  
//    
//    /**
//     * 
//    * @Title: getConn 
//    * @Description: 获取当前连接
//    * @param @return     
//    * @return Connection    
//    * @throws
//     */
//    public Connection getConn(){
//    	return this.conn;
//    }
//      
//    /**
//     *   
//    * @Title: beginTransaction 
//    * @Description: 开启事务
//    * @param @throws DAOException     
//    * @return void    
//    * @throws
//     */
//    public void beginTransaction() throws DAOException{  
//        try {  
//            conn.setAutoCommit(false);  //把事务提交方式改为手工提交  
//        } catch (SQLException e) {  
//            throw new DAOException("开启事务时出现异常",e);  
//        }  
//    }  
//      
//    /**
//     * 
//    * @Title: commitAndClose 
//    * @Description: 提交事务并关闭连接 
//    * @param @throws DAOException     
//    * @return void    
//    * @throws
//     */
//    public void commitAndClose() throws DAOException{  
//        try {  
//            conn.commit(); //提交事务  
//        } catch (SQLException e) {  
//            throw new DAOException("提交事务时出现异常",e);  
//        }finally{  
//            DBUtils.close(conn);  
//        }  
//    }  
//      
//    /**
//     * 
//    * @Title: rollbackAndClose 
//    * @Description: 回滚并关闭连接
//    * @param @throws DAOException     
//    * @return void    
//    * @throws
//     */
//    public void rollbackAndClose()throws DAOException{  
//        try {  
//            conn.rollback();  
//        } catch (SQLException e) {  
//            throw new DAOException("回滚事务时出现异常",e);  
//        }finally{  
//        	DBUtils.close(conn);  
//        }  
//    }  
// }
