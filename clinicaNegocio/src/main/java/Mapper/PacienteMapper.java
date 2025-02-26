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
    /**
    * Convierte un objeto PacienteDTO a un objeto Paciente.
    * 
    * @param pacienteNuevo El objeto PacienteDTO que contiene los datos del paciente a convertir.
    * @return Un objeto Paciente que contiene los mismos datos del PacienteDTO convertido.
    */
    public Paciente convertirAEntidad(PacienteDTO pacienteNuevo) {
        Direccion direccion = new Direccion(pacienteNuevo.getCalle(), pacienteNuevo.getNumero(), pacienteNuevo.getColonia(), pacienteNuevo.getCodigoPostal());
        Paciente paciente = new Paciente(pacienteNuevo.getNombresPaciente(), pacienteNuevo.getApellidoPaternoPaciente(), pacienteNuevo.getApellidoMaternoPaciente(), pacienteNuevo.getCorreo(), pacienteNuevo.getTelefono(), pacienteNuevo.getFechaNacimiento(), direccion);
        return paciente;
    }
    /**
    * Convierte un objeto Paciente a un objeto PacienteDTO.
    * 
    * @param paciente El objeto Paciente que contiene los datos del paciente a convertir.
    * @return Un objeto PacienteDTO que contiene los mismos datos del Paciente convertido.
    */
       public PacienteDTO convertirADTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(), paciente.getApellidoMaternoPaciente(), paciente.getCorreo(), paciente.getTelefono(), paciente.getFechaNacimiento(), paciente.getDireccion().getCalle(), paciente.getDireccion().getNumero(), paciente.getDireccion().getColonia(), paciente.getDireccion().getCodigoPostal(), paciente.getNombreUsuario(), paciente.getContrasenaUsuario());
        return pacienteDTO;
    }
    /**
    * Convierte un objeto PacienteActualizarDTO a un objeto Paciente.
    * 
    * @param pacienteDTO El objeto PacienteActualizarDTO que contiene los datos del paciente a convertir.
    * @return Un objeto Paciente que contiene los mismos datos del PacienteActualizarDTO convertido.
    */
    public Paciente convertirAEntidad(PacienteActualizarDTO pacienteDTO) {
        Direccion direccion = new Direccion(pacienteDTO.getDireccion().getIdDireccion(),
                pacienteDTO.getDireccion().getCalle(),
                pacienteDTO.getDireccion().getNumero(),
                pacienteDTO.getDireccion().getColonia(),
                pacienteDTO.getDireccion().getCodigoPostal());
        Paciente paciente = new Paciente(pacienteDTO.getNombresPaciente(), pacienteDTO.getApellidoPaternoPaciente(), pacienteDTO.getApellidoMaternoPaciente(), null, pacienteDTO.getTelefono(), pacienteDTO.getFechaNacimiento(), direccion);
        paciente.setIDUsuario(pacienteDTO.getIdPaciente());
        return paciente;
    }
    /**
    * Convierte un objeto Paciente a un objeto PacienteActualizarDTO.
    * 
    * @param paciente El objeto Paciente que contiene los datos del paciente a convertir.
    * @return Un objeto PacienteActualizarDTO que contiene los mismos datos del Paciente convertido.
    */
    public PacienteActualizarDTO convertirAPacienteActualizarDTO(Paciente paciente) {
        DireccionDTO direccionDTO = new DireccionDTO(paciente.getDireccion().getIDDireccion(), paciente.getDireccion().getCalle(), paciente.getDireccion().getNumero(), paciente.getDireccion().getColonia(), paciente.getDireccion().getCodigoPostal());
        return new PacienteActualizarDTO(paciente.getIDUsuario(), paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(), paciente.getApellidoMaternoPaciente(), paciente.getTelefono(), paciente.getFechaNacimiento(), direccionDTO);
    }
    
}
