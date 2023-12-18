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

public class BDadmin extends JFrame implements ActionListener {

    public BDadmin() {
        initComponents();
    }
                       
    private void initComponents() {

        JPanel panel = new JPanel();
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "buscar", "actualizar", "borrar", "insertar" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Inserte la Accion a realizar");

        jButton1.setText("volver");
        jButton1.addActionListener(this);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(this);

        GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        add(panel);
    }                      

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          


                       
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){
            Adminhub ventana = new Adminhub();
           ventana.setVisible(true);
           this.dispose();
        }else if(e.getSource() == jButton2){
            if(jComboBox1.getSelectedItem().equals("buscar")){
                Buscar ventana = new Buscar();
                ventana.setVisible(true);
                this.dispose();

            }else if(jComboBox1.getSelectedItem().equals("actualizar")){
                Actualizar ventana = new Actualizar();
                ventana.setVisible(true);
                this.dispose();

            }else if(jComboBox1.getSelectedItem().equals("borrar")){
                Borrar ventana = new Borrar();
                ventana.setVisible(true);
                this.dispose();

            }else if(jComboBox1.getSelectedItem().equals("insertar")){
                Agregar ventana = new Agregar();
                ventana.setVisible(true);
                this.dispose();

            }

        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new BDadmin().setVisible(true);
        });}
}