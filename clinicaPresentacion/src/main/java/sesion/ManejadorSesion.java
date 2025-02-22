/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesion;

/**
 *
 * @author Alici
 */
public class ManejadorSesion {

    private static String idUsuario = "8";
    private static String tipo;

    public static String getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(String idUsuario) {
        ManejadorSesion.idUsuario = idUsuario;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        ManejadorSesion.tipo = tipo;
    }
}
