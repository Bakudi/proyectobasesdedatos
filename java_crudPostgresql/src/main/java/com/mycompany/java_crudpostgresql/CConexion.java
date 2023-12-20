/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_crudpostgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author juanv
 */
public class CConexion {
    
    Connection conectar = null;
    
    //credenciales
    String usuario = "postgres";
    String contrasena = "admin";
    String bd = "TrabajoFinal"; 
    String ip = "localhost";
    String puerto = "5432"; 
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        
        try{
            //ruta del driver
            Class.forName("org.postgresql.Driver");
            
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            
           // JOptionPane.showMessageDialog(null,"se conecto correctamente" );
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+ e.toString() );
        }
        
        return conectar;
    }
}
