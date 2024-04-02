/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea13;
import java.sql.*;
/**
 *
 * @author ING_SOFTWARE_3S
 */
public class Tarea13 {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String bbdd = "jdbc:mysql://localhost:3306/matricula";
    private static final String usuario="root";
    private static final String clave="root";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection conex = null;
        conex = Conexion();
        
        if(conex != null) {
            System.out.println("Conectado correctamente");
            
             PreparedStatement ps;
             ps = conex.prepareStatement("select * from productos;");
             ResultSet rs;
             rs = ps.executeQuery();
             while(rs.next()) {
                String producto = rs.getString("Nomb_Producto");
                System.out.println(producto);
            }
        }
        else {
            System.out.println("No has podido conectarte ");
        }
        
    }
    
    public static Connection Conexion() {
        Connection conex = null;
        try 
        {
            Class.forName(driver);
            conex = DriverManager.getConnection(bbdd,usuario,clave);            
            
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        
        return conex;
    }
            
    
}
