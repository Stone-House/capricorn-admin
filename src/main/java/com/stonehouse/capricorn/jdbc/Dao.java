package com.stonehouse.capricorn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Libin
 */
public class Dao {
    public boolean insert(String sql, String... params){
        boolean result = false;
        Connection conn = DbUtil.getConnection();
        PreparedStatement pstmt = null;
        int index = 1;
        try {
            pstmt = conn.prepareStatement(sql);

            for(String param: params) {
                pstmt.setString(index++, param);
            }
            result = pstmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn, pstmt, null);
        }
        return result;
    }

    public List<Map<String,Object>> query(){
        return null;
    }

}

