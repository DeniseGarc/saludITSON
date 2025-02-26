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
            return horariosDisponibles.stream().filter(hora -> hora.isAfter(LocalTime.now())).toList();
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
    public String consultarNombreCompletoMedico(int idMedico) throws PersistenciaException {
        String sentenciaSQL = "SELECT CONCAT(nombresMedico, ' ', apellidoPaternoMedico, ' ', apellidoMaternoMedico) AS nombreCompleto FROM medicos WHERE IDMedico = ?";
    
        try (Connection con = conexion.crearConexion(); 
             PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
        
            ps.setInt(1, idMedico); 
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
    public boolean tieneCitasActivas(int idMedico) throws PersistenciaException {
    String sentenciasql = "SELECT COUNT(*) FROM Citas WHERE idMedico = ? AND estadoCita = 'activa'";
    
    try (Connection con = conexion.crearConexion();
         PreparedStatement ps = con.prepareStatement(sentenciasql)) {

        ps.setInt(1, idMedico);
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
    public boolean bajaTemporal(int idMedico) throws PersistenciaException {
    if (tieneCitasActivas(idMedico)) {
        throw new PersistenciaException("No se puede dar de baja al médico porque tiene citas activas.");
    }
    String sentenciaSQL = "UPDATE Medicos SET estado = 'inactivo' WHERE IDMedico = ?";
    try (Connection con = conexion.crearConexion();
         PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
         ps.setInt(1, idMedico);
         int filasActualizadas = ps.executeUpdate();
        return filasActualizadas > 0;
    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al dar de baja temporalmente al médico", e);
        throw new PersistenciaException("Error al dar de baja temporalmente al médico: " + e.getMessage());
    }
}
    
    @Override
    public boolean reactivarCuenta(int idMedico) throws PersistenciaException {
    String sentenciaSQL = "UPDATE Medicos SET estado = 'activo' WHERE IDMedico = ?";
    try (Connection con = conexion.crearConexion();
         PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
         ps.setInt(1, idMedico);
         int filasActualizadas = ps.executeUpdate();
         return filasActualizadas > 0;
    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al reactivar la cuenta del médico", e);
        throw new PersistenciaException("Error al reactivar la cuenta del médico: " + e.getMessage());
    }
}
    @Override
    public String obtenerEstadoMedico(int idMedico) throws PersistenciaException {
    String sentenciaSQL = "SELECT estado FROM Medicos WHERE IDMedico = ?";
    
    try (Connection con = conexion.crearConexion();
         PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {

        ps.setInt(1, idMedico);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("estado");
            } else {
                throw new PersistenciaException("No se encontró el médico con ID: " + idMedico);
            }
        }
    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al obtener el estado del médico", e);
        throw new PersistenciaException("Error al obtener el estado del médico: " + e.getMessage());
    }
}
}
