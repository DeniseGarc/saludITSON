package DTO;

import java.util.List;

/**
 *
 * @author Alici
 */
public class MedicoDTO {
    private String IDMedico;
    private String nombresMedico;
    private String apellidoPaternoMedico;
    private String apellidoMaternoMedico;
    private String cedulaProfesional;
    private String especialidad;
    private String esstado;
    private List<HorarioDTO> horarios;

    public MedicoDTO() {
    }

    public MedicoDTO(String IDMedico, String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String esstado, List<HorarioDTO> horarios) {
        this.IDMedico = IDMedico;
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.esstado = esstado;
        this.horarios = horarios;
    }

    public MedicoDTO(String nombresMedico, String apellidoPaternoMedico, String apellidoMaternoMedico, String cedulaProfesional, String especialidad, String esstado, List<HorarioDTO> horarios) {
        this.nombresMedico = nombresMedico;
        this.apellidoPaternoMedico = apellidoPaternoMedico;
        this.apellidoMaternoMedico = apellidoMaternoMedico;
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
        this.esstado = esstado;
        this.horarios = horarios;
    }

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

    public String getEsstado() {
        return esstado;
    }

    public void setEsstado(String esstado) {
        this.esstado = esstado;
    }

    public List<HorarioDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioDTO> horarios) {
        this.horarios = horarios;
    }
    
    
}
