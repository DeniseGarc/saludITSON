/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import Mapper.UsuarioMapper;
import conexion.IConexion;
import entidades.Usuario;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joelr
 */
public class UsuarioBO {

    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());
    private final IUsuarioDAO usuarioDAO;
    private final UsuarioMapper mapper = new UsuarioMapper();

    public UsuarioBO(IConexion conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }
//// Será necesario??
    
//    public boolean RegistrarUsuario(UsuarioDTO usuarioNuevo) throws NegocioException {
//        // Valida que el usuario no sea nulo.
//        if (usuarioNuevo == null) {
//            System.out.println("Error: El usuario es nulo.");
//            return false;
//        }
//        // Verificar que los campos no esten vacios.
//        if (usuarioNuevo.getNombreUsuario().isEmpty() || usuarioNuevo.getContrasenaUsuario().isEmpty()) {
//            throw new NegocioException("Error: Campos vacios");
//        }
//        // Uso de Mapper para convertir a Entidad.
//        Usuario usuario = mapper.ConvertirAEntidad(usuarioNuevo);
//        // Registrar
//        try {
//            Usuario usuarioAGuardar = usuarioDAO.registrarUsuario(usuario);
//            return usuarioAGuardar != null;
//        } catch (PersistenciaException pe) {
//            // Registro de Error con el logger.
//            logger.log(Level.SEVERE, "Error: error al guardar usuario en la base de datos", pe);
//            // Muestra la excepción con un mensaje.
//            throw new NegocioException("Error: No se pudo guardar el Usuario", pe);
//        }
//    }

}
