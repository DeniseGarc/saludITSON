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
    * Método que encripta una contraseña utilizando el algoritmo BCrypt.
    * 
    * @param contrasena La contraseña en texto plano que se desea encriptar.
    * @return La contraseña encriptada utilizando el algoritmo BCrypt.
    */
    String encriptar(String contrasena);

}
