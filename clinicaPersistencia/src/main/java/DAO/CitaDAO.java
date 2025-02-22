package DAO;

import conexion.IConexion;
import excepciones.PersistenciaException;
import entidades.Cita;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alici
 */
public class CitaDAO implements ICitaDAO {

    IConexion conexion;

    public CitaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agendarCita(Cita cita) throws PersistenciaException {
        String sentenciaSQL = "CALL agendar_cita(?,?,?)";
        try (Connection con = conexion.crearConexion(); CallableStatement cs = con.prepareCall(sentenciaSQL);) {
            cs.setTimestamp(1, Timestamp.valueOf(cita.getFechaHora()));
            cs.setInt(2, cita.getMedico().getIDUsuario());
            cs.setInt(3, cita.getPaciente().getIDUsuario());
            cs.execute();
            return true;
        } catch (SQLException ex) {
            if ("45000".equals(ex.getSQLState())) {
                throw new PersistenciaException(ex.getMessage());
            }
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, "Ocurrio un error intentando agendar cita", ex);
            throw new PersistenciaException("Ocurrió un error al agendar cita");
        }
    }

    @Override
    public boolean generarCitaEmergencia(Cita cita) throws PersistenciaException {
        String sentenciaSQL = "CALL generar_cita_emergencia(?,?,?,?)";
        try (Connection con = conexion.crearConexion(); CallableStatement cs = con.prepareCall(sentenciaSQL);) {
            cs.setTimestamp(1, Timestamp.valueOf(cita.getFechaHora()));
            cs.setString(2, cita.getFolioCita());
            cs.setInt(3, cita.getMedico().getIDUsuario());
            cs.setInt(4, cita.getPaciente().getIDUsuario());
            cs.execute();
            return true;
        } catch (SQLException ex) {
            if ("45000".equals(ex.getSQLState())) {
                throw new PersistenciaException(ex.getMessage());
            }
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, "Ocurrio un error intentando agendar cita de emergencia", ex);
            throw new PersistenciaException("Ocurrió un error al agendar cita de emergencia");
        }
    }

    @Override
    public boolean consultarCitaPorFechaHora(LocalDateTime fechaHora, String idMedico) throws PersistenciaException {
        String sentenciaSQL = "SELECT fechaHora FROM citas WHERE fechaHora = ? AND  idMedico = ? AND estadoCita != 'cancelada';";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setTimestamp(1, Timestamp.valueOf(fechaHora));
            ps.setString(2, idMedico);
            ResultSet resultado = ps.executeQuery();
            return resultado.next();
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, "Ocurrio un error al intentar consultar cita por fecha hora", ex);
            throw new PersistenciaException("Ocurrió un error al intentar consultar las citas por fecha y hora");
        }
    }

    @Override
    public boolean consultarCitaPorFolio(String folio) throws PersistenciaException {
        String sentenciaSQL = "SELECT folioCita FROM citas WHERE tipo = 'emergencia' AND folioCita = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setString(1, folio);
            ResultSet resultado = ps.executeQuery();
            return resultado.next();
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar consultar existencia de folio");
        }
    }

}
