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
public class CitaRegistroDTO {

    private LocalDateTime fechaHora;
    private String idMedico;
    private String idPaciente;

    /**
     * Constructor de la clase CitaRegistroDTO.
     * 
     * @param fechaHora Fecha y hora de la cita.
     * @param idMedico Identificador del médico relacionado con la cita.
     * @param idPaciente Identificador del paciente relacionado con la cita.
     */
    public CitaRegistroDTO(LocalDateTime fechaHora, String idMedico, String idPaciente) {
        this.fechaHora = fechaHora;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
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
     * Obtiene el identificador del médico relacionado con la cita.
     * 
     * @return El identificador del médico.
     */
    public String getIdMedico() {
        return idMedico;
    }

    /**
     * Establece el identificador del médico relacionado con la cita.
     * 
     * @param idMedico El identificador del médico.
     */
    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
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