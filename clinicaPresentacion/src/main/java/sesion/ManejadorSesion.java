/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesion;

/**
 *
 * @author benjy
 */
public class ManejadorSesion {
    
    private static String idUsuario;
    private static String tipo;
    
    /**
     * Obtiene el ID del usuario de la sesión actual.
     * 
     * @return El ID del usuario.
     */
    public static String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario para la sesión actual.
     * 
     * @param idUsuario El ID del usuario a establecer.
     */
    public static void setIdUsuario(String idUsuario) {
        ManejadorSesion.idUsuario = idUsuario;
    }

    /**
     * Obtiene el tipo del usuario de la sesión actual.
     * 
     * @return El tipo de usuario.
     */
    public static String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del usuario para la sesión actual.
     * @param tipo El tipo de usuario a establecer.
     */
    public static void setTipo(String tipo) {
        ManejadorSesion.tipo = tipo;
    }
    
    /**
     * Borra los datos de la sesión actual, estableciendo los valores a null.
     */
    public static void borrarDatosSesion() {
        idUsuario = null;
        tipo = null;
    }
    
}
