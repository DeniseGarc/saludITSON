/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.CitaDAO;
import DAO.ICitaDAO;
import DAO.IMedicoDAO;
import DAO.IPacienteDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DTO.CitaDTO;
import DTO.CitaRegistroDTO;
import DTO.CitaEmergenciaDTO;
import DTO.ConsultaDTO;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alici
 */
public class CitaBO {

    private final ICitaDAO citaDAO;
    private final IMedicoDAO medicoDAO;
    private final IPacienteDAO pacienteDAO;
    private final MapperMedico convertidorMedico = new MapperMedico();
    private final CitaMapper convertidorCita = new CitaMapper();
    Timer timer = new Timer();
    
    /**
     * Constructor que inicializa los DAOs de Cita, Médico y Paciente, además de iniciar un temporizador
     * que verifica la validez de las citas activas cada 60 segundos.
     *
     * @param conexion Objeto que gestiona la conexión a la base de datos.
     */
    public CitaBO(IConexion conexion) {
        this.citaDAO = new CitaDAO(conexion);
        this.medicoDAO = new MedicoDAO(conexion);
        this.pacienteDAO = new PacienteDAO(conexion);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                verificarValidezCitasActivas();
            }
        }, 0, 60000);

    }
    /**
     * Consulta las especialidades de los médicos disponibles.
     *
     * @return Una lista con las especialidades disponibles.
     * @throws NegocioException Si ocurre un error al consultar las especialidades.
     */
    public List<String> especialidadesMedicos() throws NegocioException {
        try {
            return medicoDAO.consultarEspecialidades();
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al consultar especialidades");
        }
    }
    /**
     * Consulta los médicos filtrados por especialidad.
     *
     * @param especialidad La especialidad para filtrar los médicos.
     * @return Una lista de objetos MedicoDTO que contienen los datos de los médicos filtrados.
     * @throws NegocioException Si ocurre un error al consultar los médicos por especialidad.
     */
    public List<MedicoDTO> medicosFiltradosPorEspecialidad(String especialidad) throws NegocioException {
        try {
            return convertidorMedico.convertirADTO(medicoDAO.consultarMedicosPorEspecialidad(especialidad));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al recuperar los medicos filtrados por su especialidad");
        }
    }
    /**
     * Consulta los horarios disponibles para una cita con un médico en una fecha determinada.
     *
     * @param medicoDTO Objeto MedicoDTO que contiene los datos del médico.
     * @param fecha La fecha en la que se desea consultar los horarios de cita.
     * @return Una lista de horarios disponibles para una cita con el médico especificado en la fecha dada.
     * @throws NegocioException Si ocurre un error al consultar los horarios de citas.
     */
    public List<String> horariosCitaMedico(MedicoDTO medicoDTO, LocalDate fecha) throws NegocioException {
        try {
            return convertidorMedico.convertirAListaString(medicoDAO.obtenerHorariosCitas(convertidorMedico.convertirAEntidad(medicoDTO), fecha));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }

    }
    /**
     * Agenda una cita para un paciente con un médico en una fecha y hora especificada.
     *
     * @param citaDTO Objeto CitaRegistroDTO que contiene los datos de la cita a agendar.
     * @return true si la cita fue agendada exitosamente, false si ocurrió un error.
     * @throws NegocioException Si los datos para agendar la cita están incompletos o si ocurre algún error.
     */
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
    /**
     * Genera un folio único para una cita.
     *
     * @return Un string con el folio generado.
     * @throws NegocioException Si no fue posible generar un folio único.
     */
    private String generarFolio() throws NegocioException {
        Random random = new Random();
        String folioEscrito;
        try {
            do {
                int folio = 10000000 + random.nextInt(90000000);
                folioEscrito = String.valueOf(folio);
            } while (citaDAO.consultarCitaPorFolio(folioEscrito).getFolioCita() != null);
            return folioEscrito;

        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No fue posible generar un folio");
        }
    }
    /**
     * Asigna una cita de emergencia a un paciente, buscando al médico más cercano según su especialidad.
     *
     * @param especialidad La especialidad del médico que atenderá la emergencia.
     * @param idPaciente El ID del paciente que recibirá la cita.
     * @return Un objeto CitaEmergenciaDTO con los datos de la cita de emergencia asignada.
     * @throws NegocioException Si ocurre un error al asignar la cita de emergencia.
     */
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
                if (horasDisponibles == null) {
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
                Cita citaGenerada = citaDAO.generarCitaEmergencia(convertidorCita.convertirAEntidad(citaEmergencia));
                if (citaGenerada != null) {
                    return citaEmergencia;
                }
            }
            throw new NegocioException("No hay horarios de atención disponibles");
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException(ex.getMessage());
        }
    }
    /**
     * Obtiene las horas disponibles de un médico específico.
     *
     * @param idMedico El ID del médico para el que se desean obtener las horas disponibles.
     * @return Una lista con las horas disponibles para el médico.
     */
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
    /**
     * Cancela una cita utilizando su folio.
     *
     * @param folio El folio de la cita que se desea cancelar.
     * @return true si la cita fue cancelada exitosamente, false si ocurrió un error.
     * @throws NegocioException Si ocurre un error al cancelar la cita.
     */
    public boolean cancelarCitaPorFolio(String folio) throws NegocioException {
        try {
            Cita cita = citaDAO.consultarCitaPorFolio(folio);
            cita.setEstadoCita("cancelada");
            return citaDAO.actualizarEstadoCita(cita);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No fue posible cancelar la cita");
        }
    }
    /**
     * Actualiza el estado de una cita utilizando su ID, marcándola como "atendida".
     *
     * @param id El ID de la cita a actualizar.
     * @return true si la cita fue marcada como atendida exitosamente, false si ocurrió un error.
     * @throws NegocioException Si ocurre un error al actualizar el estado de la cita.
     */
    public boolean actualizarCitaPorId(String id) throws NegocioException {
        try {
            Cita cita = citaDAO.consultarCitaPorId(Integer.parseInt(id));
            cita.setEstadoCita("atendida");
            return citaDAO.actualizarEstadoCita(cita);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No fue posible marcar como atendida la cita");
        }
    }
    /**
     * Verifica la validez de las citas activas. Si alguna cita tiene una fecha anterior a la actual, se cancela.
     */
    private void verificarValidezCitasActivas() {
        try {
            List<Cita> citasActivas = citaDAO.consultarCitasActivas();
            for (Cita citaActiva : citasActivas) {
                if (citaActiva.getTipo().equals("previa") && LocalDateTime.now().isAfter(citaActiva.getFechaHora().plusMinutes(15))) {
                    citaActiva.setEstadoCita("no asistió paciente");
                    citaDAO.actualizarEstadoCita(citaActiva);
                } else if (citaActiva.getTipo().equals("emergencia") && LocalDateTime.now().isAfter(citaActiva.getFechaHora().plusMinutes(10))) {
                    citaActiva.setEstadoCita("no atendida");
                    citaDAO.actualizarEstadoCita(citaActiva);
                }
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, "Ha ocurrido un error al intentar cambiar el estado de la cita", ex);
        }
    }
    /**
     * Obtiene las citas activas de un médico específico.
     * 
     * @param idMedico El ID del médico para obtener sus citas activas.
     * @return Una lista de objetos CitaDTO que contienen las citas activas del médico.
     * @throws NegocioException Si ocurre un error al obtener las citas activas del médico.
     */
    public List<CitaDTO> citasActivasMedico(String idMedico) throws NegocioException {
        try {
            List<Cita> citas = citaDAO.consultarCitasActivas().stream().filter(cita -> cita.getMedico().getIDUsuario() == Integer.parseInt(idMedico)).toList();
            return convertidorCita.convertirADTO(citas);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al obtener las citas activas del médico");
        }
    }
    /**
     * Obtiene las citas activas de un paciente específico.
     * 
     * @param idPaciente El ID del paciente para obtener sus citas activas.
     * @return Una lista de objetos CitaDTO que contienen las citas activas del paciente.
     * @throws NegocioException Si ocurre un error al obtener las citas activas del paciente.
     */
    public List<CitaDTO> citasActivasPaciente(String idPaciente) throws NegocioException {
        try {
            List<Cita> citas = citaDAO.consultarCitasActivas().stream().filter(cita -> cita.getPaciente().getIDUsuario() == Integer.parseInt(idPaciente) && cita.getTipo().equals("previa")).toList();
            return convertidorCita.convertirADTO(citas);
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al obtener las citas activas del paciente");
        }
    }
    /**
     * Obtiene una cita específica de un médico o paciente a través de su ID.
     * 
     * @param idMedico El ID de la cita que se desea obtener. Se utiliza el ID del médico para la búsqueda.
     * @return Un objeto CitaDTO que contiene los datos de la cita.
     * @throws NegocioException Si ocurre un error al obtener la cita con el ID indicado.
     */
    public CitaDTO obtenerCitaPorId(String idMedico) throws NegocioException {
        try {
            return convertidorCita.convertirADTO(citaDAO.consultarCitaPorId(Integer.parseInt(idMedico)));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No es posible obtener la cita con el id indicado");
        }
    }
    /**
     * Registra una consulta para una cita específica.
     * 
     * @param consulta El objeto ConsultaDTO que contiene los datos de la consulta a registrar.
     * @return true si la consulta fue registrada exitosamente, false si ocurrió un error.
     * @throws NegocioException Si los datos de la consulta son incompletos o si ocurre un error al registrar la consulta.
     */
    public boolean registrarConsulta(ConsultaDTO consulta) throws NegocioException {
        if (consulta == null) {
            throw new NegocioException("Error al intentar registrar la consulta");
        }
        if (consulta.getDiagnostico().isBlank() || consulta.getObservaciones().isBlank() || consulta.getTratamiento().isBlank()
                || consulta.getIdCita().isBlank() || consulta.getDiagnostico() == null || consulta.getObservaciones() == null || consulta.getTratamiento() == null
                || consulta.getIdCita() == null) {
            throw new NegocioException("Alguno de los campos se mandó vacio");
        }

        try {
            return citaDAO.registrarConsulta(convertidorCita.convertirAEntidad(consulta));
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al intentar registrar la consulta");
        }
    }
}
