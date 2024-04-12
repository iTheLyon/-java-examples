/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.senati.newbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ETIA 2024
 */
public class BaseDatos {
    public Connection conexion;
    
    public Connection getConection() {
          Connection con = null;          
          String base = "newbank";//Nombre de la base de datos
          String url = "jdbc:mysql://localhost:3306/"+ base;//Direccion, puerto y nombre de la Base de Datos
          String user = "root";//Usuario de Acceso a MySQL
          String password = "";//Password del Usuario

          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("se conecto");
          } catch (ClassNotFoundException | SQLException e) {
            System.err.print(e);
          }
            return con;
    }
    
    public ResultSet buscar(String sql) throws SQLException {
        PreparedStatement ps;
        ps = conexion.prepareStatement(sql);
        ResultSet rs;
        rs = ps.executeQuery();
        return rs;
    }
    
    public int insertar(String sql) throws SQLException {
         PreparedStatement ps;
         ps = conexion.prepareStatement(sql);
         int rs;
         rs = ps.executeUpdate();
         return rs;
    }
    
     public int actualizar(String sql) throws SQLException {
         PreparedStatement ps;
         ps = conexion.prepareStatement(sql);
         int rs;
         rs = ps.executeUpdate();
         return rs;
    }
}
