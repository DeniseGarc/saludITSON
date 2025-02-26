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

    /**
     * Constructor con todos los parámetros.
     * 
     * @param IDCita El ID de la cita.
     * @param fechaHora La fecha y hora de la cita.
     * @param folioCita El folio único de la cita.
     * @param tipo El tipo de cita.
     * @param medicoDTO Información del médico asignado.
     * @param pacienteSimpleDTO Información del paciente asociado.
     */
    public CitaDTO(String IDCita, LocalDateTime fechaHora, String folioCita, String tipo, MedicoDTO medicoDTO, PacienteSimpleDTO pacienteSimpleDTO) {
        this.IDCita = IDCita;
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.medicoDTO = medicoDTO;
        this.pacienteSimpleDTO = pacienteSimpleDTO;
    }

    /**
     * Obtiene el ID de la cita.
     * 
     * @return El ID de la cita.
     */
    public String getIDCita() {
        return IDCita;
    }

    /**
     * Establece el ID de la cita.
     * 
     * @param IDCita El nuevo ID de la cita.
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
     * @param fechaHora La nueva fecha y hora de la cita.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el folio de la cita.
     * 
     * @return El folio de la cita.
     */
    public String getFolioCita() {
        return folioCita;
    }

    /**
     * Establece el folio de la cita.
     * 
     * @param folioCita El nuevo folio de la cita.
     */
    public void setFolioCita(String folioCita) {
        this.folioCita = folioCita;
    }

    /**
     * Obtiene el tipo de la cita.
     * 
     * @return El tipo de la cita.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la cita.
     * 
     * @param tipo El nuevo tipo de la cita.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene al médico asignado a la cita.
     * 
     * @return El médico asignado.
     */
    public MedicoDTO getMedicoDTO() {
        return medicoDTO;
    }

    /**
     * Establece el médico asignado a la cita.
     * 
     * @param medicoDTO El nuevo médico asignado.
     */
    public void setMedicoDTO(MedicoDTO medicoDTO) {
        this.medicoDTO = medicoDTO;
    }

    /**
     * Obtiene la información del paciente asociado a la cita.
     * 
     * @return El paciente asociado.
     */
    public PacienteSimpleDTO getPacienteSimpleDTO() {
        return pacienteSimpleDTO;
    }

    /**
     * Establece el paciente asociado a la cita.
     * 
     * @param pacienteSimpleDTO El nuevo paciente asociado.
     */
    public void setPacienteSimpleDTO(PacienteSimpleDTO pacienteSimpleDTO) {
        this.pacienteSimpleDTO = pacienteSimpleDTO;
    }
}
