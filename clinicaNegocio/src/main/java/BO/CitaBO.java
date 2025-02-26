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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    * Constructor de la clase CitaBO que inicializa los DAOs necesarios y configura un temporizador
    * para verificar periódicamente la validez de las citas activas.
    *
    * @param conexion Objeto de conexión a la base de datos utilizado para inicializar los DAOs.
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
    * Obtiene la lista de especialidades médicas disponibles.
    *
    * @return Lista de especialidades médicas.
    * @throws NegocioException Si ocurre un error al consultar las especialidades en la capa de persistencia.
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
    * Obtiene una lista de médicos filtrados por especialidad.
    *
    * @param especialidad La especialidad médica por la cual se filtrarán los médicos.
    * @return Lista de médicos que pertenecen a la especialidad indicada.
    * @throws NegocioException Si ocurre un error al recuperar los médicos desde la capa de persistencia.
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
    * Obtiene una lista de horarios disponibles para citas de un médico en una fecha específica.
    *
    * @param medicoDTO El médico del cual se desean consultar los horarios.
    * @param fecha La fecha en la que se buscan los horarios disponibles.
    * @return Lista de horarios disponibles en formato de cadena.
    * @throws NegocioException Si ocurre un error al recuperar los horarios desde la capa de persistencia.
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
    * Agenda una nueva cita en el sistema, validando que no haya conflictos de horario y que la fecha sea válida.
    *
    * @param citaDTO Datos de la cita a agendar, incluyendo el médico, paciente y la fecha y hora de la cita.
    * @return true si la cita se agenda exitosamente, false en caso contrario.
    * @throws NegocioException Si los datos están incompletos, ya existe una cita en el mismo horario o la fecha es inválida.
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
    * Genera un folio único para una cita médica.
    *
    * @return Un folio de 8 dígitos que no esté registrado en el sistema.
    * @throws NegocioException Si ocurre un error al verificar la existencia del folio en la base de datos.
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
    * Asigna una cita de emergencia a un paciente según la especialidad requerida.
    *
    * @param especialidad La especialidad médica que necesita el paciente.
    * @param idPaciente El identificador del paciente que requiere la cita de emergencia.
    * @return Un objeto CitaEmergenciaDTO con los detalles de la cita asignada.
    * @throws NegocioException Si no hay médicos disponibles en la especialidad o si ocurre un error en la asignación.
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
                //Cambio: Genera una consultaDTO para posteriormente usar el mapper, convertirlo a entidad y registrar la consulta.
                ConsultaDTO consultaDTO = new ConsultaDTO("En espera", "En espera", "En espera", String.valueOf(citaGenerada.getIDCita()));
                this.citaDAO.registrarConsulta(convertidorCita.convertirAEntidad(consultaDTO));
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
    * Obtiene la lista de horarios disponibles para un médico en la fecha actual.
    *
    * @param idMedico El identificador del médico.
    * @return Una lista de objetos LocalTime con los horarios disponibles, o null si ocurre un error al obtenerlos.
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
    * Cancela una cita mediante su folio.
    *
    * @param folio El folio de la cita a cancelar.
    * @return true si la cita fue cancelada con éxito, false en caso contrario.
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
     * Metodo que recibe un id por el cual actualiza el estado de las citas Si
     * no ocurre ningun error regresa un true. Si ocurre un error devuelve
     * false.
     *
     * @param id
     * @return true si todo sale bien, false en caso contrario.
     * @throws NegocioException
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
     * Metodo que valida los estados de las citas.
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
     * Metodo que devuelve las citas activas del medico.
     *
     * @param idMedico
     * @return
     * @throws NegocioException
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
     * Metodo que obtiene una cita por su id.
     *
     * @param idMedico
     * @return
     * @throws NegocioException
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
     * Metodo que recibe consultaDTO para registrarla. Valida si la consulta es
     * null o si tiene algun campo vacio, envia el mensaje correspondiente.
     *
     * @param consulta
     * @return
     * @throws NegocioException
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

    /**
     * Metodo que instancia el metodo para eliminar la cita seleccionada.
     * Devuelve true si no hay errores de persistencia. Devuelve false y un
     * mensaje de error en caso contrario.
     *
     * @param idMedico
     * @param FechaHora
     * @return
     * @throws PersistenciaException
     */
    public boolean ActualizarEstadoCancelarCita(int idMedico, LocalDateTime FechaHora) throws PersistenciaException {
        try {
            citaDAO.ActualizarEstadoCancelarCita(idMedico, FechaHora);
            return true;
        } catch (PersistenciaException pe) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, pe);
            JOptionPane.showMessageDialog(null, "Error: error al eliminar cita.");
            return false;
        }

    }

    /**
     * Obtener Medico por su nombre.
     *
     * @param nombresMedico
     * @return
     * @throws PersistenciaException
     */
    public int ObtenerMedicoPorNombre(String nombresMedico) throws PersistenciaException {
        try {
            int id = medicoDAO.consultarMedicoPorNombre(nombresMedico);
            return id;
        } catch (PersistenciaException pe) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, pe);
            JOptionPane.showMessageDialog(null, "Error: error al obtener el medico.");
            return 0;
        }

    }

    /**
     * Metodo para obtener las consultas previas del Paciente.
     *
     * @param tabla
     * @param id
     * @return
     * @throws PersistenciaException
     */
    public DefaultTableModel ObtenerConsultasPrevias(JTable tabla, int id) throws PersistenciaException {
        try {
            return this.citaDAO.ObtenerConsultasPrevias(tabla, id);
        } catch (PersistenciaException pe) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, pe);
            throw new PersistenciaException("Error al conseguir las citas registradas");

        }
    }

    /**
     * Metodo para obtener las consultas previas del Paciente.
     *
     * @param tabla
     * @param id
     * @param fechaDesde
     * @param fechaHasta
     * @param especialidad
     * @return
     * @throws PersistenciaException
     */
    public DefaultTableModel ObtenerConsultasPreviasFiltro(JTable tabla, int id, LocalDate fechaDesde, LocalDate fechaHasta, String especialidad) throws PersistenciaException {
        try {
            return this.citaDAO.ObtenerConsultasPreviasFiltro(tabla, id, fechaDesde, fechaHasta, especialidad);

        } catch (PersistenciaException pe) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, pe);
            throw new PersistenciaException("Error al conseguir las citas registradas");

        }
    }
    /**
    * Método que obtiene la lista de especialidades disponibles en las citas.
    *
    * @return Lista de especialidades como objetos de tipo String.
    * @throws PersistenciaException Si ocurre un error al recuperar las especialidades desde la base de datos.
    */
    public List<String> obtenerEspecialidades() throws PersistenciaException {
        try {
            return this.citaDAO.ObtenerEspecialidadesCitas();
        } catch (PersistenciaException ex) {
            Logger.getLogger(CitaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al conseguir las especialidades");
        }
    }

    /**
     * Metodo que devuelve una tabla con las consultas previas del Medico.
     *
     * @param tabla
     * @param id del Medico.
     * @return
     * @throws PersistenciaException
     */
    public DefaultTableModel ObtenerConsultasPreviasMedico(JTable tabla, int id) throws PersistenciaException {
        try {
            return this.citaDAO.ObtenerConsultasPreviasMedico(tabla, id);

        } catch (PersistenciaException pe) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, pe);
            throw new PersistenciaException("Error al conseguir las citas registradas");

        }
    }

    /**
     * Metodo que compara 2 fechas para verificar si faltan menos de 24 horas
     * para la cita. Regresa true si la fecha esta a menos de 24 horas. Regresa
     * false si la fecha esta a mas de 24 horas de la fecha.
     *
     * @param fecha
     * @return
     */
    public boolean compararFechas(LocalDateTime fecha) {
        return this.citaDAO.CompararFechas(fecha);
    }
}
