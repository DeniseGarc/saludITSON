package DAO;

import conexion.IConexion;
import excepciones.PersistenciaException;
import entidades.Cita;
import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public Cita generarCitaEmergencia(Cita cita) throws PersistenciaException {
        String sentenciaSQL = "CALL generar_cita_emergencia(?,?,?,?,?)";
        try (Connection con = conexion.crearConexion(); CallableStatement cs = con.prepareCall(sentenciaSQL);) {
            cs.setTimestamp(1, Timestamp.valueOf(cita.getFechaHora()));
            cs.setString(2, cita.getFolioCita());
            cs.setInt(3, cita.getMedico().getIDUsuario());
            cs.setInt(4, cita.getPaciente().getIDUsuario());
            cs.registerOutParameter(5, Types.INTEGER);
            cs.execute();
            int idGenerado = cs.getInt(5);
            cita.setIDCita(idGenerado);
            return cita;
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
    public Cita consultarCitaPorFolio(String folio) throws PersistenciaException {
        String sentenciaSQL = "SELECT IDCita, folioCita FROM citas WHERE tipo = 'emergencia' AND folioCita = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setString(1, folio);
            ResultSet resultado = ps.executeQuery();
            Cita cita = new Cita();
            if (resultado.next()) {
                cita.setIDCita(resultado.getInt("IDCita"));
                cita.setFolioCita(resultado.getString("folioCita"));
            }
            return cita;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al intentar consultar existencia de folio");
        }
    }

    @Override
    public Cita consultarCitaPorId(int id) throws PersistenciaException {
        String sentenciaSQL = "SELECT c.IDCita, c.fechaHora, c.estadoCita, c.folioCita, c.tipo, c.idMedico, m.nombresMedico, m.apellidoPaternoMedico, m.apellidoMaternoMedico, m.cedulaProfesional, m.especialidad, m.estado, c.idPaciente,p.nombresPaciente, p.apellidoPaternoPaciente, p.apellidoMaternoPaciente, p.correo, p.telefono,calcularEdad(p.fechaNacimiento) as 'edad' ,p.fechaNacimiento FROM citas c INNER JOIN pacientes p ON p.IDPaciente = c.idPaciente INNER JOIN medicos m ON m.IDMedico = c.idMedico WHERE IDCita = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Medico medico = new Medico();
            Paciente paciente = new Paciente();
            if (rs.next()) {
                medico.setIDUsuario(rs.getInt("idMedico"));
                paciente.setIDUsuario(rs.getInt("idPaciente"));
                Cita cita = new Cita(
                        rs.getInt("IDCita"),
                        rs.getTimestamp("fechaHora").toLocalDateTime(),
                        rs.getString("estadoCita"),
                        rs.getString("folioCita"),
                        rs.getString("tipo"),
                        new Medico(rs.getInt("idMedico"),
                                null, rs.getString("nombresMedico"),
                                rs.getString("apellidoPaternoMedico"),
                                rs.getString("apellidoMaternoMedico"),
                                rs.getString("cedulaProfesional"),
                                rs.getString("especialidad"),
                                rs.getString("estado")
                        ),
                        new Paciente(rs.getInt("idPaciente"), null,
                                rs.getString("nombresPaciente"),
                                rs.getString("apellidoPaternoPaciente"),
                                rs.getString("apellidoMaternoPaciente"),
                                rs.getString("correo"),
                                rs.getString("telefono"),
                                rs.getInt("edad"),
                                rs.getDate("fechaNacimiento").toLocalDate(),
                                null));
                return cita;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al conseguir la cita por su id");
        }
    }

    @Override
    public boolean actualizarEstadoCita(Cita cita) throws PersistenciaException {
        String sentenciaSQL = "UPDATE citas SET estadoCita = ?, folioCita = null WHERE IDCita = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setString(1, cita.getEstadoCita());
            ps.setInt(2, cita.getIDCita());
            int resultado = ps.executeUpdate();
            return (resultado > 0);
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al actualizar el estado de la cita");
        }
    }

    @Override
    public List<Cita> consultarCitasActivas() throws PersistenciaException {
        List<Cita> citas = new ArrayList<>();
        String sentenciaSQL = "SELECT c.IDCita, c.fechaHora, c.estadoCita, c.folioCita, c.tipo, c.idMedico, m.nombresMedico, m.apellidoPaternoMedico, m.apellidoMaternoMedico, m.cedulaProfesional, m.especialidad, m.estado, c.idPaciente,p.nombresPaciente, p.apellidoPaternoPaciente, p.apellidoMaternoPaciente, p.correo, p.telefono,calcularEdad(p.fechaNacimiento) as 'edad' ,p.fechaNacimiento FROM citas c INNER JOIN pacientes p ON p.IDPaciente = c.idPaciente INNER JOIN medicos m ON m.IDMedico = c.idMedico WHERE estadoCita = 'activa'";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ResultSet rs = ps.executeQuery();
            Medico medico = new Medico();
            Paciente paciente = new Paciente();
            while (rs.next()) {
                medico.setIDUsuario(rs.getInt("idMedico"));
                paciente.setIDUsuario(rs.getInt("idPaciente"));
                Cita cita = new Cita(
                        rs.getInt("IDCita"),
                        rs.getTimestamp("fechaHora").toLocalDateTime(),
                        rs.getString("estadoCita"),
                        rs.getString("folioCita"),
                        rs.getString("tipo"),
                        new Medico(rs.getInt("idMedico"),
                                null, rs.getString("nombresMedico"),
                                rs.getString("apellidoPaternoMedico"),
                                rs.getString("apellidoMaternoMedico"),
                                rs.getString("cedulaProfesional"),
                                rs.getString("especialidad"),
                                rs.getString("estado")
                        ),
                        new Paciente(rs.getInt("idPaciente"), null,
                                rs.getString("nombresPaciente"),
                                rs.getString("apellidoPaternoPaciente"),
                                rs.getString("apellidoMaternoPaciente"),
                                rs.getString("correo"),
                                rs.getString("telefono"),
                                rs.getInt("edad"),
                                rs.getDate("fechaNacimiento").toLocalDate(),
                                null));
                citas.add(cita);
            }
            return citas;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al conseguir las citas registradas");
        }
    }

    @Override
    public boolean registrarConsulta(Consulta consulta) throws PersistenciaException{
        String sentenciaSQL = "INSERT INTO consultas(diagnostico, tratamiento, observaciones, idCita) VALUES (?,?,?,?)";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setString(1,consulta.getDiagnostico());
            ps.setString(2, consulta.getTratamiento());
            ps.setString(3, consulta.getObservaciones());
            ps.setInt(4, consulta.getCita().getIDCita());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No fue posible registrar la consulta");
        }
        
    }
    @Override
    public boolean eliminarCitaSeleccionada(int idMedico, LocalDateTime fechaHora ) throws PersistenciaException{
        String sentenciaSQL = "DELETE FROM citas WHERE idMedico = ? AND fechaHora = ?";
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL);) {
            ps.setInt(1,idMedico);
            ps.setTimestamp(2, Timestamp.valueOf(fechaHora));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error: error al eliminar la consulta");
            return false;
        }
    }
   
}

