/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.PacienteNuevoDTO;
import entidades.Paciente;
import entidades.Direccion;

/**
 *
 * @author joelr
 */
public class PacienteMapper {

    public Paciente convertirAEntidad(PacienteNuevoDTO pacienteNuevo) {
        Direccion direccion = new Direccion(pacienteNuevo.getCalle(),pacienteNuevo.getNumero(),pacienteNuevo.getColonia(),pacienteNuevo.getCodigoPostal());
        Paciente paciente = new Paciente(pacienteNuevo.getNombresPaciente(), pacienteNuevo.getApellidoPaternoPaciente(), pacienteNuevo.getApellidoMaternoPaciente(), pacienteNuevo.getCorreo(), pacienteNuevo.getTelefono(), pacienteNuevo.getFechaNacimiento(), direccion);
        return paciente;
    }

    public PacienteNuevoDTO ConvertirADTO(Paciente paciente) {
        PacienteNuevoDTO pacienteDTO = new PacienteNuevoDTO(paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(), paciente.getApellidoMaternoPaciente(), paciente.getCorreo(), paciente.getTelefono(), paciente.getFechaNacimiento(), paciente.getDireccion().getCalle(), paciente.getDireccion().getNumero(), paciente.getDireccion().getColonia(), paciente.getDireccion().getCodigoPostal(), paciente.getNombreUsuario(), paciente.getContrasenaUsuario());
        return pacienteDTO;
    }
}
