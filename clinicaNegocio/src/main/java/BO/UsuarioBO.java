/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioIniciarSesionDTO;
import Encriptado.Encriptador;
import Encriptado.IEncriptador;
import Mapper.UsuarioMapper;
import conexion.IConexion;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author joelr
 */
public class UsuarioBO {

    private final IEncriptador encriptador = new Encriptador();
    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());
    private final IUsuarioDAO usuarioDAO;
    private final UsuarioMapper mapper = new UsuarioMapper();
    public UsuarioBO(IConexion conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }

    /**
     * Inicia sesión de un usuario en el sistema.
     *
     * @param nombreUsuario El nombre de usuario o correo electrónico.
     * @param contrasena    La contraseña del usuario.
     * @return Un objeto UsuarioIniciarSesionDTO con el ID y el tipo de usuario.
     * @throws NegocioException Si hay problemas en las capas o si las credenciales son inválidas.
     */
    public UsuarioIniciarSesionDTO iniciarSesion(String nombreUsuario, String contrasena) throws NegocioException {
        if (!esCampoValido(nombreUsuario) || !esCampoValido(contrasena)) {
            logger.warning("Error: Campos de inicio de sesión vacíos o nulos");
            throw new NegocioException("Por favor, complete todos los campos.");
        }
        try {
            // Consultar el usuario en la base de datos
            Usuario usuario = usuarioDAO.consultarUsuarioPorCorreo(nombreUsuario);

            // Verificar si el usuario existe
            if (usuario == null) {
                logger.severe("Error: Usuario no encontrado");
                throw new NegocioException("El usuario no existe.");
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(contrasena, usuario.getContrasenaUsuario())) {
             logger.severe("Error: Contraseña incorrecta");
             throw new NegocioException("Contraseña incorrecta.");
            }

            String tipoUsuario;
            if (nombreUsuario.contains("@")) {
                tipoUsuario = "Paciente";
            } else {
                tipoUsuario = "Medico";
            }
            // Crear y devolver el objeto UsuarioIniciarSesionDTO
            UsuarioIniciarSesionDTO usuarioIniciarSesionDTO = new UsuarioIniciarSesionDTO();
            usuarioIniciarSesionDTO.setIdUsuario(usuario.getIDUsuario()); // Asignar el ID
            usuarioIniciarSesionDTO.setTipo(tipoUsuario); // Asignar el tipo

            logger.info("Inicio de sesión exitoso para el usuario: " + nombreUsuario);
            return usuarioIniciarSesionDTO;

        } catch (PersistenciaException e) {
            logger.log(Level.SEVERE, "Error en inicio de sesión", e);
            throw new NegocioException("Error en inicio de sesión.", e);
        }
    }
    /**
     * Valida si un campo no está vacío o nulo.
     *
     * @param campo El campo a validar.
     * @return true si el campo es válido, false en caso contrario.
     */
    private boolean esCampoValido(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }
}
