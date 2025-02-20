/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.PacienteDTO;
import entidades.Paciente;

/**
 *
 * @author joelr
 */
public class PacienteMapper {

    public Paciente ConvertirAEntidad(PacienteDTO pacienteNuevo) {
        Paciente paciente = new Paciente(pacienteNuevo.getNombresPaciente(), pacienteNuevo.getApellidoPaternoPaciente(), pacienteNuevo.getApellidoMaternoPaciente(), pacienteNuevo.getCorreo(), pacienteNuevo.getTelefono(), pacienteNuevo.getFechaNacimiento(), pacienteNuevo.getDireccion());
        return paciente;
    }
    
    public PacienteDTO ConvertirADTO(Paciente paciente){
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(), paciente.getApellidoMaternoPaciente(), paciente.getCorreo(), paciente.getTelefono(), paciente.getFechaNacimiento(), paciente.getDireccion());
        return pacienteDTO;
    }
}
