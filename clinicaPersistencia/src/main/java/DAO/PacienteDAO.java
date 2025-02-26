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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Constructor que inicializa la conexión a la base de datos.
     *
     * @param conexion Objeto que gestiona la conexión a la base de datos.
     */
    public PacienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Registra un nuevo paciente en la base de datos.
     *
     * @param paciente Objeto Paciente que contiene la información del paciente a registrar.
     * @return El paciente registrado.
     * @throws PersistenciaException Si ocurre un error al registrar el paciente.
     */
    @Override
    public Paciente registrarPaciente(Paciente paciente) throws PersistenciaException {
        String procedimientoSQL = "CALL registrar_paciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conexion.crearConexion(); CallableStatement cs = con.prepareCall(procedimientoSQL)) {

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

            cs.executeUpdate();
            logger.info("Paciente registrado exitosamente.");

            return paciente;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar paciente", e);
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    /**
     * Verifica si un paciente existe en la base de datos a partir de su teléfono.
     *
     * @param telefono Número de teléfono del paciente.
     * @return true si el paciente existe, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al consultar el teléfono del paciente.
     */
    @Override
    public boolean consultarPacientePorTelefono(String telefono) throws PersistenciaException {
        String sentenciaSQL = "SELECT telefono FROM pacientes WHERE telefono = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
            ps.setString(1, telefono);
            ResultSet resultado = ps.executeQuery();
            return resultado.next();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar consultar el telefono del paciente");
        }
    }
    /**
     * Consulta los datos de un paciente por su ID.
     *
     * @param id ID del paciente a consultar.
     * @return Objeto Paciente con los datos del paciente consultado.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    @Override
    public Paciente consultarPacientePorId(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT IDPaciente, nombresPaciente, apellidoPaternoPaciente, apellidoMaternoPaciente, correo, telefono, fechaNacimiento, idDireccion FROM pacientes WHERE IDPaciente = ?";
        try (Connection con = conexion.crearConexion()) {
            try (PreparedStatement psPaciente = con.prepareStatement(sentenciaSQL)) {
                psPaciente.setInt(1, id);
                ResultSet rs = psPaciente.executeQuery();
                Paciente paciente = null;
                if (rs.next()) {
                    paciente = new Paciente(rs.getInt("IDPaciente"),null,rs.getString("nombresPaciente"),rs.getString("apellidoPaternoPaciente"),rs.getString("apellidoMaternoPaciente"),
                            rs.getString("correo"),rs.getString("telefono"),rs.getDate("fechaNacimiento").toLocalDate(),
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

    /**
     * Consulta el nombre completo de un paciente a partir de su ID.
     *
     * @param idPaciente ID del paciente a consultar.
     * @return Nombre completo del paciente en formato "Nombre ApellidoPaterno ApellidoMaterno".
     * @throws PersistenciaException Si ocurre un error en la consulta o el paciente no es encontrado.
     */
    @Override
    public String consultarNombreCompletoPaciente(int idPaciente) throws PersistenciaException {
        String sentenciaSQL = "SELECT CONCAT(nombresPaciente, ' ', apellidoPaternoPaciente, ' ', apellidoMaternoPaciente) AS nombreCompleto FROM pacientes WHERE IDPaciente = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {

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

    /**
     * Verifica si un paciente tiene citas activas en la base de datos.
     *
     * @param idPaciente ID del paciente a verificar.
     * @return true si el paciente tiene al menos una cita activa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    @Override
    public boolean tieneCitasActivas(int idPaciente) throws PersistenciaException {
        String sentenciasql = "SELECT COUNT(*) FROM Citas WHERE idPaciente = ? AND estadoCita = 'activa'";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciasql)) {
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
    /**
     * Actualiza los datos de un paciente en la base de datos, incluyendo su dirección.
     *
     * @param paciente Objeto Paciente con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al actualizar los datos del paciente.
     */
    @Override
    public boolean actualizarPaciente(Paciente paciente) throws PersistenciaException {
        String sqlDireccion = "UPDATE Direcciones SET calle = ?, numero = ?, colonia = ?, codigoPostal = ? WHERE IDDireccion = ?";
        try (Connection con = conexion.crearConexion();) {
            con.setAutoCommit(false);
            try (PreparedStatement psDireccion = con.prepareStatement(sqlDireccion)) {
                psDireccion.setString(1, paciente.getDireccion().getCalle());
                psDireccion.setString(2, paciente.getDireccion().getNumero());
                psDireccion.setString(3, paciente.getDireccion().getColonia());
                psDireccion.setString(4, paciente.getDireccion().getCodigoPostal());
                psDireccion.setInt(5, paciente.getDireccion().getIDDireccion());
                int filasActualizadasDireccion = psDireccion.executeUpdate();
                if (filasActualizadasDireccion == 0) {
                    throw new PersistenciaException("No se pudo actualizar la dirección del paciente");
                }
            }

            String sqlPaciente = "UPDATE Pacientes SET nombresPaciente = ?, apellidoPaternoPaciente = ?, apellidoMaternoPaciente = ?, telefono = ?, fechaNacimiento = ? WHERE IDPaciente = ?";
            try (PreparedStatement psPaciente = con.prepareStatement(sqlPaciente)) {
                psPaciente.setString(1, paciente.getNombresPaciente());
                psPaciente.setString(2, paciente.getApellidoPaternoPaciente());
                psPaciente.setString(3, paciente.getApellidoMaternoPaciente());
                psPaciente.setString(4, paciente.getTelefono());
                psPaciente.setDate(5, Date.valueOf(paciente.getFechaNacimiento()));
                psPaciente.setInt(6, paciente.getIDUsuario());
                int filasActualizadasPaciente = psPaciente.executeUpdate();
                if (filasActualizadasPaciente == 0) {
                    throw new PersistenciaException("No se pudo actualizar los datos del paciente");
                }
            }
            con.commit();
            return true;
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar paciente: " + e.getMessage());
        }
    }
    /**
     * Obtiene el ID de la dirección de un paciente a partir de su ID de paciente.
     *
     * @param idPaciente ID del paciente.
     * @return El ID de la dirección asociada al paciente.
     * @throws PersistenciaException Si ocurre un error al consultar la dirección del paciente.
     */
    @Override
    public int obtenerIdDireccionPorPaciente(int idPaciente) throws PersistenciaException {
        String sql = "SELECT IDDireccion FROM Pacientes WHERE IDPaciente = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaciente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("IDDireccion");
                } else {
                    throw new PersistenciaException("No se encontró la dirección para el paciente con ID: " + idPaciente);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la dirección: " + e.getMessage());
        }
    }
    /**
     * Obtiene los datos completos de un paciente a partir de su ID, incluyendo su dirección.
     *
     * @param idPaciente ID del paciente a consultar.
     * @return Un objeto Paciente con todos sus datos completos, incluidos los de la dirección.
     * @throws PersistenciaException Si ocurre un error al obtener los datos del paciente.
     */
    @Override
    public Paciente obtenerDatosPaciente(int idPaciente) throws PersistenciaException {
        String sql = "SELECT p.nombresPaciente, p.apellidoPaternoPaciente, p.apellidoMaternoPaciente, p.telefono, p.fechaNacimiento, d.calle, d.numero, d.colonia, d.codigoPostal "
                + "FROM Pacientes p JOIN Direcciones d ON p.IDDireccion = d.IDDireccion WHERE p.IDPaciente = ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new PersistenciaException("No se encontró un paciente con ID: " + idPaciente);
            }
            Paciente paciente = new Paciente();
            paciente.setNombresPaciente(rs.getString("nombresPaciente"));
            paciente.setApellidoPaternoPaciente(rs.getString("apellidoPaternoPaciente"));
            paciente.setApellidoMaternoPaciente(rs.getString("apellidoMaternoPaciente"));
            paciente.setTelefono(rs.getString("telefono"));

            Date fecha = rs.getDate("fechaNacimiento");
            if (fecha != null) {
                paciente.setFechaNacimiento(fecha.toLocalDate());
            }

            Direccion direccion = new Direccion();
            direccion.setCalle(rs.getString("calle"));
            direccion.setNumero(rs.getString("numero"));
            direccion.setColonia(rs.getString("colonia"));
            direccion.setCodigoPostal(rs.getString("codigoPostal"));
            paciente.setDireccion(direccion);

            return paciente;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener los datos del paciente: " + e.getMessage(), e);
        }
    }
    // /*
    // Metodo para consultar el id del paciente que corresponde con el correo y la contraseña.
    // Si el ID existe y la contraseña coincide, devuelve el id para acceder al sistema.
    // Devuelve un 0 y un error en caso contrario.
    //  */
    // @Override
    // public int consultarIDPacientePorContrasenaCorreo(String correoIngresado, String contrasenaIngresada) throws PersistenciaException {

    //     try (Connection con = conexion.crearConexion()) {
    //         String sentenciaSQL = "SELECT IDPaciente,IDUsuario FROM pacientes INNER JOIN Usuarios ON IDPaciente=IDUsuario WHERE correo = ?  AND contrasenaUsuario = ?";
    //         PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
    //         psID1.setString(1, correoIngresado);
    //         psID1.setString(2, contrasenaIngresada);
    //         try {
    //             ResultSet rs = psID1.executeQuery();
    //             if (this.VerificarContrasena(contrasenaIngresada) == true) {
    //                 return Integer.parseInt(rs.getString(1));
    //             } else {
    //                 JOptionPane.showMessageDialog(null, "Error: La contraseña es incorrecta.");
    //             }

    //         } catch (SQLException s) {
    //             Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Consulta que devuelve resultados vacios", s);
    //             JOptionPane.showMessageDialog(null, "Error: La dirección de correo o la contraseña son inexistentes");
    //         }
    //     } catch (SQLException ex) {
    //         Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
    //         JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

    //     }
    //     return 0;
    // }

    // public boolean VerificarCorreo(String correoIngresado) throws PersistenciaException {
    //     try (Connection con = conexion.crearConexion()) {
    //         String sentenciaSQL = "SELECT IDPaciente FROM pacientes WHERE correo = ?";
    //         PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
    //         psID1.setString(1, correoIngresado);
    //         ResultSet rs = psID1.executeQuery();
    //         if (rs.getString(1).isEmpty()) {
    //             JOptionPane.showMessageDialog(null, "Error: El correo no esta registrado en el Sistema.");
    //             return false;
    //         } else {
    //             return true;
    //         }

    //     } catch (SQLException ex) {
    //         Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
    //         JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

    //     }
    //     return false;
    // }

    // public boolean VerificarContrasena(String contrasenaIngresada) throws PersistenciaException {
    //     try (Connection con = conexion.crearConexion()) {
    //         String sentenciaSQL = "SELECT contrasenaUsuario FROM Usuarios WHERE contrasenaUsuario = ?";
    //         PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
    //         psID1.setString(1, contrasenaIngresada);
    //         try {
    //             ResultSet rs = psID1.executeQuery();
    //             if (encriptador.Match(contrasenaIngresada, rs.getString(1))) {
    //                 return true;

    //             } else {
    //                 return false;
    //             }

    //         } catch (SQLException s) {
    //             Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Consulta con resultado vacio", s);
    //             JOptionPane.showMessageDialog(null, "Error: La contraseña no se encuentra en el sistema.");
    //         }

    //     } catch (SQLException ex) {
    //         Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
    //         JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

    //     }
    //     return false;
    // }

    // public int ObtenerIDPaciente(boolean verificacion1, boolean verificacion2, String correoIngresado) throws PersistenciaException {
    //     if (verificacion1 == true && verificacion2 == true) {
    //         try (Connection con = conexion.crearConexion()) {
    //             String sentenciaSQL = "SELECT IDPaciente FROM pacientes WHERE correo = ?";
    //             PreparedStatement psID1 = con.prepareStatement(sentenciaSQL);
    //             psID1.setString(1, correoIngresado);
    //             ResultSet rs = psID1.executeQuery();
    //             if (rs.getString(1).isEmpty()) {
    //                 JOptionPane.showMessageDialog(null, "Error: El correo no esta registrado en el Sistema.");
    //                 return 0;
    //             } else {
    //                 return Integer.parseInt(rs.getString(1));
    //             }

    //         } catch (SQLException ex) {
    //             Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, "Error: Espacios vacios", ex);
    //             JOptionPane.showMessageDialog(null, "Error: error al intentar consultar el paciente");

    //         }
    //     }
    //     return 0;
    // }

}
