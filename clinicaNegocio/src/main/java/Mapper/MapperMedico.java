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
    * Convierte un objeto Medico a un objeto MedicoDTO.
    * 
    * @param medico El objeto Medico que se desea convertir a un objeto MedicoDTO.
    * @return Un objeto MedicoDTO que representa los datos del Medico en formato adecuado para la transferencia de datos.
    */
    public MedicoDTO convertirADTO(Medico medico) {
        return new MedicoDTO(String.valueOf(medico.getIDUsuario()), medico.getNombresMedico(), medico.getApellidoPaternoMedico(), medico.getApellidoMaternoMedico(), medico.getEspecialidad());
    }
    /**
    * Convierte un objeto MedicoDTO a un objeto Medico.
    * 
    * @param medicoDTO El objeto MedicoDTO que contiene los datos del médico para ser convertido a una entidad Medico.
    * @return Un objeto Medico que representa los datos del médico como una entidad en el sistema.
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
    * Convierte una lista de objetos Medico a una lista de objetos MedicoDTO.
    * 
    * @param medicos La lista de objetos Medico que contienen los datos de los médicos a convertir.
    * @return Una lista de objetos MedicoDTO, que representa los datos de los médicos en formato adecuado para la transferencia.
    */
    public List<MedicoDTO> convertirADTO(List<Medico> medicos) {
        List<MedicoDTO> medicosDTO = new ArrayList<>();
        for (Medico medico : medicos) {
            medicosDTO.add(convertirADTO(medico));
        }
        return medicosDTO;
    }
    /**
    * Convierte una lista de objetos LocalTime a una lista de String.
    * 
    * @param tiempos La lista de objetos LocalTime que representan tiempos a convertir.
    * @return Una lista de objetos String, cada uno representando un tiempo en formato String.
    */
    public List<String> convertirAListaString(List<LocalTime> tiempos) {
        List<String> tiemposString = new ArrayList<>();

        for (LocalTime tiempo : tiempos) {
            tiemposString.add(tiempo.toString());
        }

        return tiemposString;
    }
}
