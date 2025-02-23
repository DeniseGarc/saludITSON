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
    
    public boolean registrarConsulta(Consulta consulta)throws PersistenciaException;
}
