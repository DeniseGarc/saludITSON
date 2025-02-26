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

    public Cita convertirAEntidad(CitaRegistroDTO citaDTO) {
        Medico medico = new Medico();
        medico.setIDUsuario(Integer.parseInt(citaDTO.getIdMedico()));
        Paciente paciente = new Paciente();
        paciente.setIDUsuario(Integer.parseInt(citaDTO.getIdPaciente()));
        return new Cita(citaDTO.getFechaHora(), null, null, null, medico, paciente);
    }

    public Cita convertirAEntidad(CitaEmergenciaDTO citaEmergencia) {
        Medico medico = new Medico();
        medico.setIDUsuario(Integer.parseInt(citaEmergencia.getMedicoDTO().getIDMedico()));
        Paciente paciente = new Paciente();
        paciente.setIDUsuario(Integer.parseInt(citaEmergencia.getIdPaciente()));
        return new Cita(citaEmergencia.getFechaHora(), null, citaEmergencia.getFolioCita(), null, medico, paciente);
    }

    public List<CitaDTO> convertirADTO(List<Cita> citas) {
        List<CitaDTO> citasDTO = new ArrayList<>();
        for (Cita cita : citas) {
            citasDTO.add(convertirADTO(cita));
        }
        return citasDTO;
    }

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

    public Consulta convertirAEntidad(ConsultaDTO consultaDTO) {
        Cita cita = new Cita();
        cita.setIDCita(Integer.parseInt(consultaDTO.getIdCita()));
        return new Consulta(consultaDTO.getDiagnostico(), consultaDTO.getTratamiento(), consultaDTO.getObservaciones(), cita);
    }

}
