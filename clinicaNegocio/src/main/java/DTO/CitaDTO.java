/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;

/**
 *
 * @author Alici
 */
public class CitaDTO {
    
    private String IDCita;
    private LocalDateTime fechaHora;
    private String folioCita;
    private String tipo;
    private MedicoDTO medicoDTO;
    private PacienteSimpleDTO pacienteSimpleDTO;
    private String estado;

    /**
     * Constructor de la clase CitaDTO.
     * 
     * @param IDCita Identificador único de la cita.
     * @param fechaHora Fecha y hora de la cita.
     * @param estado Estado de la cita.
     * @param folioCita Folio asignado a la cita.
     * @param tipo Tipo de cita.
     * @param medicoDTO Información del médico relacionado con la cita.
     * @param pacienteSimpleDTO Información del paciente relacionado con la cita.
     */
    public CitaDTO(String IDCita, LocalDateTime fechaHora, String estado, String folioCita, String tipo, MedicoDTO medicoDTO, PacienteSimpleDTO pacienteSimpleDTO) {
        this.IDCita = IDCita;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.medicoDTO = medicoDTO;
        this.pacienteSimpleDTO = pacienteSimpleDTO;
    }

    /**
     * Obtiene el identificador único de la cita.
     * 
     * @return El identificador único de la cita.
     */
    public String getIDCita() {
        return IDCita;
    }

    /**
     * Establece el identificador único de la cita.
     * 
     * @param IDCita El identificador único de la cita.
     */
    public void setIDCita(String IDCita) {
        this.IDCita = IDCita;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     * 
     * @return La fecha y hora de la cita.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la cita.
     * 
     * @param fechaHora La fecha y hora de la cita.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el estado de la cita.
     * 
     * @return El estado de la cita.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cita.
     * 
     * @param estado El estado de la cita.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el folio asignado a la cita.
     * 
     * @return El folio de la cita.
     */
    public String getFolioCita() {
        return folioCita;
    }

    /**
     * Establece el folio asignado a la cita.
     * 
     * @param folioCita El folio de la cita.
     */
    public void setFolioCita(String folioCita) {
        this.folioCita = folioCita;
    }

    /**
     * Obtiene el tipo de la cita.
     * 
     * @return El tipo de cita.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la cita.
     * 
     * @param tipo El tipo de cita.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la información del médico relacionado con la cita.
     * 
     * @return El médico relacionado con la cita.
     */
    public MedicoDTO getMedicoDTO() {
        return medicoDTO;
    }

    /**
     * Establece la información del médico relacionado con la cita.
     * 
     * @param medicoDTO El médico relacionado con la cita.
     */
    public void setMedicoDTO(MedicoDTO medicoDTO) {
        this.medicoDTO = medicoDTO;
    }

    /**
     * Obtiene la información del paciente relacionado con la cita.
     * 
     * @return El paciente relacionado con la cita.
     */
    public PacienteSimpleDTO getPacienteSimpleDTO() {
        return pacienteSimpleDTO;
    }

    /**
     * Establece la información del paciente relacionado con la cita.
     * 
     * @param pacienteSimpleDTO El paciente relacionado con la cita.
     */
    public void setPacienteSimpleDTO(PacienteSimpleDTO pacienteSimpleDTO) {
        this.pacienteSimpleDTO = pacienteSimpleDTO;
    }

    
    
}
