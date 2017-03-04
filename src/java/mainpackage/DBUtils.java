/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author Travis
 */
public class DBUtils {

    public static void connect() {
        Connection conn = null;
        try {
            //db parameters
            String url = "jdbc:sqlite:questions.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }   
    }
    public static void main(String[] args){
       createNewDatabase("dementiahack.db");
       //connect();
    }
    
    public static void createNewDatabase(String fileName)
    {
       String url = "jdbc:sqlite:" + fileName;
       
       try (Connection conn = DriverManager.getConnection(url)){
           if (conn != null) {
               DatabaseMetaData meta = conn.getMetaData();
               System.out.println("The driver name is " + meta.getDriverName());
               System.out.println("A new database has been created.");
           }
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }  
}
