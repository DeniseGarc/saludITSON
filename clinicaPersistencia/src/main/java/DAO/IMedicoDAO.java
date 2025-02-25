/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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

    //metodo para registrar un medico
    // public Medico registrarMedico(Medico medico) throws PersistenciaException;
    // ver comentario que deje en el DAO de médico
    public List<Medico> consultarMedicosPorEspecialidad(String especialidad) throws PersistenciaException;

    public List<String> consultarEspecialidades() throws PersistenciaException;

    public List<LocalTime> obtenerHorariosCitas(Medico medico, LocalDate fecha) throws PersistenciaException;

    public Medico consultarMedicoPorId(int id) throws PersistenciaException;

    public int consultarMedicoPorNombre(String Nombre) throws PersistenciaException;
    }
