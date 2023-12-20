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


public class ClassEncargo {

    
    String id;
    int anticipo;
    String medidas;
    String fecha_encargo;
    String fecha_entrega;
    int precio_total;
    String estado;
    String id_producto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(int anticipo) {
        this.anticipo = anticipo;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public String getFecha_encargo() {
        return fecha_encargo;
    }

    public void setFecha_encargo(String fecha_encargo) {
        this.fecha_encargo = fecha_encargo;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    
    
    
   
    public void mostrarEncargos(JTable param_tabla_total_Encargoss){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("ID");
        modelo.addColumn("Anticipo");
        modelo.addColumn("Medidas");
        modelo.addColumn("Fecha del encargo");
        modelo.addColumn("Fecha de entrega");
        modelo.addColumn("Precio Total");
        modelo.addColumn("Estado");
        modelo.addColumn("Id Producto");
        
        
        param_tabla_total_Encargoss.setModel(modelo);
        
        //consultas
        sql = "SELECT * FROM encargo;";
        String [] datos = new String[8];
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
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                
                modelo.addRow(datos);
            }
            
            param_tabla_total_Encargoss.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void insertarEncargo(JTextField param_id, JTextField param_anticipo, 
    JTextField param_lugar_medidas, JTextField param_fecha_encar, JTextField param_fecha_ent, JTextField param_precio, JTextField param_estado, JTextField param_id_prod){
            
        setId(param_id.getText());
        setAnticipo(Integer.parseInt(param_anticipo.getText()));
        setMedidas(param_lugar_medidas.getText());
        setFecha_encargo(param_fecha_encar.getText());
        setFecha_entrega(param_fecha_ent.getText());
        setPrecio_total(Integer.parseInt(param_precio.getText()));
        setEstado(param_estado.getText());
        setId_producto(param_id_prod.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO encargo (idencargo, anticipo, medidas, fechaencargo, fechaent, preciototal, estado, idprod) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getId());
            cs.setInt(2, getAnticipo());
            cs.setString(3, getMedidas());
            cs.setString(4, getFecha_encargo());
            cs.setString(5, getFecha_entrega());
            cs.setInt(6, getPrecio_total());
            cs.setString(7, getEstado());
            cs.setString(8, getId_producto());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void seleccionarEncargo(JTable param_tabla_encargo, JTextField param_id, JTextField param_anticipo, 
    JTextField param_medidas, JTextField param_fecha_enc, JTextField param_fecha_ent, JTextField param_precio, JTextField param_estado, JTextField param_id_prod ){
      try{
          
          int fila = param_tabla_encargo.getSelectedRow();
          
          if(fila >= 0){
              param_id.setText(param_tabla_encargo.getValueAt(fila, 0).toString());
              param_anticipo.setText(param_tabla_encargo.getValueAt(fila, 1).toString());
              param_medidas.setText(param_tabla_encargo.getValueAt(fila, 2).toString());
              param_fecha_enc.setText(param_tabla_encargo.getValueAt(fila, 3).toString());
              param_fecha_ent.setText(param_tabla_encargo.getValueAt(fila, 4).toString());
              param_precio.setText(param_tabla_encargo.getValueAt(fila, 5).toString()); 
              param_estado.setText(param_tabla_encargo.getValueAt(fila, 6).toString());
              param_id_prod.setText(param_tabla_encargo.getValueAt(fila, 7).toString());
          }
          else{
              JOptionPane.showMessageDialog(null, "Fila no seleccionada");
          }
          
      }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void modificarEncargo(JTextField param_id, JTextField param_anticipo, 
    JTextField param_lugar_medidas, JTextField param_fecha_encar, JTextField param_fecha_ent, JTextField param_precio, JTextField param_estado, JTextField param_id_prod){
            
        setId(param_id.getText());
        setAnticipo(Integer.parseInt(param_anticipo.getText()));
        setMedidas(param_lugar_medidas.getText());
        setFecha_encargo(param_fecha_encar.getText());
        setFecha_entrega(param_fecha_ent.getText());
        setPrecio_total(Integer.parseInt(param_precio.getText()));
        setEstado(param_estado.getText());
        setId_producto(param_id_prod.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE encargo SET idencargo= ?, anticipo = ?, medidas = ?, fechaencargo = ?, fechaentrega = ?, preciototal = ?, estado = ?, idprod = ? WHERE idencargo = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getId());
            cs.setInt(2, getAnticipo());
            cs.setString(3, getMedidas());
            cs.setString(4, getFecha_encargo());
            cs.setString(5, getFecha_entrega());
            cs.setInt(6, getPrecio_total());
            cs.setString(7, getEstado());
            cs.setString(8, getId_producto());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void eliminarEncargo(JTextField param_codigo){
            
        setId(param_codigo.getText());
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM encargo WHERE idencargo = ?";
        
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
