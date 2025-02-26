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

    /**
     * Constructor vacío para la clase Medico.
     */
    public Medico() {
        super();
    }

    /**
     * Constructor con todos los atributos de la clase padre Usuario y la clase hija Medico.
     * 
     * @param IDUsuario Identificador único del usuario.
     * @param contrasenaUsuario Contraseña del usuario.
     * @param nombresMedico Nombres del médico.
     * @param apellidoPaternoMedico Apellido paterno del médico.
     * @param apellidoMaternoMedico Apellido materno del médico.
     * @param cedulaProfesional Cédula profesional del médico.
     * @param especialidad Especialidad médica del doctor.
     * @param estado Estado del médico.
     */
    public Medico(int IDUsuario, String contrasenaUsuario, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String estado) {
        super(IDUsuario, cedulaProfesional, contrasenaUsuario);
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    /**
     * Constructor con todos los atributos menos el IDUsuario.
     * 
     * @param nombresMedico Nombres del médico.
     * @param apellidoPaternoMedico Apellido paterno del médico.
     * @param apellidoMaternoMedico Apellido materno del médico.
     * @param cedulaProfesional Cédula profesional del médico.
     * @param especialidad Especialidad médica del doctor.
     * @param estado Estado del médico.
     * @param nombreUsuario Nombre de usuario.
     * @param contrasenaUsuario Contraseña del usuario.
     */
    public Medico(String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String estado, String nombreUsuario, String contrasenaUsuario) {
        super(nombreUsuario, contrasenaUsuario);
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    /**
     * Obtiene el nombre del médico.
     * 
     * @return El nombre del médico.
     */
    public String getNombresMedico() {
        return nombresMedico;
    }

    /**
     * Establece el nombre del médico.
     * 
     * @param nombresMedico El nombre del médico.
     */
    public void setNombresMedico(String nombresMedico) {
        this.nombresMedico = nombresMedico;
    }

    /**
     * Obtiene el apellido paterno del médico.
     * 
     * @return El apellido paterno del médico.
     */
    public String getApellidoPaternoMedico() {
        return apellidoPaternoMedico;
    }

    /**
     * Establece el apellido paterno del médico.
     * 
     * @param apellidoPaternoMedico El apellido paterno del médico.
     */
    public void setApellidoPaternoMedico(String apellidoPaternoMedico) {
        this.apellidoPaternoMedico = apellidoPaternoMedico;
    }

    /**
     * Obtiene el apellido materno del médico.
     * 
     * @return El apellido materno del médico.
     */
    public String getApellidoMaternoMedico() {
        return apellidoMaternoMedico;
    }

    /**
     * Establece el apellido materno del médico.
     * 
     * @param apellidoMaternoMedico El apellido materno del médico.
     */
    public void setApellidoMaternoMedico(String apellidoMaternoMedico) {
        this.apellidoMaternoMedico = apellidoMaternoMedico;
    }

    /**
     * Obtiene la cédula profesional del médico.
     * 
     * @return La cédula profesional del médico.
     */
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    /**
     * Establece la cédula profesional del médico.
     * 
     * @param cedulaProfesional La cédula profesional del médico.
     */
    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    /**
     * Obtiene la especialidad del médico.
     * 
     * @return La especialidad del médico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad del médico.
     * 
     * @param especialidad La especialidad del médico.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el estado del médico.
     * 
     * @return El estado del médico.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del médico.
     * 
     * @param estado El estado del médico.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna una cadena con los atributos del médico.
     * 
     * @return Una cadena que representa al médico.
     */
    @Override
    public String toString() {
        return "Medico{" + "nombresMedico=" + nombresMedico + ", apellidoPaternoMedico=" + apellidoPaternoMedico + ", apellidoMaternoMedico=" + apellidoMaternoMedico + ", cedulaProfesional=" + cedulaProfesional + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }

}
