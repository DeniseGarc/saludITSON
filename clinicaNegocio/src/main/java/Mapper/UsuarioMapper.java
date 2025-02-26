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
    
    
    public Usuario ConvertirAEntidad (UsuarioDTO usuarioNuevo){
         Usuario usuario = new Usuario(usuarioNuevo.getNombreUsuario(),usuarioNuevo.getContrasenaUsuario());
         return usuario;
    }
    
    public UsuarioDTO ConvertirADTO (Usuario usuario){
        UsuarioDTO usuarioNuevoDTO = new UsuarioDTO(usuario.getNombreUsuario(),usuario.getContrasenaUsuario());
        return usuarioNuevoDTO;
    } 
}
