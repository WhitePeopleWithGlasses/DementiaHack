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
import static java.sql.JDBCType.NULL;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Travis
 */
public class DBUtils {

    public static void main(String[] args) throws Exception{
       //createNewDatabase("dementiahack.db");
       //connect();
       //createNewTable();
       //DBUtils app = new DBUtils();
       //app.insertQuestion(3, "take 3", null);
      //updateTable();
     //selectAll();
       email();
    }
    
    public static void updateTable(){
        //SQLite connection string
        String url = "jdbc:sqlite:dementiahack.db";
        
        //SQL statement 
        String sql = "ALTER TABLE questions \n" 
                + " ADD COLUMN timesAsked integer \n"
                + ";";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
            //create a new table
            stmt.execute(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void connect() {
        Connection conn = null;
        try {
            //db parameters
            String url = "jdbc:sqlite:dementiahack.db";
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
    
    public static void createNewTable(){
        //SQLite connection string
        String url = "jdbc:sqlite:dementiahack.db";
        
        //SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS questions (\n" 
                + " questionId integer PRIMARY KEY, \n"
                + " question text NOT NULL, \n"
                + " answer text \n"
                + " timesAsked integer \n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
            //create a new table
            stmt.execute(sql);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertQuestion(int questionId, String question, String answer){
        String url = "jdbc:sqlite:dementiahack.db";
        int DEFAULT = 0;
        String sql = "INSERT INTO questions(questionId, question, answer, timesAsked) VALUES(?,?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, questionId);
            pstmt.setString(2, question);
            pstmt.setString(3, answer);
            pstmt.setInt(4, DEFAULT);
            pstmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void selectAll(){
        String url = "jdbc:sqlite:dementiahack.db";
        String sql = "SELECT questionId, question, answer, timesAsked FROM questions";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("questionId") +  "\t" + 
                                   rs.getString("question") + "\t" +
                                   rs.getString("answer") + "\t" +
                                   rs.getInt("timesAsked"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void email(){
        final String username = "nuvorkwebtest@gmail.com";
		final String password = "P@ssw0rd123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("nuvorkwebtest@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("traviskelly172@gmail.com"));
			message.setSubject("Report for " + "insert user here" + " for " + "insert date range here" );
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
    
    
}
