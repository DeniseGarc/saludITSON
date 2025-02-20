/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

/**
 *
 * @author Alici
 */
public class Medico extends Usuario{
    private int IDMedico;
    private String nombresMedico;
    private String apellidoPaternoMedico;
    private String apellidoMaternoMedico;
    private String cedulaProfesional;
    private String especialidad;
    private String estado;
    private List<Horario> horario;
    //constructor vacio 

    public Medico() {
    }
    
    //constructor con todos los atributos 

    public Medico(int IDMedico, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String estado, List<Horario> horario) {
        this.IDMedico = IDMedico;
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
        this.horario = horario;
    }

    
   
    
    //constructor con todos los atributos menos el IDMedico
    public Medico(String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String estado, List<Horario> horario) {
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
        this.horario = horario;
    }

    //gets y sets
    public int getIDMedico() {
        return IDMedico;
    }

    public void setIDMedico(int IDMedico) {
        this.IDMedico = IDMedico;
    }

    public String getNombresMedico() {
        return nombresMedico;
    }

    public void setNombresMedico(String nombresMedico) {
        this.nombresMedico = nombresMedico;
    }

    public String getApellidoPaternoMedico() {
        return apellidoPaternoMedico;
    }

    public void setApellidoPaternoMedico(String apellidoPaternoMedico) {
        this.apellidoPaternoMedico = apellidoPaternoMedico;
    }

    public String getApellidoMaternoMedico() {
        return apellidoMaternoMedico;
    }

    public void setApellidoMaternoMedico(String apellidoMaternoMedico) {
        this.apellidoMaternoMedico = apellidoMaternoMedico;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }

   
    //toString 

    @Override
    public String toString() {
        return "Medico{" + "IDMedico=" + IDMedico + ", nombresMedico=" + nombresMedico + ", apellidoPaternoMedico=" + apellidoPaternoMedico + ", apellidoMaternoMedico=" + apellidoMaternoMedico + ", cedulaProfesional=" + cedulaProfesional + ", especialidad=" + especialidad + ", estado=" + estado + ", horario=" + horario + '}';
    }

    
    
    
}
