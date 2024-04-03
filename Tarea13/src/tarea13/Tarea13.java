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
             
             
             System.out.println("-------------"
                     + "--------------------------------");
             PreparedStatement ps5;
             ps5 = conex.prepareStatement("update notas set nota_notas=10 where id_notas=3;");
             int rs5;
             rs5 = ps5.executeUpdate();
             
             if(rs5>0) {                
                System.out.println("Esta actualizado");                                
                ps5 = conex.prepareStatement("select * from notas where id_notas=3;");
                ResultSet rs6;
                rs6 = ps5.executeQuery();
                if(rs6.next()) {
                    String nota = rs6.getString("nota_notas");                
                    String alumno = rs6.getString("Nombre_notas");                
                    System.out.println("Alumno:"+alumno + ", nota : "+nota);
                }             
             }
             else {
                 System.out.println("No Esta actualizado");
             }
             
               System.out.println("-------------"
                     + "--------------------------------");
             PreparedStatement ps7;
             ps7 = conex.prepareStatement("update productos set desc_producto='LACTEOS Y YOGURES' where id_producto=41;");
             int rs7;
             rs7 = ps7.executeUpdate();
             
             if(rs7>0) {                
                System.out.println("Esta actualizado productos");                                
                ps7 = conex.prepareStatement("select * from productos where id_producto=41;");
                ResultSet rs8;
                rs8 = ps7.executeQuery();
                if(rs8.next()) {
                    String nombreproducto = rs8.getString("Nomb_Producto");                
                    String descproducto = rs8.getString("Desc_Producto");                
                    System.out.println("producto:"+nombreproducto + ", categoria : "+descproducto);
                }             
             }
             else {
                 System.out.println("No Esta actualizado");
             }
             
             
               System.out.println("-------------"
                     + "--------------------------------");
             PreparedStatement ps9;
             ps9 = conex.prepareStatement(
                     "insert into productos(Nomb_Producto,Desc_Producto,Prec_Producto,Cant_Producto) "
                             + "values('TELEVISOR','TV',1200,10);");
             int rs9;
             rs9 = ps9.executeUpdate();
             
             if(rs9>0) {                
                System.out.println("Esta insertado el producto");                                
                ps9 = conex.prepareStatement("select * from productos order by Id_Producto desc;");
                ResultSet rs10;
                rs10 = ps9.executeQuery();
                if(rs10.next()) {
                    String nombreproducto = rs10.getString("Nomb_Producto");                
                    String descproducto = rs10.getString("Desc_Producto");                
                    System.out.println("producto:"+nombreproducto + ", categoria : "+descproducto);
                }             
             }
             else {
                 System.out.println("No Esta insertado");
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
