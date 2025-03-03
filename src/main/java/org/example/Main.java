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
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/dev2", "root", "111111");

            stmt = conn.createStatement();

            // Read
            rs = stmt.executeQuery("SELECT * FROM grades");
            // sum of grade
            double totalGrade = 0;
            // count of grade
            int gradeCount = 0;

            // 1. query result
            while (rs.next()) {
                // read data and display
                int id = rs.getInt("id");
                String courseName = rs.getString("courseName");
                String gradeName = rs.getString("gradeName");
                String grade = rs.getString("grade");
                System.out.println("ID: " + id + "," + courseName + "," + gradeName + "," + grade);
                totalGrade += Double.parseDouble(grade);
                gradeCount++;
            }

            // average of grade
            if (gradeCount > 0) {
                double averageGrade = totalGrade / gradeCount;
                System.out.println("Grade Average: " + averageGrade);
            } else {
                System.out.println("No grade found");
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