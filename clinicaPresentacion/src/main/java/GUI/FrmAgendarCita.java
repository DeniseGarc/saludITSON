/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author Alici
 */
public class FrmAgendarCita extends javax.swing.JFrame {

    /**
     * Creates new form FrmAgendarCita
     */
    public FrmAgendarCita() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRedondo = new GUI.PanelRound();
        lblAgendarTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        dtPkrFecha = new com.github.lgooddatepicker.components.DatePicker();
        lblEspecialidad = new javax.swing.JLabel();
        cBoxEspecialidad = new javax.swing.JComboBox<>();
        lblMedico = new javax.swing.JLabel();
        cBoxMedico = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cBoxHora = new javax.swing.JComboBox<>();
        btnAgendarCita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(241, 243, 245));
        setResizable(false);

        panelRedondo.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo.setRoundBottomLeft(30);
        panelRedondo.setRoundBottomRight(30);
        panelRedondo.setRoundTopLeft(30);
        panelRedondo.setRoundTopRight(30);

        lblAgendarTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAgendarTitulo.setText("Agendar una cita nueva");

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechaRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblFecha.setText("Fecha");

        lblEspecialidad.setText("Especialidad");

        cBoxEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblMedico.setText("Médico");

        cBoxMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Hora consulta");

        cBoxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgendarCita.setBackground(new java.awt.Color(44, 44, 44));
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita.setText("Agendar Cita");
        btnAgendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRedondoLayout = new javax.swing.GroupLayout(panelRedondo);
        panelRedondo.setLayout(panelRedondoLayout);
        panelRedondoLayout.setHorizontalGroup(
            panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondoLayout.createSequentialGroup()
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblAgendarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnRegresar))
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cBoxEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cBoxMedico, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cBoxHora, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dtPkrFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRedondoLayout.createSequentialGroup()
                                    .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel1))))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        panelRedondoLayout.setVerticalGroup(
            panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblAgendarTitulo)
                .addGap(27, 27, 27)
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtPkrFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEspecialidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnAgendarCita)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgendarCitaActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmAgendarCita().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendarCita;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cBoxEspecialidad;
    private javax.swing.JComboBox<String> cBoxHora;
    private javax.swing.JComboBox<String> cBoxMedico;
    private com.github.lgooddatepicker.components.DatePicker dtPkrFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAgendarTitulo;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMedico;
    private GUI.PanelRound panelRedondo;
    // End of variables declaration//GEN-END:variables
}
