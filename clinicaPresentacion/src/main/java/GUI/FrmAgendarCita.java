/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BO.CitaBO;
import DTO.CitaRegistroDTO;
import DTO.MedicoDTO;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import configuracion.DependencyInjector;
import excepciones.NegocioException;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sesion.ManejadorSesion;

/**
 *
 * @author Alici
 */
public class FrmAgendarCita extends javax.swing.JFrame {
    private CitaBO citaBO = DependencyInjector.crearCitaBO();

    /**
     * Creates new form FrmAgendarCita
     */
    public FrmAgendarCita() {
        initComponents();
        cBoxMedico.setEnabled(false);
        cBoxHora.setEnabled(false);
        btnAgendarCita.setEnabled(false);
        llenarComboEspecialidad();
        agregarListeners();
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
        lblEspecialidad = new javax.swing.JLabel();
        cBoxEspecialidad = new javax.swing.JComboBox<>();
        lblMedico = new javax.swing.JLabel();
        cBoxMedico = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cBoxHora = new javax.swing.JComboBox<>();
        btnAgendarCita = new javax.swing.JButton();
        dtPkrFecha = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(241, 243, 245));
        setResizable(false);

        panelRedondo.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo.setRoundBottomLeft(30);
        panelRedondo.setRoundBottomRight(30);
        panelRedondo.setRoundTopLeft(30);
        panelRedondo.setRoundTopRight(30);

        lblAgendarTitulo.setText("Agendar una cita nueva");
        lblAgendarTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flechaRegresar.png"))); // NOI18N
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblFecha.setText("Fecha de la cita");

        lblEspecialidad.setText("Especialidad");

        lblMedico.setText("Médico");

        cBoxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxMedicoActionPerformed(evt);
            }
        });

        jLabel1.setText("Hora consulta");

        btnAgendarCita.setText("Agendar Cita");
        btnAgendarCita.setBackground(new java.awt.Color(44, 44, 44));
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addGap(42, 42, 42)
                        .addComponent(lblAgendarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnRegresar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelRedondoLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addComponent(dtPkrFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE))
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgendarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );
        panelRedondoLayout.setVerticalGroup(
            panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAgendarTitulo)
                .addGap(60, 60, 60)
                .addGroup(panelRedondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtPkrFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRedondoLayout.createSequentialGroup()
                        .addComponent(lblEspecialidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(lblMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(btnAgendarCita)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(panelRedondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
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
        regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaActionPerformed
        agendarCita();
    }//GEN-LAST:event_btnAgendarCitaActionPerformed

    private void cBoxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxMedicoActionPerformed

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
    
    /**
    * Método para agendar una cita médica. Recoge la información de la interfaz,
    * crea un objeto CitaRegistroDTO y llama a la lógica de negocio para agendar la cita.
    * Muestra un mensaje de éxito o error dependiendo del resultado.
    */
    private void agendarCita() {
        try {
            LocalDate fecha = dtPkrFecha.getDate();
            String especialidad = cBoxEspecialidad.getSelectedItem().toString();
            String hora = cBoxHora.getSelectedItem().toString();
            LocalDateTime fechaHora = fecha.atTime(LocalTime.parse(hora));
            MedicoDTO medicoDTO = (MedicoDTO) cBoxMedico.getSelectedItem();
            CitaRegistroDTO citaDTO = new CitaRegistroDTO(fechaHora, medicoDTO.getIDMedico(), ManejadorSesion.getIdUsuario());
            boolean exito = citaBO.agendarCita(citaDTO);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Se ha agendado correctamente su cita");
                regresar();
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al agendar su cita", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NegocioException ex) {
            Logger.getLogger(FrmAgendarCita.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    /**
    * Método para agregar los listeners a los componentes de la interfaz.
    */
    private void agregarListeners() {
        // Listener para fecha
        dtPkrFecha.addDateChangeListener(new DateChangeListener() {
            @Override
            public void dateChanged(DateChangeEvent event) {
                if (event.getNewDate() != null) {
                    cBoxEspecialidad.setEnabled(true);
                    actualizarDatosPorFecha();
                } else {
                    reiniciarFormulario();
                }
            }
        });

        // Listener para cBoxEspecialidad
        cBoxEspecialidad.addItemListener(e -> {
            if (cBoxEspecialidad.getSelectedIndex() != -1) {
                llenarComboMedicos();
            } else {
                cBoxMedico.setEnabled(false);
                cBoxHora.setEnabled(false); 
            }
        });

        // Listener para cBoxMedico
        cBoxMedico.addItemListener(e -> {
            if (cBoxMedico.getSelectedIndex() != -1) {
                llenarComboHoras();
            } else {
                cBoxHora.setEnabled(false);
            }
        });

        cBoxHora.addItemListener(e -> {
            btnAgendarCita.setEnabled(cBoxEspecialidad.getSelectedIndex() != -1
                    && cBoxHora.getSelectedIndex() != -1
                    && cBoxMedico.getSelectedIndex() != -1
                    && dtPkrFecha.getDate() != null);
        });
    }
    /**
    * Método para llenar el combo de especialidades con las opciones disponibles.
    * Si no hay especialidades, deshabilita los combos de especialidad y médico 
    * y muestra un mensaje de error.
    */
    private void llenarComboEspecialidad() {
        try {
            cBoxEspecialidad.removeAllItems();
            List<String> listaEspecialidades = citaBO.especialidadesMedicos();

            if (listaEspecialidades.isEmpty()) {
                throw new NegocioException("No hay especialidades disponibles");
            }
            for (String especialidad : listaEspecialidades) {
                cBoxEspecialidad.addItem(especialidad);
            }
            cBoxEspecialidad.setSelectedIndex(-1);
        } catch (NegocioException ex) {
            cBoxEspecialidad.setEnabled(false);
            cBoxMedico.setEnabled(false);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
    * Método para llenar el combo de médicos filtrados por la especialidad seleccionada.
    * Si no hay médicos disponibles, deshabilita los combos de médico y hora 
    * y muestra un mensaje de error.
    */
    private void llenarComboMedicos() {
        try {
            cBoxMedico.removeAllItems();

            List<MedicoDTO> listaMedicosDTOs = citaBO.medicosFiltradosPorEspecialidad(
                    cBoxEspecialidad.getSelectedItem().toString()
            );

            if (listaMedicosDTOs.isEmpty()) {
                throw new NegocioException("No hay médicos disponibles");
            }

            for (MedicoDTO medicoDTO : listaMedicosDTOs) {
                cBoxMedico.addItem(medicoDTO);
            }
            cBoxMedico.setEnabled(true);

        } catch (NegocioException ex) {
            cBoxMedico.setEnabled(false);
            cBoxHora.setEnabled(false);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
    * Método para llenar el combo de horas disponibles para la cita según el médico y la fecha seleccionados.
    * Si no hay horarios disponibles, deshabilita el combo de hora y muestra un mensaje de error.
    */
    private void llenarComboHoras() {
        try {
            cBoxHora.removeAllItems();
            List<String> listaHorariosCita = citaBO.horariosCitaMedico((MedicoDTO) cBoxMedico.getSelectedItem(), dtPkrFecha.getDate());
            if (listaHorariosCita.isEmpty()) {
                throw new NegocioException("No hay horarios disponibles para el médico en la fecha seleccionada");
            } else {
                for (String hora : listaHorariosCita) {
                    cBoxHora.addItem(hora);
                }
                cBoxHora.setEnabled(true);
            }
        } catch (NegocioException ex) {
            Logger.getLogger(FrmAgendarCita.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
            cBoxHora.setEnabled(false);
        }
    }
    /**
    * Método que actualiza los datos de médicos y horarios basados en la fecha seleccionada.
    * Si la especialidad está seleccionada, llena el combo de médicos.
    * Si el médico está seleccionado, llena el combo de horarios.
    */
    private void actualizarDatosPorFecha() {
        if (cBoxEspecialidad.getSelectedIndex() != -1) {
            llenarComboMedicos();
        }
        if (cBoxMedico.getSelectedIndex() != -1) {
            llenarComboHoras();
        }
    }
    /**
    * Método que reinicia el formulario.
    * Desactiva los campos de especialidad, médico, hora y el botón de agendar cita.
    * Además, restablece las selecciones de los combos a su estado inicial.
    */
    private void reiniciarFormulario() {
        cBoxEspecialidad.setEnabled(false);
        cBoxMedico.setEnabled(false);
        cBoxHora.setEnabled(false);
        btnAgendarCita.setEnabled(false);

        cBoxEspecialidad.setSelectedIndex(-1);
        cBoxMedico.setSelectedIndex(-1);
        cBoxMedico.setSelectedIndex(-1);
    }
    /**
    * Navega a la ventana principal de Citas del Paciente y cierra la ventana actual.
    */
    private void regresar() {
        FrmCitasPaciente frmCitasPaciente = new FrmCitasPaciente();
        frmCitasPaciente.setVisible(true);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendarCita;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cBoxEspecialidad;
    private javax.swing.JComboBox<String> cBoxHora;
    private javax.swing.JComboBox<MedicoDTO> cBoxMedico;
    private com.github.lgooddatepicker.components.DatePicker dtPkrFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAgendarTitulo;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMedico;
    private GUI.PanelRound panelRedondo;
    // End of variables declaration//GEN-END:variables
}
