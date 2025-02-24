/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Direccion;
import entidades.Paciente;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author benjy
 */
public class PacienteDAO implements IPacienteDAO {

    IConexion conexion;
    private static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());

    public PacienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) throws PersistenciaException {
        String procedimientoSQL = "CALL registrar_paciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conexion.crearConexion(); CallableStatement cs = con.prepareCall(procedimientoSQL)) {

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
            cs.setString(11, paciente.getContrasenaUsuario());

            // Ejecutar el procedimiento almacenado
            cs.executeUpdate();
            logger.info("Paciente registrado exitosamente.");

            return paciente;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar paciente", e);
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean consultarPacientePorTelefono(String telefono) throws PersistenciaException {
        String sentenciaSQL = "SELECT telefono FROM pacientes WHERE telefono = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setString(1, telefono);
            ResultSet resultado = ps.executeQuery();
            return resultado.next();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar consultar el telefono del paciente");
        }
    }
    
    @Override
    public String consultarNombreCompletoPaciente(int idPaciente) throws PersistenciaException {
        String sentenciaSQL = "SELECT CONCAT(nombresPaciente, ' ', apellidoPaternoPaciente, ' ', apellidoMaternoPaciente) AS nombreCompleto FROM pacientes WHERE IDPaciente = ?";
        try (Connection con = conexion.crearConexion(); 
            PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
        
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
        
            if (rs.next()) {
                return rs.getString("nombreCompleto"); 
            } else {
            throw new PersistenciaException(null);
            }
        
        } catch (SQLException ex) {
        logger.log(Level.SEVERE, null, ex);
        throw new PersistenciaException(null, ex);
        }
}
    @Override
    public boolean tieneCitasActivas(int idPaciente) throws PersistenciaException {
    String sentenciasql = "SELECT COUNT(*) FROM Citas WHERE idPaciente = ? AND estadoCita = 'activa'";
    
    try (Connection con = conexion.crearConexion();
         PreparedStatement ps = con.prepareStatement(sentenciasql)) {

        ps.setInt(1, idPaciente);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    } catch (SQLException e) {
        throw new PersistenciaException("Error al verificar citas activas: " + e.getMessage());
    }
}
    @Override
    public boolean actualizarPaciente(int idPaciente, String nombres, String apellidoPaterno, String apellidoMaterno,
        String telefono, LocalDate fechaNacimiento, int idDireccion, String calle, String numero, String colonia, String codigoPostal) throws PersistenciaException {
        Connection con = null;
        try {
        con = conexion.crearConexion();
        con.setAutoCommit(false); 

        String sqlDireccion = "UPDATE Direcciones SET calle = ?, numero = ?, colonia = ?, codigoPostal = ? WHERE IDDireccion = ?";
        try (PreparedStatement psDireccion = con.prepareStatement(sqlDireccion)) {
            psDireccion.setString(1, calle);
            psDireccion.setString(2, numero);
            psDireccion.setString(3, colonia);
            psDireccion.setString(4, codigoPostal);
            psDireccion.setInt(5, idDireccion);
            psDireccion.executeUpdate();
        }

        String sqlPaciente = "UPDATE Pacientes SET nombresPaciente = ?, apellidoPaternoPaciente = ?, apellidoMaternoPaciente = ?, telefono = ?, fechaNacimiento = ? WHERE IDPaciente = ?";
        try (PreparedStatement psPaciente = con.prepareStatement(sqlPaciente)) {
            psPaciente.setString(1, nombres);
            psPaciente.setString(2, apellidoPaterno);
            psPaciente.setString(3, apellidoMaterno);
            psPaciente.setString(4, telefono); // 
            psPaciente.setDate(5, Date.valueOf(fechaNacimiento)); 
            psPaciente.setInt(6, idPaciente); 
            psPaciente.executeUpdate();
        }

        con.commit(); 

        return true; 

    } catch (SQLException e) {
        if (con != null) {
            try {
                con.rollback(); 
            } catch (SQLException ex) {
                throw new PersistenciaException("Error al hacer rollback: " + ex.getMessage());
            }
        }
        throw new PersistenciaException("Error al actualizar paciente: " + e.getMessage());
    } finally {
        if (con != null) {
            try {
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                
            }
        }
    }
}

      
}
