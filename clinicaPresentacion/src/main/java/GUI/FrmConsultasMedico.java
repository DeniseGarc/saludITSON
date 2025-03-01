/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BO.CitaBO;
import BO.MedicoBO;
import configuracion.DependencyInjector;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sesion.ManejadorSesion;

/**
 *
 * @author Alici
 */
public class FrmConsultasMedico extends javax.swing.JFrame {

    private MedicoBO medicoBO = DependencyInjector.crearMedicoBO();
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    /**
     * Creates new form FrmCitas
     */
    public FrmConsultasMedico() {
        initComponents();
        cargarNombreMedico();
        this.cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBarraLateral = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblCerrarSesion = new javax.swing.JLabel();
        btnCitas = new javax.swing.JButton();
        lblNombreCompletoMedico = new javax.swing.JLabel();
        panelRedondo = new GUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsulta = new javax.swing.JTable();
        lblConsultas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(844, 579));

        panelBarraLateral.setBackground(new java.awt.Color(103, 172, 244));

        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avatar.png"))); // NOI18N
        lblAvatar.setPreferredSize(new java.awt.Dimension(30, 30));

        lblCerrarSesion.setText("<html><u>Cerrar Sesión</u></html>");
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseExited(evt);
            }
        });

        btnCitas.setBackground(new java.awt.Color(30, 98, 159));
        btnCitas.setForeground(new java.awt.Color(255, 255, 255));
        btnCitas.setText("Citas");
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });

        lblNombreCompletoMedico.setText("jLabel1");

        javax.swing.GroupLayout panelBarraLateralLayout = new javax.swing.GroupLayout(panelBarraLateral);
        panelBarraLateral.setLayout(panelBarraLateralLayout);
        panelBarraLateralLayout.setHorizontalGroup(
            panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraLateralLayout.createSequentialGroup()
                .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBarraLateralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBarraLateralLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombreCompletoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelBarraLateralLayout.setVerticalGroup(
            panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraLateralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreCompletoMedico)
                .addGap(12, 12, 12)
                .addComponent(btnCitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        lblAvatar.getAccessibleContext().setAccessibleName("");

        panelRedondo.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo.setRoundBottomLeft(30);
        panelRedondo.setRoundBottomRight(30);
        panelRedondo.setRoundTopLeft(30);
        panelRedondo.setRoundTopRight(30);

        tablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha y hora", "Paciente", "Diagnóstico", "Observaciones", "Tratamiento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaConsulta);
        if (tablaConsulta.getColumnModel().getColumnCount() > 0) {
            tablaConsulta.getColumnModel().getColumn(0).setResizable(false);
            tablaConsulta.getColumnModel().getColumn(1).setResizable(false);
            tablaConsulta.getColumnModel().getColumn(2).setResizable(false);
            tablaConsulta.getColumnModel().getColumn(3).setResizable(false);
            tablaConsulta.getColumnModel().getColumn(4).setResizable(false);
            tablaConsulta.getColumnModel().getColumn(5).setResizable(false);
        }

        lblConsultas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblConsultas.setText("Consultas previas");

        javax.swing.GroupLayout panelRedondoLayout = new javax.swing.GroupLayout(panelRedondo);
        panelRedondo.setLayout(panelRedondoLayout);
        panelRedondoLayout.setHorizontalGroup(
            panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelRedondoLayout.setVerticalGroup(
            panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
        citas();
    }//GEN-LAST:event_btnCitasActionPerformed

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        lblCerrarSesion.setForeground(new Color(30, 98, 159));
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        lblCerrarSesion.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        cerrarSesion();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked
    /**
    * Carga el nombre completo del médico en la interfaz de usuario utilizando el ID del usuario.
    */
    private void cargarNombreMedico() {
        try {
            String idUsuario = ManejadorSesion.getIdUsuario();
            int idMedico = Integer.parseInt(idUsuario);
            String nombreCompleto = medicoBO.obtenerNombreCompletoMedico(idMedico);
            lblNombreCompletoMedico.setText(nombreCompleto);
        } catch (NegocioException e) {

        }
    }

    private void citas() {
        FrmCitasMedico frmCitasMedico = new FrmCitasMedico();
        frmCitasMedico.setVisible(true);
        this.dispose();
    }

    private void cerrarSesion() {
        ManejadorSesion.borrarDatosSesion();
        FrmInicioSesion frmInicio = new FrmInicioSesion();
        frmInicio.setVisible(true);
        this.dispose();
    }
    /**
    * Carga las consultas previas del médico en la tabla de consultas.
    * Si ocurre un error de persistencia, muestra un mensaje de error.
    */
     public void cargarTabla(){
        try {
            
            DefaultTableModel modelo = (DefaultTableModel) this.tablaConsulta.getModel();
            modelo = this.citaBO.ObtenerConsultasPreviasMedico(this.tablaConsulta, Integer.parseInt(ManejadorSesion.getIdUsuario()));
        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmConsultasPaciente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: error al cargar los datos");
        }

    }
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
//            java.util.logging.Logger.getLogger(FrmConsultasMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmConsultasMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmConsultasMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmConsultasMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmConsultasMedico().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCitas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblConsultas;
    private javax.swing.JLabel lblNombreCompletoMedico;
    private javax.swing.JPanel panelBarraLateral;
    private GUI.PanelRound panelRedondo;
    private javax.swing.JTable tablaConsulta;
    // End of variables declaration//GEN-END:variables
}
