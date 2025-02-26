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
public class CitaEmergenciaDTO {

    private String idCita;
    private LocalDateTime fechaHora;
    private String folioCita;
    private MedicoDTO medicoDTO;
    private String idPaciente;

    /**
     * Constructor de la clase CitaEmergenciaDTO.
     * 
     * @param idCita Identificador único de la cita.
     * @param fechaHora Fecha y hora de la cita.
     * @param folioCita Folio asignado a la cita.
     * @param medicoDTO Información del médico relacionado con la cita.
     * @param idPaciente Identificador del paciente relacionado con la cita.
     */
    public CitaEmergenciaDTO(String idCita, LocalDateTime fechaHora, String folioCita, MedicoDTO medicoDTO, String idPaciente) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.medicoDTO = medicoDTO;
        this.idPaciente = idPaciente;
    }

    /**
     * Constructor de la clase CitaEmergenciaDTO sin el ID de la cita.
     * 
     * @param fechaHora Fecha y hora de la cita.
     * @param folioCita Folio asignado a la cita.
     * @param medicoDTO Información del médico relacionado con la cita.
     * @param idPaciente Identificador del paciente relacionado con la cita.
     */
    public CitaEmergenciaDTO(LocalDateTime fechaHora, String folioCita, MedicoDTO medicoDTO, String idPaciente) {
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.medicoDTO = medicoDTO;
        this.idPaciente = idPaciente;
    }

    /**
     * Obtiene el identificador único de la cita.
     * 
     * @return El identificador único de la cita.
     */
    public String getIdCita() {
        return idCita;
    }

    /**
     * Establece el identificador único de la cita.
     * 
     * @param idCita El identificador único de la cita.
     */
    public void setIdCita(String idCita) {
        this.idCita = idCita;
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
     * Obtiene el identificador del paciente relacionado con la cita.
     * 
     * @return El identificador del paciente.
     */
    public String getIdPaciente() {
        return idPaciente;
    }

    /**
     * Establece el identificador del paciente relacionado con la cita.
     * 
     * @param idPaciente El identificador del paciente.
     */
    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }
}
