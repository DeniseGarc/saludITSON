
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

    /**
     * Constructor que inicializa la conexión a la base de datos.
     * 
     * @param conexion Objeto que gestiona la conexión a la base de datos.
     */
    public MedicoDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta médicos por su especialidad.
     * 
     * @param especialidad La especialidad de los médicos a consultar.
     * @return Una lista de objetos Medico que cumplen con la especialidad
     *         solicitada.
     * @throws PersistenciaException Si ocurre un error al consultar los médicos en
     *                               la base de datos.
     */
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

    /**
     * Consulta todas las especialidades disponibles de los médicos.
     * 
     * @return Una lista de cadenas con las especialidades de los médicos.
     * @throws PersistenciaException Si ocurre un error al obtener las
     *                               especialidades.
     */
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

    /**
     * Obtiene los horarios disponibles para una cita con un médico en una fecha
     * específica.
     * 
     * @param medico El médico para el cual se consultan los horarios.
     * @param fecha  La fecha en la que se desea obtener los horarios disponibles.
     * @return Una lista de objetos LocalTime con los horarios disponibles para
     *         citas.
     * @throws PersistenciaException Si ocurre un error al obtener los horarios de
     *                               citas.
     */
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

    /**
     * Consulta un médico por su ID.
     * 
     * @param id El ID del médico a consultar.
     * @return Un objeto Medico con la información del médico, o null si no se
     *         encuentra.
     * @throws PersistenciaException Si ocurre un error al consultar el médico.
     */
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

    /**
     * Consulta el nombre completo de un médico dado su ID.
     * 
     * @param idMedico El ID del médico.
     * @return El nombre completo del médico.
     * @throws PersistenciaException Si ocurre un error al consultar el nombre
     *                               completo del médico.
     */
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

    /**
     * Verifica si un médico tiene citas activas.
     * 
     * @param idMedico El ID del médico.
     * @return true si el médico tiene citas activas, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al verificar las citas
     *                               activas.
     */
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

    /**
     * Da de baja temporal a un médico, cambiando su estado a 'inactivo'.
     * 
     * @param idMedico El ID del médico.
     * @return true si la baja temporal fue exitosa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al dar de baja al médico.
     */
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

    /**
     * Reactiva la cuenta de un médico, cambiando su estado a 'activo'.
     * 
     * @param idMedico El ID del médico.
     * @return true si la reactivación fue exitosa, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al reactivar la cuenta del
     *                               médico.
     */
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

    /**
     * Obtiene el estado de un médico (activo o inactivo).
     * 
     * @param idMedico El ID del médico.
     * @return El estado del médico.
     * @throws PersistenciaException Si ocurre un error al obtener el estado del
     *                               médico.
     */
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

     @Override
     public int consultarMedicoPorNombre(String Nombre) throws PersistenciaException {
         String sentenciaSQL = "SELECT IDMedico FROM medicos WHERE nombresMedico = ?";
         try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sentenciaSQL)) {
             ps.setString(1, Nombre);
             ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                 return rs.getInt("IDMedico");
             } else {
                 return 0;
             }
         } catch (SQLException ex) {
             Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
             throw new PersistenciaException("Error al intentar consultar el medico por su Nombre");

         }
     }
}