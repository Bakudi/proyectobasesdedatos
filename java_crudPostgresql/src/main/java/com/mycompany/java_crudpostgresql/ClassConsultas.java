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


public class ClassConsultas {

    
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

    
    
    
   
    public void mostrarConsulta1(JTable param_tabla_total_Encargoss){
        
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
        sql = "select * from encargo where estado = 'En Espera' order by fechaencargo";
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
    
    public void mostrarConsulta2(JTable param_tabla_total_Encargoss){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("documento Id");
        modelo.addColumn("id Encargo");
        modelo.addColumn("Descripcion");

        
        
        param_tabla_total_Encargoss.setModel(modelo);
        
        //consultas
        sql = "SELECT c.docID, e.idEncargo, pt.descripcion FROM cliente c inner JOIN cliente_encargo ce ON c.docID = ce.docID inner JOIN encargo e ON ce.idEncargo = e.idEncargo inner JOIN ProductoTerminado pt ON e.idprod = pt.codigo WHERE e.estado != 'Entregado';";
        String [] datos = new String[8];
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
            
            param_tabla_total_Encargoss.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public void mostrarConsulta3(JTable param_tabla_total_Encargoss){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad en existencia");

        
        
        param_tabla_total_Encargoss.setModel(modelo);
        
        //consultas
        sql = "SELECT PT.codigo AS codigo_producto, PT.descripcion, (PT.cantidad - COALESCE(SUM(E.anticipo), 0)) AS cantidad_en_existencia FROM ProductoTerminado PT LEFT JOIN encargo E ON PT.codigo = E.idProd AND E.estado = 'En proceso' GROUP BY PT.codigo, PT.cantidad;";
        String [] datos = new String[8];
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
            
            param_tabla_total_Encargoss.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
      public void mostrarConsulta4(JTable param_tabla_total_Encargoss){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Escudo");

        
        
        param_tabla_total_Encargoss.setModel(modelo);
        
        //consultas
        sql = "select c.codigo,c.nombre,c.escudo from colegio c inner join uniforme u on c.codigo = u.idcolegio where c.codigo = u.idcolegio";
        String [] datos = new String[8];
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
            
            param_tabla_total_Encargoss.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
      
    public void mostrarConsulta5(JTable param_tabla_total_uniformes){
        
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
        
        
        param_tabla_total_uniformes.setModel(modelo);
        
        //consultas
        sql = "SELECT U.idUniforme, U.tipoTela, U.lugarBordado, U.color, U.colorBorde, U.bordadoEst FROM colegio C inner JOIN uniforme U ON C.codigo = U.idColegio WHERE C.codigo = '100';";
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
            
            param_tabla_total_uniformes.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
        
    }
    
    public void mostrarConsulta6(JTable param_tabla_total_Encargoss){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Total productos Vendidos");

        
        
        param_tabla_total_Encargoss.setModel(modelo);
        
        //consultas
        sql = "SELECT C.codigo,C.nombre, SUM(fv.total) AS Total_Productos_Vendidos FROM colegio C inner join uniforme u ON C.codigo = u.idColegio inner join encargo_uniforme eu on u.iduniforme = eu.iduniforme inner join encargo e on eu.idencargo = e.idencargo inner join factura_venta fv on e.idencargo = fv.idencargo where c.nombre = 'I.E Polanco' group by c.codigo, c.nombre";
        String [] datos = new String[8];
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
            
            param_tabla_total_Encargoss.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
     public void mostrarConsulta7(JTable param_tabla_total_Encargoss){
        
        //Hacemos la conexion
        CConexion objetoConexion = new CConexion();  
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
        
        //Tabla
        modelo.addColumn("Suma");


        
        
        param_tabla_total_Encargoss.setModel(modelo);
        
        //consultas
        sql = "SELECT sum(fv.total) from factura_venta fv";
        String [] datos = new String[1];
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
             
            while(rs.next()){
                datos[0] = rs.getString(1);

                
                modelo.addRow(datos);
            }
            
            param_tabla_total_Encargoss.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
}   
