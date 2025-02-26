/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptado;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Clase para encriptar contraseñas mediante BCrypt.
 * @author joelr
 */
public class Encriptador implements IEncriptador {

    /**
     * Encripta una contraseña utilizando el algoritmo BCrypt.
     * 
     * @param contrasena La contraseña en texto claro que se desea encriptar.
     * @return La contraseña encriptada.
     */
    @Override
    public String encriptar(String contrasena) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  // Instancia del encriptador BCrypt.
        String contrasenaEncriptada = encoder.encode(contrasena);     // Encripta la contraseña.
        return contrasenaEncriptada;                                  // Devuelve la contraseña encriptada.
    }
}
