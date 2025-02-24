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
    public Paciente consultarPacientePorId(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT IDPaciente, nombresPaciente, apellidoPaternoPaciente, apellidoMaternoPaciente, correo, telefono, fechaNacimiento, idDireccion FROM pacientes WHERE IDPaciente = ?";
        try (Connection con = conexion.crearConexion()) {
            try (PreparedStatement psPaciente = con.prepareStatement(sentenciaSQL)) {
                psPaciente.setInt(1, id);
                ResultSet rs = psPaciente.executeQuery();
                Paciente paciente = null;
                if (rs.next()) {
                    paciente = new Paciente(rs.getInt("IDPaciente"),
                            null,
                            rs.getString("nombresPaciente"),
                            rs.getString("apellidoPaternoPaciente"),
                            rs.getString("apellidoMaternoPaciente"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getDate("fechaNacimiento").toLocalDate(),
                            new Direccion(rs.getInt("idDireccion"), null, null, null, null));
                }
                String sentenciaSQL2 = "SELECT calle, numero, colonia, codigoPostal FROM direcciones WHERE IDDireccion = ?";
                try (PreparedStatement psDireccion = con.prepareStatement(sentenciaSQL2)) {
                    psDireccion.setInt(1, paciente.getDireccion().getIDDireccion());
                    if (rs.next()) {
                        paciente.getDireccion().setCalle(rs.getString("calle"));
                        paciente.getDireccion().setNumero(rs.getString("numero"));
                        paciente.getDireccion().setColonia(rs.getString("colonia"));
                        paciente.getDireccion().setCodigoPostal(rs.getString("codigoPostal"));
                    }
                }
                return paciente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar consultar el paciente por su id");
        }
    }

}
