///**  
//* @Project: WISP_MGR_2.0
//* @Title: TransactionManager.java
//* @Package com.rj.commons.utils
//* @Description: TODO
//* @author ������ mshin@qq.com  
//* @date 2012-2-2 ����01:28:07
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
// * @Description: �������
// * @author ������ mshin@qq.com  
// * @date 2012-2-2 ����01:28:07 
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
//    * @Description: ��ȡ��ǰ����
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
//    * @Description: ��������
//    * @param @throws DAOException     
//    * @return void    
//    * @throws
//     */
//    public void beginTransaction() throws DAOException{  
//        try {  
//            conn.setAutoCommit(false);  //�������ύ��ʽ��Ϊ�ֹ��ύ  
//        } catch (SQLException e) {  
//            throw new DAOException("��������ʱ�����쳣",e);  
//        }  
//    }  
//      
//    /**
//     * 
//    * @Title: commitAndClose 
//    * @Description: �ύ���񲢹ر����� 
//    * @param @throws DAOException     
//    * @return void    
//    * @throws
//     */
//    public void commitAndClose() throws DAOException{  
//        try {  
//            conn.commit(); //�ύ����  
//        } catch (SQLException e) {  
//            throw new DAOException("�ύ����ʱ�����쳣",e);  
//        }finally{  
//            DBUtils.close(conn);  
//        }  
//    }  
//      
//    /**
//     * 
//    * @Title: rollbackAndClose 
//    * @Description: �ع����ر�����
//    * @param @throws DAOException     
//    * @return void    
//    * @throws
//     */
//    public void rollbackAndClose()throws DAOException{  
//        try {  
//            conn.rollback();  
//        } catch (SQLException e) {  
//            throw new DAOException("�ع�����ʱ�����쳣",e);  
//        }finally{  
//        	DBUtils.close(conn);  
//        }  
//    }  
// }
