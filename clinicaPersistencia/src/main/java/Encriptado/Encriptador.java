/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptado;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Clase para encriptar contraseñas mediante BCrypt.
 *
 * @author joelr
 */
public class Encriptador implements IEncriptador {
    /**
     * Metodo para encriptar una contraseña.
     * @param contrasena contraseña a encriptar
     * @return Contraseña Encriptada.
     */
    @Override
    public String encriptar(String contrasena) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String contrasenaEncriptada = encoder.encode(contrasena);
        return contrasenaEncriptada;
    }
    /**
     * Metodo para comprobar si la contraseña coincide con la cifrada.
     * @param contrasena
     * @param contrasenaEncriptada
     * @return 
     */
    public boolean Match(String contrasena, String contrasenaEncriptada) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean coincide = encoder.matches(contrasena, contrasenaEncriptada);
        return coincide;
    }
}
