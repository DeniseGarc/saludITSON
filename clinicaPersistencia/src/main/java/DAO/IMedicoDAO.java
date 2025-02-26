package DAO;

import entidades.Medico;
import excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author benjy
 */
public interface IMedicoDAO {

    /**
     * Consulta médicos por su especialidad.
     * 
     * @param especialidad La especialidad de los médicos a consultar.
     * @return Una lista de objetos Medico que cumplen con la especialidad
     *         solicitada.
     * @throws PersistenciaException Si ocurre un error al consultar los médicos en
     *                               la base de datos.
     */
    public List<Medico> consultarMedicosPorEspecialidad(String especialidad) throws PersistenciaException;

    /**
     * Consulta todas las especialidades disponibles de los médicos.
     * 
     * @return Una lista de cadenas con las especialidades de los médicos.
     * @throws PersistenciaException Si ocurre un error al obtener las
     *                               especialidades.
     */
    public List<String> consultarEspecialidades() throws PersistenciaException;

    /**
     * Obtiene los horarios disponibles para una cita con un médico en una fecha
     * específica.
     * 
     * @param medico El médico para el cual se consultan los horarios.
     * @param fecha  La fecha en la que se desea obtener los horarios disponibles.
     * @return Una lista de objetos LocalTime con los horarios disponibles para
     *         citas.
     * @throws PersistenciaException Si ocurre un error al obtener los horarios de
     *                               citas.
     */
    public List<LocalTime> obtenerHorariosCitas(Medico medico, LocalDate fecha) throws PersistenciaException;

    /**
     * Consulta un médico por su ID.
     * 
     * @param id El ID del médico a consultar.
     * @return Un objeto Medico con la información del médico, o null si no se
     *         encuentra.
     * @throws PersistenciaException Si ocurre un error al consultar el médico.
     */
    public Medico consultarMedicoPorId(int id) throws PersistenciaException;

    /**
     * Consulta el nombre completo de un médico dado su ID.
     * 
     * @param idMedico El ID del médico.
     * @return El nombre completo del médico.
     * @throws PersistenciaException Si ocurre un error al consultar el nombre
     *                               completo del médico.
     */
    public String consultarNombreCompletoMedico(int idMedico) throws PersistenciaException;

    /**
     * Verifica si un médico tiene citas activas.
     * 
     * @param idMedico El ID del médico.
     * @return true si el médico tiene citas activas, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al verificar las citas
     *                               activas.
     */
    public boolean tieneCitasActivas(int idMedico) throws PersistenciaException;

    /**
     * Da de baja temporal a un médico, cambiando su estado a 'inactivo'.
     * 
     * @param idMedico El ID del médico.
     * @return true si la baja temporal fue exitosa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al dar de baja al médico.
     */
    public boolean bajaTemporal(int idMedico) throws PersistenciaException;

    /**
     * Reactiva la cuenta de un médico, cambiando su estado a 'activo'.
     * 
     * @param idMedico El ID del médico.
     * @return true si la reactivación fue exitosa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al reactivar la cuenta del
     *                               médico.
     */
    public boolean reactivarCuenta(int idMedico) throws PersistenciaException;

    /**
     * Obtiene el estado de un médico (activo o inactivo).
     * 
     * @param idMedico El ID del médico.
     * @return El estado del médico.
     * @throws PersistenciaException Si ocurre un error al obtener el estado del
     *                               médico.
     */
    public String obtenerEstadoMedico(int idMedico) throws PersistenciaException;
    /**
    * Este método consulta la base de datos para obtener el ID de un médico a partir de su nombre.
    * 
    * @param Nombre El nombre del médico a consultar.
    * @return El ID del médico si se encuentra, o 0 si no se encuentra.
    * @throws PersistenciaException Si ocurre un error en la consulta o en la conexión con la base de datos.
    */
    public int consultarMedicoPorNombre(String Nombre) throws PersistenciaException;

}
