/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.CitaDTO;
import DTO.CitaRegistroDTO;
import DTO.CitaEmergenciaDTO;
import DTO.ConsultaDTO;
import DTO.MedicoDTO;
import DTO.PacienteSimpleDTO;
import entidades.Cita;
import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class CitaMapper {
    /**
    * Convierte un objeto de tipo CitaRegistroDTO a una entidad Cita.
    * 
    * 
    * @param citaDTO El objeto CitaRegistroDTO que contiene la información de la cita a convertir.
    * @return Un objeto de tipo Cita que representa la entidad correspondiente con los datos del DTO.
    */
    public Cita convertirAEntidad(CitaRegistroDTO citaDTO) {
        Medico medico = new Medico();
        medico.setIDUsuario(Integer.parseInt(citaDTO.getIdMedico()));
        Paciente paciente = new Paciente();
        paciente.setIDUsuario(Integer.parseInt(citaDTO.getIdPaciente()));
        return new Cita(citaDTO.getFechaHora(), null, null, null, medico, paciente);
    }
    /**
    * Convierte un objeto de tipo CitaEmergenciaDTO a una entidad Cita.
    * 
    * @param citaEmergencia El objeto CitaEmergenciaDTO que contiene la información de la cita de emergencia a convertir.
    * @return Un objeto de tipo Cita que representa la entidad correspondiente con los datos del DTO.
    */
    public Cita convertirAEntidad(CitaEmergenciaDTO citaEmergencia) {
        Medico medico = new Medico();
        medico.setIDUsuario(Integer.parseInt(citaEmergencia.getMedicoDTO().getIDMedico()));
        Paciente paciente = new Paciente();
        paciente.setIDUsuario(Integer.parseInt(citaEmergencia.getIdPaciente()));
        return new Cita(citaEmergencia.getFechaHora(), null, citaEmergencia.getFolioCita(), null, medico, paciente);
    }
    /**
    * Convierte una lista de objetos Cita a una lista de objetos CitaDTO.
    * 
    * @param citas La lista de objetos Cita que contiene las entidades a convertir.
    * @return Una lista de objetos CitaDTO que representa las entidades Cita en formato DTO.
    */
    public List<CitaDTO> convertirADTO(List<Cita> citas) {
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(convertirADTO(cita));
        }
        return citasDTO;
    }
    /**
    * Convierte un objeto Cita a un objeto CitaDTO.
    * 
    * @param cita El objeto Cita que se desea convertir a un CitaDTO.
    * @return Un objeto CitaDTO que representa la entidad Cita en formato DTO.
    */
    public CitaDTO convertirADTO(Cita cita) {
        return new CitaDTO(
                String.valueOf(cita.getIDCita()),
                cita.getFechaHora(),
                cita.getEstadoCita(),
                cita.getFolioCita(),
                cita.getTipo(),
                new MedicoDTO(String.valueOf(cita.getMedico().getIDUsuario()),
                        cita.getMedico().getNombresMedico(),
                        cita.getMedico().getApellidoPaternoMedico(),
                        cita.getMedico().getApellidoMaternoMedico(),
                        cita.getMedico().getEspecialidad()
                ),
                new PacienteSimpleDTO(
                        String.valueOf(cita.getPaciente().getIDUsuario()),
                        cita.getPaciente().getNombresPaciente(),
                        cita.getPaciente().getApellidoPaternoPaciente(),
                        cita.getPaciente().getApellidoMaternoPaciente(),
                        String.valueOf(cita.getPaciente().getEdad())
                )
        );
    }
    /**
    * Convierte un objeto ConsultaDTO a un objeto Consulta.
    * 
    * @param consultaDTO El objeto ConsultaDTO que se desea convertir a un objeto Consulta.
    * @return Un objeto Consulta que representa los datos del ConsultaDTO en formato entidad.
    */
    public Consulta convertirAEntidad(ConsultaDTO consultaDTO) {
        Cita cita = new Cita();
        cita.setIDCita(Integer.parseInt(consultaDTO.getIdCita()));
        return new Consulta(consultaDTO.getDiagnostico(), consultaDTO.getTratamiento(), consultaDTO.getObservaciones(), cita);
    }

}
