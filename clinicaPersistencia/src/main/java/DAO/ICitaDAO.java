
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Cita;
import entidades.Consulta;
import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alici
 */
public interface ICitaDAO {

    public boolean agendarCita(Cita cita) throws PersistenciaException;

    /**
     * Consulta si existe una cita para un médico y una fecha y hora
     * específicas.
     *
     * @param fechaHora fecha y hora de la cita a consultar.
     * @param idMedico ID del médico para el cual se consulta la cita.
     * @return true si existe una cita con la misma fecha y hora para ese
     * médico, false en caso contrario.
     * @throws PersistenciaException si ocurre un error en la base de datos.
     */
    public boolean consultarCitaPorFechaHora(LocalDateTime fechaHora, String idMedico) throws PersistenciaException;

    /**
     * Consulta una cita en base a su folio.
     *
     * @param folio folio de la cita a consultar.
     * @return la cita si se encuentra, o un objeto Cita vacío si no se
     * encuentra.
     * @throws PersistenciaException si ocurre un error en la base de datos.
     */
    public Cita consultarCitaPorFolio(String folio) throws PersistenciaException;

    /**
     * Genera una cita de emergencia y la guarda en la base de datos.
     *
     * @param cita objeto que contiene los detalles de la cita de emergencia.
     * @return la cita con el ID generado por la base de datos.
     * @throws PersistenciaException si ocurre un error en la base de datos.
     */
    public Cita generarCitaEmergencia(Cita cita) throws PersistenciaException;

    /**
     * Actualiza el estado de una cita existente.
     *
     * @param cita la cita cuyo estado se desea actualizar.
     * @return true si se actualizó correctamente el estado, false en caso
     * contrario.
     * @throws PersistenciaException si ocurre un error en la base de datos.
     */
    public boolean actualizarEstadoCita(Cita cita) throws PersistenciaException;

    /**
     * Consulta una cita por su ID.
     *
     * @param id ID de la cita a consultar.
     * @return la cita correspondiente al ID, o null si no se encuentra.
     * @throws PersistenciaException si ocurre un error en la base de datos.
     */
    public Cita consultarCitaPorId(int id) throws PersistenciaException;

    /**
     * Consulta todas las citas activas.
     *
     * @return una lista con todas las citas activas.
     * @throws PersistenciaException si ocurre un error en la base de datos.
     */
    public List<Cita> consultarCitasActivas() throws PersistenciaException;

    /**
     * Registra una consulta para una cita.
     *
     * @param consulta objeto que contiene los detalles de la consulta.
     * @return true si la consulta se registró correctamente, false en caso
     * contrario.
     * @throws PersistenciaException si ocurre un error en la base de datos.
     */
    public boolean registrarConsulta(Consulta consulta) throws PersistenciaException;

    public boolean ActualizarEstadoCancelarCita(int idMedico, LocalDateTime fechaHora) throws PersistenciaException;

    public DefaultTableModel ObtenerConsultasPrevias(JTable tabla, int id) throws PersistenciaException;

    public DefaultTableModel ObtenerConsultasPreviasFiltro(JTable tabla, int id, LocalDate fechaDesde,
            LocalDate fechaHasta, String especialidad) throws PersistenciaException;

    public List<String> ObtenerEspecialidadesCitas() throws PersistenciaException;

    public DefaultTableModel ObtenerConsultasPreviasMedico(JTable tabla, int id) throws PersistenciaException;

    public boolean CompararFechas(LocalDateTime fecha);
}
