package com.freedom.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author tobebetter9527
 * @description jdbc测试类
 * @create 2020/04/13 22:17
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/mybatisdemo";
            String user = "root";
            String password = "258369";
            conn = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql = "select * from tb_user where id=?";
            ps = conn.prepareStatement(sql);
            // 设置参数
            ps.setLong(1, 1L);
            // 执行查询，获取结果集
            rs = ps.executeQuery();
            // 处理结果集
            while (rs.next()) {
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
        } finally {
            // 关闭连接，释放资源
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
