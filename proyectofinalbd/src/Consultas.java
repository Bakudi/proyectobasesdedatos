import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Consultas extends JFrame implements ActionListener {

    public Consultas() {
        initComponents();
    }
                         
    private void initComponents() {

        JPanel panel = new JPanel();
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jLabel1.setText("Consultas preestablecidas en los requisitos funcionales");

        jButton1.setText("consulta 1");
        jButton1.addActionListener(this);

        jButton2.setText("consulta 2");
        jButton2.addActionListener(this);

        jButton3.setText("consulta 3");
        jButton3.addActionListener(this);

        jButton4.setText("consulta 4");
        jButton4.addActionListener(this);

        jButton5.setText("consulta 5");
        jButton5.addActionListener(this);

        jButton6.setText("consulta 6");
        jButton6.addActionListener(this);

        jButton7.setText("consulta 7");
        jButton7.addActionListener(this);

        jButton8.setText("Volver");
        jButton8.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton4)
                        .addGap(20, 20, 20)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jButton8)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        add(panel);
    }                      

                   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;               

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){

        }

        if(e.getSource() == jButton2){
            
        }

        if(e.getSource() == jButton3){
            
        }

        if(e.getSource() == jButton4){
            
        }

        if(e.getSource() == jButton5){
            
        }

        if(e.getSource() == jButton6){
            
        }

        if(e.getSource() == jButton7){
            
        }
        if(e.getSource() == jButton8){
            Login ventana = new Login();
           ventana.setVisible(true);
           this.dispose();
    }}

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Consultas().setVisible(true);
        });}
}
