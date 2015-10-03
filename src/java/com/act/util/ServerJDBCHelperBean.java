/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.act.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iftikhar.Khan
 */
public class ServerJDBCHelperBean {
   private static String SERVER_URL = "jdbc:mysql://localhost:3307/bb2_default";
   private static String DEFAULT_DB = "bb2_default";
   private static String USER = "root";
   private static String PASSWORD = "root";
   
   private Connection connection;
   private Statement statement;
   
   public ServerJDBCHelperBean () {
       initConnection();
       createStatement();
   }
   
   public ResultSet executeSelectQuery(String query) {
       
       if (statement != null) {
           try {
               return statement.executeQuery(query);
           } catch (SQLException ex) {
               Logger.getLogger(ServerJDBCHelperBean.class.getName()).log(Level.SEVERE, null, ex);
               return null;
           }
       }
       else {
           return null;
       }
   }
   public int executeUpdateQuery(String query) {
      if (statement != null) {
           try {
               return statement.executeUpdate(USER);
           } catch (SQLException ex) {
               Logger.getLogger(ServerJDBCHelperBean.class.getName()).log(Level.SEVERE, null, ex);
               return -1;
           }
       }
       else {
           return -1;
       } 
   }
   private void initConnection() {
       if (connection == null)
          
           try {
               Class.forName("com.mysql.jdbc.Driver");
               connection = DriverManager.getConnection(SERVER_URL, USER, PASSWORD);               
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ServerJDBCHelperBean.class.getName()).log(Level.SEVERE, null, ex);
               
           } catch (SQLException ex) {
               Logger.getLogger(ServerJDBCHelperBean.class.getName()).log(Level.SEVERE, null, ex);
              
           }
       
       
   }
   private void createStatement() {
       if (connection != null)
           try {
           statement = connection.createStatement();
       } catch (SQLException ex) {
           Logger.getLogger(ServerJDBCHelperBean.class.getName()).log(Level.SEVERE, null, ex);
           
       }      
   }
   
   public static void main(String args []) {
       try {
           ServerJDBCHelperBean helper = new ServerJDBCHelperBean();
           String query = "select max(control_no) from bb2_default.log_misc_doc where pn = 234567";
          ResultSet result =  helper.executeSelectQuery(query);
          while (result.next()) {
              System.out.println(result.getString("max(control_no)"));
          }
       } catch (SQLException ex) {
           Logger.getLogger(ServerJDBCHelperBean.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
