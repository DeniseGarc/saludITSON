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
     * Constructor con todos los parámetros.
     * 
     * @param diagnostico El diagnóstico realizado al paciente.
     * @param tratamiento El tratamiento recomendado para el paciente.
     * @param observaciones Observaciones adicionales sobre la consulta.
     * @param idCita El ID de la cita asociada a esta consulta.
     */
    public ConsultaDTO(String diagnostico, String tratamiento, String observaciones, String idCita) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.idCita = idCita;
    }

    /**
     * Obtiene el diagnóstico realizado al paciente.
     * 
     * @return El diagnóstico.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico realizado al paciente.
     * 
     * @param diagnostico El nuevo diagnóstico.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene el tratamiento recomendado para el paciente.
     * 
     * @return El tratamiento.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento recomendado para el paciente.
     * 
     * @param tratamiento El nuevo tratamiento.
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Obtiene las observaciones adicionales sobre la consulta.
     * 
     * @return Las observaciones.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones adicionales sobre la consulta.
     * 
     * @param observaciones Las nuevas observaciones.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene el ID de la cita asociada a la consulta.
     * 
     * @return El ID de la cita.
     */
    public String getIdCita() {
        return idCita;
    }

    /**
     * Establece el ID de la cita asociada a la consulta.
     * 
     * @param idCita El nuevo ID de la cita.
     */
    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }
}

