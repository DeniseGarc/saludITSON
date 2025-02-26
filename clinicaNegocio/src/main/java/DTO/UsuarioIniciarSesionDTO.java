/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class UsuarioIniciarSesionDTO {
    private int idUsuario;  // El ID del usuario.
    private String tipo;    // El tipo de usuario (por ejemplo, paciente, médico, etc.).

    /**
     * Obtiene el ID del usuario.
     * 
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param idUsuario El nuevo ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el tipo de usuario.
     * 
     * @return El tipo de usuario.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de usuario.
     * 
     * @param tipo El nuevo tipo de usuario.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

