/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tictoc
 */
public class ConnectionUtil {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/library";
    private String user = "root";
    private String pass = "Zdvhm#2589";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
      Class.forName(driver);
      Connection conn= DriverManager.getConnection(url, user, pass);
      conn.setAutoCommit(false);
      return conn;
    }
    
}
