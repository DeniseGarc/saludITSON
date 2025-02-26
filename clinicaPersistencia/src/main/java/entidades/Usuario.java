/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Alici
 */
public class Usuario {
    private int IDUsuario;
    private String nombreUsuario;
    private String contrasenaUsuario;

    /**
     * Constructor vacío de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con todos los atributos.
     * 
     * @param IDUsuario El ID único del usuario.
     * @param nombreUsuario El nombre de usuario.
     * @param contrasenaUsuario La contraseña asociada al usuario.
     */
    public Usuario(int IDUsuario, String nombreUsuario, String contrasenaUsuario) {
        this.IDUsuario = IDUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    /**
     * Constructor de la clase Usuario sin el IDUsuario.
     * 
     * @param nombreUsuario El nombre de usuario.
     * @param contrasenaUsuario La contraseña asociada al usuario.
     */
    public Usuario(String nombreUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    /**
     * Obtiene el ID del usuario.
     * 
     * @return El ID del usuario.
     */
    public int getIDUsuario() {
        return IDUsuario;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param IDUsuario El ID del usuario.
     */
    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
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
     * Devuelve una representación en cadena del objeto Usuario.
     * 
     * @return Una cadena con los detalles del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "IDUsuario=" + IDUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenaUsuario=" + contrasenaUsuario + '}';
    }
}