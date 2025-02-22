/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.CitaDAO;
import DAO.ICitaDAO;
import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import DTO.CitaRegistroDTO;
import DTO.CitaEmergenciaDTO;
import DTO.MedicoDTO;
import Mapper.CitaMapper;
import Mapper.MapperMedico;
import conexion.IConexion;
import entidades.Medico;
import entidades.Cita;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alici
 */
public class CitaBO {

    private final ICitaDAO citaDAO;
    private final IMedicoDAO medicoDAO;
    private final MapperMedico convertidorMedico = new MapperMedico();
    private final CitaMapper convertidorCita = new CitaMapper();

    public CitaBO(IConexion conexion) {
        this.citaDAO = new CitaDAO(conexion);
        this.medicoDAO = new MedicoDAO(conexion);
    }

    public List<String> especialidadesMedicos() throws NegocioException {
        try {
            return medicoDAO.consultarEspecialidades();
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al consultar especialidades");
        }
    }

    public List<MedicoDTO> medicosFiltradosPorEspecialidad(String especialidad) throws NegocioException {
        try {
            return convertidorMedico.convertirADTO(medicoDAO.consultarMedicosPorEspecialidad(especialidad));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al recuperar los medicos filtrados por su especialidad");
        }
    }

    public List<String> horariosCitaMedico(MedicoDTO medicoDTO, LocalDate fecha) throws NegocioException {
        try {
            return convertidorMedico.convertirAListaString(medicoDAO.obtenerHorariosCitas(convertidorMedico.convertirAEntidad(medicoDTO), fecha));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }

    }

    public boolean agendarCita(CitaRegistroDTO citaDTO) throws NegocioException {
        if (citaDTO == null || citaDTO.getIdMedico() == null || citaDTO.getIdPaciente() == null || citaDTO.getFechaHora() == null
                || citaDTO.getIdMedico().isBlank() || citaDTO.getIdPaciente().isBlank()) {
            throw new NegocioException("Los datos para agendar la cita se encuentran incompletos");
        }
        try {
            // si encuentra una cita con la misma fecha y hora
            if (citaDAO.consultarCitaPorFechaHora(citaDTO.getFechaHora(), citaDTO.getIdMedico())) {
                throw new NegocioException("Ya existe una cita registrada en el mismo horario y fecha");
            }
            // si la fecha y hora son menores a la fecha y hora actual
            if (!citaDTO.getFechaHora().isAfter(LocalDateTime.now())) {
                throw new NegocioException("No puede agendar citas en una fecha que sea anterior a la fecha actual");
            }
            return citaDAO.agendarCita(convertidorCita.convertirAEntidad(citaDTO));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    public String generarFolio() throws NegocioException {
        Random random = new Random();
        String folioEscrito = null;
        try {
            do {
                int folio = 10000000 + random.nextInt(90000000);
                folioEscrito = String.valueOf(folio);
            } while (citaDAO.consultarCitaPorFolio(folioEscrito));
            return folioEscrito;

        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No fue posible generar un folio");
        }
    }

    public CitaEmergenciaDTO asignarCitaEmergencia(String especialidad, String idPaciente) throws NegocioException {
        if (especialidad == null || especialidad.isBlank()) {
            throw new NegocioException("No se ha seleccionado una especialidad");
        }
        try {
            LocalDateTime ahora = LocalDateTime.now();
            // mapa donde se va a guardar al medico con su hora más cercana de atención
            Map<Medico, LocalDateTime> medicoHorasCercanas = new HashMap<>();
            // medicos por especialidad indicada
            List<Medico> medicos = medicoDAO.consultarMedicosPorEspecialidad(especialidad);
            
            for (Medico medico : medicos) {
                // lista de horas disponibles del medico
               
                List<LocalTime> horasDisponibles = obtenerHorasDisponiblesMedico(medico.getIDUsuario());
                 if (horasDisponibles  == null) {
                    throw new NegocioException("No hay horarios de atención disponibles");
                }
                // se utiliza optional para manejar la posible ausencia de horas disponibles
                Optional<LocalDateTime> horaMasCercana 
                        // se hace stream a las horas disponibles del medico
                        = horasDisponibles.stream()
                         // Combina las horas con la fecha actual
                        .map(hora -> LocalDateTime.of(ahora.toLocalDate(), hora)) 
                        // se filtran las fecha y hora que son anteriores a la fecha actual
                        .filter(horaFecha -> !horaFecha.isBefore(ahora))
                        // se ordena ascendentemente las fecha hora       
                        .min((h1, h2) -> h1.compareTo(h2));
                // si hay un valor obtenido en el stream anterior se agrega al mapa el medico con su hora 
                horaMasCercana.ifPresent(hora -> medicoHorasCercanas.put(medico, hora)); // mete al mapa el medico y la hora 
            }

            // Encontrar la cita más cercana de todas
            Optional<Map.Entry<Medico, LocalDateTime>> citaMasCercana
                    // entrySet convierte el mapa en un flujo de entradas y con min.comparingByValue se obtiene el LocalDateTime más pequeño
                    = medicoHorasCercanas.entrySet().stream().min(Map.Entry.comparingByValue());
            // si es que existe una cita más cercana se agenda
            if (citaMasCercana.isPresent()) {
                // se guarda el par de Medico y fecha hora de la cita más cercana obtenida
                Map.Entry<Medico, LocalDateTime> medicoHorarioCita = citaMasCercana.get();
                MedicoDTO medicoCita = convertidorMedico.convertirADTO(medicoHorarioCita.getKey());
                String folio;
                folio = generarFolio();
                CitaEmergenciaDTO citaEmergencia = new CitaEmergenciaDTO(medicoHorarioCita.getValue(), folio, medicoCita, idPaciente);
                if (citaDAO.generarCitaEmergencia(convertidorCita.convertirAEntidad(citaEmergencia))) {
                    return citaEmergencia;
                }
            }
            throw new NegocioException("No hay horarios de atención disponibles");
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }

    private List<LocalTime> obtenerHorasDisponiblesMedico(int idMedico) {
        // Tu implementación actual para obtener horas disponibles
        Medico medico = new Medico();
        medico.setIDUsuario(idMedico);
        try {
            return medicoDAO.obtenerHorariosCitas(medico, LocalDate.now());
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, "El médico no tiene horas disponibles", ex);
            return null;
        }
    }

}
