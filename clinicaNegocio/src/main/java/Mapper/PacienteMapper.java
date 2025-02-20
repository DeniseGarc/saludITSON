/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.DireccionDTO;
import DTO.PacienteDTO;
import entidades.Paciente;
import entidades.Direccion;

/**
 *
 * @author joelr
 */
public class PacienteMapper {

    public Paciente ConvertirAEntidad(PacienteDTO pacienteNuevo) {
                DireccionMapper convertidor = new DireccionMapper();

        Direccion direccion = convertidor.ConvertirAEntidad(pacienteNuevo.getDireccion());
        Paciente paciente = new Paciente(pacienteNuevo.getNombresPaciente(), pacienteNuevo.getApellidoPaternoPaciente(), pacienteNuevo.getApellidoMaternoPaciente(), pacienteNuevo.getCorreo(), pacienteNuevo.getTelefono(), pacienteNuevo.getFechaNacimiento(), direccion);
        return paciente;
    }

    public PacienteDTO ConvertirADTO(Paciente paciente) {
        DireccionMapper convertidor = new DireccionMapper();
        DireccionDTO direccion = convertidor.ConvertirADTO(paciente.getDireccion());
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(), paciente.getApellidoMaternoPaciente(), paciente.getCorreo(), paciente.getTelefono(), paciente.getFechaNacimiento(), direccion);
        return pacienteDTO;
    }
}
