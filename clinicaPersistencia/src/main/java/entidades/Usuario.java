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
    
    //constructor vacio

    public Usuario() {
    }
    
    //constructor con todos los atributos 

    public Usuario(int IDUsuario, String nombreUsuario, String contrasenaUsuario) {
        this.IDUsuario = IDUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    //constructor con todos los atributos menos el IDUsuario

    public Usuario(String nombreUsuario, String contrasenaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    //gets y sets 

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    //ToString

    @Override
    public String toString() {
        return "Usuario{" + "IDUsuario=" + IDUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenaUsuario=" + contrasenaUsuario + '}';
    }
    
}
