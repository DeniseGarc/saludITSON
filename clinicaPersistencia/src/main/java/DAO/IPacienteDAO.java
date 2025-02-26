/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Paciente;
import excepciones.PersistenciaException;

/**
 *
 * @author benjy
 */
public interface IPacienteDAO {
    
    /**
     * Registra un nuevo paciente en la base de datos.
     * 
     * @param paciente Objeto Paciente que contiene la información del paciente a registrar.
     * @return El paciente registrado.
     * @throws PersistenciaException Si ocurre un error al registrar el paciente.
     */
    public Paciente registrarPaciente(Paciente paciente) throws PersistenciaException;
    /**
     * Verifica si un paciente existe en la base de datos a partir de su teléfono.
     * 
     * @param telefono Número de teléfono del paciente.
     * @return true si el paciente existe, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al consultar el teléfono del paciente.
     */
    public boolean consultarPacientePorTelefono(String telefono) throws PersistenciaException;
    /**
     * Consulta los datos de un paciente por su ID.
     * 
     * @param id ID del paciente a consultar.
     * @return Objeto Paciente con los datos del paciente consultado.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    public Paciente consultarPacientePorId(int id) throws PersistenciaException;
    /**
     * Consulta el nombre completo de un paciente a partir de su ID.
     * 
     * @param idPaciente ID del paciente a consultar.
     * @return Nombre completo del paciente en formato "Nombre ApellidoPaterno ApellidoMaterno".
     * @throws PersistenciaException Si ocurre un error en la consulta o el paciente no es encontrado.
     */
    public String consultarNombreCompletoPaciente(int idPaciente) throws PersistenciaException;
    /**
     * Actualiza los datos de un paciente en la base de datos, incluyendo su dirección.
     * 
     * @param paciente Objeto Paciente con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al actualizar los datos del paciente.
     */
    public boolean actualizarPaciente(Paciente paciente) throws PersistenciaException; 
    /**
     * Verifica si un paciente tiene citas activas en la base de datos.
     * 
     * @param idPaciente ID del paciente a verificar.
     * @return true si el paciente tiene al menos una cita activa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    public boolean tieneCitasActivas(int idPaciente) throws PersistenciaException;
    /**
     * Obtiene el ID de la dirección de un paciente a partir de su ID de paciente.
     * 
     * @param idPaciente ID del paciente.
     * @return El ID de la dirección asociada al paciente.
     * @throws PersistenciaException Si ocurre un error al consultar la dirección del paciente.
     */
    public int obtenerIdDireccionPorPaciente(int idPaciente) throws PersistenciaException;
    /**
     * Obtiene los datos completos de un paciente a partir de su ID, incluyendo su dirección.
     * 
     * @param idPaciente ID del paciente a consultar.
     * @return Un objeto Paciente con todos sus datos completos, incluidos los de la dirección.
     * @throws PersistenciaException Si ocurre un error al obtener los datos del paciente.
     */
    public Paciente obtenerDatosPaciente(int idPaciente) throws PersistenciaException;
}
