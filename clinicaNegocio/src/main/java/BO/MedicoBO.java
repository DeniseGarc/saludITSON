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

    public MedicoBO(IConexion conexion) {
        this.medicoDAO = new MedicoDAO(conexion);
    }
    
    public String obtenerNombreCompletoMedico(int idMedico) throws NegocioException {
        try {
            return medicoDAO.consultarNombreCompletoMedico(idMedico);
        } catch (PersistenciaException e) {
            throw new NegocioException(null + e.getMessage(), e);
        }
    }
    
    
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
        throw new NegocioException("Error al dar de baja temporalmente al médico: " + e.getMessage());
    }
    }
    
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
        throw new NegocioException("Error al reactivar la cuenta del médico: " + e.getMessage());
    }
}
    public String obtenerEstadoMedico(int idMedico) throws NegocioException {
        try {
            return medicoDAO.obtenerEstadoMedico(idMedico);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el estado del médico: " + e.getMessage());
        }
    }

}
