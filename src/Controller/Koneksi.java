package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aryz
 */
public class Koneksi {
    Connection con;
    Statement stm;
    public  void config() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/parkir", "root", "");
            stm = con.createStatement();
        }catch(Exception Ex)
        {
            System.out.println("Controller.Koneksi.config()");
        }
        
    }
    public Connection connect()
    {
        if(con == null)
        {
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("parkir");
            db.setUser("root");
            db.setPassword("");
            try
            {
                con = db.getConnection();
            }
            catch(Exception e){}
            }
       
            return con;
        } 
    
    public ResultSet executeSQL(String sql) {  
        try {           
            
            return con.createStatement().executeQuery(sql);    
        } catch (SQLException ex)
        {      
            return null;    
        }   
    }
    }
   

