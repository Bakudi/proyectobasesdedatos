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


public class ClassMateriaPrima {

    
    String codigo;
    String descripcion;
    String tipo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
  

   
    public void mostrarMateriasPrimas(JTable param_tabla_total_materiaP){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Tipo");
        
        param_tabla_total_materiaP.setModel(modelo);
        
        //consultas
        sql = "SELECT * FROM materiaprima;";
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
            
            param_tabla_total_materiaP.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void insertarMateriaPrima(JTextField param_codigo, JTextField param_descripcion, JTextField param_tipo){
            
        setCodigo(param_codigo.getText());
        setDescripcion(param_descripcion.getText());
        setTipo(param_tipo.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO materiaprima (codigo, descripcion, tipo) VALUES (?, ?, ?)";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getCodigo());
            cs.setString(2, getDescripcion());
            cs.setString(3, getTipo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void seleccionarMateriaPrima(JTable param_tabla_materiaP, JTextField param_cod, JTextField param_descripcion, JTextField param_tipo){
      try{
          
          int fila = param_tabla_materiaP.getSelectedRow();
          
          if(fila >= 0){
              param_cod.setText(param_tabla_materiaP.getValueAt(fila, 0).toString());
              param_descripcion.setText(param_tabla_materiaP.getValueAt(fila, 1).toString());
              param_tipo.setText(param_tabla_materiaP.getValueAt(fila, 2).toString());
          }
          else{
              JOptionPane.showMessageDialog(null, "Fila no seleccionada");
          }
          
      }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void modificarMateriaPrima(JTextField param_codigo, JTextField param_descripcion, JTextField param_tipo){
            
        setCodigo(param_codigo.getText());
        setDescripcion(param_descripcion.getText());
        setTipo(param_tipo.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE materiaprima SET codigo= ?, descripcion = ?, tipo = ? WHERE codigo = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getCodigo());
            cs.setString(2, getDescripcion());
            cs.setString(3, getTipo());
            cs.setString(4, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void eliminarMateriaPrima(JTextField param_codigo){
            
        setCodigo(param_codigo.getText());
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM materiaprima WHERE codigo = ?";
        
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
