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
    * Convierte un objeto UsuarioDTO a un objeto Usuario.
    *
    * @param usuarioNuevo El objeto UsuarioDTO que contiene los datos del usuario a convertir.
    * @return Un objeto Usuario que contiene los mismos datos del UsuarioDTO convertido.
    */
    public Usuario ConvertirAEntidad (UsuarioDTO usuarioNuevo){
         Usuario usuario = new Usuario(usuarioNuevo.getNombreUsuario(),usuarioNuevo.getContrasenaUsuario());
         return usuario;
    }
    /**
    * Convierte un objeto Usuario a un objeto UsuarioDTO.
    *
    * @param usuario El objeto Usuario que contiene los datos del usuario a convertir.
    * @return Un objeto UsuarioDTO que contiene los mismos datos del Usuario convertido.
    */
    public UsuarioDTO ConvertirADTO (Usuario usuario){
        UsuarioDTO usuarioNuevoDTO = new UsuarioDTO(usuario.getNombreUsuario(),usuario.getContrasenaUsuario());
        return usuarioNuevoDTO;
    } 
}
