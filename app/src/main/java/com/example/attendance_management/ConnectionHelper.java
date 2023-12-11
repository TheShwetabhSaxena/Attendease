package com.example.attendance_management;

import android.annotation.SuppressLint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {


   @SuppressLint("NewApi")
    public Connection connectionClass(){
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create the database connection URL
            String url = "jdbc:mysql://attend-ease.c4lcuoyrritk.ap-south-1.rds.amazonaws.com:3306/attendease";
            String username = "admin";
            String password = "ASS_attendease";

            // Create the connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

//    private Connection createConnection() {
//        Connection connection = null;
//        try {
//            // Load the MySQL JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            // Create the database connection URL
//            String url = "jdbc:mysql://attend-ease.c4lcuoyrritk.ap-south-1.rds.amazonaws.com:3306/attendease";
//            String username = "admin";
//            String password = "ASS_attendease";
//
//            // Create the connection
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }