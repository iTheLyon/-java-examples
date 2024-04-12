/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senati.newbank;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ETIA 2024
 */
public class Compania {
    
    public Integer id;
    public String nro;
    public String nombre;    
    private BaseDatos bd;
    public ArrayList<Compania> Companias;
    
    public Compania() {
        bd = new BaseDatos();
        bd.conexion = bd.getConection();
    }
    
    public Compania buscar(String nro) throws SQLException {
        String sql="select * from compania where nro='"+nro+"'";
        ResultSet rs = bd.buscar(sql);
        while(rs.next()) {
            this.id = rs.getInt("Id");
            this.nro = rs.getString("Nro");
            this.nombre = rs.getString("Nombre");         
        }
        
        return this;
    }
    
    public int insertar() throws SQLException {
        /*String sql="insert into persona"
        + "(clave,nombre,domicilio,"
        + "telefono,correo_electronico,"
        + "fecha_nacimiento,genero) "
        + "values ('"+this.clave+"',"
                + "'"+ this.nombre+ "',"
                + "'"+this.domicilio+"',"
                + "'"+this.telefono+"',"
                + "'"+this.email+"',"
                + "'"+this.fechaNacimiento.toString()+"',"
                + "'"+this.genero+"')";*/
        int resultado = 1;//bd.insertar(sql);
        return resultado;
    }

    public int actualizar() throws SQLException {
        /*String sql="update persona"
        + "set clave='"+this.clave+"',"
        + " nombre='"+ this.nombre+ "',"
        + " domicilio='"+this.domicilio+"',"
        + " telefono='"+this.telefono+"',"
        + " correo_electronico='"+this.email+"',"
        + " fecha_nacimiento='"+this.fechaNacimiento.toString()+"',"
        + " genero='"+this.genero+"'"
        + " where id="+this.id.toString();        */
        
        int resultado = 1;//bd.actualizar(sql);
        return resultado;
    }
    
    public ArrayList<Compania> listar() throws SQLException {
        String sql="select * from compania";
        ResultSet rs = bd.buscar(sql);
        this.Companias = new ArrayList<Compania>();
        if(!this.Companias.isEmpty())
            this.Companias.clear();
        while(rs.next()) {
            Compania compania = new Compania();
            compania.id = rs.getInt("Id");
            compania.nro = rs.getString("Nro");
            compania.nombre = rs.getString("Nombre");         
            this.Companias.add(compania);
        }
        
        return this.Companias;
    }
    
}
