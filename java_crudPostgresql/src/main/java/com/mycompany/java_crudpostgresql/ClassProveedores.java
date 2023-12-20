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


public class ClassProveedores {

    
    String NIT;
    String nombre_empresa;
    String nombre_contacto;
    String Direccion;
    String telefono;

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
   
    public void mostrarProveedores(JTable param_tabla_total_proveedores){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("NIT");
        modelo.addColumn("Empresa");
        modelo.addColumn("Nombre Contacto");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        
        param_tabla_total_proveedores.setModel(modelo);
        
        //consultas
        sql = "SELECT * FROM proovedores;";
        String [] datos = new String[5];
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
             
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
            
            param_tabla_total_proveedores.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void insertarProveedores(JTextField param_codigo, JTextField param_empresa, JTextField param_contacto, JTextField param_direccion, JTextField param_telefono){
            
        setNIT(param_codigo.getText());
        setNombre_empresa(param_empresa.getText());
        setNombre_contacto(param_contacto.getText());
        setDireccion(param_direccion.getText());
        setTelefono(param_telefono.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO proovedores (nit, nombreempresa, nombrecontacto, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNIT());
            cs.setString(2, getNombre_empresa());
            cs.setString(3, getNombre_contacto());
            cs.setString(4, getDireccion());
            cs.setString(5, getTelefono());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void seleccionarProveedores(JTable param_tabla_proveedores, JTextField param_cod, JTextField param_empresa, JTextField param_contacto, JTextField param_direccion, JTextField param_telefono ){
      try{
          
          int fila = param_tabla_proveedores.getSelectedRow();
          
          if(fila >= 0){
              param_cod.setText(param_tabla_proveedores.getValueAt(fila, 0).toString());
              param_empresa.setText(param_tabla_proveedores.getValueAt(fila, 1).toString());
              param_contacto.setText(param_tabla_proveedores.getValueAt(fila, 2).toString());
              param_direccion.setText(param_tabla_proveedores.getValueAt(fila, 3).toString());
              param_telefono.setText(param_tabla_proveedores.getValueAt(fila, 4).toString());
          }
          else{
              JOptionPane.showMessageDialog(null, "Fila no seleccionada");
          }
          
      }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void modificarProveedores(JTextField param_codigo, JTextField param_empresa, JTextField param_contacto, JTextField param_direccion, JTextField param_telefono){
            
        setNIT(param_codigo.getText());
        setNombre_empresa(param_empresa.getText());
        setNombre_contacto(param_contacto.getText());
        setDireccion(param_direccion.getText());
        setTelefono(param_telefono.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE proovedores SET nit= ?, nombreempresa = ?, nombrecontacto = ?, direccion = ?, telefono = ? WHERE nit = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNIT());
            cs.setString(2, getNombre_empresa());
            cs.setString(3, getNombre_contacto());
            cs.setString(4, getDireccion());
            cs.setString(5, getTelefono());
            cs.setString(6, getNIT());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void eliminarProveedores(JTextField param_codigo){
            
        setNIT(param_codigo.getText());
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM proovedores WHERE nit = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNIT());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó Correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}   
