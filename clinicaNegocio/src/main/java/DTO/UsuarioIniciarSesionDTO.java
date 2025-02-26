/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class UsuarioIniciarSesionDTO {
    
    private int idUsuario; 
    private String tipo;   

    /**
     * Obtiene el identificador del usuario.
     * 
     * @return El identificador único del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     * 
     * @param idUsuario El identificador único del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el tipo de usuario.
     * 
     * @return El tipo de usuario (por ejemplo, "Paciente", "Medico").
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de usuario.
     * 
     * @param tipo El tipo de usuario (por ejemplo, "Paciente", "Medico").
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
