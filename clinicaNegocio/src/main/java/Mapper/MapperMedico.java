/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.MedicoDTO;
import entidades.Medico;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class MapperMedico {

    /**
     * Convierte una entidad Medico a un DTO de Medico.
     * 
     * @param medico La entidad Medico a convertir.
     * @return El DTO de Medico correspondiente.
     */
    public MedicoDTO convertirADTO(Medico medico) {
        return new MedicoDTO(String.valueOf(medico.getIDUsuario()), medico.getNombresMedico(), medico.getApellidoPaternoMedico(), medico.getApellidoMaternoMedico());    
    }

    /**
     * Convierte un DTO de Medico a una entidad Medico.
     * 
     * @param medicoDTO El DTO que contiene la información del médico.
     * @return La entidad Medico correspondiente a los datos del DTO.
     */
    public Medico convertirAEntidad(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setIDUsuario(Integer.parseInt(medicoDTO.getIDMedico()));  
        medico.setNombresMedico(medicoDTO.getNombresMedico());  
        medico.setApellidoPaternoMedico(medicoDTO.getApellidoPaternoMedico()); 
        medico.setApellidoMaternoMedico(medicoDTO.getApellidoMaternoMedico());  
        return medico;
    }

    /**
     * Convierte una lista de entidades Medico a una lista de DTOs de Medico.
     * 
     * @param medicos La lista de entidades Medico a convertir.
     * @return Una lista de DTOs de Medico.
     */
    public List<MedicoDTO> convertirADTO(List<Medico> medicos) {
        List<MedicoDTO> medicosDTO = new ArrayList<>();
        for (Medico medico : medicos) {
            medicosDTO.add(convertirADTO(medico));
        }
        return medicosDTO;
    }

    /**
     * Convierte una lista de objetos LocalTime a una lista de Strings.
     * 
     * @param tiempos La lista de objetos LocalTime a convertir.
     * @return Una lista de Strings representando los objetos LocalTime.
     */
    public List<String> convertirAListaString(List<LocalTime> tiempos) {
        List<String> tiemposString = new ArrayList<>();
        for (LocalTime tiempo : tiempos) {
            tiemposString.add(tiempo.toString());
        }
        return tiemposString;
    }
}
