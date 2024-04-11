/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senati.escuela;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author ETIA 2024
 */
public class Persona {
    
    public Integer id;
    public String clave;
    public String nombre;
    public String domicilio;
    public String telefono;
    public String email;
    public Date fechaNacimiento;
    public String genero;
    private BaseDatos bd;
            
    public Persona() {
        bd = new BaseDatos();
        bd.conexion = bd.getConection();
    }
    
    public Persona buscar(String clave) throws SQLException {
        String sql="select * from persona where clave='"+clave+"'";
        ResultSet rs = bd.buscar(sql);
        while(rs.next()) {
            this.id = rs.getInt("id");
            this.clave = rs.getString("clave");
            this.nombre = rs.getString("nombre");
            this.domicilio = rs.getString("domicilio");
            this.telefono = rs.getString("telefono");
            this.email = rs.getString("correo_electronico");
            this.fechaNacimiento = rs.getDate("fecha_nacimiento");
            this.genero = rs.getString("genero");
        }
        
        return this;
    }
    
    public int insertar() throws SQLException {
        String sql="insert into persona"
        + "(clave,nombre,domicilio,"
        + "telefono,correo_electronico,"
        + "fecha_nacimiento,genero) "
        + "values ('"+this.clave+"',"
                + "'"+ this.nombre+ "',"
                + "'"+this.domicilio+"',"
                + "'"+this.telefono+"',"
                + "'"+this.email+"',"
                + "'"+this.fechaNacimiento.toString()+"',"
                + "'"+this.genero+"')";
        int resultado = bd.insertar(sql);
        return resultado;
    }

    public int actualizar() throws SQLException {
        String sql="update persona"
        + "set clave='"+this.clave+"',"
        + " nombre='"+ this.nombre+ "',"
        + " domicilio='"+this.domicilio+"',"
        + " telefono='"+this.telefono+"',"
        + " correo_electronico='"+this.email+"',"
        + " fecha_nacimiento='"+this.fechaNacimiento.toString()+"',"
        + " genero='"+this.genero+"'"
        + " where id="+this.id.toString();        
        int resultado = bd.actualizar(sql);
        return resultado;
    }
    
        
    
}
