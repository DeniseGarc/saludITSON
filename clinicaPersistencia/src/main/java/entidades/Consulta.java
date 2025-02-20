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
    private int idCita;
    
   
    //Constructor vacio
    
    public Consulta() {
    }
    
    //constructor con todos los atributos 

    public Consulta(int IDConsulta, String diagnostico, String tratamiento, String observaciones, int idCita) {
        this.IDConsulta = IDConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.idCita = idCita;
    }
    
    //constructor con todos los atributos menos IDConsulta

    public Consulta(String diagnostico, String tratamiento, String observaciones, int idCita) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.idCita = idCita;
    }
    
    
    //gets y sets 

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

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
    
    //toString 

    @Override
    public String toString() {
        return "Consulta{" + "IDConsulta=" + IDConsulta + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + ", idCita=" + idCita + '}';
    }
    
    
}
