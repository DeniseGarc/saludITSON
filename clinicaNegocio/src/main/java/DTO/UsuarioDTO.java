/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author joelr
 */
public class UsuarioDTO{

    private String nombreUsuario;
    private String contrasenaUsuario;
    
    //Constructor vacio

    public UsuarioDTO() {
    }  
    //Constructor con Atributos

    public UsuarioDTO(String nombreUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    //gets y sets 

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    //ToString

    @Override
    
    public String toString() {
        return "UsuarioDTO: " + "nombreUsuario=" + nombreUsuario + ", contrasenaUsuario=" + contrasenaUsuario;
    }
}
