/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Horario;
import entidades.Medico;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author benjy
 */
public class MedicoDAO implements IMedicoDAO{
    IConexion conexion;
    private static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());

    public MedicoDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    
    @Override
    public Medico registrarMedico(Medico medico) throws PersistenciaException {
        String procedimientoSQL = "{CALL registrar_medico(?, ?, ?, ?, ?, ?)}";

        try (Connection con = conexion.crearConexion();
             CallableStatement cs = con.prepareCall(procedimientoSQL)) {

            // Establecer los parámetros del procedimiento almacenado
            cs.setString(1, medico.getNombresMedico());
            cs.setString(2, medico.getApellidoPaternoMedico());
            cs.setString(3, medico.getApellidoMaternoMedico());
            cs.setString(4, medico.getCedulaProfesional());
            cs.setString(5, medico.getEspecialidad());
            cs.setString(6, medico.getUsuario().getContrasenaUsuario()); // Contraseña

            // Enviar los horarios, cada uno en su correspondiente parámetro

            // Ejecutar el procedimiento almacenado
            cs.executeUpdate();
            logger.info("Médico registrado exitosamente.");

            return medico;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar médico", e);
            throw new PersistenciaException("Error al registrar el médico en la base de datos.", e);
        }
    }
}
