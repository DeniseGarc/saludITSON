/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Alici
 */
public class Medico extends Usuario {

    private String nombresMedico;
    private String apellidoPaternoMedico;
    private String apellidoMaternoMedico;
    private String cedulaProfesional;
    private String especialidad;
    private String estado;

    //constructor vacio 
    public Medico() {
        super();
    }
    //constructor con todos los atributos de la clase padre usuario y la clase hija Medico

    public Medico(int IDUsuario, String contrasenaUsuario, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String estado) {
        super(IDUsuario, cedulaProfesional, contrasenaUsuario);
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    //constructor sin contraseña.

    public Medico(int IDUsuario, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String estado) {
        super(IDUsuario, cedulaProfesional, " ");
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    //constructor con todos los atributos menos el IDUsuario
    public Medico(String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String estado, String nombreUsuario, String contrasenaUsuario) {
        super(nombreUsuario, contrasenaUsuario);
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    //gets y sets   
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

    @Override
    public String toString() {
        return "Medico{" + "nombresMedico=" + nombresMedico + ", apellidoPaternoMedico=" + apellidoPaternoMedico + ", apellidoMaternoMedico=" + apellidoMaternoMedico + ", cedulaProfesional=" + cedulaProfesional + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }

}
