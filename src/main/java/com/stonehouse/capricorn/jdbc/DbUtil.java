package com.stonehouse.capricorn.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class DbUtil {
    /**
     * 加载数据库配置
     */
    private static ResourceBundle resource = ResourceBundle.getBundle("db");

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        String url = resource.getString("url");
        String driver = resource.getString("driverClassName");
        String username = resource.getString("username");
        String password = resource.getString("password");

        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 关闭数据库资源
     * @param connection
     * @param pstmt
     * @param rs
     */
    public static void close(Connection connection, PreparedStatement pstmt, ResultSet rs){
        // 异常分开处理，否则一个资源关闭出错之后其他资源则不能关闭
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Dao dao = new Dao();
        boolean result = dao.insert("insert into province values(?,?)","11","北京市");
        System.out.println(result);
    }
}
