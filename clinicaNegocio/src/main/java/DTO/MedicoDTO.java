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

    /**
     * Constructor con todos los parámetros.
     * 
     * @param IDMedico El ID único del médico.
     * @param nombresMedico El nombre del médico.
     * @param apellidoPaternoMedico El apellido paterno del médico.
     * @param apellidoMaternoMedico El apellido materno del médico.
     */
    public MedicoDTO(String IDMedico, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico) {
        this.IDMedico = IDMedico;
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
    }

    /**
     * Obtiene el ID del médico.
     * 
     * @return El ID del médico.
     */
    public String getIDMedico() {
        return IDMedico;
    }

    /**
     * Establece el ID del médico.
     * 
     * @param IDMedico El nuevo ID del médico.
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
     * @param nombresMedico El nuevo nombre del médico.
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
     * @param apellidoPaternoMedico El nuevo apellido paterno del médico.
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
     * @param apellidoMaternoMedico El nuevo apellido materno del médico.
     */
    public void setApellidoMaternoMedico(String apellidoMaternoMedico) {
        this.apellidoMaternoMedico = apellidoMaternoMedico;
    }

    /**
     * Representa al médico como una cadena con su nombre completo.
     * 
     * @return El nombre completo del médico.
     */
    @Override
    public String toString() {
        return nombresMedico + " "
                + apellidoPaternoMedico + " "
                + apellidoMaternoMedico;
    }
}

