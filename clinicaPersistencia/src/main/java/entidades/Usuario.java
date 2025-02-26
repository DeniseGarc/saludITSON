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
     * Constructor con todos los atributos.
     * 
     * @param IDUsuario Identificador único del usuario.
     * @param nombreUsuario Nombre del usuario.
     * @param contrasenaUsuario Contraseña del usuario.
     */
    public Usuario(int IDUsuario, String nombreUsuario, String contrasenaUsuario) {
        this.IDUsuario = IDUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    /**
     * Constructor con todos los atributos menos el IDUsuario.
     * 
     * @param nombreUsuario Nombre del usuario.
     * @param contrasenaUsuario Contraseña del usuario.
     */
    public Usuario(String nombreUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    /**
     * Obtiene el identificador único del usuario.
     * 
     * @return El ID del usuario.
     */
    public int getIDUsuario() {
        return IDUsuario;
    }

    /**
     * Establece el identificador único del usuario.
     * 
     * @param IDUsuario El ID a asignar al usuario.
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
     * @param nombreUsuario El nombre a asignar al usuario.
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
     * @param contrasenaUsuario La contraseña a asignar al usuario.
     */
    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    // Método toString

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     * 
     * @return Una cadena que describe el objeto Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "IDUsuario=" + IDUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenaUsuario=" + contrasenaUsuario + '}';
    }
}
