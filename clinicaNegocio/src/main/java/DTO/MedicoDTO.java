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
    //Constructor con los atributos de Medico.
    public MedicoDTO(String IDMedico, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String especialidad) {
        this.IDMedico = IDMedico;
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.especialidad = especialidad;
    }
    // Gets y Sets
    public String getIDMedico() {
        return IDMedico;
    }

    public void setIDMedico(String IDMedico) {
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return nombresMedico + " "
                + apellidoPaternoMedico + " "
                + apellidoMaternoMedico + " "
                + especialidad;
    }
}
