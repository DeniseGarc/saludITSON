/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.DireccionDTO;
import DTO.PacienteActualizarDTO;
import DTO.PacienteDTO;
import entidades.Paciente;
import entidades.Direccion;
import java.time.LocalDate;

/**
 *
 * @author joelr
 */
public class PacienteMapper {

    public Paciente ConvertirAEntidad(PacienteDTO pacienteNuevo) {
        Direccion direccion = new Direccion(pacienteNuevo.getCalle(),pacienteNuevo.getNumero(),pacienteNuevo.getColonia(),pacienteNuevo.getCodigoPostal());
        Paciente paciente = new Paciente(pacienteNuevo.getNombresPaciente(), pacienteNuevo.getApellidoPaternoPaciente(), pacienteNuevo.getApellidoMaternoPaciente(), pacienteNuevo.getCorreo(), pacienteNuevo.getTelefono(), pacienteNuevo.getFechaNacimiento(), direccion);
        return paciente;
    }

    public PacienteDTO ConvertirADTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(), paciente.getApellidoMaternoPaciente(), paciente.getCorreo(), paciente.getTelefono(), paciente.getFechaNacimiento(), paciente.getDireccion().getCalle(), paciente.getDireccion().getNumero(), paciente.getDireccion().getColonia(), paciente.getDireccion().getCodigoPostal(), paciente.getNombreUsuario(), paciente.getContrasenaUsuario());
        return pacienteDTO;
    }
    public PacienteActualizarDTO convertirAActualizarDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, LocalDate fechaNacimiento, String calle, String numero, String colonia, String codigoPostal, int idPaciente, int idDireccion) {
    DireccionDTO direccionDTO = new DireccionDTO(idDireccion, calle, numero, colonia, codigoPostal);
    return new PacienteActualizarDTO(idPaciente, nombres, apellidoPaterno, apellidoMaterno, telefono, fechaNacimiento, direccionDTO);
    }
    public PacienteActualizarDTO convertirAPacienteActualizarDTO(Paciente paciente) {
    DireccionDTO direccionDTO = new DireccionDTO(paciente.getDireccion().getIDDireccion(),paciente.getDireccion().getCalle(),paciente.getDireccion().getNumero(),paciente.getDireccion().getColonia(),paciente.getDireccion().getCodigoPostal());
    return new PacienteActualizarDTO(paciente.getIDUsuario(),paciente.getNombresPaciente(),paciente.getApellidoPaternoPaciente(),paciente.getApellidoMaternoPaciente(),paciente.getTelefono(),paciente.getFechaNacimiento(),direccionDTO);
    }
    
}
    

