/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Encriptado.Encriptador;
import Encriptado.IEncriptador;
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
import javax.swing.JOptionPane;

/**
 *
 * @author benjy
 */
public class PacienteDAO implements IPacienteDAO {

    IConexion conexion;
    private static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());
    IEncriptador encriptador = new Encriptador();

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

    /*
    Metodo para consultar el id del paciente que corresponde con el correo y la contraseña.
    Ejecuta 2 consultas, la primera consulta el correo en la tabla pacientes, si el correo coincide con uno almacenado
    en la BD, obtiene el id del paciente, muestra un error en caso contrario.
    La segunda consulta busca el usuario que tenga una contraseña que coincida en la base de datos
    Si encuentra un usuario que tenga una contraseña que coincida, obtiene el id, muestra un error en caso contrario.
    Al encontrar los 2 IDs que coinciden, estos se comparan, si ambos son iguales, entonces el correo y la contraseña
    estan correctos, dando lugar al logeo.
     */
    @Override
    public int consultarIDPacientePorContrasenaCorreo(String correoIngresado, String contrasenaIngresada) throws PersistenciaException {

        try (Connection con = conexion.crearConexion()) {
            String sentenciaSQL = "SELECT IDPaciente,IDUsuario, FROM pacientes INNER JOIN Usuarios ON IDPaciente=IDUsuario WHERE correo = ?  AND contrasenaUsuario = ?";
            PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
            psID1.setString(1, correoIngresado);
            psID1.setString(2, contrasenaIngresada);
            ResultSet rs = psID1.executeQuery();
            if (rs.getString(1).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: El correo no esta registrado en el Sistema.");
                return 0;
            } else if (rs.getString(2).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: La contraseña es incorrecta.");
                return 0;
            } else {
                return Integer.parseInt(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
            JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

        }
        return 0;
    }

    public boolean VerificarCorreo(String correoIngresado) throws PersistenciaException {
        try (Connection con = conexion.crearConexion()) {
            String sentenciaSQL = "SELECT IDPaciente FROM pacientes WHERE correo = ?";
            PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
            psID1.setString(1, correoIngresado);
            ResultSet rs = psID1.executeQuery();
            if (rs.getString(1).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: El correo no esta registrado en el Sistema.");
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
            JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

        }
        return false;
    }

    public boolean VerificarContrasena(String contrasenaIngresada) throws PersistenciaException {
        try (Connection con = conexion.crearConexion()) {
            String sentenciaSQL = "SELECT IDUsuario FROM pacientes WHERE contrasenaUsuario = ?";
            PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
            psID1.setString(1, contrasenaIngresada);
            ResultSet rs = psID1.executeQuery();
            if (rs.getString(1).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: la contrasena esta vacia.");
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
            JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

        }
        return false;
    }

    public int ObtenerIDPaciente(boolean verificacion1, boolean verificacion2, String correoIngresado) throws PersistenciaException {
        if (verificacion1 == true && verificacion2 == true) {
            try (Connection con = conexion.crearConexion()) {
                String sentenciaSQL = "SELECT IDPaciente FROM pacientes WHERE correo = ?";
                PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
                psID1.setString(1, correoIngresado);
                ResultSet rs = psID1.executeQuery();
                if (rs.getString(1).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: El correo no esta registrado en el Sistema.");
                    return 0;
                } else {
                    return Integer.parseInt(rs.getString(1));
                }

            } catch (SQLException ex) {
                Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
                JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

            }
        }
        return 0;
    }
}
