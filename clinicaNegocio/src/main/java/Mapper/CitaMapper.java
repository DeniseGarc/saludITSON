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
     * Convierte un DTO de cita de registro a una entidad Cita.
     * 
     * @param citaDTO El DTO que contiene la información de la cita a registrar.
     * @return La entidad Cita correspondiente a los datos del DTO.
     */
    public Cita convertirAEntidad(CitaRegistroDTO citaDTO) {
        Medico medico = new Medico();
        medico.setIDUsuario(Integer.parseInt(citaDTO.getIdMedico())); 
        Paciente paciente = new Paciente();
        paciente.setIDUsuario(Integer.parseInt(citaDTO.getIdPaciente()));  
        return new Cita(citaDTO.getFechaHora(), null, null, null, medico, paciente);
    }

    /**
     * Convierte un DTO de cita de emergencia a una entidad Cita.
     * 
     * @param citaEmergencia El DTO que contiene la información de la cita de emergencia.
     * @return La entidad Cita correspondiente a los datos del DTO de emergencia.
     */
    public Cita convertirAEntidad(CitaEmergenciaDTO citaEmergencia) {
        Medico medico = new Medico();
        medico.setIDUsuario(Integer.parseInt(citaEmergencia.getMedicoDTO().getIDMedico()));  
        Paciente paciente = new Paciente();
        paciente.setIDUsuario(Integer.parseInt(citaEmergencia.getIdPaciente()));  
        return new Cita(citaEmergencia.getFechaHora(), null, citaEmergencia.getFolioCita(), null, medico, paciente);
    }

    /**
     * Convierte una lista de entidades Cita a una lista de DTOs de Cita.
     * 
     * @param citas La lista de entidades Cita a convertir.
     * @return Una lista de DTOs de Cita.
     */
    public List<CitaDTO> convertirADTO(List<Cita> citas) {
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(convertirADTO(cita));  
        }
        return citasDTO;
    }

    /**
     * Convierte una entidad Cita a un DTO de Cita.
     * 
     * @param cita La entidad Cita a convertir.
     * @return El DTO de Cita correspondiente.
     */
    public CitaDTO convertirADTO(Cita cita) {
        return new CitaDTO(
                String.valueOf(cita.getIDCita()), 
                cita.getFechaHora(),  
                cita.getFolioCita(),  
                cita.getTipo(),  
                new MedicoDTO(String.valueOf(cita.getMedico().getIDUsuario()),  
                        cita.getMedico().getNombresMedico(),
                        cita.getMedico().getApellidoPaternoMedico(),
                        cita.getMedico().getApellidoMaternoMedico()
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
     * Convierte un DTO de consulta a una entidad Consulta.
     * 
     * @param consultaDTO El DTO que contiene la información de la consulta.
     * @return La entidad Consulta correspondiente a los datos del DTO.
     */
    public Consulta convertirAEntidad(ConsultaDTO consultaDTO) {
        Cita cita = new Cita();
        cita.setIDCita(Integer.parseInt(consultaDTO.getIdCita()));  
        return new Consulta(consultaDTO.getDiagnostico(), consultaDTO.getTratamiento(), consultaDTO.getObservaciones(), cita);
    }
}
