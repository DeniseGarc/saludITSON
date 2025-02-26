/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Alici
 */
public class Cita {

    private int IDCita;
    private LocalDateTime fechaHora;
    private String estadoCita;
    private String folioCita;
    private String tipo;
    private Medico medico;
    private Paciente paciente;

    /**
     * Constructor vacío de Cita.
     */
    public Cita() {
    }

    /**
     * Constructor con todos los parámetros menos IDCita.
     * 
     * @param fechaHora Fecha y hora de la cita
     * @param estadoCita Estado de la cita
     * @param folioCita Folio único de la cita
     * @param tipo Tipo de cita
     * @param medico Médico asignado
     * @param paciente Paciente asignado
     */
    public Cita(LocalDateTime fechaHora, String estadoCita, String folioCita, String tipo, Medico medico, Paciente paciente) {
        this.fechaHora = fechaHora;
        this.estadoCita = estadoCita;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param IDCita Identificador único de la cita
     * @param fechaHora Fecha y hora de la cita
     * @param estadoCita Estado de la cita
     * @param folioCita Folio único de la cita
     * @param tipo Tipo de cita
     * @param medico Médico asignado
     * @param paciente Paciente asignado
     */
    public Cita(int IDCita, LocalDateTime fechaHora, String estadoCita, String folioCita, String tipo, Medico medico, Paciente paciente) {
        this.IDCita = IDCita;
        this.fechaHora = fechaHora;
        this.estadoCita = estadoCita;
        this.folioCita = folioCita;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

    // Métodos Getters y Setters

    /**
     * Obtiene el identificador de la cita.
     * 
     * @return El identificador de la cita.
     */
    public int getIDCita() {
        return IDCita;
    }

    /**
     * Establece el identificador de la cita.
     * 
     * @param IDCita El nuevo identificador de la cita.
     */
    public void setIDCita(int IDCita) {
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
     * Obtiene el estado de la cita.
     * 
     * @return El estado de la cita.
     */
    public String getEstadoCita() {
        return estadoCita;
    }

    /**
     * Establece el estado de la cita.
     * 
     * @param estadoCita El nuevo estado de la cita.
     */
    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    /**
     * Obtiene el folio único de la cita.
     * 
     * @return El folio único de la cita.
     */
    public String getFolioCita() {
        return folioCita;
    }

    /**
     * Establece el folio único de la cita.
     * 
     * @param folioCita El nuevo folio único de la cita.
     */
    public void setFolioCita(String folioCita) {
        this.folioCita = folioCita;
    }

    /**
     * Obtiene el tipo de cita.
     * 
     * @return El tipo de cita.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de cita.
     * 
     * @param tipo El nuevo tipo de cita.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el médico asignado a la cita.
     * 
     * @return El médico asignado.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico asignado a la cita.
     * 
     * @param medico El nuevo médico asignado.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Obtiene el paciente asignado a la cita.
     * 
     * @return El paciente asignado.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asignado a la cita.
     * 
     * @param paciente El nuevo paciente asignado.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Devuelve una representación en cadena de la cita.
     * 
     * @return La cadena con los detalles de la cita.
     */
    @Override
    public String toString() {
        return "Cita{" + "IDCita=" + IDCita + ", fechaHora=" + fechaHora + ", estadoCita=" + estadoCita + ", folioCita=" + folioCita + ", tipo=" + tipo + ", medico=" + medico + ", paciente=" + paciente + '}';
    }
}
