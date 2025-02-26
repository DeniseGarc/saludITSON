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
    * Consulta un usuario en la base de datos utilizando su correo electrónico.
    *
    * @param correo El correo electrónico del usuario a consultar.
    * @return Un objeto `Usuario` con los datos del usuario encontrado, o `null` si no se encuentra ningún usuario con el correo proporcionado.
    * @throws PersistenciaException Si ocurre algún error en la consulta a la base de datos.
    */
    public Usuario consultarUsuarioPorCorreo(String correo) throws PersistenciaException;
}