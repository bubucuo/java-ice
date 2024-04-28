package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dev", "root", "111111");

            // 创建查询语句
            stmt = conn.createStatement();

//            stmt.execute("INSERT INTO user (username, age, code, address, phone) VALUES ('高少云', '20', '1234567890', '110', '114')");

            // update
//            stmt.executeUpdate("UPDATE user set username='高少云2' WHERE username = '高少云'");

            // delete
//            stmt.executeUpdate("DELETE FROM user WHERE id = 高少云2");

            // Read
            // 倒序
            rs = stmt.executeQuery("SELECT * FROM user order by id desc limit 10");

            // 1. 处理查询结果
            while (rs.next()) {
                // 读取数据并进行处理
                int id = rs.getInt("id");
                String name = rs.getString("username");
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
