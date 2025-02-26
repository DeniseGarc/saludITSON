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
     * Constructor con todos los parámetros.
     * 
     * @param fechaHora La fecha y hora de la cita.
     * @param idMedico El ID del médico asignado a la cita.
     * @param idPaciente El ID del paciente asociado a la cita.
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
     * @param fechaHora La nueva fecha y hora de la cita.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el ID del médico asignado a la cita.
     * 
     * @return El ID del médico.
     */
    public String getIdMedico() {
        return idMedico;
    }

    /**
     * Establece el ID del médico asignado a la cita.
     * 
     * @param idMedico El nuevo ID del médico.
     */
    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
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
