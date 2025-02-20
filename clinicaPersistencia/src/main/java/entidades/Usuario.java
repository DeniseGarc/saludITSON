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
    private int nombreUsuario;
    private int contrasenaUsuario;
    
    //constructor vacio

    public Usuario() {
    }
    
    //constructor con todos los atributos 

    public Usuario(int IDUsuario, int nombreUsuario, int contrasenaUsuario) {
        this.IDUsuario = IDUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    //constructor con todos los atributos menos el IDUsuario

    public Usuario(int nombreUsuario, int contrasenaUsuario) {
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

    public int getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(int nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(int contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    //ToString

    @Override
    public String toString() {
        return "Usuario{" + "IDUsuario=" + IDUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenaUsuario=" + contrasenaUsuario + '}';
    }
    
}
