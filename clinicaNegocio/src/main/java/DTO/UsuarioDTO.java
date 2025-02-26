/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author joelr
 */
public class UsuarioDTO {

    private String IDUsuario;
    private String nombreUsuario;
    private String contrasenaUsuario;

    /**
     * Constructor vacío.
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor con atributos.
     * 
     * @param IDUsuario El ID del usuario.
     * @param nombreUsuario El nombre del usuario.
     * @param contrasenaUsuario La contraseña del usuario.
     */
    public UsuarioDTO(String IDUsuario, String nombreUsuario, String contrasenaUsuario) {
        this.IDUsuario = IDUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    /**
     * Constructor con atributos (sin ID).
     * 
     * @param nombreUsuario El nombre del usuario.
     * @param contrasenaUsuario La contraseña del usuario.
     */
    public UsuarioDTO(String nombreUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    // Getters y Setters

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombreUsuario El nuevo nombre del usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contrasenaUsuario La nueva contraseña del usuario.
     */
    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    /**
     * Devuelve una representación en formato de cadena de la clase UsuarioDTO.
     * 
     * @return Una cadena con el nombre de usuario y la contraseña.
     */
    @Override
    public String toString() {
        return "UsuarioDTO: " + "nombreUsuario=" + nombreUsuario + ", contrasenaUsuario=" + contrasenaUsuario;
    }
}
