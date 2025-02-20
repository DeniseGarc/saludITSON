/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author benjy
 */
    public class UsuarioDAO implements IUsuarioDAO {
    IConexion conexion;
    private static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());

    public UsuarioDAO(IConexion conexion) {
        this.conexion = conexion;
    }
     @Override
     
     
     
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException {
    String sentenciaSQL = "{CALL registrar_usuario(?, ?)}";
    
    try (
        Connection con = conexion.crearConexion();
        CallableStatement cs = con.prepareCall(sentenciaSQL)
    ) {
        // Establecer los parámetros
        cs.setString(1, usuario.getNombreUsuario()); 
        cs.setString(2, usuario.getContrasenaUsuario()); 

        cs.execute();
        logger.info("Usuario agregado exitosamente.");
        return usuario;

    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Error al registrar usuario", e);
        throw new PersistenciaException("Error al registrar el usuario", e);
    }
    }
    }
