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
     * Constructor vacío para la clase Cita.
     */
    public Cita() {
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param IDCita Identificador único de la cita.
     * @param fechaHora Fecha y hora en que se lleva a cabo la cita.
     * @param estadoCita Estado de la cita.
     * @param folioCita Folio único asignado a la cita.
     * @param tipo Tipo de cita.
     * @param medico Médico asociado a la cita.
     * @param paciente Paciente asociado a la cita.
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

    /**
     * Constructor sin el campo de idcita.
     *
     * @param fechaHora Fecha y hora en que se lleva a cabo la cita.
     * @param estadoCita Estado de la cita.
     * @param folioCita Folio único asignado a la cita.
     * @param tipo Tipo de cita.
     * @param medico Médico asociado a la cita.
     * @param paciente Paciente asociado a la cita.
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
     * Obtiene el ID de la cita.
     * 
     * @return El ID de la cita.
     */
    public int getIDCita() {
        return IDCita;
    }

    /**
     * Establece el ID de la cita.
     * 
     * @param IDCita El nuevo ID de la cita.
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
     * Obtiene el folio único asignado a la cita.
     * 
     * @return El folio de la cita.
     */
    public String getFolioCita() {
        return folioCita;
    }

    /**
     * Establece el folio único de la cita.
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
     * Obtiene el médico asociado a la cita.
     * 
     * @return El médico de la cita.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico asociado a la cita.
     * 
     * @param medico El nuevo médico de la cita.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Obtiene el paciente asociado a la cita.
     * 
     * @return El paciente de la cita.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado a la cita.
     * 
     * @param paciente El nuevo paciente de la cita.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Devuelve una cadena con todos los atributos de la cita.
     * 
     * @return Una cadena que describe la cita.
     */
    @Override
    public String toString() {
        return "Cita{" + "IDCita=" + IDCita + ", fechaHora=" + fechaHora + ", estadoCita=" + estadoCita + ", folioCita=" + folioCita + ", tipo=" + tipo + ", medico=" + medico + ", paciente=" + paciente + '}';
    }

}
