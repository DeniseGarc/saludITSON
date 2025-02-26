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

    //Constructor vacio
    public Consulta() {
    }

    //constructor con todos los atributos 
    public Consulta(int IDConsulta, String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.IDConsulta = IDConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    //constructor con todos los atributos menos IDConsulta
    public Consulta(String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    public int getIDConsulta() {
        return IDConsulta;
    }

    public void setIDConsulta(int IDConsulta) {
        this.IDConsulta = IDConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

}
