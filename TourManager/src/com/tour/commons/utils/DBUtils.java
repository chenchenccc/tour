package com.tour.commons.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 数据库工具类
 * 
 * @author chenrh
 * @date 2015-5-8
 */
public class DBUtils {
    
    private DBUtils() {
    };
    
    /**
     * jndi
     * 
     * @author chenrh
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup( "java:comp/env/jdbc/mysql" );
            conn = dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    
    /**
     * 关闭
     * 
     * @author chenrh
     * @param rs
     * @param pstmt
     * @param conn
     */
    public static void tryClose( ResultSet rs, PreparedStatement pstmt, Connection conn ) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
                rs = null;
            }
            if (pstmt != null && !pstmt.isClosed()) {
                pstmt.close();
                pstmt = null;
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
