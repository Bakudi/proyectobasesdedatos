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


public class ClassProducto {

    
    String id;
    int precio;
    String descripcion;
    String talla;
    String sexo;
    int cantidad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
   
    public void mostrarProductos(JTable param_tabla_total_productos){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("ID");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Talla");
        modelo.addColumn("Sexo");
        modelo.addColumn("Cantidad");
        
        
        param_tabla_total_productos.setModel(modelo);
        
        //consultas
        sql = "SELECT * FROM productoterminado;";
        String [] datos = new String[6];
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
                datos[5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            
            param_tabla_total_productos.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void insertarProducto(JTextField param_id, JTextField param_precio, 
    JTextField param_desc, JTextField param_talla, JTextField param_sexo, JTextField param_cantidad){
            
        setId(param_id.getText());
        setPrecio(Integer.parseInt(param_precio.getText()));
        setDescripcion(param_desc.getText());
        setTalla(param_talla.getText());
        setSexo(param_sexo.getText());
        setCantidad(Integer.parseInt(param_cantidad.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO productoterminado (codigo, precio, descripcion, talla, sexo, cantidad) VALUES (?,?, ?, ?, ?, ?)";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getId());
            cs.setInt(2, getPrecio());
            cs.setString(3, getDescripcion());
            cs.setString(4, getTalla());
            cs.setString(5, getSexo());
            cs.setInt(6, getCantidad());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void seleccionarProducto(JTable param_tabla_productos, JTextField param_id, JTextField param_precio, 
    JTextField param_desc, JTextField param_talla, JTextField param_sexo, JTextField param_cantidad){
      try{
          
          int fila = param_tabla_productos.getSelectedRow();
          
          if(fila >= 0){
              param_id.setText(param_tabla_productos.getValueAt(fila, 0).toString());
              param_precio.setText(param_tabla_productos.getValueAt(fila, 1).toString());
              param_desc.setText(param_tabla_productos.getValueAt(fila, 2).toString());
              param_talla.setText(param_tabla_productos.getValueAt(fila, 3).toString());
              param_sexo.setText(param_tabla_productos.getValueAt(fila, 4).toString()); 
              param_cantidad.setText(param_tabla_productos.getValueAt(fila, 5).toString());
          }
          else{
              JOptionPane.showMessageDialog(null, "Fila no seleccionada");
          }
          
      }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void modificarProducto(JTextField param_id, JTextField param_precio, 
    JTextField param_desc, JTextField param_talla, JTextField param_sexo, JTextField param_cantidad){
            
        setId(param_id.getText());
        setPrecio(Integer.parseInt(param_precio.getText()));
        setDescripcion(param_desc.getText());
        setTalla(param_talla.getText());
        setSexo(param_sexo.getText());
        setCantidad(Integer.parseInt(param_cantidad.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE productoterminado SET codigo= ?, precio = ?, descripcion = ?, talla = ?, sexo = ?, cantidad = ?  WHERE codigo = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
                     
            cs.setString(1, getId());
            cs.setInt(2, getPrecio());
            cs.setString(3, getDescripcion());
            cs.setString(4, getTalla());
            cs.setString(5, getSexo());
            cs.setInt(6, getCantidad());
            cs.setString(7, getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void eliminarProducto(JTextField param_codigo){
            
        setId(param_codigo.getText());
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM productoterminado WHERE codigo = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getId());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó Correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}   
