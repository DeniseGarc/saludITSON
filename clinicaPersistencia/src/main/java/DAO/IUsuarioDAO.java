/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Usuario;
import excepciones.PersistenciaException;

/**
 *
 * @author benjy
 */
public interface IUsuarioDAO {

    /**
    * Consulta un usuario en la base de datos mediante su nombre de usuario.
    * 
    * @param correo 
    * 
    * @return Un objeto Usuario con los datos del usuario encontrado, o null si no se encuentra
    * 
    * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
    */
    public Usuario consultarUsuarioPorCorreo(String correo) throws PersistenciaException;
}