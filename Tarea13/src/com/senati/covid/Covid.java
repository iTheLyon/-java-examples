/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senati.covid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static tarea13.Tarea13.Conexion;

public class Covid {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String bbdd = "jdbc:mysql://localhost:3306/covid";
    private static final String usuario="root";
    private static final String clave="root";
    
     public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection conex = null;
        conex = Conexion();
        if(conex != null) {
            System.out.println("Conectado correctamente");
            
            
            System.out.println("****************** PROGRAMA COVID *************************");
            System.out.println("MENU : ESCRIBA SU OPCION");
            System.out.println("1 -REGISTRO");
            System.out.println("2 -EDICION");
            System.out.println("3 -CONSULTA");
            System.out.println("4 -ELIMINACION");
            
            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.next();
            
            switch(opcion) {
                case "1" : 
                    System.out.println("REGISTRO DE PACIENTES");
                    System.out.println("NOMBRES : ");
                    String nombres = scanner.next();
                    System.out.println("APELLIDOS : ");
                    String apellidos = scanner.next();
                    System.out.println("EDAD : ");
                    int edad = scanner.nextInt();
                    System.out.println("TALLA(MTS) : ");
                    double talla = scanner.nextDouble();
                    System.out.println("PESO(KG) : ");
                    double peso = scanner.nextDouble();
                    System.out.println("----- SINTOMAS (1=SI,0=NO) -------");                    
                    System.out.println("TIENES TOS ? : ");
                    String tos = scanner.next();
                    System.out.println("TIENES FIEBRE ? : ");
                    String fiebre = scanner.next();
                    System.out.println("TIENES DISNEA ? : ");
                    String disnea = scanner.next();
                    System.out.println("TIENES DOLOR MUSCULAR ? : ");
                    String dolor = scanner.next();
                    System.out.println("TIENES GRIPE ? : ");
                    String gripe = scanner.next();
                    System.out.println("TIENES PRESION  ALTA ? : ");
                    String presion = scanner.next();
                    System.out.println("TIENES FATIGA ? : ");
                    String fatiga = scanner.next();
                    System.out.println("TIENES GARRASPERA ? : ");
                    String garraspera = scanner.next();
                    System.out.println("CUANDO FUE LA ULTIMA VACUNACION (YYYY-MM-DD) ? : ");
                    String fecha_vacunacion = scanner.next();
                          
                    PreparedStatement ps9;
                    ps9 = conex.prepareStatement(
                            "insert into pacientes("
                            + "nombres,\n" +
                            "apellidos,\n" +
                            "edad,\n" +
                            "talla_m,\n" +
                            "peso_kg,\n" +
                            "sintoma_tos,\n" +
                            "sintoma_fiebre,\n" +
                            "sintoma_disnea,\n" +
                            "sintoma_dolormuscular,\n" +
                            "sintoma_gripe,\n" +
                            "sintoma_presionalta,\n" +
                            "sintoma_fatiga,\n" +
                            "sintoma_garraspera,\n" +
                            "ultima_fecha_vacunacion,resultado) "
                           + 
                           "values('"+nombres+"','"
                                    +apellidos+"','"
                                    +edad+"','"
                                    +talla+"','"
                                    +peso+"','"
                                    +tos+"','"
                                    +fiebre+"','"
                                    +disnea+"','"
                                    +dolor+"','"
                                    +gripe+"','"
                                    +presion+"','"                                            
                                    +fatiga+"','"                                            
                                    +garraspera+"','"                                            
                                    +fecha_vacunacion                                            
                                    + "','');");
                    int rs9;
                    rs9 = ps9.executeUpdate();

                    if(rs9>0) {                
                       System.out.println("Se registro el paciente correctamente");                                
                    }
                    else {
                        System.out.println("No Esta insertado");
                    }

                    break;
                case "2" :
                    System.out.println("ACTUALIZACION DE PACIENTES");                    
                    System.out.println("ID : ");
                    int id = scanner.nextInt();
                    System.out.println("NOMBRES : ");
                    String nombres2 = scanner.next();
                    System.out.println("APELLIDOS : ");
                    String apellidos2 = scanner.next();
                    System.out.println("EDAD : ");
                    int edad2 = scanner.nextInt();
                    System.out.println("TALLA(MTS) : ");
                    double talla2 = scanner.nextDouble();
                    System.out.println("PESO(KG) : ");
                    double peso2 = scanner.nextDouble();
                    System.out.println("----- SINTOMAS (1=SI,0=NO) -------");                    
                    System.out.println("TIENES TOS ? : ");
                    String tos2 = scanner.next();
                    System.out.println("TIENES FIEBRE ? : ");
                    String fiebre2 = scanner.next();
                    System.out.println("TIENES DISNEA ? : ");
                    String disnea2 = scanner.next();
                    System.out.println("TIENES DOLOR MUSCULAR ? : ");
                    String dolor2 = scanner.next();
                    System.out.println("TIENES GRIPE ? : ");
                    String gripe2 = scanner.next();
                    System.out.println("TIENES PRESION  ALTA ? : ");
                    String presion2 = scanner.next();
                    System.out.println("TIENES FATIGA ? : ");
                    String fatiga2 = scanner.next();
                    System.out.println("TIENES GARRASPERA ? : ");
                    String garraspera2 = scanner.next();
                    System.out.println("CUANDO FUE LA ULTIMA VACUNACION (YYYY-MM-DD) ? : ");
                    String fecha_vacunacion2 = scanner.next();
                          
                    PreparedStatement ps10;
                    ps10 = conex.prepareStatement(
                            "update pacientes "
                            +"set nombres='" +nombres2+"',"
                            +"apellidos='" +apellidos2+"',"
                            +"edad=" +edad2+","
                            +"talla_m=" +talla2+","
                            +"peso_kg=" + peso2+","
                            +"sintoma_tos='"+tos2+"',"
                            +"sintoma_fiebre='" + fiebre2+"',"
                            +"sintoma_disnea='" + disnea2+"',"
                            +"sintoma_dolormuscular='" +dolor2+"',"
                            +"sintoma_gripe='" + gripe2+"',"
                            +"sintoma_presionalta='" +presion2+"',"
                            +"sintoma_fatiga='" + fatiga2 +"',"
                            +"sintoma_garraspera='" + garraspera2+"',"
                            +"ultima_fecha_vacunacion='"+fecha_vacunacion2+"'"
                            + " where id="+id+";");
                    
                    int rs10;
                    rs10 = ps10.executeUpdate();

                    if(rs10>0) {                
                       System.out.println("Se actualizo el paciente correctamente");                                
                    }
                    else {
                        System.out.println("No Esta actualizado");
                    }                    
                    break;
                case "3" :
                    System.out.println("CONSULTAS DE PACIENTES");                    
                    System.out.println("INGRESE SU BUSQUEDA : ");                    
                    String texto = scanner.next();
                    PreparedStatement ps3;
                    ps3 = conex.prepareStatement(""
                            + "select * from pacientes where "
                            + "nombres like '%"+texto+"%' or "
                            + "apellidos like  '%"+texto+"%' ");                                    
                    
                    ResultSet rs3;
                    rs3 = ps3.executeQuery();

                    while(rs3.next()) {
                       String Id= rs3.getString("Id");
                       String nombres3= rs3.getString("nombres");
                       String apellidos3= rs3.getString("apellidos");
                       
                       System.out.println("Id : "+Id
                               +"\n"+"nombres : "+nombres3
                               +"\n"+"apellidos : "+apellidos3);
                   }
                break;
                case "4" :
            }
            
            
        }
        else {
            System.out.println("no hay conexion");
        }
     }
     
    public static Connection Conexion() {
        Connection conex = null;
        try  {
            Class.forName(driver);
            conex = DriverManager.getConnection(bbdd,usuario,clave);                        
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return conex;
    }
            
    
}
