package com.spring.jdbc;

import java.sql.*;

/**
 * 数据库连接管理
 * Created by admin on 2018/8/23.
 */
public class ConnectionUtils {

    /**
     * 默认mysql 驱动
     */
    static String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * 默认url
     */
    static String URL = "jdbc:mysql://localhost:3306/env_protection";
    /**
     * 默认username
     */
    static String USER = "root";
    /**
     * 默认password
     */
    static String PASSWORD = "123456";

    /**
     * 获取默认数据库连接
     * @return
     */
    public static Connection getConnection(){
       return getConnection(DRIVER,URL,USER,PASSWORD);
    }

    public static  Connection getConnection(String driver){
        return getConnection(driver,URL,USER,PASSWORD);
    }

    public static  Connection getConnection(String driver,String url){
        return getConnection(driver,url,USER,PASSWORD);
    }

    /**
     * 连接数据库
     * @param driver
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static Connection getConnection(String driver,String url, String username,String password){
        Connection con;
        try{
            //加载驱动程序
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            if(!con.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
            }
            return con;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 关闭连接
     * @param con
     */
    public static void close(Connection con){
        close(con,null,null);
    }

    /**
     * 关闭连接
     * @param con
     */
    public static void close(Connection con, PreparedStatement prep){
        close(con,prep,null);
    }

    /**
     * 关闭连接
     * @param con
     * @param prep
     * @param rs
     */
    public static void close(Connection con, PreparedStatement prep, ResultSet rs){
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                rs = null;
            }
        }

        if(null != prep){
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                prep = null;
            }
        }

        if(null != con){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                con = null;
            }
        }
    }

}
