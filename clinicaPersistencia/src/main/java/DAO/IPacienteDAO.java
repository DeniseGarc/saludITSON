package DAO;

import entidades.Paciente;
import excepciones.PersistenciaException;

/**
 *
 * @author benjy
 */
public interface IPacienteDAO {

    //metodo para registrar usuario
    public Paciente registrarPaciente(Paciente paciente) throws PersistenciaException;

    public boolean consultarPacientePorTelefono(String telefono) throws PersistenciaException;

    public Paciente consultarPacientePorId(int id) throws PersistenciaException;
    
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

   // public int consultarIDPacientePorContrasenaCorreo(String correoIngresado, String contrasenaIngresada) throws PersistenciaException;

}
