/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Alici
 */
public class Consulta {

    private int IDConsulta;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private Cita cita;

    /**
     * Constructor vacío de Consulta.
     */
    public Consulta() {
    }

    /**
     * Constructor con todos los atributos de la consulta.
     * 
     * @param IDConsulta Identificador de la consulta
     * @param diagnostico Diagnóstico médico
     * @param tratamiento Tratamiento recomendado
     * @param observaciones Observaciones adicionales
     * @param cita Cita asociada a la consulta
     */
    public Consulta(int IDConsulta, String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.IDConsulta = IDConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    /**
     * Constructor sin IDConsulta.
     * 
     * @param diagnostico Diagnóstico médico
     * @param tratamiento Tratamiento recomendado
     * @param observaciones Observaciones adicionales
     * @param cita Cita asociada a la consulta
     */
    public Consulta(String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    /**
     * Obtiene el identificador de la consulta.
     * 
     * @return El identificador de la consulta.
     */
    public int getIDConsulta() {
        return IDConsulta;
    }

    /**
     * Establece el identificador de la consulta.
     * 
     * @param IDConsulta El nuevo identificador de la consulta.
     */
    public void setIDConsulta(int IDConsulta) {
        this.IDConsulta = IDConsulta;
    }

    /**
     * Obtiene el diagnóstico de la consulta.
     * 
     * @return El diagnóstico médico.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico de la consulta.
     * 
     * @param diagnostico El nuevo diagnóstico médico.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene el tratamiento recomendado en la consulta.
     * 
     * @return El tratamiento recomendado.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento recomendado en la consulta.
     * 
     * @param tratamiento El nuevo tratamiento recomendado.
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Obtiene las observaciones adicionales de la consulta.
     * 
     * @return Las observaciones de la consulta.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones adicionales de la consulta.
     * 
     * @param observaciones Las nuevas observaciones.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene la cita asociada a la consulta.
     * 
     * @return La cita asociada.
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * Establece la cita asociada a la consulta.
     * 
     * @param cita La nueva cita asociada.
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }
}