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
     * Constructor vacío que crea una instancia de UsuarioDTO sin inicializar los atributos.
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor que inicializa los atributos de la clase con los valores proporcionados.
     * 
     * @param IDUsuario Identificador único del usuario.
     * @param nombreUsuario Nombre del usuario.
     * @param contrasenaUsuario Contraseña del usuario.
     */
    public UsuarioDTO(String IDUsuario, String nombreUsuario, String contrasenaUsuario) {
        this.IDUsuario = IDUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    /**
     * Constructor que inicializa los atributos del usuario sin el identificador único.
     * 
     * @param nombreUsuario Nombre del usuario.
     * @param contrasenaUsuario Contraseña del usuario.
     */
    public UsuarioDTO(String nombreUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

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
     * @param nombreUsuario El nombre del usuario.
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
     * @param contrasenaUsuario La contraseña del usuario.
     */
    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    /**
     * Devuelve una representación en cadena de texto de un objeto UsuarioDTO.
     * 
     * @return Una cadena que describe al usuario, incluyendo su nombre de usuario y su contraseña.
     */
    @Override
    public String toString() {
        return "UsuarioDTO: " + "nombreUsuario=" + nombreUsuario + ", contrasenaUsuario=" + contrasenaUsuario;
    }
}
