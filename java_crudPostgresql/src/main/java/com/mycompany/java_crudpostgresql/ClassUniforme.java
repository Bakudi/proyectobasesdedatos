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


public class ClassUniforme {

    
    String id_uniforme;
    String tipo_tela;
    String lugar_bordado;
    String color;
    String color_bordado;
    String bordado_estampado;
    String id_colegio;

    public String getId_uniforme() {
        return id_uniforme;
    }

    public void setId_uniforme(String id_uniforme) {
        this.id_uniforme = id_uniforme;
    }

    public String getTipo_tela() {
        return tipo_tela;
    }

    public void setTipo_tela(String tipo_tela) {
        this.tipo_tela = tipo_tela;
    }

    public String getLugar_bordado() {
        return lugar_bordado;
    }

    public void setLugar_bordado(String lugar_bordado) {
        this.lugar_bordado = lugar_bordado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor_bordado() {
        return color_bordado;
    }

    public void setColor_bordado(String color_bordado) {
        this.color_bordado = color_bordado;
    }

    public String getBordado_estampado() {
        return bordado_estampado;
    }

    public void setBordado_estampado(String bordado_estampado) {
        this.bordado_estampado = bordado_estampado;
    }

    public String getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(String id_colegio) {
        this.id_colegio = id_colegio;
    }
    
    
    
    
    
   
    public void mostrarUniformes(JTable param_tabla_total_uniformes){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("ID");
        modelo.addColumn("Tipo de Tela");
        modelo.addColumn("Lugar bordado");
        modelo.addColumn("Color");
        modelo.addColumn("Color de Bordado");
        modelo.addColumn("Bordado o Estampado");
        modelo.addColumn("Id del Colegio");
        
        
        param_tabla_total_uniformes.setModel(modelo);
        
        //consultas
        sql = "SELECT * FROM uniforme;";
        String [] datos = new String[7];
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
                
                modelo.addRow(datos);
            }
            
            param_tabla_total_uniformes.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void insertarUniforme(JTextField param_id, JTextField param_tipo_tela, 
    JTextField param_lugar_bordado, JTextField param_color, JTextField param_colorbord,JTextField param_bordestamp, JTextField param_id_colegio){
            
        setId_uniforme(param_id.getText());
        setTipo_tela(param_tipo_tela.getText());
        setLugar_bordado(param_lugar_bordado.getText());
        setColor(param_color.getText());
        setColor_bordado(param_colorbord.getText());
        setBordado_estampado(param_bordestamp.getText());
        setId_colegio(param_id_colegio.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO uniforme (iduniforme, tipotela, lugarbordado, color, colorborde, bordadoest, idcolegio) VALUES (?,?, ?, ?, ?, ?, ?)";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getId_uniforme());
            cs.setString(2, getTipo_tela());
            cs.setString(3, getLugar_bordado());
            cs.setString(4, getColor());
            cs.setString(5, getColor_bordado());
            cs.setString(6, getBordado_estampado());
            cs.setString(7, getId_colegio());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void seleccionarUniforme(JTable param_tabla_uniforme, JTextField param_id, JTextField param_tipo_tela, 
    JTextField param_lugar_bordado, JTextField param_color, JTextField param_colorbord,JTextField param_bordestamp, JTextField param_id_colegio){
      try{
          
          int fila = param_tabla_uniforme.getSelectedRow();
          
          if(fila >= 0){
              param_id.setText(param_tabla_uniforme.getValueAt(fila, 0).toString());
              param_tipo_tela.setText(param_tabla_uniforme.getValueAt(fila, 1).toString());
              param_lugar_bordado.setText(param_tabla_uniforme.getValueAt(fila, 2).toString());
              param_color.setText(param_tabla_uniforme.getValueAt(fila, 3).toString());
              param_colorbord.setText(param_tabla_uniforme.getValueAt(fila, 4).toString()); 
              param_bordestamp.setText(param_tabla_uniforme.getValueAt(fila, 5).toString());
              param_id_colegio.setText(param_tabla_uniforme.getValueAt(fila, 6).toString());
          }
          else{
              JOptionPane.showMessageDialog(null, "Fila no seleccionada");
          }
          
      }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void modificarUniforme(JTextField param_id,JTextField param_tipo_tela, 
     JTextField param_lugar_bordado, JTextField param_color, JTextField param_colorbord,JTextField param_bordestamp, JTextField param_id_colegio){
            
        setId_uniforme(param_id.getText());
        setTipo_tela(param_tipo_tela.getText());
        setLugar_bordado(param_lugar_bordado.getText());
        setColor(param_color.getText());
        setColor_bordado(param_colorbord.getText());
        setBordado_estampado(param_bordestamp.getText());
        setId_colegio(param_id_colegio.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE uniforme SET iduniforme= ?, tipotela = ?, lugarbordado = ?, color = ?, colorborde = ?, bordadoest = ?, idcolegio = ?  WHERE iduniforme = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getId_uniforme());
            cs.setString(2, getTipo_tela());
            cs.setString(3, getLugar_bordado());
            cs.setString(4, getColor());
            cs.setString(5, getColor_bordado());
            cs.setString(6, getBordado_estampado());
            cs.setString(7, getId_colegio());
            cs.setString(8, getId_uniforme());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente   ");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void eliminarUniforme(JTextField param_codigo){
            
        setId_uniforme(param_codigo.getText());
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM uniforme WHERE iduniforme = ?";
        
        try{
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getId_uniforme());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó Correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}   
