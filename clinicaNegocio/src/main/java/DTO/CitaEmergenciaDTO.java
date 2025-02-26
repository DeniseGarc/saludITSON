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
     * Constructor con todos los parámetros.
     * 
     * @param idCita El ID de la cita de emergencia.
     * @param fechaHora La fecha y hora de la cita.
     * @param folioCita El folio único de la cita.
     * @param medicoDTO Información del médico asignado.
     * @param idPaciente El ID del paciente asociado.
     */
    public CitaEmergenciaDTO(String idCita, LocalDateTime fechaHora, String folioCita, MedicoDTO medicoDTO, String idPaciente) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.medicoDTO = medicoDTO;
        this.idPaciente = idPaciente;
    }

    /**
     * Constructor sin el campo idCita.
     * 
     * @param fechaHora La fecha y hora de la cita.
     * @param folioCita El folio único de la cita.
     * @param medicoDTO Información del médico asignado.
     * @param idPaciente El ID del paciente asociado.
     */
    public CitaEmergenciaDTO(LocalDateTime fechaHora, String folioCita, MedicoDTO medicoDTO, String idPaciente) {
        this.fechaHora = fechaHora;
        this.folioCita = folioCita;
        this.medicoDTO = medicoDTO;
        this.idPaciente = idPaciente;
    }

    /**
     * Obtiene el ID de la cita de emergencia.
     * 
     * @return El ID de la cita de emergencia.
     */
    public String getIdCita() {
        return idCita;
    }

    /**
     * Establece el ID de la cita de emergencia.
     * 
     * @param idCita El nuevo ID de la cita de emergencia.
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
     * Obtiene la información del médico asignado a la cita.
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
     * Obtiene el ID del paciente asociado a la cita.
     * 
     * @return El ID del paciente.
     */
    public String getIdPaciente() {
        return idPaciente;
    }

    /**
     * Establece el ID del paciente asociado a la cita.
     * 
     * @param idPaciente El nuevo ID del paciente.
     */
    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }
}
