/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Medico;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benjy
 */
public class MedicoDAO implements IMedicoDAO {

    IConexion conexion;
    private static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());

    public MedicoDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    // lo dejamos? No es algo que sea necesario implementar ya que no se pidió en los requerimientos  

//    @Override
//    public Medico registrarMedico(Medico medico) throws PersistenciaException {
//        String procedimientoSQL = "{CALL registrar_medico(?, ?, ?, ?, ?, ?)}";
//
//        try (Connection con = conexion.crearConexion();
//             CallableStatement cs = con.prepareCall(procedimientoSQL)) {
//
//            // Establecer los parámetros del procedimiento almacenado
//            cs.setString(1, medico.getNombresMedico());
//            cs.setString(2, medico.getApellidoPaternoMedico());
//            cs.setString(3, medico.getApellidoMaternoMedico());
//            cs.setString(4, medico.getCedulaProfesional());
//            cs.setString(5, medico.getEspecialidad());
//            cs.setString(6, medico.getContrasenaUsuario()); // Contraseña
//
//            // Enviar los horarios, cada uno en su correspondiente parámetro
//
//            // Ejecutar el procedimiento almacenado
//            cs.executeUpdate();
//            logger.info("Médico registrado exitosamente.");
//
//            return medico;
//
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Error al registrar médico", e);
//            throw new PersistenciaException("Error al registrar el médico en la base de datos.", e);
//        }
//    }
    @Override
    public List<Medico> consultarMedicosPorEspecialidad(String especialidad) throws PersistenciaException {
        ArrayList<Medico> medicos = new ArrayList<>();
        String senteciaSQL = "SELECT IDMedico, nombresMedico, apellidoPaternoMedico, apellidoMaternoMedico, cedulaProfesional, especialidad, estado FROM medicos WHERE especialidad LIKE ? AND estado = \"activo\"";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(senteciaSQL);) {
            ps.setString(1, especialidad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getInt("IDMedico"), null,
                        rs.getString("nombresMedico"),
                        rs.getString("apellidoPaternoMedico"),
                        rs.getString("apellidoMaternoMedico"),
                        rs.getString("cedulaProfesional"),
                        rs.getString("especialidad"),
                        rs.getString("estado"));
                medicos.add(medico);
            }
            return medicos;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No fue posible recuperar los medicos de la especialidad");
        }
    }

    @Override
    public List<String> consultarEspecialidades() throws PersistenciaException {
        ArrayList<String> especialidades = new ArrayList<>();
        String sentenciaSQL = "SELECT especialidad FROM medicos GROUP BY especialidad";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                especialidades.add(rs.getString("especialidad"));
            }
            return especialidades;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar obtener las especialidades de los médicos");
        }
    }

    @Override
    public List<LocalTime> obtenerHorariosCitas(Medico medico, LocalDate fecha) throws PersistenciaException {
        ArrayList<LocalTime> horariosDisponibles = new ArrayList<>();
        String sentenciaSQL = "CALL generarHorariosDisponibles(?,?)";

        try (Connection con = conexion.crearConexion(); CallableStatement cs = con.prepareCall(sentenciaSQL);) {
            cs.setInt(1, medico.getIDUsuario());
            cs.setDate(2, Date.valueOf(fecha));
            ResultSet resultados = cs.executeQuery();
            while (resultados.next()) {
                horariosDisponibles.add(resultados.getTime(1, null).toLocalTime());
            }
            return horariosDisponibles;
        } catch (SQLException ex) {
            if ("45000".equals(ex.getSQLState())) {
                throw new PersistenciaException(ex.getMessage());
            }
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar obtener horarios para citas");
        }
    }

    @Override
    public Medico consultarMedicoPorId(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT IDMedico, nombresMedico, apellidoPaternoMedico, apellidoMaternoMedico, cedulaProfesional, especialidad, estado FROM medicos WHERE IDMedico = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Medico medico = null;
            if (rs.next()) {
                medico = new Medico(
                        rs.getInt("IDMedico"), null,
                        rs.getString("nombresMedico"),
                        rs.getString("apellidoPaternoMedico"),
                        rs.getString("apellidoMaternoMedico"),
                        rs.getString("cedulaProfesional"),
                        rs.getString("especialidad"),
                        rs.getString("estado"));
            }
            return medico;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar consultar el medico por su id");
        }
    }
        @Override
    public int consultarMedicoPorNombre(String Nombre) throws PersistenciaException {
        String sentenciaSQL = "SELECT IDMedico FROM medicos WHERE nombresMedico = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
            ps.setString(1, Nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDMedico");
            }else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar consultar el medico por su Nombre");
          
        }
    }
}
