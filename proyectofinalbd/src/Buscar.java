import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Buscar extends JFrame implements ActionListener {

    public Buscar() {
        initComponents();
    }

                     
    private void initComponents() {
        JPanel panel = new JPanel();
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Seleccione la tabla e inserte llave primaria");

        jTextField2.setText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "encargo", "productoterminado", "uniforme", "cliente", "colegio", "materiaprima", "proveedor" }));

        jButton1.setText("volver");
        jButton1.setActionCommand("volver");

        jButton2.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(77, 77, 77)
                        .addComponent(jButton2)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(98, 98, 98))
        );
        add(panel);
    }                       

                   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField2;
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){
            BDadmin ventana = new BDadmin();
           ventana.setVisible(true);
           this.dispose();
        }else if(e.getSource() == jButton2){
            Object opcion = jComboBox1.getSelectedItem();
            String seleccion = String.valueOf(opcion);
            switch (seleccion) {
                case "encargo":
                    
                    break;
                case "productoterminado":
                    
                    break;
                case "uniforme":
                    
                    break;
                case "cliente":
                    
                    break;
                case "colegio":
                    
                    break;
                case "materiaprima":
                    
                    break;
                case "proveedor":
                    
                    break;                        
                default:
                    break;
            }

        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Buscar().setVisible(true);
        });}
                      
}
