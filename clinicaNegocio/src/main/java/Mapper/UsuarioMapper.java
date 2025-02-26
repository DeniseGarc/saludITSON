/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author joelr
 */
public class UsuarioMapper {
    
    /**
     * Convierte un DTO de usuario a una entidad Usuario.
     * 
     * @param usuarioNuevo El DTO que contiene la información del usuario.
     * @return La entidad Usuario correspondiente a los datos del DTO.
     */
    public Usuario ConvertirAEntidad(UsuarioDTO usuarioNuevo) {
        Usuario usuario = new Usuario(usuarioNuevo.getNombreUsuario(), usuarioNuevo.getContrasenaUsuario());
        return usuario;
    }
    
    /**
     * Convierte una entidad Usuario a un DTO de Usuario.
     * 
     * @param usuario La entidad Usuario a convertir.
     * @return El DTO de Usuario correspondiente.
     */
    public UsuarioDTO ConvertirADTO(Usuario usuario) {
        UsuarioDTO usuarioNuevoDTO = new UsuarioDTO(usuario.getNombreUsuario(), usuario.getContrasenaUsuario());
        return usuarioNuevoDTO;
    } 
}

