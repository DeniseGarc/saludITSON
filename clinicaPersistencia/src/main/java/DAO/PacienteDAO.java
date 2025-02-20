/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Paciente;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * 
 * @author benjy
 */
public class PacienteDAO implements IPacienteDAO{
    IConexion conexion;
     private static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());

    public PacienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }
@Override
public Paciente registrarPaciente(Paciente paciente) throws PersistenciaException {
    String procedimientoSQL = "{CALL registrar_paciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    try (Connection con = conexion.crearConexion();
         CallableStatement cs = con.prepareCall(procedimientoSQL)) {

        // Establecer los parámetros del procedimiento almacenado
        cs.setString(1, paciente.getNombresPaciente());
        cs.setString(2, paciente.getApellidoPaternoPaciente());
        cs.setString(3, paciente.getApellidoMaternoPaciente());
        cs.setString(4, paciente.getCorreo());
        cs.setString(5, paciente.getTelefono());
        cs.setDate(6, Date.valueOf(paciente.getFechaNacimiento()));
        cs.setString(7, paciente.getDireccion().getCalle());
        cs.setString(8, paciente.getDireccion().getNumero());
        cs.setString(9, paciente.getDireccion().getColonia());
        cs.setString(10, paciente.getDireccion().getCodigoPostal());
        cs.setString(11,paciente.getContrasenaUsuario()); 

        // Ejecutar el procedimiento almacenado
        cs.executeUpdate();
        logger.info("Paciente registrado exitosamente.");

        return paciente;

    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al registrar paciente", e);
        throw new PersistenciaException("Error al registrar el paciente", e);
    }
}
}
