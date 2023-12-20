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
public class ClassCliente {

    
    String doc_id;
    String nombre;
    String telefono;
    
    String temp_id;
    
    
    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void mostrarClientes(JTable param_tabla_total_clientes){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("Doc_Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        
        param_tabla_total_clientes.setModel(modelo);
        
        //consultas
        sql = "SELECT * FROM cliente;";
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
            
            param_tabla_total_clientes.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void insertarCliente(JTextField param_id, JTextField param_nombre, JTextField param_telef){
            
        setDoc_id(param_id.getText());
        setNombre(param_nombre.getText());
        setTelefono(param_telef.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO cliente (docid, nombre, telefono) VALUES (?, ?, ?)";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getDoc_id());
            cs.setString(2, getNombre());
            cs.setString(3, getTelefono());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void seleccionarCliente(JTable param_tabla_cliente, JTextField param_doc, JTextField param_nombre, JTextField param_telef){
      try{
          
          int fila = param_tabla_cliente.getSelectedRow();
          
          if(fila >= 0){
              param_doc.setText(param_tabla_cliente.getValueAt(fila, 0).toString());
              param_nombre.setText(param_tabla_cliente.getValueAt(fila, 1).toString());
              param_telef.setText(param_tabla_cliente.getValueAt(fila, 2).toString());
          }
          else{
              JOptionPane.showMessageDialog(null, "Fila no seleccionada");
          }
          
      }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void modificarCliente(JTextField param_id, JTextField param_nombre, JTextField param_telef){
            
        setDoc_id(param_id.getText());
        setNombre(param_nombre.getText());
        setTelefono(param_telef.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE cliente SET docid= ?, nombre = ?, telefono = ? WHERE docid = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getDoc_id());
            cs.setString(2, getNombre());
            cs.setString(3, getTelefono());
            cs.setString(4, getDoc_id());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void eliminarCliente(JTextField param_id){
            
        setDoc_id(param_id.getText());
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM cliente WHERE docid = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getDoc_id());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó Correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}   
