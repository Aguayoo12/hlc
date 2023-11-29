/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misclases;

/**
 *
 * @author alex
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnSingleton {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;
 
    // Constructor
    private ConnSingleton(){
 
 String url = "jdbc:mysql://localhost:3306/uno?autoReconnect=true&useSSL=false";
 String driver = "com.mysql.jdbc.Driver";
 String usuario = "ana";
 String password = "1234";
  
 try{
     Class.forName(driver);
     conn = DriverManager.getConnection(url, usuario, password);
 }
 catch(ClassNotFoundException | SQLException e){
     e.printStackTrace();
 }
    } // Fin constructor
 
    // Métodos
    public static Connection getConnection(){
  
 if (conn == null){
     new ConnSingleton();
 }
  
 return conn;
    } // Fin getConnection
    public static void  cerrarConexion()
{
if (conn != null)
{
    try {
        conn.close();
    } catch (SQLException ex) {
        Logger.getLogger(ConnSingleton.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
}
