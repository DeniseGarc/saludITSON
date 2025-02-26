/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Alici
 */
public class ConsultaDTO {

    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private String idCita;

    /**
     * Constructor de la clase ConsultaDTO.
     * 
     * @param diagnostico Diagnóstico dado durante la consulta.
     * @param tratamiento Tratamiento prescrito durante la consulta.
     * @param observaciones Observaciones adicionales de la consulta.
     * @param idCita Identificador de la cita relacionada con la consulta.
     */
    public ConsultaDTO(String diagnostico, String tratamiento, String observaciones, String idCita) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.idCita = idCita;
    }

    /**
     * Obtiene el diagnóstico de la consulta.
     * 
     * @return El diagnóstico de la consulta.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico de la consulta.
     * 
     * @param diagnostico El diagnóstico de la consulta.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene el tratamiento prescrito en la consulta.
     * 
     * @return El tratamiento prescrito.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento prescrito en la consulta.
     * 
     * @param tratamiento El tratamiento prescrito.
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Obtiene las observaciones de la consulta.
     * 
     * @return Las observaciones de la consulta.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones de la consulta.
     * 
     * @param observaciones Las observaciones de la consulta.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene el identificador de la cita relacionada con la consulta.
     * 
     * @return El identificador de la cita.
     */
    public String getIdCita() {
        return idCita;
    }

    /**
     * Establece el identificador de la cita relacionada con la consulta.
     * 
     * @param idCita El identificador de la cita.
     */
    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }
}
