/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.CitaDAO;
import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Mapper.MapperMedico;

/**
 *
 * @author benjy
 */
public class MedicoBO {
    private final IMedicoDAO medicoDAO;
    private final MapperMedico mapper = new MapperMedico();
    private static final Logger logger = Logger.getLogger(PacienteBO.class.getName());
    /**
     * Constructor que inicializa el DAO de médicos.
     * 
     * @param conexion La conexión utilizada para acceder a la base de datos.
     */ 
    public MedicoBO(IConexion conexion) {
        this.medicoDAO = new MedicoDAO(conexion);
    }
    /**
     * Obtiene el nombre completo de un médico dado su ID.
     * 
     * @param idMedico El ID del médico cuya información se desea obtener.
     * @return El nombre completo del médico.
     * @throws NegocioException Si ocurre un error al obtener el nombre del médico desde la base de datos.
     */
    public String obtenerNombreCompletoMedico(int idMedico) throws NegocioException {
        try {
            return medicoDAO.consultarNombreCompletoMedico(idMedico);
        } catch (PersistenciaException e) {
            throw new NegocioException(null + e.getMessage(), e);
        }
    }
    
    /**
     * Da de baja temporalmente a un médico, evitando que pueda acceder al sistema por un tiempo determinado.
     * 
     * @param idMedico El ID del médico a dar de baja temporalmente.
     * @return `true` si la baja temporal fue exitosa, `false` en caso contrario.
     * @throws NegocioException Si el ID del médico no es válido o si ocurre un error al dar de baja al médico.
     */
    public boolean darDeBajaTemporal(int idMedico) throws NegocioException {
    try {
        if (idMedico <= 0) {
            throw new NegocioException("El ID del médico no es válido.");
        }
        boolean exito = medicoDAO.bajaTemporal(idMedico);
        if (!exito) {
            throw new NegocioException("No se pudo dar de baja temporalmente al médico.");
        }
        logger.info("Médico dado de baja temporalmente correctamente.");
        return true; 
    } catch (PersistenciaException e) {
        logger.log(Level.SEVERE, "Error al dar de baja temporalmente al médico", e);
        throw new NegocioException(e.getMessage());
    }
    }
    /**
     * Reactiva la cuenta de un médico que fue dada de baja previamente.
     * 
     * @param idMedico El ID del médico cuya cuenta se desea reactivar.
     * @return `true` si la reactivación fue exitosa, `false` en caso contrario.
     * @throws NegocioException Si el ID del médico no es válido o si ocurre un error al reactivar la cuenta del médico.
     */
    public boolean reactivarCuenta(int idMedico) throws NegocioException {
    try {
        if (idMedico <= 0) {
            throw new NegocioException("El ID del médico no es válido.");
        }
        boolean exito = medicoDAO.reactivarCuenta(idMedico);
        if (!exito) {
            throw new NegocioException("No se pudo reactivar la cuenta del médico.");
        }
        logger.info("Cuenta del médico reactivada correctamente.");
        return true;   
    } catch (PersistenciaException e) {
        logger.log(Level.SEVERE, "Error al reactivar la cuenta del médico", e);
        throw new NegocioException(e.getMessage());
    }
}
    /**
     * Obtiene el estado de un médico dado su ID.
     * 
     * @param idMedico El ID del médico cuyo estado se desea obtener.
     * @return El estado actual del médico (por ejemplo, activo, inactivo, etc.).
     * @throws NegocioException Si ocurre un error al obtener el estado del médico desde la base de datos.
     */
    public String obtenerEstadoMedico(int idMedico) throws NegocioException {
        try {
            return medicoDAO.obtenerEstadoMedico(idMedico);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

}
