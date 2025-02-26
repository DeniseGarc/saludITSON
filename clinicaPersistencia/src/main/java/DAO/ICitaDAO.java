/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Cita;
import entidades.Consulta;
import excepciones.PersistenciaException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alici
 */
public interface ICitaDAO {

    public boolean agendarCita(Cita cita) throws PersistenciaException;

    public boolean consultarCitaPorFechaHora(LocalDateTime fechaHora, String idMedico) throws PersistenciaException;

    public Cita consultarCitaPorFolio(String folio) throws PersistenciaException;

    public Cita generarCitaEmergencia(Cita cita) throws PersistenciaException;

    public boolean actualizarEstadoCita(Cita cita) throws PersistenciaException;

    public Cita consultarCitaPorId(int id) throws PersistenciaException;

    public List<Cita> consultarCitasActivas() throws PersistenciaException;

    public boolean registrarConsulta(Consulta consulta) throws PersistenciaException;

    public boolean ActualizarEstadoCancelarCita(int idMedico, LocalDateTime fechaHora) throws PersistenciaException;

    public DefaultTableModel ObtenerConsultasPrevias(JTable tabla, int id) throws PersistenciaException;

    public DefaultTableModel ObtenerConsultasPreviasFiltro(JTable tabla, int id, LocalDate fechaDesde, LocalDate fechaHasta, String especialidad) throws PersistenciaException;

    public List<String> ObtenerEspecialidadesCitas() throws PersistenciaException;
    
    public DefaultTableModel ObtenerConsultasPreviasMedico(JTable tabla, int id) throws PersistenciaException;
}
