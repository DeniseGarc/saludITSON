/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.CitaRegistroDTO;
import DTO.CitaEmergenciaDTO;
import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;

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
    
}
