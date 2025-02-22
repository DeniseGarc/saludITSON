/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTO.MedicoDTO;
import entidades.Medico;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alici
 */
public class MedicoMapper {

    public MedicoDTO convertirADTO(Medico medico) {
        return new MedicoDTO(String.valueOf(medico.getIDUsuario()), medico.getNombresMedico(), medico.getApellidoPaternoMedico(), medico.getApellidoMaternoMedico());
    }

    public Medico convertirAEntidad(MedicoDTO medico) {
        return new Medico(medico.getIDMedico(), null, medico.getNombresMedico(), medico.getApellidoPaternoMedico(), medico.getApellidoMaternoMedico(), null, null, null);
    }

    public List<MedicoDTO> convertirADTO(List<Medico> medicos) {
        List<MedicoDTO> medicosDTO = new ArrayList<>();
        for (Medico medico : medicos) {
            medicosDTO.add(convertirADTO(medico));
        }
        return medicosDTO;
    }

    public List<String> convertirAListaString(List<LocalTime> tiempos) {
        List<String> tiemposString = new ArrayList<>();

        for (LocalTime tiempo : tiempos) {
            tiemposString.add(tiempo.toString());
        }

        return tiemposString;
    }
}
