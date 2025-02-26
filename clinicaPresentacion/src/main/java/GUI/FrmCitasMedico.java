/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BO.MedicoBO;
import configuracion.DependencyInjector;
import excepciones.NegocioException;
import java.awt.Color;
import javax.swing.JOptionPane;
import BO.CitaBO;
import BO.PacienteBO;
import DTO.CitaDTO;
import configuracion.DependencyInjector;
import excepciones.NegocioException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sesion.ManejadorSesion;

/**
 *
 * @author Alici
 */
public class FrmCitasMedico extends javax.swing.JFrame {

    private MedicoBO medicoBO = DependencyInjector.crearMedicoBO();
    private CitaBO citaBO = DependencyInjector.crearCitaBO();
    private PacienteBO pacienteBO = DependencyInjector.crearPacienteBO();
    private List<CitaDTO> citasPrevias;
    private List<CitaDTO> citasEmergencia;
    Timer timer = new Timer();

    /**
     * Creates new form FrmCitas
     */
    public FrmCitasMedico() {
        initComponents();
        cargarNombreMedico();
        cargarEstadoMedicoYActualizarBotones();
        tablaCitasEmergencia.removeColumn(tablaCitasEmergencia.getColumnModel().getColumn(0));
        tablaCitas.removeColumn(tablaCitas.getColumnModel().getColumn(0));

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                cargarCitasPrevias();
                cargarCitasEmergencia();
            }
        }, 0, 60000);
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
        btnActivarCuenta = new javax.swing.JButton();
        btnConsultaPrevia = new javax.swing.JButton();
        lblCerrarSesion = new javax.swing.JLabel();
        btnBajaTemporal = new javax.swing.JButton();
        lblNombreCompletoMedico = new javax.swing.JLabel();
        panelRedondoCitasP = new GUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        lblCitasProximas = new javax.swing.JLabel();
        btnAtenderCitaProxima = new javax.swing.JButton();
        panelRedondoCitasE = new GUI.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCitasEmergencia = new javax.swing.JTable();
        lblCitasEmergencia = new javax.swing.JLabel();
        btnAtenderCitaEmergencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(241, 243, 245));
        setResizable(false);
        setSize(new java.awt.Dimension(844, 579));

        panelBarraLateral.setBackground(new java.awt.Color(103, 172, 244));

        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avatar.png"))); // NOI18N
        lblAvatar.setPreferredSize(new java.awt.Dimension(30, 30));

        btnActivarCuenta.setBackground(new java.awt.Color(128, 204, 43));
        btnActivarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnActivarCuenta.setText("Activar cuenta");
        btnActivarCuenta.setMaximumSize(new java.awt.Dimension(72, 23));
        btnActivarCuenta.setMinimumSize(new java.awt.Dimension(72, 23));
        btnActivarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarCuentaActionPerformed(evt);
            }
        });

        btnConsultaPrevia.setBackground(new java.awt.Color(30, 98, 159));
        btnConsultaPrevia.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultaPrevia.setText("Consultas previas");
        btnConsultaPrevia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaPreviaActionPerformed(evt);
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

        btnBajaTemporal.setBackground(new java.awt.Color(195, 54, 29));
        btnBajaTemporal.setForeground(new java.awt.Color(255, 255, 255));
        btnBajaTemporal.setText("Baja temporal");
        btnBajaTemporal.setMaximumSize(new java.awt.Dimension(72, 23));
        btnBajaTemporal.setMinimumSize(new java.awt.Dimension(72, 23));
        btnBajaTemporal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaTemporalActionPerformed(evt);
            }
        });

        lblNombreCompletoMedico.setText("jLabel1");

        javax.swing.GroupLayout panelBarraLateralLayout = new javax.swing.GroupLayout(panelBarraLateral);
        panelBarraLateral.setLayout(panelBarraLateralLayout);
        panelBarraLateralLayout.setHorizontalGroup(
            panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraLateralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(panelBarraLateralLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(panelBarraLateralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBajaTemporal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultaPrevia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActivarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreCompletoMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBarraLateralLayout.setVerticalGroup(
            panelBarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraLateralLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreCompletoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnConsultaPrevia)
                .addGap(18, 18, 18)
                .addComponent(btnBajaTemporal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActivarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panelRedondoCitasP.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondoCitasP.setRoundBottomLeft(30);
        panelRedondoCitasP.setRoundBottomRight(30);
        panelRedondoCitasP.setRoundTopLeft(30);
        panelRedondoCitasP.setRoundTopRight(30);

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IdCita", "Fecha y hora", "Paciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCitas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCitas);
        if (tablaCitas.getColumnModel().getColumnCount() > 0) {
            tablaCitas.getColumnModel().getColumn(0).setResizable(false);
            tablaCitas.getColumnModel().getColumn(1).setResizable(false);
            tablaCitas.getColumnModel().getColumn(2).setResizable(false);
        }

        lblCitasProximas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCitasProximas.setText("Citas próximas");

        btnAtenderCitaProxima.setBackground(new java.awt.Color(128, 204, 43));
        btnAtenderCitaProxima.setForeground(new java.awt.Color(255, 255, 255));
        btnAtenderCitaProxima.setText("Atender cita");
        btnAtenderCitaProxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderCitaProximaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRedondoCitasPLayout = new javax.swing.GroupLayout(panelRedondoCitasP);
        panelRedondoCitasP.setLayout(panelRedondoCitasPLayout);
        panelRedondoCitasPLayout.setHorizontalGroup(
            panelRedondoCitasPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondoCitasPLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRedondoCitasPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtenderCitaProxima)
                    .addGroup(panelRedondoCitasPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCitasProximas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRedondoCitasPLayout.setVerticalGroup(
            panelRedondoCitasPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondoCitasPLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblCitasProximas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtenderCitaProxima)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelRedondoCitasE.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondoCitasE.setRoundBottomLeft(30);
        panelRedondoCitasE.setRoundBottomRight(30);
        panelRedondoCitasE.setRoundTopLeft(30);
        panelRedondoCitasE.setRoundTopRight(30);

        tablaCitasEmergencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idCita", "Fecha y hora", "Paciente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCitasEmergencia.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaCitasEmergencia);
        if (tablaCitasEmergencia.getColumnModel().getColumnCount() > 0) {
            tablaCitasEmergencia.getColumnModel().getColumn(0).setResizable(false);
            tablaCitasEmergencia.getColumnModel().getColumn(1).setResizable(false);
            tablaCitasEmergencia.getColumnModel().getColumn(2).setResizable(false);
        }

        lblCitasEmergencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCitasEmergencia.setText("Citas emergencia");

        btnAtenderCitaEmergencia.setBackground(new java.awt.Color(128, 204, 43));
        btnAtenderCitaEmergencia.setForeground(new java.awt.Color(255, 255, 255));
        btnAtenderCitaEmergencia.setText("Atender cita");
        btnAtenderCitaEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderCitaEmergenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRedondoCitasELayout = new javax.swing.GroupLayout(panelRedondoCitasE);
        panelRedondoCitasE.setLayout(panelRedondoCitasELayout);
        panelRedondoCitasELayout.setHorizontalGroup(
            panelRedondoCitasELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondoCitasELayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRedondoCitasELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtenderCitaEmergencia)
                    .addGroup(panelRedondoCitasELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCitasEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelRedondoCitasELayout.setVerticalGroup(
            panelRedondoCitasELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondoCitasELayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblCitasEmergencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtenderCitaEmergencia)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarraLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRedondoCitasE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRedondoCitasP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBarraLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelRedondoCitasE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRedondoCitasP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarCuentaActionPerformed
activarCuenta();    }//GEN-LAST:event_btnActivarCuentaActionPerformed

    private void btnConsultaPreviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaPreviaActionPerformed
        consultas();
    }//GEN-LAST:event_btnConsultaPreviaActionPerformed

    private void btnBajaTemporalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaTemporalActionPerformed
        bajaCuenta();
    }//GEN-LAST:event_btnBajaTemporalActionPerformed

    private void btnAtenderCitaEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderCitaEmergenciaActionPerformed
        atenderCita(obtenerIdCitaSeleccionadaCitasEmergencia());
    }//GEN-LAST:event_btnAtenderCitaEmergenciaActionPerformed

    private void btnAtenderCitaProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderCitaProximaActionPerformed
        atenderCita(obtenerIdCitaSeleccionadaCitasPrevias());
    }//GEN-LAST:event_btnAtenderCitaProximaActionPerformed

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        cerrarSesion();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        lblCerrarSesion.setForeground(new Color(30, 98, 159));
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        lblCerrarSesion.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_lblCerrarSesionMouseExited
    /**
    * Método que abre la ventana de consultas del médico y cierra la ventana actual.
    */
    private void consultas() {
        FrmConsultasMedico frmConsultasMedico = new FrmConsultasMedico();
        frmConsultasMedico.setVisible(true);
        this.dispose();
    }
    /**
    * Método que carga el nombre completo del médico basado en el ID del usuario en la sesión.
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
    * Método que carga el estado del médico y actualiza los botones según el estado.
    */
    private void cargarEstadoMedicoYActualizarBotones() {
        try {
            String idUsuario = ManejadorSesion.getIdUsuario();
            int idMedico = Integer.parseInt(idUsuario);
            String estadoMedico = medicoBO.obtenerEstadoMedico(idMedico);

            // Habilitar o deshabilitar botones según el estado
            if (estadoMedico.equals("activo")) {
                btnBajaTemporal.setEnabled(true);
                btnActivarCuenta.setEnabled(false);
            } else if (estadoMedico.equals("inactivo")) {
                btnBajaTemporal.setEnabled(false);
                btnActivarCuenta.setEnabled(true);
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el estado del médico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
    * Método que permite dar de baja temporal al médico después de una confirmación.
    */
    private void bajaCuenta() {
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas desactivar tu cuenta?",
                "Confirmar baja temporal",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                String idUsuario = ManejadorSesion.getIdUsuario();
                int idMedico = Integer.parseInt(idUsuario);

                boolean exito = medicoBO.darDeBajaTemporal(idMedico);
                if (exito) {
                    JOptionPane.showMessageDialog(this, "Médico dado de baja temporalmente correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarEstadoMedicoYActualizarBotones();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo dar de baja temporalmente al médico.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NegocioException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
    * Método que permite reactivar la cuenta del médico después de una confirmación.
    */
    public void activarCuenta() {
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas reactivar tu cuenta?",
                "Confirmar reactivación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                String idUsuario = ManejadorSesion.getIdUsuario();
                int idMedico = Integer.parseInt(idUsuario);

                boolean exito = medicoBO.reactivarCuenta(idMedico);
                if (exito) {
                    JOptionPane.showMessageDialog(this, "Cuenta del médico reactivada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarEstadoMedicoYActualizarBotones(); // Actualizar botones después de la operación
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo reactivar la cuenta del médico.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NegocioException e) {
                JOptionPane.showMessageDialog(this, "Error al reactivar la cuenta del médico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
    * Método que carga las citas previas del médico y las muestra en la tabla.
    */
    public void cargarCitasPrevias() {
        DefaultTableModel modeloTablaPrevias = (DefaultTableModel) tablaCitas.getModel();
        modeloTablaPrevias.setRowCount(0); // Limpiar la tabla

        try {
            List<CitaDTO> citasPrevias = citaBO.citasActivasMedico(ManejadorSesion.getIdUsuario()).stream().filter(citaDTO -> citaDTO.getTipo().equals("previa")).sorted(Comparator.comparing(CitaDTO::getFechaHora)).toList();

            // Ocultar columna ID
            for (CitaDTO cita : citasPrevias) {

                modeloTablaPrevias.addRow(new Object[]{
                    cita.getIDCita(), // Columna 0 oculta 
                    String.valueOf(cita.getFechaHora().toLocalDate().toString() + " " + cita.getFechaHora().toLocalTime()), // Columna 1 visible
                    String.valueOf(cita.getPacienteSimpleDTO()) // Columna 2 visible
                });
            }

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
    * Método que carga las citas de emergencia del médico y las muestra en la tabla.
    */
    public void cargarCitasEmergencia() {
        DefaultTableModel modeloTablaEmergencia = (DefaultTableModel) tablaCitasEmergencia.getModel();
        modeloTablaEmergencia.setRowCount(0); // Limpiar la tabla

        try {
            List<CitaDTO> citasEmergencia = citaBO.citasActivasMedico(ManejadorSesion.getIdUsuario()).stream().filter(citaDTO -> citaDTO.getTipo().equals("emergencia")).sorted(Comparator.comparing(CitaDTO::getFechaHora)).toList();

            // Tabla de citas de emergencia
            for (CitaDTO cita : citasEmergencia) {
                modeloTablaEmergencia.addRow(new Object[]{
                    cita.getIDCita(),
                    String.valueOf(cita.getFechaHora().toLocalDate().toString() + " " + cita.getFechaHora().toLocalTime()),
                    String.valueOf(cita.getPacienteSimpleDTO())
                });
            }

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
    * Método que permite atender una cita seleccionada, abriendo el formulario para registrar la consulta.
    * @param filaseleccionada El ID de la cita seleccionada.
    */
    public void atenderCita(String filaseleccionada) {
        if (filaseleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccione la cita a atender", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                CitaDTO citaDTO = citaBO.obtenerCitaPorId(filaseleccionada);
                if (LocalDateTime.now().isBefore(citaDTO.getFechaHora())) {
                    JOptionPane.showMessageDialog(null, "Espere a que sea la hora de la cita", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    FrmRegistrarConsulta frmRegistrarConsulta = new FrmRegistrarConsulta(citaDTO);
                    frmRegistrarConsulta.setVisible(true);
                    dispose();
                }
            } catch (NegocioException ex) {
                Logger.getLogger(FrmRegistrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
    * Método que obtiene el ID de la cita seleccionada en la tabla de citas previas.
    * @return El ID de la cita seleccionada, o null si no hay ninguna selección.
    */
    public String obtenerIdCitaSeleccionadaCitasPrevias() {
        int filaSeleccionada = tablaCitas.getSelectedRow();
        if (filaSeleccionada != -1) {
            return tablaCitas.getModel().getValueAt(filaSeleccionada, 0).toString();
        }
        return null;
    }
    /**
    * Método que obtiene el ID de la cita seleccionada en la tabla de citas de emergencia.
    * @return El ID de la cita seleccionada, o null si no hay ninguna selección.
    */
    public String obtenerIdCitaSeleccionadaCitasEmergencia() {
        int filaSeleccionada = tablaCitasEmergencia.getSelectedRow();
        if (filaSeleccionada != -1) {
            return tablaCitasEmergencia.getModel().getValueAt(filaSeleccionada, 0).toString();
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarCuenta;
    private javax.swing.JButton btnAtenderCitaEmergencia;
    private javax.swing.JButton btnAtenderCitaProxima;
    private javax.swing.JButton btnBajaTemporal;
    private javax.swing.JButton btnConsultaPrevia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblCitasEmergencia;
    private javax.swing.JLabel lblCitasProximas;
    private javax.swing.JLabel lblNombreCompletoMedico;
    private javax.swing.JPanel panelBarraLateral;
    private GUI.PanelRound panelRedondoCitasE;
    private GUI.PanelRound panelRedondoCitasP;
    private javax.swing.JTable tablaCitas;
    private javax.swing.JTable tablaCitasEmergencia;
    // End of variables declaration//GEN-END:variables
}
