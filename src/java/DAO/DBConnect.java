/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GG
 */
public class DBConnect {
     public Connection connection = null;
    
    public DBConnect(String URL, String userName, String password){
        try {
            //        URL: string connection: address,port, databasename
            //        userName,passsword: account of SQL Server
            //call Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connection
            connection = DriverManager.getConnection(URL, userName, password);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
        } catch (SQLException ex) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
        }
    }
    public ResultSet getData(String sql){
        ResultSet rs = null;
        try {
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public DBConnect(){
        this("jdbc:sqlserver://localhost:1433;databaseName=SE1713","sa","12345678");
    }
    public static void main(String[] args) {
        new DBConnect();
    }
}
