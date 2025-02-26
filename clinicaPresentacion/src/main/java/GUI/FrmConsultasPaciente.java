/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BO.PacienteBO;
import configuracion.DependencyInjector;
import excepciones.NegocioException;
import java.awt.Color;
import sesion.ManejadorSesion;

/**
 *
 * @author Alici
 */
public class FrmConsultasPaciente extends javax.swing.JFrame {
    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    /**
     * Creates new form FrmCitas
     */
    public FrmConsultasPaciente() {
        initComponents();
        cargarNombrePaciente();
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
        btnGenerarConsulta = new javax.swing.JButton();
        btnConsultaPrevia = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();
        lblCerrarSesion = new javax.swing.JLabel();
        lblNombreCompletoPaciente = new javax.swing.JLabel();
        panelRedondo = new GUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();
        lblCitasProximas = new javax.swing.JLabel();
        dtPkrDesde = new com.github.lgooddatepicker.components.DatePicker();
        dtPkrHasta = new com.github.lgooddatepicker.components.DatePicker();
        lblDesde = new javax.swing.JLabel();
        lblHasta = new javax.swing.JLabel();
        cBoxEspecialidad = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        lblEspecialidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(844, 579));

        panelBarraLateral.setBackground(new java.awt.Color(103, 172, 244));

        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avatar.png"))); // NOI18N
        lblAvatar.setPreferredSize(new java.awt.Dimension(30, 30));
        lblAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvatarMouseClicked(evt);
            }
        });

        btnGenerarConsulta.setText("Generar consulta");
        btnGenerarConsulta.setBackground(new java.awt.Color(128, 204, 43));
        btnGenerarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarConsultaActionPerformed(evt);
            }
        });

        btnConsultaPrevia.setText("Consultas previas");
        btnConsultaPrevia.setBackground(new java.awt.Color(30, 98, 159));
        btnConsultaPrevia.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaPrevia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaPreviaActionPerformed(evt);
            }
        });

        btnCitas.setText("Citas");
        btnCitas.setBackground(new java.awt.Color(30, 98, 159));
        btnCitas.setForeground(new java.awt.Color(255, 255, 255));
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });

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

        lblNombreCompletoPaciente.setText("jLabel1");

        javax.swing.GroupLayout panelBarraLateralLayout = new javax.swing.GroupLayout(panelBarraLateral);
        panelBarraLateral.setLayout(panelBarraLateralLayout);
        panelBarraLateralLayout.setHorizontalGroup(
            panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraLateralLayout.createSequentialGroup()
                .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBarraLateralLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBarraLateralLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNombreCompletoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnConsultaPrevia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGenerarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        panelBarraLateralLayout.setVerticalGroup(
            panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraLateralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreCompletoPaciente)
                .addGap(12, 12, 12)
                .addComponent(btnGenerarConsulta)
                .addGap(18, 18, 18)
                .addComponent(btnConsultaPrevia)
                .addGap(18, 18, 18)
                .addComponent(btnCitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        lblAvatar.getAccessibleContext().setAccessibleName("");

        panelRedondo.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo.setRoundBottomLeft(30);
        panelRedondo.setRoundBottomRight(30);
        panelRedondo.setRoundTopLeft(30);
        panelRedondo.setRoundTopRight(30);

        tablaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha y hora", "Especialidad", "Médico", "Diagnóstico", "Tratamiento", "Estado"
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
        tablaConsultas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaConsultas);
        if (tablaConsultas.getColumnModel().getColumnCount() > 0) {
            tablaConsultas.getColumnModel().getColumn(0).setResizable(false);
            tablaConsultas.getColumnModel().getColumn(1).setResizable(false);
            tablaConsultas.getColumnModel().getColumn(2).setResizable(false);
            tablaConsultas.getColumnModel().getColumn(3).setResizable(false);
            tablaConsultas.getColumnModel().getColumn(4).setResizable(false);
            tablaConsultas.getColumnModel().getColumn(5).setResizable(false);
        }

        lblCitasProximas.setText("Consultas previas");
        lblCitasProximas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblDesde.setText("Desde");

        lblHasta.setText("Hasta");

        cBoxEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.setBackground(new java.awt.Color(128, 204, 43));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        lblEspecialidad.setText("Especialidad");

        javax.swing.GroupLayout panelRedondoLayout = new javax.swing.GroupLayout(panelRedondo);
        panelRedondo.setLayout(panelRedondoLayout);
        panelRedondoLayout.setHorizontalGroup(
            panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCitasProximas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelRedondoLayout.createSequentialGroup()
                            .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtPkrDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtPkrHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRedondoLayout.createSequentialGroup()
                                    .addComponent(cBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRedondoLayout.setVerticalGroup(
            panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesde)
                    .addComponent(lblHasta)
                    .addComponent(lblEspecialidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtPkrDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtPkrHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addGap(39, 39, 39)
                .addComponent(lblCitasProximas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarConsultaActionPerformed

    private void btnConsultaPreviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaPreviaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultaPreviaActionPerformed

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        lblCerrarSesion.setForeground(new Color(30, 98, 159));
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        lblCerrarSesion.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_lblCerrarSesionMouseExited

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        cerrarSesion();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void lblAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvatarMouseClicked
        actualizarDatos();       
    }//GEN-LAST:event_lblAvatarMouseClicked
    /**
    * Método que carga el nombre completo del usuario basado en el ID del usuario en la sesión.
    */
    private void cargarNombrePaciente() {
    try {
        String idUsuario = ManejadorSesion.getIdUsuario();
        int idPaciente = Integer.parseInt(idUsuario);
        String nombreCompleto = pacienteBO.obtenerNombreCompletoPaciente(idPaciente);
        lblNombreCompletoPaciente.setText(nombreCompleto);
    } catch (NegocioException e) {
       
    }
    }
        /**
        * Método que cierra la sesión del usuario y redirige a la pantalla de inicio de sesión.
        */
        private void cerrarSesion() {
        ManejadorSesion.borrarDatosSesion();
        FrmInicioSesion frmInicio = new FrmInicioSesion(); 
        frmInicio.setVisible(true);
        this.dispose();
    }
         /**
        * Método que abre la ventana para actualizar los datos del paciente y cierra la ventana actual.
        */
        private void actualizarDatos(){
        FrmActualizarDatosPaciente frmActualizar = new FrmActualizarDatosPaciente();
        frmActualizar.setVisible(true);
        this.dispose();
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
//            java.util.logging.Logger.getLogger(FrmConsultasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmConsultasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmConsultasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmConsultasPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
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
//                new FrmConsultasPaciente().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnConsultaPrevia;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGenerarConsulta;
    private javax.swing.JComboBox<String> cBoxEspecialidad;
    private com.github.lgooddatepicker.components.DatePicker dtPkrDesde;
    private com.github.lgooddatepicker.components.DatePicker dtPkrHasta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblCitasProximas;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblNombreCompletoPaciente;
    private javax.swing.JPanel panelBarraLateral;
    private GUI.PanelRound panelRedondo;
    private javax.swing.JTable tablaConsultas;
    // End of variables declaration//GEN-END:variables
}
