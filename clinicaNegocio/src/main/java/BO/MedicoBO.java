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
import mapper.MedicoMapper;

/**
 *
 * @author benjy
 */
public class MedicoBO {
    private final IMedicoDAO medicoDAO;
    private final MedicoMapper mapper = new MedicoMapper();

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
}
