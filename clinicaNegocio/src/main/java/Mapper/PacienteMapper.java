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
     * Convierte un DTO de paciente a una entidad Paciente.
     * 
     * @param pacienteNuevo El DTO que contiene la información del paciente.
     * @return La entidad Paciente correspondiente a los datos del DTO.
     */
    public Paciente convertirAEntidad(PacienteDTO pacienteNuevo) {
        Direccion direccion = new Direccion(pacienteNuevo.getCalle(),pacienteNuevo.getNumero(), pacienteNuevo.getColonia(), pacienteNuevo.getCodigoPostal());
        Paciente paciente = new Paciente(pacienteNuevo.getNombresPaciente(), pacienteNuevo.getApellidoPaternoPaciente(), pacienteNuevo.getApellidoMaternoPaciente(),pacienteNuevo.getCorreo(),pacienteNuevo.getTelefono(),pacienteNuevo.getFechaNacimiento(),direccion);
        return paciente;
    }
    
    /**
     * Convierte una entidad Paciente a un DTO de Paciente.
     * 
     * @param paciente La entidad Paciente a convertir.
     * @return El DTO de Paciente correspondiente.
     */
    public PacienteDTO convertirADTO(Paciente paciente) {
        // Convierte la entidad Paciente a DTO, incluyendo su dirección.
        PacienteDTO pacienteDTO = new PacienteDTO(paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(),paciente.getApellidoMaternoPaciente(),paciente.getCorreo(),paciente.getTelefono(),paciente.getFechaNacimiento(),  paciente.getDireccion().getCalle(), paciente.getDireccion().getNumero(),  paciente.getDireccion().getColonia(),  paciente.getDireccion().getCodigoPostal(),  paciente.getNombreUsuario(), paciente.getContrasenaUsuario());
        return pacienteDTO;
    }

    /**
     * Convierte un DTO de paciente para actualización a una entidad Paciente.
     * 
     * @param pacienteDTO El DTO que contiene la información del paciente a actualizar.
     * @return La entidad Paciente correspondiente a los datos del DTO de actualización.
     */
    public Paciente convertirAEntidad(PacienteActualizarDTO pacienteDTO) {
        Direccion direccion = new Direccion(pacienteDTO.getDireccion().getIdDireccion(),pacienteDTO.getDireccion().getCalle(),pacienteDTO.getDireccion().getNumero(),pacienteDTO.getDireccion().getColonia(),pacienteDTO.getDireccion().getCodigoPostal());
        Paciente paciente = new Paciente(pacienteDTO.getNombresPaciente(), pacienteDTO.getApellidoPaternoPaciente(), pacienteDTO.getApellidoMaternoPaciente(), null, pacienteDTO.getTelefono(), pacienteDTO.getFechaNacimiento(), direccion);
        
        paciente.setIDUsuario(pacienteDTO.getIdPaciente());  
        return paciente;
    }
    
    /**
     * Convierte una entidad Paciente a un DTO de Paciente para actualización.
     * 
     * @param paciente La entidad Paciente a convertir.
     * @return El DTO de Paciente para actualización correspondiente.
     */
    public PacienteActualizarDTO convertirAPacienteActualizarDTO(Paciente paciente) {
        DireccionDTO direccionDTO = new DireccionDTO(paciente.getDireccion().getIDDireccion(),  paciente.getDireccion().getCalle(),  paciente.getDireccion().getNumero(), paciente.getDireccion().getColonia(), paciente.getDireccion().getCodigoPostal());
        
        return new PacienteActualizarDTO(paciente.getIDUsuario(), paciente.getNombresPaciente(), paciente.getApellidoPaternoPaciente(), paciente.getApellidoMaternoPaciente(), paciente.getTelefono(), paciente.getFechaNacimiento(), direccionDTO);
    }
}
