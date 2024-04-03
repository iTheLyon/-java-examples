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
    private static final String bbdd = "jdbc:mysql://172.16.3.105:3306/matricula";
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
              
             
             System.out.println("-------------"
                     + "--------------------------------");
             PreparedStatement ps2;
             ps2 = conex.prepareStatement(""
                     + "select * from productos where "
                     + "desc_producto like '%light%';");
             ResultSet rs2;
             rs2 = ps2.executeQuery();
             while(rs2.next()) {
                String producto2 
                        = rs2.getString(
                                "Nomb_Producto");
                System.out.println(producto2);
            }

             System.out.println("-------------"
                     + "--------------------------------");
             PreparedStatement ps3;
             ps3 = conex.prepareStatement(""
                     + "select * from vehiculo where "
                     + "Colo_Vehiculo='1';");
             ResultSet rs3;
             rs3 = ps3.executeQuery();
             
             while(rs3.next()) {
                String IdVehiculo
                        = rs3.getString(
                                "Id_Vehiculo");
                String ModeVehiculo
                        = rs3.getString(
                                "Mode_Vehiculo");
                String PlacaVehiculo
                        = rs3.getString(
                                "Plac_Vehiculo");
                System.out.println("IdVehiculo : "+IdVehiculo
                        +"\n"+"Modelo : "+ModeVehiculo
                        +"\n"+"Placa : "+PlacaVehiculo);
            }
            
              System.out.println("-------------"
                     + "--------------------------------");
             PreparedStatement ps4;
             ps4 = conex.prepareStatement(""
                     + " select round(avg(nota_notas),2) as "
                     + "promedio from notas;");
             ResultSet rs4;
             rs4 = ps4.executeQuery();
             
             if(rs4.next()) {
                String promedio= rs4.getString("promedio");                
                System.out.println("Promedio : "+promedio);
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
