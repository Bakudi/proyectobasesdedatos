    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_crudpostgresql;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanv
 */


public class ClassColegio {

    
    String codigo;
    String nombre;
    String escudo;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

   
    
    
    
   
    public void mostrarColegios(JTable param_tabla_total_colegio){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Lugar Escudo");
        
        param_tabla_total_colegio.setModel(modelo);
        
        //consultas
        sql = "SELECT * FROM colegio;";
        String [] datos = new String[3];
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
             
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                
                modelo.addRow(datos);
            }
            
            param_tabla_total_colegio.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void insertarColegio(JTextField param_codigo, JTextField param_nombre, JTextField param_escudo){
            
        setCodigo(param_codigo.getText());
        setNombre(param_nombre.getText());
        setEscudo(param_escudo.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO colegio (codigo, nombre, escudo) VALUES (?, ?, ?)";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getCodigo());
            cs.setString(2, getNombre());
            cs.setString(3, getEscudo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void seleccionarColegio(JTable param_tabla_colegio, JTextField param_cod, JTextField param_nombre, JTextField param_escudo){
      try{
          
          int fila = param_tabla_colegio.getSelectedRow();
          
          if(fila >= 0){
              param_cod.setText(param_tabla_colegio.getValueAt(fila, 0).toString());
              param_nombre.setText(param_tabla_colegio.getValueAt(fila, 1).toString());
              param_escudo.setText(param_tabla_colegio.getValueAt(fila, 2).toString());
          }
          else{
              JOptionPane.showMessageDialog(null, "Fila no seleccionada");
          }
          
      }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void modificarColegio(JTextField param_codigo, JTextField param_nombre, JTextField param_escudo){
            
        setCodigo(param_codigo.getText());
        setNombre(param_nombre.getText());
        setEscudo(param_escudo.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE colegio SET codigo= ?, nombre = ?, escudo = ? WHERE codigo = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getCodigo());
            cs.setString(2, getNombre());
            cs.setString(3, getEscudo());
            cs.setString(4, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void eliminarColegio(JTextField param_codigo){
            
        setCodigo(param_codigo.getText());
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM colegio WHERE codigo = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó Correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}   
