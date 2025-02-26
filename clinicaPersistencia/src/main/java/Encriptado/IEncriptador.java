/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Encriptado;

/**
 *
 * @author joelr
 */
public interface IEncriptador {
    /**
     * Metodo para encriptar una contraseña.
     * @param contrasena contraseña a encriptar
     * @return Contraseña Encriptada.
     */
    String encriptar(String contrasena);
    /**
     * Metodo para comprobar si la contraseña coincide con la cifrada.
     * @param contrasena
     * @param contrasenaEncriptada
     * @return 
     */
    public boolean Match(String contrasena, String contrasenaEncriptada);
    
}
