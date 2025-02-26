package DTO;

/**
 *
 * @author Alici
 */
public class MedicoDTO {

    private String IDMedico;
    private String nombresMedico;
    private String apellidoPaternoMedico;
    private String apellidoMaternoMedico;
    private String especialidad;

    /**
     * Constructor de la clase MedicoDTO.
     * 
     * @param IDMedico Identificador único del médico.
     * @param nombresMedico Nombre del médico.
     * @param apellidoPaternoMedico Apellido paterno del médico.
     * @param apellidoMaternoMedico Apellido materno del médico.
     * @param especialidad Especialidad del médico.
     */
    public MedicoDTO(String IDMedico, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String especialidad) {
        this.IDMedico = IDMedico;
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el identificador único del médico.
     * 
     * @return El identificador del médico.
     */
    public String getIDMedico() {
        return IDMedico;
    }

    /**
     * Establece el identificador único del médico.
     * 
     * @param IDMedico El identificador del médico.
     */
    public void setIDMedico(String IDMedico) {
        this.IDMedico = IDMedico;
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
     * Devuelve una representación en forma de cadena del médico, que incluye el nombre, los apellidos y la especialidad.
     * 
     * @return Una cadena con el nombre completo y la especialidad del médico.
     */
    @Override
    public String toString() {
        return nombresMedico + " "
                + apellidoPaternoMedico + " "
                + apellidoMaternoMedico + " "
                + especialidad;
    }
}
