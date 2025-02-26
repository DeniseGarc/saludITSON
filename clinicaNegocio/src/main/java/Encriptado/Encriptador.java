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
    * Método que encripta una contraseña utilizando el algoritmo BCrypt.
    * 
    * @param contrasena La contraseña en texto plano que se desea encriptar.
    * @return La contraseña encriptada utilizando el algoritmo BCrypt.
    */
       @Override
    public String encriptar(String contrasena){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String contrasenaEncriptada = encoder.encode(contrasena);
        return contrasenaEncriptada;
    }
}
