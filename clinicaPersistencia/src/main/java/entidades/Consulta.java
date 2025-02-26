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
     * Constructor vacío para la clase Consulta.
     */
    public Consulta() {
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param IDConsulta Identificador único de la consulta.
     * @param diagnostico Diagnóstico realizado durante la consulta.
     * @param tratamiento Tratamiento recomendado en la consulta.
     * @param observaciones Observaciones adicionales de la consulta.
     * @param cita Cita asociada a la consulta.
     */
    public Consulta(int IDConsulta, String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.IDConsulta = IDConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    /**
     * Constructor sin el IDConsulta.
     * 
     * @param diagnostico Diagnóstico realizado durante la consulta.
     * @param tratamiento Tratamiento recomendado en la consulta.
     * @param observaciones Observaciones adicionales de la consulta.
     * @param cita Cita asociada a la consulta.
     */
    public Consulta(String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }


    /**
     * Obtiene el ID único de la consulta.
     * 
     * @return El ID de la consulta.
     */
    public int getIDConsulta() {
        return IDConsulta;
    }

    /**
     * Establece el ID único de la consulta.
     * 
     * @param IDConsulta El nuevo ID de la consulta.
     */
    public void setIDConsulta(int IDConsulta) {
        this.IDConsulta = IDConsulta;
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
     * @param diagnostico El nuevo diagnóstico de la consulta.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene el tratamiento de la consulta.
     * 
     * @return El tratamiento de la consulta.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento de la consulta.
     * 
     * @param tratamiento El nuevo tratamiento de la consulta.
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
     * @param observaciones Las nuevas observaciones de la consulta.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene la cita asociada a la consulta.
     * 
     * @return La cita de la consulta.
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * Establece la cita asociada a la consulta.
     * 
     * @param cita La nueva cita asociada a la consulta.
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }
    
    /**
     * Devuelve una cadena con todos los atributos de la consulta.
     * 
     * @return Una cadena que describe la consulta.
     */
    @Override
    public String toString() {
        return "Consulta{" + "IDConsulta=" + IDConsulta + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", cita=" + cita + '}';
    }
    

}
